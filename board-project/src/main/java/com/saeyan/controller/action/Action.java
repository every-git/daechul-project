package com.saeyan.controller.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Action 인터페이스
 * Front Controller 패턴에서 사용되는 Command 인터페이스
 * web-study-11 패턴 적용
 */
public interface Action {
    /**
     * 클라이언트의 요청을 처리하는 메서드
     * @param request HttpServletRequest 객체
     * @param response HttpServletResponse 객체
     * @return 이동할 페이지 경로
     * @throws Exception 예외 발생 시
     */
    String execute(HttpServletRequest request, HttpServletResponse response) throws Exception;
}
