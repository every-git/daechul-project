package com.saeyan.controller.action.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.saeyan.controller.action.Action;

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
     * @return 이동할 페이지 경로
     *         - 로그인 성공(관리자): "redirect:" + request.getContextPath() + "/AdminServlet?command=admin_main"
     *         - 로그인 성공(일반): "redirect:" + request.getContextPath() + "/member/main.jsp"
     *         - 로그인 실패: "/member/login.jsp" (message 속성에 "아이디 또는 비밀번호가 일치하지 않습니다." 저장)
     * @throws Exception 예외 발생 시
     */
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        // TODO: Implement this class
        // 1. request.getParameter("id"), getParameter("password")로 데이터 받기
        // 2. MemberDAO.getInstance().userCheck(id, password)로 인증 (반환값: 1=성공, 0=실패)
        // 3. 인증 성공 시:
        //    - MemberDAO.getInstance().getMember(id)로 회원 정보 조회
        //    - HttpSession session = request.getSession()
        //    - session.setAttribute("userId", member.getId())
        //    - session.setAttribute("userName", member.getName())
        //    - session.setAttribute("userRole", member.getRole())
        //    - 권한 체크: "ADMIN".equalsIgnoreCase(member.getRole())로 관리자 확인
        //    - 관리자면 "redirect:" + request.getContextPath() + "/AdminServlet?command=admin_main"
        //    - 일반회원이면 "redirect:" + request.getContextPath() + "/member/main.jsp"
        // 4. 인증 실패 시:
        //    - request.setAttribute("message", "아이디 또는 비밀번호가 일치하지 않습니다.")
        //    - "/member/login.jsp" 반환 (forward)
        return null;
    }
}
