package com.saeyan.controller.action.member;

import java.io.IOException;

import javax.servlet.ServletException;
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
     * 2. 메인 페이지로 리다이렉트
     * 
     * @param request HttpServletRequest 객체
     * @param response HttpServletResponse 객체
     * @throws ServletException 서블릿 예외 발생 시
     * @throws IOException 입출력 예외 발생 시
     */
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO: Implement this class
        // 
        // 처리 순서:
        // 1. 세션 객체 가져오기
        //    - getSession(false): 현재 세션이 있으면 가져오고, 없으면 null 반환
        //    - false 파라미터: 세션이 없어도 새로 생성하지 않음
        //    - javax.servlet.http.HttpSession session = request.getSession(false)
        // 
        // 2. 세션 무효화
        //    - invalidate(): 세션을 무효화하여 모든 세션 정보 삭제
        //    - 세션에 저장된 모든 속성(userId, userName, userRole 등)이 삭제됨
        //    - if (session != null) {
        //        - session.invalidate()
        //      }
        // 
        // 3. 메인 페이지로 리다이렉트
        //    - 리다이렉트: 브라우저가 새로운 URL로 요청 (URL 변경됨)
        //    - getContextPath(): 웹 애플리케이션의 컨텍스트 경로 (예: /board-project)
        //    - String url = request.getContextPath() + "/index.jsp"
        //    - sendRedirect(): 브라우저에게 새로운 URL로 요청하도록 지시
        //    - response.sendRedirect(url)
    }
}
