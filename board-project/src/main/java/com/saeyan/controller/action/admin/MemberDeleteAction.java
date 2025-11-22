package com.saeyan.controller.action.admin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.saeyan.controller.action.Action;

/**
 * 회원 삭제 처리 Action (관리자)
 */
public class MemberDeleteAction implements Action {

    /**
     * 회원 삭제 요청을 처리하는 메서드 (관리자용)
     * 
     * 처리 순서:
     * 1. request에서 회원 아이디(id) 파라미터 받기
     * 2. 아이디가 비어있거나 null인 경우: 에러 메시지와 함께 memberList.jsp로 포워드
     * 3. 세션에서 현재 로그인한 사용자 아이디 확인
     * 4. 자기 자신은 삭제할 수 없도록 체크
     * 5. MemberDAO를 통해 회원 삭제 (deleteMember)
     * 6. 성공 시 회원 목록 페이지로 리다이렉트, 실패 시 memberList.jsp로 포워드 (에러 메시지 포함)
     * 
     * @param request HttpServletRequest 객체 (id 파라미터 필요)
     * @param response HttpServletResponse 객체
     * @return 이동할 페이지 경로
     *         - 아이디 없음: "/admin/member/memberList.jsp" (message 속성에 "회원 아이디가 없습니다." 저장)
     *         - 자기 자신 삭제 시도: "/admin/member/memberList.jsp" (message 속성에 "자기 자신은 삭제할 수 없습니다." 저장)
     *         - 삭제 성공: "redirect:" + request.getContextPath() + "/AdminServlet?command=member_list"
     *         - 삭제 실패: "/admin/member/memberList.jsp" (message 속성에 "회원 삭제에 실패했습니다." 저장)
     * @throws Exception 예외 발생 시
     */
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        // TODO: Implement this class
        // 1. request.getParameter("id")로 회원 아이디 받기
        // 2. 아이디가 null이거나 isEmpty()면 에러 메시지와 함께 "/admin/member/memberList.jsp" 반환
        // 3. HttpSession session = request.getSession()
        // 4. String currentUserId = (String) session.getAttribute("userId")
        // 5. id.equals(currentUserId)면 "자기 자신은 삭제할 수 없습니다." 메시지와 함께 "/admin/member/memberList.jsp" 반환
        // 6. MemberDAO.getInstance().deleteMember(id) 호출 (반환값: 1=성공, 0=실패)
        // 7. 성공하면 "redirect:" + request.getContextPath() + "/AdminServlet?command=member_list" 반환
        // 8. 실패하면 에러 메시지와 함께 "/admin/member/memberList.jsp" 반환
        return null;
    }
}
