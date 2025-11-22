package com.saeyan.controller.action.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.saeyan.controller.action.Action;

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
     * @return 이동할 페이지 경로: "/member/idCheck.jsp"
     *         - request 속성:
     *           - id: 확인한 아이디
     *           - result: 중복 확인 결과 (1=중복/사용불가, 0=사용가능, -1=입력오류)
     *           - message: 에러 메시지 (입력 오류 시에만)
     * @throws Exception 예외 발생 시
     */
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        // TODO: Implement this class
        // 1. request.getParameter("id")로 아이디 받기
        // 2. 아이디가 null이거나 trim().isEmpty()면:
        //    - request.setAttribute("message", "아이디를 입력해주세요.")
        //    - request.setAttribute("result", -1)
        //    - "/member/idCheck.jsp" 반환
        // 3. MemberDAO.getInstance().confirmID(id) 호출 (반환값: 1=중복, 0=사용가능)
        // 4. request.setAttribute("id", id)
        // 5. request.setAttribute("result", result)
        // 6. "/member/idCheck.jsp" 반환 (forward)
        return null;
    }
}
