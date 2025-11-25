package com.saeyan.controller.action.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.saeyan.controller.action.Action;
import com.saeyan.dao.MemberDAO;
import com.saeyan.dto.MemberVO;

/**
 * 회원 상세 정보 조회 Action
 */
public class MemberDetailAction implements Action {

    /**
     * 회원 상세 정보를 조회하여 화면에 표시하는 메서드 (관리자용)
     * 
     * 처리 순서:
     * 1. request에서 회원 아이디(id) 파라미터 받기
     * 2. MemberDAO를 통해 해당 회원 정보 조회
     * 3. 조회한 회원 정보를 request에 "member"라는 이름으로 저장
     * 4. 회원 상세 정보 페이지(memberDetail.jsp)로 포워드
     * 
     * @param request HttpServletRequest 객체 (id 파라미터 필요)
     * @param response HttpServletResponse 객체
     * @throws ServletException 서블릿 예외 발생 시
     * @throws IOException 입출력 예외 발생 시
     */
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO: Implement this class
        // 
        // 처리 순서:
        // 1. 이동할 페이지 경로 설정 (포워드 방식)
        //    - String url = "/admin/member/memberDetail.jsp"
        // 
        // 2. request에서 회원 아이디 파라미터 추출
        //    - 클라이언트가 전송한 파라미터 중 "id" 값을 가져옴
        //    - 예: /AdminServlet?command=member_detail&id=user123
        //    - String id = request.getParameter("id")
        // 
        // 3. MemberDAO 인스턴스 얻기
        //    - Singleton 패턴으로 구현된 DAO 클래스
        //    - getInstance() 메서드를 통해 유일한 인스턴스를 반환받음
        //    - com.saeyan.dao.MemberDAO memberDAO = com.saeyan.dao.MemberDAO.getInstance()
        // 
        // 4. 특정 회원 정보 조회
        //    - getMember(id) 메서드를 통해 데이터베이스에서 해당 아이디의 회원 정보를 조회
        //    - 반환 타입: MemberVO (회원 정보를 담는 DTO 객체)
        //    - com.saeyan.dto.MemberVO member = memberDAO.getMember(id)
        // 
        // 5. 조회한 회원 정보를 request에 저장
        //    - setAttribute() 메서드를 통해 JSP에서 사용할 수 있도록 데이터 저장
        //    - 첫 번째 파라미터: 속성 이름 (JSP에서 ${member}로 접근 가능)
        //    - 두 번째 파라미터: 저장할 객체
        //    - request.setAttribute("member", member)
        // 
        // 6. 포워드 방식으로 페이지 이동
        //    - getRequestDispatcher(): RequestDispatcher 객체를 얻어서 포워드 처리
        //    - forward(): 실제로 페이지 이동 수행
        //    - request.getRequestDispatcher(url).forward(request, response)
    	
    	String url = "/admin/member/memberDetail.jsp";
    	
    	String id = request.getParameter("id");
    	
    	MemberDAO dao = MemberDAO.getInstance();
    	MemberVO member = dao.getMember(id);
    	
    	request.setAttribute("member", member);
    	request.getRequestDispatcher(url).forward(request, response);
    	
    	
    	
    }
}
