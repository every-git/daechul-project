package com.saeyan.controller.action.admin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.saeyan.controller.action.Action;

/**
 * 관리자 메인 페이지 표시 Action
 */
public class AdminMainAction implements Action {

    /**
     * 관리자 메인 페이지를 표시하는 메서드
     * 
     * 처리 순서:
     * 1. 관리자 메인 페이지(adminMain.jsp)로 포워드
     * 
     * @param request HttpServletRequest 객체
     * @param response HttpServletResponse 객체
     * @return 이동할 페이지 경로: "/admin/adminMain.jsp"
     * @throws Exception 예외 발생 시
     */
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        // TODO: Implement this class
        // 1. "/admin/adminMain.jsp" 반환 (forward)
        return null;
    }
}
