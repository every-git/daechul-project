package com.saeyan.controller.action.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.saeyan.controller.action.Action;

/**
 * 회원가입 처리 Action
 */
public class JoinAction implements Action {

    /**
     * 회원가입 요청을 처리하는 메서드
     * 
     * 처리 순서:
     * 1. request.setCharacterEncoding("UTF-8")로 인코딩 설정
     * 2. request에서 회원 정보 파라미터 받기 (id, password, password_confirm, name, email, phone, role, admin_password)
     * 3. 비밀번호 일치 확인 (password와 password_confirm 비교)
     * 4. 관리자 가입인 경우 관리자 비밀번호 확인 (admin_password가 "9876"인지 확인)
     * 5. 아이디 중복 확인 (MemberDAO.confirmID)
     * 6. MemberVO 객체 생성하여 회원 정보 설정
     * 7. MemberDAO를 통해 회원 등록 (insertMember)
     * 8. 성공 시 로그인 폼으로 리다이렉트, 실패 시 join.jsp로 포워드 (에러 메시지 포함)
     * 
     * @param request HttpServletRequest 객체 (id, password, password_confirm, name, email, phone, role, admin_password 파라미터 필요)
     * @param response HttpServletResponse 객체
     * @return 이동할 페이지 경로
     *         - 비밀번호 불일치: "/member/join.jsp" (message 속성에 "비밀번호가 일치하지 않습니다." 저장)
     *         - 관리자 비밀번호 오류: "/member/join.jsp" (message 속성에 적절한 에러 메시지 저장)
     *         - 아이디 중복: "/member/join.jsp" (message 속성에 "이미 사용 중인 아이디입니다." 저장)
     *         - 회원가입 성공: "redirect:" + request.getContextPath() + "/MemberServlet?command=login_form"
     *         - 회원가입 실패: "/member/join.jsp" (message 속성에 "회원가입에 실패했습니다. 다시 시도해주세요." 저장)
     * @throws Exception 예외 발생 시
     */
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        // TODO: Implement this class
        // 1. request.setCharacterEncoding("UTF-8") 설정
        // 2. request.getParameter로 모든 회원 정보 받기
        // 3. 비밀번호 일치 확인: !password.equals(passwordConfirm)이면 에러 메시지와 함께 "/member/join.jsp" 반환
        // 4. 관리자 가입 체크: "ADMIN".equalsIgnoreCase(role)이면 admin_password가 "9876"인지 확인
        // 5. role이 null이면 "MEMBER"로 설정
        // 6. MemberDAO.getInstance().confirmID(id)로 아이디 중복 확인 (반환값: 1=중복, 0=사용가능)
        // 7. 중복이면 에러 메시지와 함께 "/member/join.jsp" 반환
        // 8. MemberVO 객체 생성하여 모든 정보 설정
        // 9. MemberDAO.getInstance().insertMember(member) 호출 (반환값: 1=성공, 0=실패)
        // 10. 성공하면 "redirect:" + request.getContextPath() + "/MemberServlet?command=login_form" 반환
        // 11. 실패하면 에러 메시지와 함께 "/member/join.jsp" 반환
        return null;
    }
}
