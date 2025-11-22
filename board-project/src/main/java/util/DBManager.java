package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * 데이터베이스 연결 관리 유틸리티 클래스
 * 
 * 역할:
 * - 데이터베이스 연결(Connection) 생성 및 관리
 * - 데이터베이스 자원(Connection, Statement, ResultSet) 해제
 * - 모든 DAO 클래스에서 공통으로 사용하는 유틸리티
 * 
 * 설계 패턴: Utility Class (모든 메서드가 static)
 * 
 * 사용 데이터베이스: MySQL
 * - 호스트: localhost:3306
 * - 데이터베이스명: dcproject
 * - 인코딩: UTF-8
 * 
 * web-study-11 패턴과 동일
 */
public class DBManager {

    /**
     * MySQL 데이터베이스 연결을 생성하는 메서드
     * 
     * 처리 과정:
     * 1. JDBC 드라이버 로드 (com.mysql.cj.jdbc.Driver)
     * 2. 연결 URL, 사용자 ID, 비밀번호를 이용하여 데이터베이스 접속
     * 3. Connection 객체 반환
     * 
     * 연결 정보:
     * - URL: jdbc:mysql://localhost:3306/dcproject
     * - Timezone: Asia/Seoul
     * - Character Encoding: UTF-8
     * - 사용자: jdbctest
     * 
     * 주의사항:
     * - 연결 실패 시 null 반환
     * - 사용 후 반드시 close() 메서드로 연결 해제 필요
     * 
     * @return Connection 객체 (연결 성공 시), 연결 실패 시 null
     */
    public static Connection getConnection() {

        Connection con = null;

        try {
            // JDBC 드라이버 로드
            Class.forName("com.mysql.cj.jdbc.Driver");

            // 연결 정보
            // characterEncoding=UTF-8&useUnicode=true: 한글 인코딩 처리
            con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/dcproject?serverTimezone=Asia/Seoul&characterEncoding=UTF-8&useUnicode=true",
                    "jdbctest",
                    "1234");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return con;
    }

    /**
     * SELECT 쿼리 수행 후 데이터베이스 자원을 반납하는 메서드
     * 
     * 처리 과정:
     * 1. ResultSet이 null이 아니면 close()
     * 2. Statement가 null이 아니면 close()
     * 3. Connection이 null이 아니면 close()
     * 4. 예외 발생 시에도 안전하게 처리
     * 
     * 사용 시점:
     * - SELECT 쿼리(selectAllBoards, selectOneBySeq 등) 실행 후
     * - ResultSet을 사용한 모든 쿼리 실행 후
     * 
     * 주의사항:
     * - 반드시 finally 블록에서 호출하여 예외 발생 시에도 자원 해제 보장
     * - null 체크를 통해 안전하게 처리
     * 
     * @param con  Connection 객체 (데이터베이스 연결)
     * @param stmt Statement 객체 (SQL 실행 객체, PreparedStatement도 가능)
     * @param rs   ResultSet 객체 (조회 결과)
     */
    public static void close(Connection con, Statement stmt, ResultSet rs) {
        try {
            if (rs != null)
                rs.close();
            if (stmt != null)
                stmt.close();
            if (con != null)
                con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * INSERT, UPDATE, DELETE 쿼리 수행 후 데이터베이스 자원을 반납하는 메서드
     * 
     * 처리 과정:
     * 1. Statement가 null이 아니면 close()
     * 2. Connection이 null이 아니면 close()
     * 3. 예외 발생 시에도 안전하게 처리
     * 
     * 사용 시점:
     * - INSERT 쿼리(insertBoard, insertMember 등) 실행 후
     * - UPDATE 쿼리(updateBoard, updateMember, updateHit 등) 실행 후
     * - DELETE 쿼리(deleteBoard, deleteMember 등) 실행 후
     * - ResultSet을 사용하지 않는 모든 쿼리 실행 후
     * 
     * 주의사항:
     * - 반드시 finally 블록에서 호출하여 예외 발생 시에도 자원 해제 보장
     * - null 체크를 통해 안전하게 처리
     * 
     * @param con  Connection 객체 (데이터베이스 연결)
     * @param stmt Statement 객체 (SQL 실행 객체, PreparedStatement도 가능)
     */
    public static void close(Connection con, Statement stmt) {
        try {
            if (stmt != null)
                stmt.close();
            if (con != null)
                con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
