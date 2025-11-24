package com.saeyan.controller.action.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.saeyan.controller.action.Action;
import com.saeyan.dao.MemberDAO;

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
     * @param request HttpServletRequest 객체
     *  (id, password, password_confirm, name, email, phone, role, admin_password 파라미터 필요)
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
    	if (!password.equals("password_confirm")) {
    		request.setAttribute("message", "비밀번호가 일치하지 않습니다.");
    		String url = "/member/join.jsp";
    		request.getRequestDispatcher(url)
    			.forward(request, response);
    		return;
    	}
    	
        // 4. 관리자로 가입하는 경우 관리자 비밀번호 확인 (관리자 비밀번호가 "9876"인지 확인)
    	if ("ADMIN".equals(role)) {
    		if(!"9876".equals(adminPassword)) {
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
    	//if(dao.confirmID(request.getParameter(id)) == 1) {
    		request.setAttribute("message", "이미 사용 중인 아이디입니다.");
    		String url = "/member/join.jsp";
    		request.getRequestDispatcher(url)
    			.forward(request, response);
    		return;   		
    	} 
    	
    
    

        // 처리 순서:
        // 1. 이동할 페이지 경로 설정 (포워드 방식)
        //    - String url = "/member/idCheck.jsp"
        // 
        // 2. request에서 아이디 파라미터 추출
        //    - 클라이언트가 전송한 파라미터 중 "id" 값을 가져옴
        //    - String id = request.getParameter("id")
        // 
        // 3. 파라미터 유효성 검사
        //    - 아이디가 null이거나 공백인 경우 에러 처리
        //    - trim(): 앞뒤 공백 제거
        //    - isEmpty(): 문자열이 비어있는지 확인
        //    - if (id == null || id.trim().isEmpty()) {
        //        - 에러 메시지를 request에 저장
        //        - request.setAttribute("message", "아이디를 입력해주세요.")
        //        - 결과 코드를 -1로 설정 (입력 오류)
        //        - request.setAttribute("result", -1)
        //        - 포워드 방식으로 아이디 중복 확인 페이지로 이동
        //        - request.getRequestDispatcher(url).forward(request, response)
        //        - return (메서드 종료)
        //      }
        // 
        // 4. MemberDAO를 통해 아이디 중복 확인
        //    - Singleton 패턴으로 구현된 DAO 클래스
        //    - com.saeyan.dao.MemberDAO memberDAO = com.saeyan.dao.MemberDAO.getInstance()
        //    - confirmID(id) 메서드를 통해 데이터베이스에서 아이디 중복 확인
        //    - 반환값: 1 (중복/사용불가) 또는 0 (사용가능)
        //    - int result = memberDAO.confirmID(id)
        // 
        // 5. 확인 결과를 request에 저장
        //    - setAttribute() 메서드를 통해 JSP에서 사용할 수 있도록 데이터 저장
        //    - request.setAttribute("id", id) (확인한 아이디)
        //    - request.setAttribute("result", result) (중복 확인 결과)
        // 
        // 6. 포워드 방식으로 아이디 중복 확인 페이지로 이동
        //    - getRequestDispatcher(): RequestDispatcher 객체를 얻어서 포워드 처리
        //    - forward(): 실제로 페이지 이동 수행
        //    - request.getRequestDispatcher(url).forward(request, response)
    }
}
    
    
    
    
    
    
    	
        //    - Singleton 패턴으로 구현된 DAO 클래스
        //    - com.saeyan.dao.MemberDAO memberDAO = com.saeyan.dao.MemberDAO.getInstance()
        //    - confirmID(id) 메서드를 통해 데이터베이스에서 아이디 중복 확인
        //    - 반환값: 1 (중복/사용불가) 또는 0 (사용가능)
        //    - int idCheckResult = memberDAO.confirmID(id)
        // 
        // 7. 아이디 중복 체크
        //    - if (idCheckResult == 1) {
        //        - 에러 메시지를 request에 저장
        //        - request.setAttribute("message", "이미 사용 중인 아이디입니다.")
        //        - 포워드 방식으로 회원가입 페이지로 이동
        //        - String url = "/member/join.jsp"
        //        - request.getRequestDispatcher(url).forward(request, response)
        //        - return (메서드 종료)
        //      }
        // 
        // 8. MemberVO 객체 생성하여 회원 정보 설정
        //    - MemberVO: 회원 정보를 담는 DTO 객체
        //    - com.saeyan.dto.MemberVO member = new com.saeyan.dto.MemberVO()
        //    - member.setId(id)
        //    - member.setPassword(password)
        //    - member.setName(name)
        //    - member.setEmail(email)
        //    - member.setPhone(phone)
        //    - member.setRole(role)
        // 
        // 9. MemberDAO를 통해 회원 등록
        //    - insertMember(member) 메서드를 통해 데이터베이스에 회원 등록
        //    - 반환값: 1 (성공) 또는 0 (실패)
        //    - SQL의 INSERT 문 실행 결과 (영향받은 행의 개수)
        //    - int result = memberDAO.insertMember(member)
        // 
        // 10. 회원가입 결과에 따른 처리
        //     - if (result == 1) {
        //         - 회원가입 성공 시 로그인 폼으로 리다이렉트
        //         - 리다이렉트: 브라우저가 새로운 URL로 요청 (URL 변경됨)
        //         - getContextPath(): 웹 애플리케이션의 컨텍스트 경로 (예: /board-project)
        //         - String url = request.getContextPath() + "/MemberServlet?command=login_form"
        //         - sendRedirect(): 브라우저에게 새로운 URL로 요청하도록 지시
        //         - response.sendRedirect(url)
        //       } else {
        //         - 회원가입 실패 시 에러 메시지 저장
        //         - request.setAttribute("message", "회원가입에 실패했습니다. 다시 시도해주세요.")
        //         - 포워드 방식으로 회원가입 페이지로 이동
        //         - String url = "/member/join.jsp"
        //         - request.getRequestDispatcher(url).forward(request, response)
        //       }
    }
}
