package com.saeyan.controller.action.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.saeyan.controller.action.Action;

/**
 * 회원정보 수정 처리 Action
 */
public class UpdateAction implements Action {

    /**
     * 회원정보 수정 요청을 처리하는 메서드
     * 
     * 처리 순서:
     * 1. request.setCharacterEncoding("UTF-8")로 인코딩 설정
     * 2. 세션에서 로그인 정보 확인 (userId)
     * 3. 로그인되지 않은 경우: 로그인 폼으로 리다이렉트
     * 4. request에서 수정할 정보 파라미터 받기 (password, email, phone)
     * 5. MemberVO 객체 생성하여 회원 정보 설정 (id는 세션의 userId 사용)
     * 6. MemberDAO를 통해 회원 정보 수정 (updateMember)
     * 7. 성공 시 메인 페이지로 리다이렉트, 실패 시 memberUpdate.jsp로 포워드 (에러 메시지 포함)
     * 
     * @param request HttpServletRequest 객체 (password, email, phone 파라미터 필요)
     * @param response HttpServletResponse 객체
     * @return 이동할 페이지 경로
     *         - 로그인 안됨: "redirect:" + request.getContextPath() + "/MemberServlet?command=login_form"
     *         - 수정 성공: "redirect:" + request.getContextPath() + "/member/main.jsp"
     *         - 수정 실패: "/member/memberUpdate.jsp" (message 속성에 "회원정보 수정에 실패했습니다." 저장)
     * @throws Exception 예외 발생 시
     */
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        // TODO: Implement this class
        // 1. request.setCharacterEncoding("UTF-8") 설정
        // 2. 세션 체크 및 로그인 확인 (userId)
        // 3. 로그인 안되면 "redirect:" + request.getContextPath() + "/MemberServlet?command=login_form" 반환
        // 4. request.getParameter로 password, email, phone 받기
        // 5. MemberVO 객체 생성하여 setId(userId), setPassword, setEmail, setPhone 설정
        // 6. MemberDAO.getInstance().updateMember(member) 호출 (반환값: 1=성공, 0=실패)
        // 7. 성공하면 "redirect:" + request.getContextPath() + "/member/main.jsp" 반환
        // 8. 실패하면 request.setAttribute("message", "회원정보 수정에 실패했습니다.") 후 "/member/memberUpdate.jsp" 반환
        return null;
    }
}
