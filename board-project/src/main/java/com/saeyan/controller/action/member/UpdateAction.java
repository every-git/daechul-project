package com.saeyan.controller.action.member;

import java.io.IOException;

import javax.servlet.ServletException;
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
     * @throws ServletException 서블릿 예외 발생 시
     * @throws IOException 입출력 예외 발생 시
     */
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO: Implement this class
        // 
        // 처리 순서:
        // 1. 요청 인코딩 설정
        //    - 한글 처리를 위해 UTF-8 인코딩 설정
        //    - request.setCharacterEncoding("UTF-8")
        // 
        // 2. 세션에서 로그인 정보 확인
        //    - getSession(): 현재 세션 객체를 가져옴 (없으면 새로 생성)
        //    - javax.servlet.http.HttpSession session = request.getSession()
        //    - String userId = (String) session.getAttribute("userId")
        // 
        // 3. 로그인 확인
        //    - 로그인되지 않은 경우 로그인 폼으로 리다이렉트
        //    - if (userId == null) {
        //        - String url = request.getContextPath() + "/MemberServlet?command=login_form"
        //        - response.sendRedirect(url)
        //        - return (메서드 종료)
        //      }
        // 
        // 4. request에서 수정할 정보 파라미터 추출
        //    - 클라이언트가 전송한 파라미터 중 "password", "email", "phone" 값을 가져옴
        //    - String password = request.getParameter("password")
        //    - String email = request.getParameter("email")
        //    - String phone = request.getParameter("phone")
        // 
        // 5. MemberVO 객체 생성하여 회원 정보 설정
        //    - MemberVO: 회원 정보를 담는 DTO 객체
        //    - com.saeyan.dto.MemberVO member = new com.saeyan.dto.MemberVO()
        //    - member.setId(userId) (세션의 userId 사용)
        //    - member.setPassword(password)
        //    - member.setEmail(email)
        //    - member.setPhone(phone)
        // 
        // 6. MemberDAO를 통해 회원 정보 수정
        //    - Singleton 패턴으로 구현된 DAO 클래스
        //    - com.saeyan.dao.MemberDAO memberDAO = com.saeyan.dao.MemberDAO.getInstance()
        //    - updateMember(member) 메서드를 통해 데이터베이스에서 회원 정보 수정
        //    - 반환값: 1 (성공) 또는 0 (실패)
        //    - SQL의 UPDATE 문 실행 결과 (영향받은 행의 개수)
        //    - int result = memberDAO.updateMember(member)
        // 
        // 7. 수정 결과에 따른 처리
        //    - if (result == 1) {
        //        - 수정 성공 시 메인 페이지로 리다이렉트
        //        - 리다이렉트: 브라우저가 새로운 URL로 요청 (URL 변경됨)
        //        - getContextPath(): 웹 애플리케이션의 컨텍스트 경로 (예: /board-project)
        //        - String url = request.getContextPath() + "/member/main.jsp"
        //        - sendRedirect(): 브라우저에게 새로운 URL로 요청하도록 지시
        //        - response.sendRedirect(url)
        //      } else {
        //        - 수정 실패 시 에러 메시지 저장
        //        - request.setAttribute("message", "회원정보 수정에 실패했습니다.")
        //        - 포워드 방식으로 회원정보 수정 페이지로 이동
        //        - String url = "/member/memberUpdate.jsp"
        //        - request.getRequestDispatcher(url).forward(request, response)
        //      }
    }
}
