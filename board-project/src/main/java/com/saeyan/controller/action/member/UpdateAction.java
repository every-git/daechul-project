package com.saeyan.controller.action.member;

import java.io.IOException;import java.net.PasswordAuthentication;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.coyote.BadRequestException;

import com.saeyan.controller.action.Action;
import com.saeyan.dao.MemberDAO;
import com.saeyan.dto.MemberVO;

public class UpdateAction implements Action {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) 
    		throws ServletException, IOException {

    	request.setCharacterEncoding("UTF-8");
    	
    	HttpSession session = request.getSession();
    	
    	String id = (String)session.getAttribute("userId");
    	
    	if(id == null) {
    		String url = request.getContextPath() + "/login.jsp";
    		response.sendRedirect(url);
    	} else {
    		MemberDAO dao = MemberDAO.getInstance();
    		
    		String password = request.getParameter("password");
    		String email = request.getParameter("email");
    		String phone = request.getParameter("phone");
    		
    		MemberVO vo = new MemberVO();
    		
    		vo.setId(id);
    		vo.setPassword(password);
    		vo.setEmail(email);
    		vo.setPhone(phone);
    		
    		int result = dao.updateMember(vo);
    		
    		if(result == 1) {
    			String url = request.getContextPath() + "/index.jsp";
    			response.sendRedirect(url);
    		} else {
    			request.setAttribute("message", "회원정보 수정에 실패했습니다.");
    			String url = request.getContextPath() + "/memberUpdate.jsp";
    			request.getRequestDispatcher(url).forward(request, response);
    			}
    }
    	
    }
}
