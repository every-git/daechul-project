package com.saeyan.controller.action.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.saeyan.controller.action.Action;
import com.saeyan.dao.BoardDAO;
import com.saeyan.dto.BoardVO;

/**
 * 게시글 작성 처리 Action
 * TODO: BoardDAO를 사용하여 게시글 작성 처리 구현
 */
public class BoardWriteAction implements Action {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        HttpSession session = request.getSession();
        String userId = (String) session.getAttribute("userId");

        if (userId == null) {
            return "redirect:MemberServlet?command=login_form";
        }

        BoardVO vo = new BoardVO();
        vo.setWriter(userId);
        vo.setTitle(request.getParameter("title"));
        vo.setContent(request.getParameter("content"));

        BoardDAO.getInstance().insertBoard(vo);

        return "redirect:BoardServlet?command=board_list";
    }
}
