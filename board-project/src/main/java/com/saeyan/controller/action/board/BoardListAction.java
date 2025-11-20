package com.saeyan.controller.action.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.saeyan.controller.action.Action;

/**
 * 게시글 목록 표시 Action
 * TODO: BoardDAO를 사용하여 게시글 목록 조회 구현
 */
public class BoardListAction implements Action {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        // TODO: 게시글 목록 조회 로직 구현
        return "/board/boardList.jsp";
    }
}
