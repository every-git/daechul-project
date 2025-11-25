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
 * 게시글 수정 처리 Action
 */
public class BoardUpdateAction implements Action {

    /**
     * 게시글 수정 요청을 처리하는 메서드
     * 
     * 처리 순서:
     * 1. request.setCharacterEncoding("UTF-8")로 인코딩 설정
     * 2. request에서 게시글 번호(seq), 제목(title), 내용(content) 파라미터 받기
     * 3. 세션에서 로그인 정보 확인 (userId, userRole)
     * 4. 로그인되지 않은 경우: index.jsp로 리다이렉트
     * 5. BoardDAO를 통해 해당 게시글 정보 조회
     * 6. 권한 체크: 작성자이거나 관리자(ADMIN)만 수정 가능
     * 7. 권한이 없는 경우: boardView.jsp로 포워드 (에러 메시지 포함)
     * 8. 권한이 있는 경우: BoardVO 객체 생성하여 수정 정보 설정 후 updateBoard 호출
     * 9. 게시글 상세보기 페이지로 리다이렉트
     * 
     * @param request HttpServletRequest 객체 (seq, title, content 파라미터 필요)
     * @param response HttpServletResponse 객체
     * @throws ServletException 서블릿 예외 발생 시
     * @throws IOException 입출력 예외 발생 시
     */
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            	//1.request.setCharacterEncoding(UTF=8)로 인코딩설정
    			request.setCharacterEncoding("UTF-8");
    			response.setContentType("text/html; charset=UTF-8");       
           
    			//3. 로그인 정보 확인
    			
    			HttpSession session = request.getSession();
    			String userId = (String) session.getAttribute("userId");
    			String userRole = (String) session.getAttribute("userRole");
    			
    			//4.로그인 되지 않을 경우  
    			
    			if (userId == null) {
    				String url = request.getContextPath() + "/index.jsp";
    				response.sendRedirect(url);
    				return;
    			}
              		//2.request에서 번호 제목 내용 피라미터 받기
    			
                	String seqStr = request.getParameter("seq");
                	int seq = Integer.parseInt(seqStr);
                	String title = request.getParameter("title");
                	String content = request.getParameter("content");
           
                	//5. BoardDAO를 통해 해당 게시글 정보 조회
         
                	BoardDAO boardDAO = BoardDAO.getInstance();
                	BoardVO board = boardDAO.selectOneBySeq(seq);
        
                	//6.  권한 체크: 작성자이거나 관리자(ADMIN)만 수정 가능
               
                	if (!userId.equals(board.getWriter()) && !"ADMIN".equalsIgnoreCase(userRole)) {
               
                	//7. 권한이 없는 경우: boardView.jsp로 포워드 (에러 메시지 포함) 
                		
                    request.setAttribute("message", "수정 권한이 없습니다.");
                    request.setAttribute("board", board);    
                    String url = "/board/boardView.jsp";
                    request.getRequestDispatcher(url).forward(request, response);
                    return;        
                }
           
                                   
                //8.권한이 있는 경우: BoardVO 객체 생성하여 수정 정보 설정 후 updateBoard 호출  
                	
                BoardVO updateBoard = new BoardVO();
                updateBoard.setSeq(seq);
                updateBoard.setTitle(title);
                updateBoard.setContent(content);                                                      
                                   
                boardDAO.updateBoard(updateBoard);
           
              //  9. 게시글 상세보기 페이지로 리다이렉트                    

                String url = request.getContextPath() + "/BoardServlet?command=board_view&seq=" + seq;
                
                response.sendRedirect(url);
    }
	}
