package com.saeyan.controller.action.board;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.saeyan.controller.action.Action;
import com.saeyan.dao.BoardDAO;
import com.saeyan.dto.BoardVO;

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
        
    	String url = "/board/boardList.jsp";
        //1.세션에 로그인 정보 확인 
    	HttpSession session = request.getSession(); 
    	String userId = (String) session.getAttribute("userId");
        //2.로그인 되지 않을경우 index.jsp로 리다이렉트
    	if (userId == null) {
        url = request.getContextPath() + "/index.jsp";
        response.sendRedirect(url);
        return;
        }
       //3.DAO를 통해  모든 게시글 목록조회
        BoardDAO boardDAO = BoardDAO.getInstance();{
     
      //4.조회한 게시글목록을 requst에 boardList라는 이름으로 저장
        List<BoardVO> boardList = boardDAO.selectAllBoards();
        request.setAttribute("boardList", boardList);
      //5.boardList.jsp로 포워드
        request.getRequestDispatcher(url).forward(request, response);  
        }
    }
    }
