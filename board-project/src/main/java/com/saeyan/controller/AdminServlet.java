package com.saeyan.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.saeyan.controller.action.Action;

/**
 * AdminServlet - 관리자 관련 Front Controller
 * web-study-11 패턴 적용
 */
public class AdminServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doProcess(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doProcess(request, response);
    }

    private void doProcess(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");

        String command = request.getParameter("command");

        if (command == null || command.isEmpty()) {
            command = "admin_main";
        }

        ActionFactory actionFactory = ActionFactory.getInstance();
        Action action = actionFactory.getAction(command);

        if (action == null) {
            System.out.println("해당 command를 처리할 Action을 찾을 수 없습니다: " + command);
            return;
        }

        try {
            String path = action.execute(request, response);

            if (path != null && !path.isEmpty()) {
                // 리다이렉트와 포워드 구분
                if (path.startsWith("redirect:")) {
                    response.sendRedirect(path.substring(9));
                } else {
                    request.getRequestDispatcher(path).forward(request, response);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("error", "요청 처리 중 오류가 발생했습니다.");
            request.getRequestDispatcher("/error.jsp").forward(request, response);
        }
    }
}
