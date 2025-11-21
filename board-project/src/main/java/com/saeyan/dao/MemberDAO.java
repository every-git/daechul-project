package com.saeyan.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.saeyan.dto.MemberVO;
import util.DBManager;

/**
 * 회원 데이터베이스 접근 객체 (Data Access Object)
 * 
 * 역할: 데이터베이스에서 회원 데이터를 조회, 추가, 수정하는 작업을 담당
 * 
 * 설계 패턴: 싱글톤 패턴
 * - 인스턴스를 하나만 생성하여 재사용
 * - 프로그램 전체에서 동일한 DAO 인스턴스를 사용하여 데이터 일관성 유지
 */
public class MemberDAO {

    // 싱글톤 패턴: 클래스 로드 시 한 번만 인스턴스 생성
    private static MemberDAO instance = new MemberDAO();

    // 외부에서 인스턴스 생성 방지 (private 생성자)
    private MemberDAO() {
    }

    /**
     * 싱글톤 인스턴스 반환 메서드
     * 
     * @return MemberDAO의 유일한 인스턴스
     */
    public static MemberDAO getInstance() {
        return instance;
    }

    /**
     * 모든 회원 목록 조회
     * 
     * @return 회원 목록, 조회 실패 시 빈 리스트
     */
    public List<MemberVO> selectAllMembers() {
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        String sql = "select * from members order by regdate desc";
        List<MemberVO> list = new ArrayList<MemberVO>();

        try {
            con = DBManager.getConnection();
            pstmt = con.prepareStatement(sql);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                MemberVO member = new MemberVO();
                member.setId(rs.getString("id"));
                member.setPassword(rs.getString("password"));
                member.setName(rs.getString("name"));
                member.setEmail(rs.getString("email"));
                member.setRole(rs.getString("role"));
                member.setPhone(rs.getString("phone"));
                member.setRegdate(rs.getTimestamp("regdate"));
                list.add(member);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBManager.close(con, pstmt, rs);
        }

        return list;
    }

    /**
     * 로그인 인증 - 아이디와 비밀번호 확인
     * 
     * @param id       회원 아이디
     * @param password 비밀번호
     * @return 1: 로그인 성공, 0: 실패 (아이디 없음 또는 비밀번호 불일치), -1: DB 오류
     */
    public int userCheck(String id, String password) {
        int result = -1; // 기본값: DB 오류

        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            con = DBManager.getConnection();
            if (con == null) {
                return -1;
            }

            String sql = "select password from members where id = ?";
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, id);
            rs = pstmt.executeQuery();

            if (rs.next()) {
                String dbPassword = rs.getString("password");
                if (dbPassword != null && dbPassword.equals(password)) {
                    result = 1; // 로그인 성공
                } else {
                    result = 0; // 비밀번호 불일치
                }
            } else {
                result = 0; // 존재하지 않는 아이디
            }
        } catch (Exception e) {
            e.printStackTrace();
            result = -1;
        } finally {
            DBManager.close(con, pstmt, rs);
        }

        return result;
    }

    /**
     * 아이디로 회원 정보 조회
     * 
     * @param id 조회할 회원의 아이디
     * @return MemberVO 객체 (회원 정보가 없으면 null)
     */
    public MemberVO getMember(String id) {
        MemberVO member = null;
        String sql = "select * from members where id = ?";

        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            con = DBManager.getConnection();
            if (con == null) {
                return null;
            }

            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, id);
            rs = pstmt.executeQuery();

            if (rs.next()) {
                member = new MemberVO();
                member.setId(rs.getString("id"));
                member.setPassword(rs.getString("password"));
                member.setName(rs.getString("name"));
                member.setEmail(rs.getString("email"));
                member.setRole(rs.getString("role"));
                member.setPhone(rs.getString("phone"));
                member.setRegdate(rs.getTimestamp("regdate"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBManager.close(con, pstmt, rs);
        }

        return member;
    }

    /**
     * 아이디 중복 확인
     * 
     * @param id 확인할 아이디
     * @return 1: 중복 (이미 존재), 0: 사용 가능, -1: DB 오류
     */
    public int confirmID(String id) {
        int result = -1;

        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            con = DBManager.getConnection();

            String sql = "select id from members where id = ?";
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, id);
            rs = pstmt.executeQuery();

            if (rs.next()) {
                result = 1; // 중복
            } else {
                result = 0; // 사용 가능
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBManager.close(con, pstmt, rs);
        }

        return result;
    }

    /**
     * 회원가입 - 새 회원 정보 등록
     * 
     * @param member 회원 정보
     * @return 1: 성공, 0: 실패, -1: DB 오류
     */
    public int insertMember(MemberVO member) {
        int result = -1;

        String sql = "insert into members (id, password, name, email, role, phone) " +
                "values (?, ?, ?, ?, ?, ?)";
        Connection con = null;
        PreparedStatement pstmt = null;

        try {
            con = DBManager.getConnection();
            if (con == null) {
                return -1;
            }

            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, member.getId());
            pstmt.setString(2, member.getPassword());
            pstmt.setString(3, member.getName());
            pstmt.setString(4, member.getEmail());
            pstmt.setString(5, member.getRole());
            pstmt.setString(6, member.getPhone());

            result = pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            result = -1;
        } finally {
            DBManager.close(con, pstmt);
        }

        return result;
    }

    /**
     * 회원 정보 수정
     * 
     * @param member 수정할 회원 정보
     * @return 1: 성공, 0: 실패, -1: DB 오류
     */
    public int updateMember(MemberVO member) {
        int result = -1;

        String sql = "update members set password=?, email=?, phone=? where id=?";
        Connection con = null;
        PreparedStatement pstmt = null;

        try {
            con = DBManager.getConnection();

            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, member.getPassword());
            pstmt.setString(2, member.getEmail());
            pstmt.setString(3, member.getPhone());
            pstmt.setString(4, member.getId());

            result = pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBManager.close(con, pstmt);
        }

        return result;
    }

    /**
     * 회원 삭제 (강제 탈퇴)
     * 
     * @param id 삭제할 회원의 아이디
     * @return 1: 성공, 0: 실패, -1: DB 오류
     */
    public int deleteMember(String id) {
        int result = -1;

        String sql = "delete from members where id = ?";
        Connection con = null;
        PreparedStatement pstmt = null;

        try {
            con = DBManager.getConnection();
            if (con == null) {
                return -1;
            }

            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, id);

            result = pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            result = -1;
        } finally {
            DBManager.close(con, pstmt);
        }

        return result;
    }
}
