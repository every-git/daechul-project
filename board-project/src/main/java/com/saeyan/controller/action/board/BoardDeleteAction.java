package com.saeyan.controller.action.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.saeyan.controller.action.Action;

/**
 * 게시글 삭제 처리 Action
 */
public class BoardDeleteAction implements Action {

    /**
     * 게시글 삭제 요청을 처리하는 메서드
     * 
     * 처리 순서:
     * 1. request에서 게시글 번호(seq) 파라미터 받기
     * 2. 세션에서 로그인 정보 확인 (userId, userRole)
     * 3. 로그인되지 않은 경우: index.jsp로 리다이렉트
     * 4. BoardDAO를 통해 해당 게시글 정보 조회
     * 5. 권한 체크: 작성자이거나 관리자(ADMIN)만 삭제 가능
     * 6. 권한이 없는 경우: boardView.jsp로 포워드 (에러 메시지 포함)
     * 7. 권한이 있는 경우: BoardDAO를 통해 게시글 삭제 (deleteBoard)
     * 8. 게시글 목록 페이지로 리다이렉트
     * 
     * @param request HttpServletRequest 객체 (seq 파라미터 필요)
     * @param response HttpServletResponse 객체
     * @throws ServletException 서블릿 예외 발생 시
     * @throws IOException 입출력 예외 발생 시
     */
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO: Implement this class
        // 
        // 처리 순서:
        // 1. 세션에서 로그인 정보 확인
        //    - getSession(): 현재 세션 객체를 가져옴 (없으면 새로 생성)
        //    - javax.servlet.http.HttpSession session = request.getSession()
        //    - String userId = (String) session.getAttribute("userId")
        //    - String userRole = (String) session.getAttribute("userRole")
        // 
        // 2. 로그인 확인
        //    - 로그인되지 않은 경우 index.jsp로 리다이렉트
        //    - if (userId == null) {
        //        - String url = request.getContextPath() + "/index.jsp"
        //        - response.sendRedirect(url)
        //        - return (메서드 종료)
        //      }
        // 
        // 3. request에서 게시글 번호 파라미터 추출 및 변환
        //    - 클라이언트가 전송한 파라미터 중 "seq" 값을 가져옴
        //    - 예: /BoardServlet?command=board_delete&seq=123
        //    - String seqStr = request.getParameter("seq")
        //    - int seq = Integer.parseInt(seqStr)
        // 
        // 4. BoardDAO를 통해 게시글 정보 조회
        //    - Singleton 패턴으로 구현된 DAO 클래스
        //    - com.saeyan.dao.BoardDAO boardDAO = com.saeyan.dao.BoardDAO.getInstance()
        //    - selectOneBySeq(seq) 메서드를 통해 데이터베이스에서 해당 게시글 정보를 조회
        //    - 반환 타입: BoardVO
        //    - com.saeyan.dto.BoardVO board = boardDAO.selectOneBySeq(seq)
        // 
        // 5. 권한 체크
        //    - 작성자이거나 관리자(ADMIN)만 삭제 가능
        //    - equals(): 문자열 내용 비교 (==는 주소 비교이므로 사용 불가)
        //    - equalsIgnoreCase(): 대소문자 구분 없이 문자열 비교
        //    - if (!userId.equals(board.getWriter()) && !"ADMIN".equalsIgnoreCase(userRole)) {
        //        - 권한이 없는 경우 에러 메시지 저장
        //        - request.setAttribute("message", "삭제 권한이 없습니다.")
        //        - request.setAttribute("board", board)
        //        - String url = "/board/boardView.jsp"
        //        - request.getRequestDispatcher(url).forward(request, response)
        //        - return (메서드 종료)
        //      }
        // 
        // 6. 권한이 있는 경우 게시글 삭제 처리
        //    - deleteBoard(seq) 메서드를 통해 데이터베이스에서 해당 게시글을 삭제
        //    - SQL의 DELETE 문 실행
        //    - boardDAO.deleteBoard(seq)
        // 
        // 7. 게시글 목록 페이지로 리다이렉트
        //    - 리다이렉트: 브라우저가 새로운 URL로 요청 (URL 변경됨)
        //    - getContextPath(): 웹 애플리케이션의 컨텍스트 경로 (예: /board-project)
        //    - String url = request.getContextPath() + "/BoardServlet?command=board_list"
        //    - sendRedirect(): 브라우저에게 새로운 URL로 요청하도록 지시
        //    - response.sendRedirect(url)
    }
}
