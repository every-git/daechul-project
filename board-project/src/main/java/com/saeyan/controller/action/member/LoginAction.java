package com.saeyan.controller.action.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import com.saeyan.controller.action.Action;
import com.saeyan.dao.MemberDAO;
import com.saeyan.dto.MemberVO;

/**
 * 로그인 처리 Action
 */
public class LoginAction implements Action {

    /**
     * 로그인 요청을 처리하는 메서드
     * 
     * 처리 순서:
     * 1. request에서 아이디(id), 비밀번호(password) 파라미터 받기
     * 2. MemberDAO를 통해 사용자 인증 (userCheck)
     * 3. 인증 성공 시:
     *    - MemberDAO를 통해 회원 정보 조회 (getMember)
     *    - 세션에 사용자 정보 저장 (userId, userName, userRole)
     *    - 권한에 따라 리다이렉트 (관리자: AdminServlet, 일반회원: main.jsp)
     * 4. 인증 실패 시:
     *    - 에러 메시지를 request에 저장하고 login.jsp로 포워드
     * 
     * @param request HttpServletRequest 객체 (id, password 파라미터 필요)
     * @param response HttpServletResponse 객체
     * @throws ServletException 서블릿 예외 발생 시
     * @throws IOException 입출력 예외 발생 시
     */
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) 
    		throws ServletException, IOException {

    	String id = request.getParameter("id");
    	String password = request.getParameter("password");
    	
    	MemberDAO dao = MemberDAO.getInstance();
    	int result = dao.userCheck(id, password);
    	
    	if(result == 1) {
    		MemberVO vo  = dao.getMember(id);
    		HttpSession session = request.getSession();
    		session.setAttribute("userId", vo.getId());
    		session.setAttribute("userName", vo.getName());
    		session.setAttribute("userRole", vo.getRole());
    	
    		if("ADMIN".equals(vo.getRole())) {
    			String url = request.getContextPath() + "/AdminServlet?command=admin_main";
    			response.sendRedirect(url);
    		} else {
    			String url = request.getContextPath() + "/member/main.jsp";
    			response.sendRedirect(url);
    		}
    	} else {
    		request.setAttribute("message", "아이디 또는 비밀번호가 일치하지 않습니다.");
    		String url = "/member/login.jsp";
    		request.getRequestDispatcher(url)
    			.forward(request, response);
    	}
    	
    	
    }
}
