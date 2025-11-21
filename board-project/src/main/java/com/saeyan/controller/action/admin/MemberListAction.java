package com.saeyan.controller.action.admin;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.saeyan.controller.action.Action;

/**
 * 회원 목록 조회 Action
 * TODO: MemberDAO를 사용하여 회원 목록 조회 구현
 */
import java.util.List;
import com.saeyan.dao.MemberDAO;
import com.saeyan.dto.MemberVO;

public class MemberListAction implements Action {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        MemberDAO dao = MemberDAO.getInstance();
        List<MemberVO> memberList = dao.selectAllMembers();
        request.setAttribute("memberList", memberList);
        return "/admin/member/memberList.jsp";
    }
}
