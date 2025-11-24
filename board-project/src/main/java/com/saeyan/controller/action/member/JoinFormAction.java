package com.saeyan.controller.action.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.saeyan.controller.action.Action;

public class JoinFormAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		// 1. 회원가입 폼 페이지 경로 설정
		// - 포워드 방식으로 이동하므로 JSP 파일 경로만 설정
		String url = "/member/join.jsp";

		// 2. 포워드 방식(서버 내부에서 페이지 이동, URL 변경X)으로 페이지 이동
		// getRequestDispatcher(): RequestDispatcher 객체를 얻어서 포워드 처리
		request.getRequestDispatcher(url)
			//forward(): 실제로 페이지 이동 수행
			.forward(request, response);
	
	}
}