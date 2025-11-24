package com.saeyan.controller.action.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.saeyan.controller.action.Action;

/**
 * 게시글 작성 폼 표시 Action
 */
public class BoardWriteFormAction implements Action {

    /**
     * 게시글 작성 폼 페이지를 표시하는 메서드
     * 
     * 처리 순서:
     * 1. 세션에서 로그인 정보 확인 (userId)
     * 2. 로그인되지 않은 경우: index.jsp로 리다이렉트
     * 3. 게시글 작성 폼 페이지(boardWrite.jsp)로 포워드
     * 
     * @param request HttpServletRequest 객체
     * @param response HttpServletResponse 객체
     * @throws ServletException 서블릿 예외 발생 시
     * @throws IOException 입출력 예외 발생 시
     */
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
    	
    	
    
       String url = "/board/boardWrite.jsp";
       HttpSession session = request.getSession();
       String userId = (String) session.getAttribute("userId");
    
        if (userId == null) {
         url = request.getContextPath() + "/index.jsp";
         response.sendRedirect(url);
         return;
           }
         request.getRequestDispatcher(url).forward(request, response);
    }
}
