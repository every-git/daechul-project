package com.saeyan.controller.action.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.saeyan.controller.action.Action;

/**
 * 게시글 수정 처리 Action
 */
public class BoardUpdateAction implements Action {

    /**
     * 게시글 수정 요청을 처리하는 메서드
     * 
     * 처리 순서:
     * 1. request.setCharacterEncoding("UTF-8")로 인코딩 설정
     * 2. request에서 게시글 번호(seq), 제목(title), 내용(content) 파라미터 받기
     * 3. 세션에서 로그인 정보 확인 (userId, userRole)
     * 4. 로그인되지 않은 경우: index.jsp로 리다이렉트
     * 5. BoardDAO를 통해 해당 게시글 정보 조회
     * 6. 권한 체크: 작성자이거나 관리자(ADMIN)만 수정 가능
     * 7. 권한이 없는 경우: boardView.jsp로 포워드 (에러 메시지 포함)
     * 8. 권한이 있는 경우: BoardVO 객체 생성하여 수정 정보 설정 후 updateBoard 호출
     * 9. 게시글 상세보기 페이지로 리다이렉트
     * 
     * @param request HttpServletRequest 객체 (seq, title, content 파라미터 필요)
     * @param response HttpServletResponse 객체
     * @return 이동할 페이지 경로
     *         - 로그인 안됨: "redirect:" + request.getContextPath() + "/index.jsp"
     *         - 권한 없음: "/board/boardView.jsp" (message 속성에 "수정 권한이 없습니다." 저장)
     *         - 정상 처리: "redirect:" + request.getContextPath() + "/BoardServlet?command=board_view&seq=" + seq
     * @throws Exception 예외 발생 시
     */
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        // TODO: Implement this class
        // 1. request.setCharacterEncoding("UTF-8") 설정
        // 2. request.getParameter로 seq, title, content 받기
        // 3. 세션 체크 및 로그인 확인
        // 4. BoardDAO.getInstance().selectOneBySeq(seq)로 게시글 조회
        // 5. 권한 체크: userId.equals(board.getWriter()) || "ADMIN".equalsIgnoreCase(userRole)
        // 6. 권한 없으면 message와 board 저장 후 "/board/boardView.jsp" 반환
        // 7. 권한 있으면 BoardVO 생성하여 setSeq, setTitle, setContent 설정
        // 8. BoardDAO.getInstance().updateBoard(vo) 호출
        // 9. "redirect:" + request.getContextPath() + "/BoardServlet?command=board_view&seq=" + seq 반환
        return null;
    }
}
