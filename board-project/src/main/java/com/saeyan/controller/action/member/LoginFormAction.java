package com.saeyan.controller.action.member;

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
     * @param request HttpServletRequest 객체
     * @param response HttpServletResponse 객체
     * @return 이동할 페이지 경로: "/member/login.jsp"
     * @throws Exception 예외 발생 시
     */
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        // TODO: Implement this class
        // 1. "/member/login.jsp" 반환 (forward)
        return null;
    }
}
