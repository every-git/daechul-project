package com.saeyan.controller.action.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.saeyan.controller.action.Action;

/**
 * 게시글 수정 폼 표시 Action
 */
public class BoardUpdateFormAction implements Action {

    /**
     * 게시글 수정 폼 페이지를 표시하는 메서드
     * 
     * 처리 순서:
     * 1. request에서 게시글 번호(seq) 파라미터 받기
     * 2. 세션에서 로그인 정보 확인 (userId, userRole)
     * 3. 로그인되지 않은 경우: index.jsp로 리다이렉트
     * 4. BoardDAO를 통해 해당 게시글 정보 조회
     * 5. 권한 체크: 작성자이거나 관리자(ADMIN)만 수정 가능
     * 6. 권한이 없는 경우: boardView.jsp로 포워드 (에러 메시지 포함)
     * 7. 권한이 있는 경우: 게시글 정보를 request에 저장하고 boardUpdate.jsp로 포워드
     * 
     * @param request HttpServletRequest 객체 (seq 파라미터 필요)
     * @param response HttpServletResponse 객체
     * @return 이동할 페이지 경로
     *         - 로그인 안됨: "redirect:" + request.getContextPath() + "/index.jsp"
     *         - 권한 없음: "/board/boardView.jsp" (message 속성에 "수정 권한이 없습니다." 저장)
     *         - 정상 처리: "/board/boardUpdate.jsp" (board 속성에 게시글 정보 저장)
     * @throws Exception 예외 발생 시
     */
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        // TODO: Implement this class
        // 1. request.getParameter("seq")로 게시글 번호 받기
        // 2. 세션 체크 및 로그인 확인
        // 3. BoardDAO.getInstance().selectOneBySeq(seq)로 게시글 조회
        // 4. 권한 체크: userId.equals(board.getWriter()) || "ADMIN".equalsIgnoreCase(userRole)
        // 5. 권한 없으면 request.setAttribute("message", "수정 권한이 없습니다.") 및 board 저장 후 "/board/boardView.jsp" 반환
        // 6. 권한 있으면 request.setAttribute("board", board) 후 "/board/boardUpdate.jsp" 반환
        return null;
    }
}
