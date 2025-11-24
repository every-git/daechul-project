package com.saeyan.controller.action.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.saeyan.controller.action.Action;
import com.saeyan.dao.BoardDAO;
import com.saeyan.dto.BoardVO;

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

	@SuppressWarnings("unused")
	@Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	request.setCharacterEncoding("UTF-8");
    	response.setContentType("text/html; charset=UTF-8");
    		
        	HttpSession session = request.getSession();
        	String userId = (String) session.getAttribute("userId");
        
      
      if (userId == null) {
         String url = request.getContextPath() + "/index.jsp";
         response.sendRedirect(url);
        return ;
              }
       
                String title = request.getParameter("title");
                String content = request.getParameter("content");
                BoardVO board = new BoardVO();
     
      
                BoardDAO boardDAO = BoardDAO.getInstance();
                boardDAO.insertBoard(board);
                String url = request.getContextPath() + "/BoardServlet?command=board_list";           
                response.sendRedirect(url);
    }
}
