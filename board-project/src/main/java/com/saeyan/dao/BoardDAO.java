package com.saeyan.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.saeyan.dto.BoardVO;
import util.DBManager;

/**
 * 게시글 데이터베이스 접근 객체 (Data Access Object)
 * 
 * 역할: 데이터베이스에서 게시글 데이터를 조회, 추가, 수정, 삭제하는 작업을 담당
 * 
 * 설계 패턴: 싱글톤 패턴
 * - 인스턴스를 하나만 생성하여 재사용
 * - 여러 곳에서 동일한 DAO 인스턴스를 사용하여 데이터 일관성 유지
 */
public class BoardDAO {

    // 싱글톤 패턴: 클래스 로드 시 한 번만 인스턴스 생성
    private static BoardDAO instance = new BoardDAO();

    // 외부에서 인스턴스 생성 방지 (private 생성자)
    private BoardDAO() {
    }

    /**
     * 싱글톤 인스턴스 반환 메서드
     * 
     * @return BoardDAO의 유일한 인스턴스
     */
    //---------------------------------------------------------------------------------------------------------
    public static BoardDAO getInstance() {
        return instance;
    }

    /**
     * 데이터베이스에서 모든 게시글을 조회하는 메서드
     * 
     * 처리 과정:
     * 1. DBManager를 통해 데이터베이스 연결 획득
     * 2. "select * from board order by seq desc" SQL 실행 (최신순 정렬)
     * 3. ResultSet을 순회하며 각 행을 BoardVO 객체로 변환
     * 4. 변환된 BoardVO 객체들을 List에 추가
     * 5. 모든 자원(Connection, PreparedStatement, ResultSet) 반납
     * 
     * @return 게시글 목록 (List<BoardVO>), 조회 실패 시 빈 리스트 반환
     *         - 정렬: 게시글 번호(seq) 내림차순 (최신 게시글이 먼저)
     */
    public List<BoardVO> selectAllBoards() {
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        String sql = "select * from board order by seq desc";
        List<BoardVO> list = new ArrayList<BoardVO>();

        try {
            con = DBManager.getConnection();
            pstmt = con.prepareStatement(sql);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                BoardVO vo = new BoardVO();
                vo.setSeq(rs.getInt("seq"));
                vo.setWriter(rs.getString("writer"));
                vo.setTitle(rs.getString("title"));
                vo.setContent(rs.getString("content"));
                vo.setHit(rs.getInt("hit"));
                vo.setRegdate(rs.getTimestamp("regdate"));
                list.add(vo);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBManager.close(con, pstmt, rs);
        }

        return list;
    }
//-----------------------------------------------------------------------------------
    /**
     * 게시글 작성 메서드
     * 
     * 처리 과정:
     * 1. DBManager를 통해 데이터베이스 연결 획득
     * 2. "insert into board (writer, title, content) values (?, ?, ?)" SQL 실행
     * 3. PreparedStatement에 게시글 정보(writer, title, content) 설정
     * 4. executeUpdate()로 INSERT 쿼리 실행
     * 5. 모든 자원(Connection, PreparedStatement) 반납
     * 
     * 주의사항:
     * - seq는 AUTO_INCREMENT로 자동 생성됨
     * - hit(조회수)는 기본값 0으로 설정됨
     * - regdate(작성일)는 현재 시간으로 자동 설정됨
     * 
     * @param vo 게시글 정보가 담긴 BoardVO 객체 (writer, title, content 필수)
     */
    public void insertBoard(BoardVO vo) {
        Connection con = null;
        PreparedStatement pstmt = null;

        String sql = "insert into board (writer, title, content) values (?, ?, ?)";

        try {
            con = DBManager.getConnection();
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, vo.getWriter());
            pstmt.setString(2, vo.getTitle());
            pstmt.setString(3, vo.getContent());
            pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBManager.close(con, pstmt);
        }
    }

    /**
     * 게시글 번호로 한 개의 게시글을 조회하는 메서드
     * 
     * 처리 과정:
     * 1. DBManager를 통해 데이터베이스 연결 획득
     * 2. "select * from board where seq = ?" SQL 실행
     * 3. PreparedStatement에 게시글 번호(seq) 설정
     * 4. ResultSet에서 조회된 데이터를 BoardVO 객체로 변환
     * 5. 모든 자원(Connection, PreparedStatement, ResultSet) 반납
     * 
     * @param seq 조회할 게시글 번호
     * @return BoardVO 객체 (게시글 정보가 담김)
     *         - 게시글이 존재하지 않으면 빈 BoardVO 객체 반환 (모든 필드가 기본값)
     */
    public BoardVO selectOneBySeq(int seq) {
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        String sql = "select * from board where seq = ?";
        BoardVO vo = new BoardVO();

        try {
            con = DBManager.getConnection();
            pstmt = con.prepareStatement(sql);
            pstmt.setInt(1, seq);
            rs = pstmt.executeQuery();

            if (rs.next()) {
                vo.setSeq(rs.getInt("seq"));
                vo.setWriter(rs.getString("writer"));
                vo.setTitle(rs.getString("title"));
                vo.setContent(rs.getString("content"));
                vo.setHit(rs.getInt("hit"));
                vo.setRegdate(rs.getTimestamp("regdate"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBManager.close(con, pstmt, rs);
        }
        return vo;
    }

    /**
     * 게시글 수정 메서드
     * 
     * 처리 과정:
     * 1. DBManager를 통해 데이터베이스 연결 획득
     * 2. "update board set title = ?, content = ? where seq = ?" SQL 실행
     * 3. PreparedStatement에 수정할 정보(title, content, seq) 설정
     * 4. executeUpdate()로 UPDATE 쿼리 실행
     * 5. 모든 자원(Connection, PreparedStatement) 반납
     * 
     * 주의사항:
     * - 제목(title)과 내용(content)만 수정 가능
     * - 작성자(writer), 조회수(hit), 작성일(regdate)은 수정되지 않음
     * 
     * @param vo 수정할 게시글 정보가 담긴 BoardVO 객체 (seq, title, content 필수)
     */
    public void updateBoard(BoardVO vo) {
        Connection con = null;
        PreparedStatement pstmt = null;

        String sql = "update board set title = ?, content = ? where seq = ?";

        try {
            con = DBManager.getConnection();
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, vo.getTitle());
            pstmt.setString(2, vo.getContent());
            pstmt.setInt(3, vo.getSeq());
            pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBManager.close(con, pstmt);
        }
    }
//--------------------------------------------------------------------------------------------------
    /**
     * 게시글 삭제 메서드
     * 
     * 처리 과정:
     * 1. DBManager를 통해 데이터베이스 연결 획득
     * 2. "delete from board where seq = ?" SQL 실행
     * 3. PreparedStatement에 삭제할 게시글 번호(seq) 설정
     * 4. executeUpdate()로 DELETE 쿼리 실행
     * 5. 모든 자원(Connection, PreparedStatement) 반납
     * 
     * 주의사항:
     * - 물리적 삭제(실제 DB에서 레코드 삭제)
     * - 삭제된 게시글은 복구 불가능
     * 
     * @param seq 삭제할 게시글 번호
     */
    public void deleteBoard(int seq) {
        Connection con = null;
        PreparedStatement pstmt = null;

        String sql = "delete from board where seq = ?";

        try {
            con = DBManager.getConnection();
            pstmt = con.prepareStatement(sql);
            pstmt.setInt(1, seq);
            pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBManager.close(con, pstmt);
        }
    }
//-----------------------------------------------------------------------------------------------------
    /**
     * 게시글 조회수 증가 메서드
     * 
     * 처리 과정:
     * 1. DBManager를 통해 데이터베이스 연결 획득
     * 2. "update board set hit = hit + 1 where seq = ?" SQL 실행
     * 3. PreparedStatement에 게시글 번호(seq) 설정
     * 4. executeUpdate()로 UPDATE 쿼리 실행 (hit 값을 1 증가)
     * 5. 모든 자원(Connection, PreparedStatement) 반납
     * 
     * 사용 시점:
     * - 게시글 상세보기 시 호출하여 조회수 증가
     * 
     * @param seq 조회수를 증가시킬 게시글 번호
     */
    public void updateHit(int seq) {
        Connection con = null;
        PreparedStatement pstmt = null;

        String sql = "update board set hit = hit + 1 where seq = ?";

        try {
            con = DBManager.getConnection();
            pstmt = con.prepareStatement(sql);
            pstmt.setInt(1, seq);
            pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBManager.close(con, pstmt);
        }
    }
}
