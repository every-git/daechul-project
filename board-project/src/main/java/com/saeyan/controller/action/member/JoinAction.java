package com.saeyan.controller.action.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.saeyan.controller.action.Action;

/**
 * 회원가입 처리 Action
 * TODO: MemberDAO를 사용하여 회원가입 처리 구현
 */
import com.saeyan.dao.MemberDAO;
import com.saeyan.dto.MemberVO;

public class JoinAction implements Action {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String id = request.getParameter("id");
        String pwd = request.getParameter("pwd");
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");

        MemberVO vo = new MemberVO();
        vo.setId(id);
        vo.setPassword(pwd);
        vo.setName(name);
        vo.setEmail(email);
        vo.setPhone(phone);
        vo.setRole("MEMBER"); // Default role

        MemberDAO.getInstance().insertMember(vo);

        return "member/login.jsp";
    }
}
