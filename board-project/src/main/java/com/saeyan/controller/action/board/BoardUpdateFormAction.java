package com.saeyan.controller.action.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.saeyan.controller.action.Action;

/**
 * 게시글 수정 폼 표시 Action
 * TODO: BoardDAO를 사용하여 게시글 조회 후 수정 폼 표시
 */
public class BoardUpdateFormAction implements Action {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        // TODO: 게시글 조회 로직 구현
        return "/board/boardUpdate.jsp";
    }
}
