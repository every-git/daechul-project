package com.saeyan.controller.action.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.saeyan.controller.action.Action;

/**
 * 게시글 수정 폼 표시 Action
 * TODO: BoardDAO를 사용하여 게시글 조회 후 수정 폼 표시
 */
import com.saeyan.dao.BoardDAO;
import com.saeyan.dto.BoardVO;

public class BoardUpdateFormAction implements Action {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String seq = request.getParameter("seq");
        BoardDAO dao = BoardDAO.getInstance();
        BoardVO board = dao.selectOneBySeq(Integer.parseInt(seq));
        request.setAttribute("board", board);
        return "/board/boardUpdate.jsp";
    }
}
