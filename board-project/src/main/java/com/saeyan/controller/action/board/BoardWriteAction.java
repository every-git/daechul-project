package com.saeyan.controller.action.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.saeyan.controller.action.Action;

/**
 * 게시글 작성 처리 Action
 */
public class BoardWriteAction implements Action {

    /**
     * 게시글 작성 요청을 처리하는 메서드
     * 
     * 처리 순서:
     * 1. request.setCharacterEncoding("UTF-8")로 인코딩 설정
     * 2. 세션에서 로그인 정보 확인 (userId)
     * 3. 로그인되지 않은 경우: index.jsp로 리다이렉트
     * 4. request에서 게시글 제목(title), 내용(content) 파라미터 받기
     * 5. BoardVO 객체 생성하여 작성자(writer), 제목, 내용 설정
     * 6. BoardDAO를 통해 게시글 등록 (insertBoard)
     * 7. 게시글 목록 페이지로 리다이렉트
     * 
     * @param request HttpServletRequest 객체 (title, content 파라미터 필요)
     * @param response HttpServletResponse 객체
     * @return 이동할 페이지 경로
     *         - 로그인 안됨: "redirect:" + request.getContextPath() + "/index.jsp"
     *         - 정상 처리: "redirect:" + request.getContextPath() + "/BoardServlet?command=board_list"
     * @throws Exception 예외 발생 시
     */
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        // TODO: Implement this class
        // 1. request.setCharacterEncoding("UTF-8") 설정
        // 2. 세션 체크 및 로그인 확인 (userId)
        // 3. request.getParameter("title"), getParameter("content")로 데이터 받기
        // 4. BoardVO 객체 생성하여 데이터 설정 (setWriter(userId), setTitle, setContent)
        // 5. BoardDAO.getInstance().insertBoard(vo)로 게시글 등록
        // 6. "redirect:" + request.getContextPath() + "/BoardServlet?command=board_list" 반환
        return null;
    }
}
