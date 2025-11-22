package com.saeyan.controller.action.admin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.saeyan.controller.action.Action;

/**
 * 게시글 관리 목록 조회 Action
 */
public class BoardManageListAction implements Action {

    /**
     * 게시글 관리 목록을 조회하여 화면에 표시하는 메서드 (관리자용)
     * 
     * 처리 순서:
     * 1. BoardDAO를 통해 모든 게시글 목록 조회
     * 2. 조회한 게시글 목록을 request에 "boardList"라는 이름으로 저장
     * 3. 게시글 관리 페이지(boardManage.jsp)로 포워드
     * 
     * @param request HttpServletRequest 객체
     * @param response HttpServletResponse 객체
     * @return 이동할 페이지 경로: "/admin/board/boardManage.jsp"
     * @throws Exception 예외 발생 시
     */
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        // TODO: Implement this class
        // 1. BoardDAO.getInstance()로 DAO 인스턴스 얻기
        // 2. selectAllBoards() 메서드로 게시글 목록 조회
        // 3. request.setAttribute("boardList", 조회결과)로 저장
        // 4. "/admin/board/boardManage.jsp" 반환 (forward)
        return null;
    }
}
