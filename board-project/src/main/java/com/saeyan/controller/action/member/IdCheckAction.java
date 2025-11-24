package com.saeyan.controller.action.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.saeyan.controller.action.Action;
import com.saeyan.dao.MemberDAO;

/**
 * 아이디 중복 확인 Action
 */
public class IdCheckAction implements Action {

    /**
     * 아이디 중복 확인 요청을 처리하는 메서드
     * 
     * 처리 순서:
     * 1. request에서 아이디(id) 파라미터 받기
     * 2. 아이디가 비어있거나 null인 경우: 에러 메시지와 함께 idCheck.jsp로 포워드
     * 3. MemberDAO를 통해 아이디 중복 확인 (confirmID)
     * 4. 확인 결과를 request에 저장하고 idCheck.jsp로 포워드
     * 
     * @param request HttpServletRequest 객체 (id 파라미터 필요)
     * @param response HttpServletResponse 객체
     * @throws ServletException 서블릿 예외 발생 시
     * @throws IOException 입출력 예외 발생 시
     */
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) 
    		throws ServletException, IOException {

        // 1. 이동할 페이지 경로 설정 (포워드 방식)
    	String url = "/member/idCheck.jsp";
    			
        // 2. request에서 아이디 파라미터 추출
    	String id = request.getParameter("id");

    	// 3. 파라미터 유효성 검사
    	if (id == null || id.trim().isEmpty()) {
    		request.setAttribute("message", "아이디를 입력해주세요.");
    		request.setAttribute("result", -1);
    		request.getRequestDispatcher(url)
    			.forward(request, response);
    		return;
    	}
    	
        // 4. MemberDAO를 통해 아이디 중복 확인
    	MemberDAO dao = MemberDAO.getInstance();
    	int result = dao.confirmID(id);
    	
        // 5. 확인 결과를 request에 저장
    	request.setAttribute("result", result);
    	request.setAttribute("id", id);
    	
    	// 6. 포워드 방식으로 아이디 중복 확인 페이지로 이동
    	request.getRequestDispatcher(url)
    	.forward(request, response);
    	
 
    }
}
