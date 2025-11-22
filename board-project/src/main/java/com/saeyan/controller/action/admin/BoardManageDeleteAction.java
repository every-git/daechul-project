package com.saeyan.controller.action.admin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.saeyan.controller.action.Action;

/**
 * 게시글 삭제 처리 Action (관리자)
 */
public class BoardManageDeleteAction implements Action {

    /**
     * 게시글 삭제 요청을 처리하는 메서드 (관리자용)
     * 
     * 처리 순서:
     * 1. request에서 게시글 번호(seq) 파라미터 받기
     * 2. BoardDAO를 통해 게시글 삭제 (deleteBoard)
     * 3. 게시글 관리 목록 페이지로 리다이렉트
     * 
     * 주의: 관리자용이므로 권한 체크 없이 바로 삭제 처리합니다.
     * 
     * @param request HttpServletRequest 객체 (seq 파라미터 필요)
     * @param response HttpServletResponse 객체
     * @return 이동할 페이지 경로: "redirect:" + request.getContextPath() + "/AdminServlet?command=board_manage_list"
     * @throws Exception 예외 발생 시
     */
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        // TODO: Implement this class
        // 1. request.getParameter("seq")로 게시글 번호 받기 (Integer.parseInt 필요)
        // 2. BoardDAO.getInstance()로 DAO 인스턴스 얻기
        // 3. deleteBoard(seq) 메서드로 게시글 삭제
        // 4. "redirect:" + request.getContextPath() + "/AdminServlet?command=board_manage_list" 반환
        return null;
    }
}
