package com.saeyan.controller.action.admin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.saeyan.controller.action.Action;

/**
 * 회원 상세 정보 조회 Action
 */
public class MemberDetailAction implements Action {

    /**
     * 회원 상세 정보를 조회하여 화면에 표시하는 메서드 (관리자용)
     * 
     * 처리 순서:
     * 1. request에서 회원 아이디(id) 파라미터 받기
     * 2. MemberDAO를 통해 해당 회원 정보 조회
     * 3. 조회한 회원 정보를 request에 "member"라는 이름으로 저장
     * 4. 회원 상세 정보 페이지(memberDetail.jsp)로 포워드
     * 
     * @param request HttpServletRequest 객체 (id 파라미터 필요)
     * @param response HttpServletResponse 객체
     * @return 이동할 페이지 경로: "/admin/member/memberDetail.jsp"
     * @throws Exception 예외 발생 시
     */
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        // TODO: Implement this class
        // 1. request.getParameter("id")로 회원 아이디 받기
        // 2. MemberDAO.getInstance()로 DAO 인스턴스 얻기
        // 3. getMember(id) 메서드로 회원 정보 조회
        // 4. request.setAttribute("member", 조회결과)로 저장
        // 5. "/admin/member/memberDetail.jsp" 반환 (forward)
        return null;
    }
}
