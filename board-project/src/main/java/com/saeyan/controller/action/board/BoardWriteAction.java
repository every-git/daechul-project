package com.saeyan.controller.action.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.saeyan.controller.action.Action;

/**
 * 게시글 작성 처리 Action
 */
public class BoardWriteAction implements Action {

    /**
     * 게시글 작성 요청을 처리하는 메서드
     * 
     * 처리 순서:
     * 1. request.setCharacterEncoding("UTF-8")로 인코딩 설정
     * 2. 세션에서 로그인 정보 확인 (userId)
     * 3. 로그인되지 않은 경우: index.jsp로 리다이렉트
     * 4. request에서 게시글 제목(title), 내용(content) 파라미터 받기
     * 5. BoardVO 객체 생성하여 작성자(writer), 제목, 내용 설정
     * 6. BoardDAO를 통해 게시글 등록 (insertBoard)
     * 7. 게시글 목록 페이지로 리다이렉트
     * 
     * @param request HttpServletRequest 객체 (title, content 파라미터 필요)
     * @param response HttpServletResponse 객체
     * @throws ServletException 서블릿 예외 발생 시
     * @throws IOException 입출력 예외 발생 시
     */
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO: Implement this class
        // 
        // 처리 순서:
        // 1. 요청 인코딩 설정
        //    - 한글 처리를 위해 UTF-8 인코딩 설정
        //    - request.setCharacterEncoding("UTF-8")
        // 
        // 2. 세션에서 로그인 정보 확인
        //    - getSession(): 현재 세션 객체를 가져옴 (없으면 새로 생성)
        //    - javax.servlet.http.HttpSession session = request.getSession()
        //    - String userId = (String) session.getAttribute("userId")
        // 
        // 3. 로그인 확인
        //    - 로그인되지 않은 경우 index.jsp로 리다이렉트
        //    - if (userId == null) {
        //        - String url = request.getContextPath() + "/index.jsp"
        //        - response.sendRedirect(url)
        //        - return (메서드 종료)
        //      }
        // 
        // 4. request에서 게시글 정보 파라미터 추출
        //    - 클라이언트가 전송한 파라미터 중 "title", "content" 값을 가져옴
        //    - String title = request.getParameter("title")
        //    - String content = request.getParameter("content")
        // 
        // 5. BoardVO 객체 생성하여 게시글 정보 설정
        //    - BoardVO: 게시글 정보를 담는 DTO 객체
        //    - com.saeyan.dto.BoardVO board = new com.saeyan.dto.BoardVO()
        //    - 작성자 설정: board.setWriter(userId) (세션의 userId 사용)
        //    - 제목 설정: board.setTitle(title)
        //    - 내용 설정: board.setContent(content)
        // 
        // 6. BoardDAO를 통해 게시글 등록
        //    - Singleton 패턴으로 구현된 DAO 클래스
        //    - com.saeyan.dao.BoardDAO boardDAO = com.saeyan.dao.BoardDAO.getInstance()
        //    - insertBoard(board) 메서드를 통해 데이터베이스에 게시글 등록
        //    - SQL의 INSERT 문 실행
        //    - boardDAO.insertBoard(board)
        // 
        // 7. 게시글 목록 페이지로 리다이렉트
        //    - 리다이렉트: 브라우저가 새로운 URL로 요청 (URL 변경됨)
        //    - getContextPath(): 웹 애플리케이션의 컨텍스트 경로 (예: /board-project)
        //    - String url = request.getContextPath() + "/BoardServlet?command=board_list"
        //    - sendRedirect(): 브라우저에게 새로운 URL로 요청하도록 지시
        //    - response.sendRedirect(url)
    }
}
