package com.saeyan.controller.action.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.saeyan.controller.action.Action;
import com.saeyan.dao.MemberDAO;
import com.saeyan.dto.MemberVO;

/**
 * 로그인 처리 Action
 * TODO: MemberDAO를 사용하여 로그인 처리 구현
 */
public class LoginAction implements Action {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String url = "member/login.jsp";
        String id = request.getParameter("id");
        String pwd = request.getParameter("pwd");

        MemberDAO dao = MemberDAO.getInstance();
        int result = dao.userCheck(id, pwd);

        if (result == 1) {
            MemberVO vo = dao.getMember(id);
            HttpSession session = request.getSession();
            session.setAttribute("userId", vo.getId());
            session.setAttribute("userName", vo.getName());
            session.setAttribute("userRole", vo.getRole());
            url = "BoardServlet?command=board_list";
            return "redirect:" + url;
        } else if (result == 0) {
            request.setAttribute("message", "비밀번호가 맞지 않습니다.");
        } else if (result == -1) {
            request.setAttribute("message", "존재하지 않는 아이디입니다.");
        }

        return url;
    }
}
