package com.user.board.open.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.user.board.open.model.service.BoardService;


/**
 * Servlet implementation class AjaxReplyUpdateController
 */
@WebServlet("/rupdate.op")
public class AjaxReplyUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AjaxReplyUpdateController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int ono = Integer.parseInt(request.getParameter("ono"));
		int rno = Integer.parseInt(request.getParameter("rno"));
		String rc = request.getParameter("reContent");
	
		int result = new BoardService().updateComments(ono,rno,rc);
		
		
		if(result>0) {
			response.sendRedirect(request.getContextPath()+"/detail.op?ono="+ono);
		}else {
			request.setAttribute("errorMsg", "댓글 수정 실패");
			request.getRequestDispatcher("/views/common/errorPage.jsp").forward(request, response);
		}
	
	}

}
