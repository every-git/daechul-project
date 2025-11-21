# 📌 팀 프로젝트 MySQL 데이터베이스 설정 가이드

> 4명의 팀원이 동일한 데이터베이스 환경을 설정하기 위한 상세 가이드입니다.  
> 초보자도 따라할 수 있도록 각 단계를 자세히 설명합니다.

---

## 📋 목차

1. [MySQL 설치](#1-mysql-설치)
2. [MySQL 실행 확인](#2-mysql-실행-확인)
3. [데이터베이스 생성](#3-데이터베이스-생성)
4. [사용자 생성 및 권한 부여](#4-사용자-생성-및-권한-부여)
5. [테이블 생성](#5-테이블-생성)
6. [연결 테스트](#6-연결-테스트)
7. [문제 해결 (Troubleshooting)](#7-문제-해결-troubleshooting)

---

## 1. MySQL 설치

### 🍎 macOS

#### **방법 1: Homebrew 사용 (권장)**

```bash
# Homebrew가 설치되어 있지 않다면
/bin/bash -c "$(curl -fsSL https://raw.githubusercontent.com/Homebrew/install/HEAD/install.sh)"

# MySQL 설치
brew install mysql

# MySQL 서비스 시작
brew services start mysql
```

#### **방법 2: 공식 설치 파일 다운로드**

1. [MySQL 공식 웹사이트](https://dev.mysql.com/downloads/mysql/) 접속
2. macOS용 DMG 파일 다운로드
3. 다운로드한 파일을 실행하여 설치 진행
4. 설치 시 나오는 **임시 비밀번호를 반드시 메모**

---

### 🪟 Windows

1. [MySQL 공식 웹사이트](https://dev.mysql.com/downloads/installer/) 접속
2. **MySQL Installer for Windows** 다운로드
3. 설치 프로그램 실행
4. **"Developer Default"** 선택
5. 설치 과정:
   - **MySQL Server 8.0 이상** 선택
   - Root 비밀번호 설정 (예: `1234` 또는 본인이 기억할 수 있는 비밀번호)
   - **포트 번호: 3306** (기본값 유지)
   - Windows Service 등록 체크

---

### 🐧 Linux (Ubuntu/Debian)

```bash
# 패키지 목록 업데이트
sudo apt update

# MySQL 서버 설치
sudo apt install mysql-server

# MySQL 서비스 시작
sudo systemctl start mysql

# MySQL 보안 설정 (선택사항, 권장)
sudo mysql_secure_installation
```

---

## 2. MySQL 실행 확인

### ✅ MySQL이 정상적으로 실행 중인지 확인

#### macOS / Linux

```bash
# MySQL 서비스 상태 확인
brew services list  # macOS (Homebrew)
sudo systemctl status mysql  # Linux

# MySQL에 접속 (root 사용자)
mysql -u root -p
```

#### Windows

1. **작업 관리자** 열기 (`Ctrl + Shift + Esc`)
2. **서비스** 탭에서 `MySQL80` 또는 `MySQL` 찾기
3. 상태가 **"실행 중"**인지 확인

**또는 명령 프롬프트에서:**

```cmd
mysql -u root -p
```

> 💡 **비밀번호 입력 프롬프트가 나오면 설치 시 설정한 root 비밀번호 입력**

---

## 3. 데이터베이스 생성

MySQL에 root로 접속한 상태에서 다음 명령어를 실행합니다.

### 📝 단계별 실행

```sql
-- 1. 기존 dcproject 데이터베이스가 있다면 삭제 (선택사항)
DROP DATABASE IF EXISTS dcproject;

-- 2. dcproject 데이터베이스 생성
CREATE DATABASE dcproject 
    DEFAULT CHARACTER SET utf8mb4 
    COLLATE utf8mb4_unicode_ci;

-- 3. 생성된 데이터베이스 확인
SHOW DATABASES;
```

**예상 결과:**
```
+--------------------+
| Database           |
+--------------------+
| dcproject              |
| information_schema |
| mysql              |
| performance_schema |
| sys                |
+--------------------+
```

> ✅ `dcproject`가 목록에 있으면 성공!

---

## 4. 사용자 생성 및 권한 부여

프로젝트에서 사용할 전용 사용자 `jdbctest`를 생성합니다.

### 📝 단계별 실행

```sql
-- 1. 기존 사용자가 있다면 삭제 (선택사항)
DROP USER IF EXISTS 'jdbctest'@'localhost';

-- 2. jdbctest 사용자 생성 (비밀번호: 1234)
CREATE USER 'jdbctest'@'localhost' IDENTIFIED BY '1234';

-- 3. dcproject 데이터베이스에 대한 모든 권한 부여
GRANT ALL PRIVILEGES ON dcproject.* TO 'jdbctest'@'localhost';

-- 4. 권한 변경사항 즉시 적용
FLUSH PRIVILEGES;

-- 5. 사용자 생성 확인
SELECT user, host FROM mysql.user WHERE user = 'jdbctest';
```

**예상 결과:**
```
+----------+-----------+
| user     | host      |
+----------+-----------+
| jdbctest | localhost |
+----------+-----------+
```

> ✅ `jdbctest` 사용자가 보이면 성공!

### 🔐 새로운 사용자로 접속 테스트

```bash
# MySQL에서 나가기
exit;

# jdbctest 사용자로 다시 접속
mysql -u jdbctest -p

# 비밀번호 입력: 1234
```

접속 후 데이터베이스 선택:

```sql
USE dcproject;
```

---

## 5. 테이블 생성

`dcproject` 데이터베이스를 사용하는 상태에서 다음 SQL을 실행합니다.

### 📋 members 테이블 생성

```sql
-- 회원 정보 테이블
CREATE TABLE members (
    id VARCHAR(20) PRIMARY KEY COMMENT '회원 아이디',
    password VARCHAR(100) NOT NULL COMMENT '비밀번호',
    name VARCHAR(50) NOT NULL COMMENT '이름',
    email VARCHAR(100) COMMENT '이메일',
    role VARCHAR(20) DEFAULT 'user' COMMENT '역할 (admin/user)',
    phone VARCHAR(20) COMMENT '전화번호',
    regdate TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT '가입일시'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='회원 테이블';
```

### 📋 board 테이블 생성

> [!IMPORTANT]
> **통합 프로젝트용 테이블**
> 
> 이 테이블은 회원 테이블과 연동되는 구조입니다.
> web-study-11 학습 프로젝트와는 다른 구조임을 주의하세요!

```sql
-- 게시판 테이블 (회원 연동형)
CREATE TABLE board (
    seq INT AUTO_INCREMENT PRIMARY KEY COMMENT '게시글 번호',
    writer VARCHAR(20) NOT NULL COMMENT '작성자 ID (회원 테이블 FK)',
    title VARCHAR(200) NOT NULL COMMENT '제목',
    content TEXT COMMENT '내용',
    hit INT DEFAULT 0 COMMENT '조회수',
    regdate TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT '작성일시',
    FOREIGN KEY (writer) REFERENCES members(id) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='게시판 테이블';
```

> [!NOTE]
> **📝 web-study-11과의 차이점**
> 
> | 필드 | web-study-11 (학습용) | 통합 프로젝트 |
> |------|----------------------|-------------|
> | 작성자 | `name VARCHAR(30)` - 수동 입력 | `writer VARCHAR(20)` - 회원 ID (FK) |
> | 비밀번호 | `pass VARCHAR(30)` - 필수 | ❌ 제거 (세션으로 권한 관리) |
> | 이메일 | `email VARCHAR(30)` - 수동 입력 | ❌ 제거 (members 테이블 조인) |
> | 조회수 | `readcount INT` | `hit INT` |
> | 작성일 | `writedate DATETIME` | `regdate TIMESTAMP` |
> 
> **통합 프로젝트의 장점:**
> - ✅ 로그인한 사용자만 글 작성 가능
> - ✅ 작성자 정보 자동 저장 (세션에서)
> - ✅ 게시글 작성자와 회원 정보 자동 연동
> - ✅ 회원 탈퇴 시 작성 게시글도 자동 삭제 (ON DELETE CASCADE)

> [!TIP]
> **필드 상세 설명**
> 
> | 필드 | 타입 | 설명 | 비고 |
> |------|------|------|------|
> | `seq` | INT | 게시글 번호 (PK, AUTO_INCREMENT) | web-study-11의 `num`에 해당 |
> | `writer` | VARCHAR(50) | 작성자 ID (FK → members.id) | 로그인한 사용자 ID가 자동 저장됨 |
> | `title` | VARCHAR(200) | 제목 | web-study-11은 50자, 통합은 200자 |
> | `content` | TEXT | 내용 | web-study-11은 VARCHAR(1000), 통합은 TEXT |
> | `hit` | INT | 조회수 | web-study-11의 `readcount`에 해당 |
> | `regdate` | TIMESTAMP | 작성일시 | web-study-11의 `writedate`에 해당 |
> 
> **BoardDAO 조인 예시:**
> ```java
> // 게시글 조회 시 작성자 정보 함께 가져오기
> String sql = "SELECT b.seq, b.writer, b.title, b.content, b.hit, b.regdate, " +
>              "       m.name AS writerName, m.email AS writerEmail " +
>              "FROM board b " +
>              "INNER JOIN members m ON b.writer = m.id " +
>              "WHERE b.seq = ?";
> ```

### ✅ 테이블 생성 확인

```sql
-- dcproject의 모든 테이블 목록 보기
SHOW TABLES;
```

**예상 결과:**
```
+------------------+
| Tables_in_dcproject  |
+------------------+
| board            |
| members          |
+------------------+
```

### 📊 테이블 구조 확인

```sql
-- members 테이블 구조 확인
DESC members;

-- board 테이블 구조 확인
DESC board;
```

---

## 6. 연결 테스트

### 🧪 테스트 데이터 삽입

```sql
-- 관리자 계정 생성
INSERT INTO members (id, password, name, email, role, phone) 
VALUES ('admin', '1234', '관리자', 'admin@example.com', 'admin', '010-1234-5678');

-- 일반 사용자 생성
INSERT INTO members (id, password, name, email, role, phone) 
VALUES ('user01', '1234', '홍길동', 'user01@example.com', 'user', '010-9876-5432');

-- 테스트 게시글 작성
INSERT INTO board (writer, title, content) 
VALUES ('admin', '테스트 게시글', '이것은 테스트 게시글입니다.');

INSERT INTO board (writer, title, content) 
VALUES ('user01', '안녕하세요', '처음 작성하는 게시글입니다.');
```

### ✅ 데이터 확인

```sql
-- 회원 목록 조회
SELECT * FROM members;

-- 게시글 목록 조회
SELECT * FROM board;
```

### 🔍 예상 결과

**members 테이블:**
```
+--------+----------+--------+--------------------+-------+----------------+---------------------+
| id     | password | name   | email              | role  | phone          | regdate             |
+--------+----------+--------+--------------------+-------+----------------+---------------------+
| admin  | 1234     | 관리자  | admin@example.com  | admin | 010-1234-5678  | 2025-11-20 20:52:00 |
| user01 | 1234     | 홍길동  | user01@example.com | user  | 010-9876-5432  | 2025-11-20 20:52:01 |
+--------+----------+--------+--------------------+-------+----------------+---------------------+
```

**board 테이블:**
```
+-----+--------+------------------+---------------------------+-----+---------------------+
| seq | writer | title            | content                   | hit | regdate             |
+-----+--------+------------------+---------------------------+-----+---------------------+
| 1   | admin  | 테스트 게시글     | 이것은 테스트 게시글입니다.  | 0   | 2025-11-20 20:52:02 |
| 2   | user01 | 안녕하세요        | 처음 작성하는 게시글입니다.  | 0   | 2025-11-20 20:52:03 |
+-----+--------+------------------+---------------------------+-----+---------------------+
```

---

## 7. 문제 해결 (Troubleshooting)

### ❌ 문제 1: "Access denied for user 'root'@'localhost'"

**원인:** root 비밀번호를 잊어버렸거나 잘못 입력함

**해결 방법:**

#### macOS / Linux
```bash
# MySQL 안전 모드로 재시작
sudo mysqld_safe --skip-grant-tables &

# 비밀번호 없이 접속
mysql -u root

# 비밀번호 재설정
ALTER USER 'root'@'localhost' IDENTIFIED BY '새비밀번호';
FLUSH PRIVILEGES;
exit;

# MySQL 정상 재시작
sudo killall mysqld
brew services restart mysql  # macOS
sudo systemctl restart mysql  # Linux
```

#### Windows
1. 서비스에서 MySQL 중지
2. `my.ini` 파일에 `skip-grant-tables` 추가
3. MySQL 재시작 후 비밀번호 재설정
4. `skip-grant-tables` 제거 후 다시 재시작

---

### ❌ 문제 2: "Can't connect to MySQL server on 'localhost'"

**원인:** MySQL 서비스가 실행되지 않음

**해결 방법:**

#### macOS
```bash
brew services start mysql
```

#### Windows
1. **서비스** 앱 실행 (`Win + R` → `services.msc`)
2. **MySQL80** 찾기
3. 우클릭 → **시작**

#### Linux
```bash
sudo systemctl start mysql
```

---

### ❌ 문제 3: "Unknown database 'dcproject'"

**원인:** 데이터베이스가 생성되지 않았거나 삭제됨

**해결 방법:**

```sql
-- root로 접속
mysql -u root -p

-- 데이터베이스 다시 생성
CREATE DATABASE dcproject 
    DEFAULT CHARACTER SET utf8mb4 
    COLLATE utf8mb4_unicode_ci;

-- jdbctest 권한 다시 부여
GRANT ALL PRIVILEGES ON dcproject.* TO 'jdbctest'@'localhost';
FLUSH PRIVILEGES;
```

---

### ❌ 문제 4: 한글이 깨져서 보임

**원인:** 문자 인코딩 설정 문제

**해결 방법:**

#### 데이터베이스 문자셋 확인
```sql
SHOW VARIABLES LIKE 'character_set%';
```

#### 문자셋이 utf8mb4가 아닌 경우
```sql
-- 데이터베이스 문자셋 변경
ALTER DATABASE dcproject 
    CHARACTER SET = utf8mb4 
    COLLATE = utf8mb4_unicode_ci;

-- 테이블 문자셋 변경
ALTER TABLE members CONVERT TO CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
ALTER TABLE board CONVERT TO CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
```

---

### ❌ 문제 5: "Table 'dcproject.members' doesn't exist"

**원인:** 테이블이 생성되지 않았거나 잘못된 데이터베이스에 접속

**해결 방법:**

```sql
-- 현재 사용 중인 데이터베이스 확인
SELECT DATABASE();

-- dcproject 사용
USE dcproject;

-- 테이블 목록 확인
SHOW TABLES;

-- 테이블이 없다면 다시 생성 (위의 5단계 참조)
```

---

## 🎯 최종 점검 체크리스트

모든 팀원이 다음 항목을 확인하세요:

- [ ] MySQL이 정상적으로 설치되고 실행 중
- [ ] `dcproject` 데이터베이스가 생성됨
- [ ] `jdbctest` 사용자 (비밀번호: `1234`)가 생성됨
- [ ] `members` 테이블이 생성됨 (7개 컬럼)
- [ ] `board` 테이블이 생성됨 (6개 컬럼)
- [ ] 테스트 데이터 삽입 및 조회 성공
- [ ] 한글 데이터가 정상적으로 입력/조회됨

---

## 📞 추가 지원

### 🔍 유용한 SQL 명령어

```sql
-- 현재 사용자 확인
SELECT USER();

-- 현재 데이터베이스 확인
SELECT DATABASE();

-- 모든 데이터베이스 목록
SHOW DATABASES;

-- 모든 테이블 목록
SHOW TABLES;

-- 테이블 구조 확인
DESC 테이블명;

-- 테이블 데이터 삭제 (구조는 유지)
TRUNCATE TABLE 테이블명;

-- 테이블 자체를 삭제
DROP TABLE 테이블명;
```

---

## 📚 참고 자료

- [MySQL 공식 문서](https://dev.mysql.com/doc/)
- [MySQL Workbench 다운로드](https://dev.mysql.com/downloads/workbench/) - GUI 도구
- [HeidiSQL](https://www.heidisql.com/) - Windows용 무료 DB 관리 도구
- [Sequel Pro](https://www.sequelpro.com/) - macOS용 무료 DB 관리 도구 (구버전)
- [TablePlus](https://tableplus.com/) - 크로스 플랫폼 DB 관리 도구

---

## ⚙️ 프로젝트 연결 정보

이 프로젝트에서 사용하는 DB 연결 정보입니다:

```
데이터베이스: dcproject
호스트: localhost
포트: 3306
사용자명: jdbctest
비밀번호: 1234
```

> ⚠️ **주의:** 모든 팀원이 동일한 설정을 사용해야 합니다!

---

**작성일:** 2025-11-20  
**버전:** 1.0  
**대상:** 게시판 프로젝트 팀원 (4명)
