package com.saeyan.controller.action.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.saeyan.controller.action.Action;

/**
 * 로그인 폼 표시 Action
 */
public class LoginFormAction implements Action {

    /**
     * 로그인 폼 페이지를 표시하는 메서드
     * 
     * 처리 순서:
     * 1. 로그인 폼 페이지(login.jsp)로 포워드
     * 
     * @param request  HttpServletRequest 객체
     * @param response HttpServletResponse 객체
     * @throws ServletException 서블릿 예외 발생 시
     * @throws IOException      입출력 예외 발생 시
     */
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url = "/member/login.jsp";
        request.getRequestDispatcher(url).forward(request, response);
    }
}
