package com.saeyan.controller.action.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.saeyan.controller.action.Action;

/**
 * 회원가입 폼 표시 Action
 */
public class JoinFormAction implements Action {

    /**
     * 회원가입 폼 페이지를 표시하는 메서드
     * 
     * 처리 순서:
     * 1. 회원가입 폼 페이지(join.jsp)로 포워드
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
        // 1. 회원가입 폼 페이지 경로 설정
        //    - 포워드 방식으로 이동하므로 JSP 파일 경로만 설정
        //    - String url = "/member/join.jsp"
        // 
        // 2. 포워드 방식으로 페이지 이동
        //    - 포워드: 서버 내부에서 페이지 이동 (URL 변경 안됨)
        //    - request와 response 객체가 그대로 전달됨
        //    - getRequestDispatcher(): RequestDispatcher 객체를 얻어서 포워드 처리
        //    - forward(): 실제로 페이지 이동 수행
        //    - request.getRequestDispatcher(url).forward(request, response)
    }
}
