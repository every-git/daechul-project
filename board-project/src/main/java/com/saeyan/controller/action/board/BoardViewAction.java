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
  
    	String url = "/board/boardView.jsp";
    
    	//1. 세션에서 로그인 정보 확인 (userId)
        	HttpSession session = request.getSession();
        	String userId = (String) session.getAttribute("userId");
        	//2. 로그인되지 않은 경우: index.jsp로 리다이렉트
        	if (userId == null) {
        		url = request.getContextPath() + "/index.jsp";
        		response.sendRedirect(url);
        		return;
        		}
        	//3. request에서 게시글 번호(seq) 파라미터 받기
        	String seqStr = request.getParameter("seq");
        	int seq = Integer.parseInt(seqStr);
        	
        		//4.BoardDAO를 통해 해당 게시글의 조회수 증가 (updateHit)     	
        		BoardDAO boardDAO = BoardDAO.getInstance();
        		boardDAO.updateHit(seq);
        		//5.BoardDAO를 통해 게시글 상세 정보 조회 (selectOneBySeq)
        		BoardVO board = boardDAO.selectOneBySeq(seq);
        		//6.조회한 게시글 정보를 request에 "board"라는 이름으로 저장
        		request.setAttribute("board", board);
        		//7.boardView.jsp로 포워드
        		request.getRequestDispatcher(url).forward(request, response);
    }
}
