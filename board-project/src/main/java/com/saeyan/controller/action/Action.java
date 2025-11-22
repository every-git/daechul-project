package com.saeyan.controller.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Action 인터페이스
 * 
 * 역할:
 * - Front Controller 패턴에서 사용되는 Command 인터페이스
 * - 모든 비즈니스 로직 처리 Action 클래스들이 구현해야 하는 인터페이스
 * - Servlet과 비즈니스 로직을 분리하여 유지보수성 향상
 * 
 * 설계 패턴:
 * - Command Pattern: 요청을 객체로 캡슐화하여 요청과 실행을 분리
 * - Front Controller Pattern: 모든 요청을 중앙 집중식으로 처리
 * 
 * 구현 클래스:
 * - board 패키지: 게시글 관련 Action (BoardListAction, BoardWriteAction 등)
 * - member 패키지: 회원 관련 Action (LoginAction, JoinAction 등)
 * - admin 패키지: 관리자 관련 Action (AdminMainAction, MemberListAction 등)
 * 
 * web-study-11 패턴 적용
 */
public interface Action {
    /**
     * 클라이언트의 요청을 처리하는 메서드
     * 
     * 처리 과정:
     * 1. request에서 필요한 파라미터 추출
     * 2. 세션 정보 확인 (로그인, 권한 등)
     * 3. DAO를 통해 데이터베이스 작업 수행
     * 4. 결과를 request에 저장 (JSP에서 사용)
     * 5. 이동할 페이지 경로 반환
     * 
     * 반환값 형식:
     * - 일반 포워드: "/경로/파일명.jsp" (예: "/board/boardList.jsp")
     * - 리다이렉트: "redirect:" + 전체 URL (예: "redirect:" + request.getContextPath() + "/BoardServlet?command=board_list")
     * 
     * @param request HttpServletRequest 객체 (요청 정보, 파라미터, 세션 등)
     * @param response HttpServletResponse 객체 (응답 정보)
     * @return 이동할 페이지 경로
     *         - 포워드: JSP 파일 경로 (예: "/board/boardList.jsp")
     *         - 리다이렉트: "redirect:"로 시작하는 전체 URL
     * @throws Exception 예외 발생 시 (데이터베이스 오류, 파라미터 오류 등)
     */
    String execute(HttpServletRequest request, HttpServletResponse response) throws Exception;
}
