package com.saeyan.controller.action.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.saeyan.controller.action.Action;
import com.saeyan.dao.MemberDAO;
import com.saeyan.dto.MemberVO;

public class JoinAction implements Action {

	/**
	 * 회원가입 요청을 처리하는 메서드
	 */
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 1. 요청 인코딩 설정
		request.setCharacterEncoding("UTF-8");

		// 2. request에서 회원 정보 파라미터 추출
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String passwordConfirm = request.getParameter("password_confirm");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String role = request.getParameter("role");
		String phone = request.getParameter("phone");
		String adminPassword = request.getParameter("admin_password");

		String url = "/member/join.jsp";

		// 3. 유효성 검사
		// 3-1. 비밀번호 일치 확인
		if (!password.equals(passwordConfirm)) {
			request.setAttribute("message", "비밀번호가 일치하지 않습니다.");
			request.getRequestDispatcher(url).forward(request, response);
			return;
		}

		// 3-2. 관리자 비밀번호 확인
		if ("ADMIN".equals(role) && !"9876".equals(adminPassword)) {
			request.setAttribute("message", "관리자 비밀번호가 일치하지 않습니다.");
			request.getRequestDispatcher(url).forward(request, response);
			return;
		}

		// 3-3. role 기본값 설정
		if (role == null || role.trim().isEmpty()) {
			role = "MEMBER";
		}

		// 3-4. 아이디 중복 확인
		MemberDAO dao = MemberDAO.getInstance();
		if (dao.confirmID(id) == 1) {
			request.setAttribute("message", "이미 사용 중인 아이디입니다.");
			request.getRequestDispatcher(url).forward(request, response);
			return;
		}

		// 4. MemberVO 객체 생성 및 설정
		MemberVO vo = new MemberVO();
		vo.setId(id);
		vo.setPassword(password);
		vo.setName(name);
		vo.setEmail(email);
		vo.setPhone(phone);
		vo.setRole(role);

		// 5. 회원 등록
		int result = dao.insertMember(vo);

		if (result == 1) {
			
			HttpSession session = request.getSession();
			session.setAttribute("message", "회원가입에 성공하였습니다.");
			session.setAttribute("id", vo.getId());
			// Redirect to login form command
			response.sendRedirect(request.getContextPath() + "/MemberServlet?command=login_form");
		} else {
			request.setAttribute("message", "회원가입에 실패하였습니다. 다시 시도해주세요.");
			request.getRequestDispatcher(url).forward(request, response);
		}
	}
}
