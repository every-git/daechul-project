package com.saeyan.controller.action.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.saeyan.controller.action.Action;

/**
 * 게시글 목록 표시 Action
 */
public class BoardListAction implements Action {

    /**
     * 게시글 목록을 조회하여 화면에 표시하는 메서드
     * 
     * 처리 순서:
     * 1. 세션에서 로그인 정보 확인 (userId)
     * 2. 로그인되지 않은 경우: index.jsp로 리다이렉트 ("redirect:" + request.getContextPath() + "/index.jsp")
     * 3. BoardDAO를 통해 모든 게시글 목록 조회
     * 4. 조회한 게시글 목록을 request에 "boardList"라는 이름으로 저장
     * 5. boardList.jsp로 포워드 ("/board/boardList.jsp")
     * 
     * @param request HttpServletRequest 객체
     * @param response HttpServletResponse 객체
     * @return 이동할 페이지 경로
     *         - 로그인 안됨: "redirect:" + request.getContextPath() + "/index.jsp"
     *         - 정상 처리: "/board/boardList.jsp"
     * @throws Exception 예외 발생 시
     */
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        // TODO: Implement this class
        // 1. 세션 체크 (HttpSession session = request.getSession())
        // 2. 로그인 확인 (session.getAttribute("userId"))
        // 3. BoardDAO.getInstance()로 DAO 인스턴스 얻기
        // 4. selectAllBoards() 메서드로 게시글 목록 조회
        // 5. request.setAttribute("boardList", 조회결과)로 저장
        // 6. "/board/boardList.jsp" 반환 (forward)
        return null;
    }
}
