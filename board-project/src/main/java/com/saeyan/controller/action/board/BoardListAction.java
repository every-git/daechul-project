package com.saeyan.controller.action.board;

import java.io.IOException;

import javax.servlet.ServletException;
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
     * 2. 로그인되지 않은 경우: index.jsp로 리다이렉트
     * 3. BoardDAO를 통해 모든 게시글 목록 조회
     * 4. 조회한 게시글 목록을 request에 "boardList"라는 이름으로 저장
     * 5. boardList.jsp로 포워드
     * 
     * @param request HttpServletRequest 객체
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
        //    - String url = "/board/boardList.jsp"
        // 
        // 2. 세션에서 로그인 정보 확인
        //    - getSession(): 현재 세션 객체를 가져옴 (없으면 새로 생성)
        //    - 세션: 서버에 저장되는 사용자별 정보 (로그인 상태 유지)
        //    - javax.servlet.http.HttpSession session = request.getSession()
        //    - 세션에 저장된 사용자 아이디 가져오기
        //    - 로그인 시 세션에 "userId"라는 이름으로 저장됨
        //    - Object 타입으로 반환되므로 String으로 형변환 필요
        //    - String userId = (String) session.getAttribute("userId")
        // 
        // 3. 로그인 확인
        //    - 로그인되지 않은 경우 index.jsp로 리다이렉트
        //    - if (userId == null) {
        //        - url = request.getContextPath() + "/index.jsp"
        //        - sendRedirect(): 브라우저에게 새로운 URL로 요청하도록 지시
        //        - response.sendRedirect(url)
        //        - return (메서드 종료)
        //      }
        // 
        // 4. BoardDAO 인스턴스 얻기
        //    - Singleton 패턴으로 구현된 DAO 클래스
        //    - getInstance() 메서드를 통해 유일한 인스턴스를 반환받음
        //    - com.saeyan.dao.BoardDAO boardDAO = com.saeyan.dao.BoardDAO.getInstance()
        // 
        // 5. 모든 게시글 목록 조회
        //    - selectAllBoards() 메서드를 통해 데이터베이스에서 전체 게시글 정보를 조회
        //    - 반환 타입: List<BoardVO>
        //    - java.util.List<com.saeyan.dto.BoardVO> boardList = boardDAO.selectAllBoards()
        // 
        // 6. 조회한 게시글 목록을 request에 저장
        //    - setAttribute() 메서드를 통해 JSP에서 사용할 수 있도록 데이터 저장
        //    - 첫 번째 파라미터: 속성 이름 (JSP에서 ${boardList}로 접근 가능)
        //    - 두 번째 파라미터: 저장할 객체
        //    - request.setAttribute("boardList", boardList)
        // 
        // 7. 포워드 방식으로 페이지 이동
        //    - getRequestDispatcher(): RequestDispatcher 객체를 얻어서 포워드 처리
        //    - forward(): 실제로 페이지 이동 수행
        //    - request.getRequestDispatcher(url).forward(request, response)
    }
}
