package com.saeyan.controller.action.admin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.saeyan.controller.action.Action;

/**
 * 게시글 수정 처리 Action (관리자)
 * TODO: BoardDAO를 사용하여 게시글 수정 처리 구현
 */
import com.saeyan.dao.BoardDAO;
import com.saeyan.dto.BoardVO;

public class BoardManageUpdateAction implements Action {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String seq = request.getParameter("seq");
        String title = request.getParameter("title");
        String content = request.getParameter("content");

        BoardVO vo = new BoardVO();
        vo.setSeq(Integer.parseInt(seq));
        vo.setTitle(title);
        vo.setContent(content);

        BoardDAO dao = BoardDAO.getInstance();
        dao.updateBoard(vo);

        return "redirect:AdminServlet?command=board_manage_list";
    }
}
