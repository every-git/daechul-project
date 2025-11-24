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
	 * 
	 * 처리 순서:
	 * 1. request.setCharacterEncoding("UTF-8")로 인코딩 설정
	 * 2. request에서 회원 정보 파라미터 받기 (id, password, password_confirm, name, email,
	 * phone, role, admin_password)
	 * 3. 비밀번호 일치 확인 (password와 password_confirm 비교)
	 * 4. 관리자 가입인 경우 관리자 비밀번호 확인 (admin_password가 "9876"인지 확인)
	 * 5. 아이디 중복 확인 (MemberDAO.confirmID)
	 * 6. MemberVO 객체 생성하여 회원 정보 설정
	 * 7. MemberDAO를 통해 회원 등록 (insertMember)
	 * 8. 성공 시 로그인 폼으로 리다이렉트, 실패 시 join.jsp로 포워드 (에러 메시지 포함)
	 * 
	 * @param request HttpServletRequest 객체
	 *                (id, password, password_confirm, name, email, phone, role,
	 *                admin_password 파라미터 필요)
	 */
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 1. 요청 인코딩 설정 : 한글 처리를 위해 UTF-8 인코딩 설정
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

		// 3. 비밀번호 일치 확인
		if (!password.equals(passwordConfirm)) {
			request.setAttribute("message", "비밀번호가 일치하지 않습니다.");
			String url = "/member/join.jsp";
			request.getRequestDispatcher(url)
					.forward(request, response);
			return;
		}

		// 4. 관리자로 가입하는 경우 관리자 비밀번호 확인 (관리자 비밀번호가 "9876"인지 확인)
		if ("ADMIN".equals(role)) {
			if (!"9876".equals(adminPassword)) {
				request.setAttribute("message", "관리자 비밀번호가 일치하지 않습니다.");
				String url = "/member/join.jsp";
				request.getRequestDispatcher(url)
						.forward(request, response);
				return;
			}
		}

		// 5. role이 null이면 MEMBER로 설정
		if (role == null || role.trim().isEmpty()) {
			role = "MEMBER";
		}

		// 6. MemberDAO를 통해 아이디 중복 확인
		MemberDAO dao = MemberDAO.getInstance();
		// 반환값: 1 (중복/사용불가) 또는 0 (사용가능)
		if (dao.confirmID(id) == 1) {
			request.setAttribute("message", "이미 사용 중인 아이디입니다.");
			request.getRequestDispatcher("/member/join.jsp")
					.forward(request, response);
			return;
		}

		// 8. MemberVO 객체 생성하여 회원 정보 설정
		// MemberVO: 회원 정보를 담는 DTO 객체
		MemberVO vo = new MemberVO();

		vo.setId(id);
		vo.setPassword(password);
		vo.setName(name);
		vo.setEmail(email);
		vo.setPhone(phone);
		vo.setRole(role);
		// 9. MemberDAO를 통해 회원 등록
		int result = dao.insertMember(vo);

		HttpSession session = request.getSession();

		if (result == 1) {
			session.setAttribute("message", "회원가입에 성공하였습니다.");
			session.setAttribute("id", vo.getId());
			String url = request.getContextPath() + "/MemberServlet?command=login_form";
			response.sendRedirect(url);
		} else {
			request.setAttribute("message", "회원가입에 실패하였습니다. 다시 시도해주세요.");
			String url = "/member/join.jsp";
			request.getRequestDispatcher(url)
					.forward(request, response);
			return;
		}
	}
}
