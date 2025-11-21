package com.saeyan.controller.action.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.saeyan.controller.action.Action;

/**
 * 게시글 삭제 처리 Action
 * TODO: BoardDAO를 사용하여 게시글 삭제 처리 구현
 */
import javax.servlet.http.HttpSession;
import com.saeyan.dao.BoardDAO;
import com.saeyan.dto.BoardVO;

public class BoardDeleteAction implements Action {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String seq = request.getParameter("seq");

        // Permission check
        HttpSession session = request.getSession();
        String userId = (String) session.getAttribute("userId");
        String userRole = (String) session.getAttribute("userRole");

        BoardDAO dao = BoardDAO.getInstance();
        BoardVO original = dao.selectOneBySeq(Integer.parseInt(seq));

        if (userId != null && (userId.equals(original.getWriter()) || "ADMIN".equals(userRole))) {
            dao.deleteBoard(Integer.parseInt(seq));
        }

        return "redirect:BoardServlet?command=board_list";
    }
}
