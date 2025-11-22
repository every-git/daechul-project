package com.saeyan.controller.action.admin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.saeyan.controller.action.Action;

/**
 * 회원 목록 조회 Action
 */
public class MemberListAction implements Action {

    /**
     * 회원 목록을 조회하여 화면에 표시하는 메서드 (관리자용)
     * 
     * 처리 순서:
     * 1. MemberDAO를 통해 모든 회원 목록 조회
     * 2. 조회한 회원 목록을 request에 "memberList"라는 이름으로 저장
     * 3. 회원 목록 페이지(memberList.jsp)로 포워드
     * 
     * @param request HttpServletRequest 객체
     * @param response HttpServletResponse 객체
     * @return 이동할 페이지 경로: "/admin/member/memberList.jsp"
     * @throws Exception 예외 발생 시
     */
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        // TODO: Implement this class
        // 1. MemberDAO.getInstance()로 DAO 인스턴스 얻기
        // 2. selectAllMembers() 메서드로 회원 목록 조회
        // 3. request.setAttribute("memberList", 조회결과)로 저장
        // 4. "/admin/member/memberList.jsp" 반환 (forward)
        return null;
    }
}
