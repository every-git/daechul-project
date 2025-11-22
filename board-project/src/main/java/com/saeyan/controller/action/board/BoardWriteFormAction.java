package com.saeyan.controller.action.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.saeyan.controller.action.Action;

/**
 * 게시글 작성 폼 표시 Action
 */
public class BoardWriteFormAction implements Action {

    /**
     * 게시글 작성 폼 페이지를 표시하는 메서드
     * 
     * 처리 순서:
     * 1. 세션에서 로그인 정보 확인 (userId)
     * 2. 로그인되지 않은 경우: index.jsp로 리다이렉트
     * 3. 게시글 작성 폼 페이지(boardWrite.jsp)로 포워드
     * 
     * @param request HttpServletRequest 객체
     * @param response HttpServletResponse 객체
     * @return 이동할 페이지 경로
     *         - 로그인 안됨: "redirect:" + request.getContextPath() + "/index.jsp"
     *         - 정상 처리: "/board/boardWrite.jsp"
     * @throws Exception 예외 발생 시
     */
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        // TODO: Implement this class
        // 1. 세션 체크 및 로그인 확인
        // 2. 로그인 안되면 "redirect:" + request.getContextPath() + "/index.jsp" 반환
        // 3. 로그인 되면 "/board/boardWrite.jsp" 반환 (forward)
        return null;
    }
}
