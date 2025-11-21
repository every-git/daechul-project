package com.saeyan.controller.action.admin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.saeyan.controller.action.Action;

/**
 * 회원 상세 정보 조회 Action
 * TODO: MemberDAO를 사용하여 회원 상세 정보 조회 구현
 */
import com.saeyan.dao.MemberDAO;
import com.saeyan.dto.MemberVO;

public class MemberDetailAction implements Action {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String id = request.getParameter("id");
        MemberDAO dao = MemberDAO.getInstance();
        MemberVO member = dao.getMember(id);
        request.setAttribute("member", member);
        return "/admin/member/memberDetail.jsp";
    }
}
