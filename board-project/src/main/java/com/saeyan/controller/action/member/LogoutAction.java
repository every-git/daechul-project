package com.saeyan.controller.action.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
     * 2. 로그인 폼 페이지로 리다이렉트
     * 
     * @param request HttpServletRequest 객체
     * @param response HttpServletResponse 객체
     * @return 이동할 페이지 경로: "redirect:" + request.getContextPath() + "/MemberServlet?command=login_form"
     * @throws Exception 예외 발생 시
     */
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        // TODO: Implement this class
        // 1. HttpSession session = request.getSession()
        // 2. session.invalidate()로 세션 무효화
        // 3. "redirect:" + request.getContextPath() + "/MemberServlet?command=login_form" 반환
        return null;
    }
}
