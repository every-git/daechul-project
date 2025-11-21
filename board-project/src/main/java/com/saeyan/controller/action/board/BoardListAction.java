package com.saeyan.controller.action.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.saeyan.controller.action.Action;

/**
 * 게시글 목록 표시 Action
 * TODO: BoardDAO를 사용하여 게시글 목록 조회 구현
 */
import java.util.List;
import com.saeyan.dao.BoardDAO;
import com.saeyan.dto.BoardVO;

public class BoardListAction implements Action {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        BoardDAO dao = BoardDAO.getInstance();
        List<BoardVO> boardList = dao.selectAllBoards();
        request.setAttribute("boardList", boardList);
        return "/board/boardList.jsp";
    }
}
