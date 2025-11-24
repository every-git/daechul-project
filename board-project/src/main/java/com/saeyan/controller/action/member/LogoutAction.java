package com.saeyan.controller.action.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.saeyan.controller.action.Action;

/**
 * 로그아웃 처리 Action
 */
public class LogoutAction implements Action {

    /**
     * 로그아웃 요청을 처리하는 메서드
     * 
     * 처리 순서:
     * 1. 세션을 무효화하여 모든 세션 정보 삭제
     * 2. 메인 페이지로 리다이렉트
     * 
     * @param request HttpServletRequest 객체
     * @param response HttpServletResponse 객체
     * @throws ServletException 서블릿 예외 발생 시
     * @throws IOException 입출력 예외 발생 시
     */
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) 
    		throws ServletException, IOException {

    	HttpSession session = request.getSession();
    	
    	if(session != null) {
    		session.invalidate();
    	}
    	
    	String url = request.getContextPath() + "/index.jsp";
    	
    	response.sendRedirect(url);
    	
    }
}