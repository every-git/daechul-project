package com.saeyan.controller.action.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.saeyan.controller.action.Action;

/**
 * 게시글 상세보기 Action
 * TODO: BoardDAO를 사용하여 게시글 상세 조회 구현
 */
import com.saeyan.dao.BoardDAO;
import com.saeyan.dto.BoardVO;

public class BoardViewAction implements Action {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String url = "/board/boardView.jsp";
        String seq = request.getParameter("seq");

        BoardDAO dao = BoardDAO.getInstance();
        dao.updateHit(Integer.parseInt(seq));

        BoardVO vo = dao.selectOneBySeq(Integer.parseInt(seq));
        request.setAttribute("board", vo);

        return url;
    }
}
