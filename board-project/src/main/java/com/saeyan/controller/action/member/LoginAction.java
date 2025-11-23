package com.saeyan.controller.action.member;

import java.io.IOException;

import javax.servlet.ServletException;
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
     * @throws ServletException 서블릿 예외 발생 시
     * @throws IOException 입출력 예외 발생 시
     */
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO: Implement this class
        // 
        // 처리 순서:
        // 1. request에서 로그인 정보 파라미터 추출
        //    - 클라이언트가 전송한 파라미터 중 "id", "password" 값을 가져옴
        //    - String id = request.getParameter("id")
        //    - String password = request.getParameter("password")
        // 
        // 2. MemberDAO를 통해 사용자 인증
        //    - Singleton 패턴으로 구현된 DAO 클래스
        //    - com.saeyan.dao.MemberDAO memberDAO = com.saeyan.dao.MemberDAO.getInstance()
        //    - userCheck(id, password) 메서드를 통해 아이디와 비밀번호가 일치하는지 확인
        //    - 반환값: 1 (인증 성공) 또는 0 (인증 실패)
        //    - int result = memberDAO.userCheck(id, password)
        // 
        // 3. 인증 성공 시 처리
        //    - if (result == 1) {
        //        - MemberDAO를 통해 회원 정보 조회
        //        - getMember(id) 메서드를 통해 데이터베이스에서 해당 회원 정보를 조회
        //        - 반환 타입: MemberVO
        //        - com.saeyan.dto.MemberVO member = memberDAO.getMember(id)
        // 
        //        - 세션에 사용자 정보 저장
        //        - getSession(): 현재 세션 객체를 가져옴 (없으면 새로 생성)
        //        - javax.servlet.http.HttpSession session = request.getSession()
        //        - session.setAttribute("userId", member.getId())
        //        - session.setAttribute("userName", member.getName())
        //        - session.setAttribute("userRole", member.getRole())
        // 
        //        - 권한에 따라 리다이렉트
        //        - equalsIgnoreCase(): 대소문자 구분 없이 문자열 비교
        //        - if ("ADMIN".equalsIgnoreCase(member.getRole())) {
        //            - 관리자인 경우 관리자 메인 페이지로 리다이렉트
        //            - String url = request.getContextPath() + "/AdminServlet?command=admin_main"
        //            - response.sendRedirect(url)
        //          } else {
        //            - 일반 회원인 경우 회원 메인 페이지로 리다이렉트
        //            - String url = request.getContextPath() + "/member/main.jsp"
        //            - response.sendRedirect(url)
        //          }
        //      }
        // 
        // 4. 인증 실패 시 처리
        //    - else {
        //        - 에러 메시지를 request에 저장
        //        - request.setAttribute("message", "아이디 또는 비밀번호가 일치하지 않습니다.")
        //        - 포워드 방식으로 로그인 페이지로 이동
        //        - String url = "/member/login.jsp"
        //        - request.getRequestDispatcher(url).forward(request, response)
        //      }
    }
}
