package com.saeyan.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.saeyan.controller.action.Action;

/**
 * BoardServlet - 게시판 관련 Front Controller
 * 
 * 역할:
 * - 게시판 관련 모든 요청을 받아서 처리하는 중앙 집중식 컨트롤러
 * - GET/POST 요청을 모두 doProcess()로 위임하여 통합 처리
 * - command 파라미터에 따라 적절한 Action을 생성하고 실행
 * - Action의 반환값(path)에 따라 forward 또는 redirect 처리
 * 
 * 설계 패턴:
 * - Front Controller Pattern: 모든 요청을 중앙에서 처리
 * - Command Pattern: Action 인터페이스를 통한 요청 처리
 * 
 * 처리 흐름:
 * 1. 클라이언트 요청 수신 (GET 또는 POST)
 * 2. 인코딩 설정 (UTF-8)
 * 3. command 파라미터 추출 (기본값: "board_list")
 * 4. ActionFactory를 통해 적절한 Action 인스턴스 생성
 * 5. Action.execute() 실행하여 비즈니스 로직 처리
 * 6. 반환된 path에 따라 forward 또는 redirect 처리
 * 7. 예외 발생 시 error.jsp로 포워드
 * 
 * URL 매핑: /BoardServlet (web.xml에서 설정)
 * 
 * web-study-11 패턴 적용
 */
public class BoardServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * GET 요청 처리 메서드
     * - 게시글 목록 조회, 상세보기 등 조회 작업
     * 
     * @param request HttpServletRequest 객체
     * @param response HttpServletResponse 객체
     * @throws ServletException 서블릿 예외
     * @throws IOException 입출력 예외
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doProcess(request, response);
    }

    /**
     * POST 요청 처리 메서드
     * - 게시글 작성, 수정, 삭제 등 데이터 변경 작업
     * 
     * @param request HttpServletRequest 객체
     * @param response HttpServletResponse 객체
     * @throws ServletException 서블릿 예외
     * @throws IOException 입출력 예외
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doProcess(request, response);
    }

    /**
     * GET/POST 요청을 통합 처리하는 메서드
     * 
     * 처리 과정:
     * 1. 요청/응답 인코딩 설정 (UTF-8)
     * 2. command 파라미터 추출 및 기본값 설정 ("board_list")
     * 3. ActionFactory를 통해 적절한 Action 인스턴스 생성
     * 4. Action.execute() 실행하여 비즈니스 로직 처리
     * 5. 반환된 path 확인:
     *    - "redirect:"로 시작하면 sendRedirect() 실행
     *    - 그 외에는 forward() 실행
     * 6. 예외 발생 시 error.jsp로 포워드
     * 
     * @param request HttpServletRequest 객체
     * @param response HttpServletResponse 객체
     * @throws ServletException 서블릿 예외
     * @throws IOException 입출력 예외
     */
    private void doProcess(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // 1. 요청/응답 인코딩 설정 (한글 처리)
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");

        // 2. command 파라미터 추출 및 기본값 설정
        String command = request.getParameter("command");
        if (command == null || command.isEmpty()) {
            command = "board_list"; // 기본값: 게시글 목록
        }

        // 3. ActionFactory를 통해 적절한 Action 인스턴스 생성
        ActionFactory actionFactory = ActionFactory.getInstance();
        Action action = actionFactory.getAction(command);

        // 4. Action이 존재하지 않으면 처리 중단
        if (action == null) {
            System.out.println("해당 command를 처리할 Action을 찾을 수 없습니다: " + command);
            return;
        }

        // 5. Action 실행 및 결과 처리
        try {
            // Action의 execute() 메서드 실행하여 비즈니스 로직 처리
            String path = action.execute(request, response);

            // 6. 반환된 path가 있으면 페이지 이동 처리
            if (path != null && !path.isEmpty()) {
                // 리다이렉트와 포워드 구분
                if (path.startsWith("redirect:")) {
                    // 리다이렉트: "redirect:" 접두사 제거 후 sendRedirect() 실행
                    // 브라우저가 새로운 URL로 요청 (URL 변경됨)
                    response.sendRedirect(path.substring(9));
                } else {
                    // 포워드: JSP 파일 경로로 forward() 실행
                    // 서버 내부에서 페이지 이동 (URL 변경 안됨)
                    request.getRequestDispatcher(path).forward(request, response);
                }
            }
        } catch (Exception e) {
            // 7. 예외 발생 시 에러 페이지로 포워드
            e.printStackTrace();
            request.setAttribute("error", "요청 처리 중 오류가 발생했습니다.");
            request.getRequestDispatcher("/error.jsp").forward(request, response);
        }
    }
}
