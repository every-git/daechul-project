package com.saeyan.controller.action.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.saeyan.controller.action.Action;

/**
 * 게시글 상세보기 Action
 */
public class BoardViewAction implements Action {

    /**
     * 게시글 상세 정보를 조회하여 화면에 표시하는 메서드
     * 
     * 처리 순서:
     * 1. 세션에서 로그인 정보 확인 (userId)
     * 2. 로그인되지 않은 경우: index.jsp로 리다이렉트
     * 3. request에서 게시글 번호(seq) 파라미터 받기
     * 4. BoardDAO를 통해 해당 게시글의 조회수 증가 (updateHit)
     * 5. BoardDAO를 통해 게시글 상세 정보 조회 (selectOneBySeq)
     * 6. 조회한 게시글 정보를 request에 "board"라는 이름으로 저장
     * 7. boardView.jsp로 포워드
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
        // 1. 이동할 페이지 경로 설정 (포워드 방식)
        //    - String url = "/board/boardView.jsp"
        // 
        // 2. 세션에서 로그인 정보 확인
        //    - getSession(): 현재 세션 객체를 가져옴 (없으면 새로 생성)
        //    - javax.servlet.http.HttpSession session = request.getSession()
        //    - String userId = (String) session.getAttribute("userId")
        // 
        // 3. 로그인 확인
        //    - 로그인되지 않은 경우 index.jsp로 리다이렉트
        //    - if (userId == null) {
        //        - url = request.getContextPath() + "/index.jsp"
        //        - response.sendRedirect(url)
        //        - return (메서드 종료)
        //      }
        // 
        // 4. request에서 게시글 번호 파라미터 추출 및 변환
        //    - 클라이언트가 전송한 파라미터 중 "seq" 값을 가져옴
        //    - 예: /BoardServlet?command=board_view&seq=123
        //    - String seqStr = request.getParameter("seq")
        //    - 파라미터를 정수형으로 변환
        //    - parseInt(): 문자열을 int 타입으로 변환
        //    - int seq = Integer.parseInt(seqStr)
        // 
        // 5. BoardDAO 인스턴스 얻기
        //    - Singleton 패턴으로 구현된 DAO 클래스
        //    - com.saeyan.dao.BoardDAO boardDAO = com.saeyan.dao.BoardDAO.getInstance()
        // 
        // 6. 게시글 조회수 증가
        //    - updateHit(seq) 메서드를 통해 해당 게시글의 조회수를 1 증가시킴
        //    - 게시글을 조회할 때마다 조회수가 증가하도록 함
        //    - boardDAO.updateHit(seq)
        // 
        // 7. 게시글 상세 정보 조회
        //    - selectOneBySeq(seq) 메서드를 통해 데이터베이스에서 해당 게시글 정보를 조회
        //    - 반환 타입: BoardVO (게시글 정보를 담는 DTO 객체)
        //    - com.saeyan.dto.BoardVO board = boardDAO.selectOneBySeq(seq)
        // 
        // 8. 조회한 게시글 정보를 request에 저장
        //    - setAttribute() 메서드를 통해 JSP에서 사용할 수 있도록 데이터 저장
        //    - 첫 번째 파라미터: 속성 이름 (JSP에서 ${board}로 접근 가능)
        //    - 두 번째 파라미터: 저장할 객체
        //    - request.setAttribute("board", board)
        // 
        // 9. 포워드 방식으로 페이지 이동
        //    - getRequestDispatcher(): RequestDispatcher 객체를 얻어서 포워드 처리
        //    - forward(): 실제로 페이지 이동 수행
        //    - request.getRequestDispatcher(url).forward(request, response)
    }
}
