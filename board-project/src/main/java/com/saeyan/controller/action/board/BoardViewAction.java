package com.saeyan.controller.action.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.saeyan.controller.action.Action;

/**
 * 게시글 상세보기 Action
 */
public class BoardViewAction implements Action {

    /**
     * 게시글 상세 정보를 조회하여 화면에 표시하는 메서드
     * 
     * 처리 순서:
     * 1. 세션에서 로그인 정보 확인 (userId)
     * 2. 로그인되지 않은 경우: index.jsp로 리다이렉트
     * 3. request에서 게시글 번호(seq) 파라미터 받기
     * 4. BoardDAO를 통해 해당 게시글의 조회수 증가 (updateHit)
     * 5. BoardDAO를 통해 게시글 상세 정보 조회 (selectOneBySeq)
     * 6. 조회한 게시글 정보를 request에 "board"라는 이름으로 저장
     * 7. boardView.jsp로 포워드
     * 
     * @param request HttpServletRequest 객체 (seq 파라미터 필요)
     * @param response HttpServletResponse 객체
     * @return 이동할 페이지 경로
     *         - 로그인 안됨: "redirect:" + request.getContextPath() + "/index.jsp"
     *         - 정상 처리: "/board/boardView.jsp"
     * @throws Exception 예외 발생 시
     */
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        // TODO: Implement this class
        // 1. 세션 체크 및 로그인 확인
        // 2. request.getParameter("seq")로 게시글 번호 받기 (Integer.parseInt 필요)
        // 3. BoardDAO.getInstance()로 DAO 인스턴스 얻기
        // 4. updateHit(seq)로 조회수 증가
        // 5. selectOneBySeq(seq)로 게시글 조회
        // 6. request.setAttribute("board", 조회결과)로 저장
        // 7. "/board/boardView.jsp" 반환 (forward)
        return null;
    }
}
