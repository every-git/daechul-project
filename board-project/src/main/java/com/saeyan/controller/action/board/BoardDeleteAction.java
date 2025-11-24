package com.saeyan.controller.action.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.saeyan.controller.action.Action;
import com.saeyan.dao.BoardDAO;
import com.saeyan.dto.BoardVO;

/**
 * 게시글 삭제 처리 Action
 */
public class BoardDeleteAction implements Action {

    private String userRole;

   /**
     * 게시글 삭제 요청을 처리하는 메서드
     * 
     * 처리 순서:
     * 1. request에서 게시글 번호(seq) 파라미터 받기
     * 2. 세션에서 로그인 정보 확인 (userId, userRole)
     * 3. 로그인되지 않은 경우: index.jsp로 리다이렉트
     * 4. BoardDAO를 통해 해당 게시글 정보 조회
     * 5. 권한 체크: 작성자이거나 관리자(ADMIN)만 삭제 가능
     * 6. 권한이 없는 경우: boardView.jsp로 포워드 (에러 메시지 포함)
     * 7. 권한이 있는 경우: BoardDAO를 통해 게시글 삭제 (deleteBoard)
     * 8. 게시글 목록 페이지로 리다이렉트
     * 
     * @param request HttpServletRequest 객체 (seq 파라미터 필요)
     * @param response HttpServletResponse 객체
     * @throws ServletException 서블릿 예외 발생 시
     * @throws IOException 입출력 예외 발생 시
     */
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       HttpSession session = request.getSession();
       String userId = (String) session.getAttribute("userId");
       
       if (userId == null) {
          String url = request.getContextPath() + "/index.jsp";
          response.sendRedirect(url);
           return;
       }
        
       String seqStr = request.getParameter("seq");
              int seq = Integer.parseInt(seqStr);
              
            BoardDAO boardDAO = BoardDAO.getInstance();
            BoardVO board = boardDAO.selectOneBySeq(seq);
  
              if (!userId.equals(board.getWriter()) && !"ADMIN".equalsIgnoreCase(userRole)) {
               
                   request.setAttribute("message", "삭제 권한이 없습니다.");
                   request.setAttribute("board", board);
                   String url = "/board/boardView.jsp";
                   request.getRequestDispatcher(url).forward(request, response);
                   return;
                        }
       
                 boardDAO.deleteBoard(seq);
              
                  response.sendRedirect("/BoardServlet?command=board_list");
      
    }
}
