package com.admin.board.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import com.admin.AdminSupport;
import com.admin.board.model.service.BoardService;
import com.admin.board.model.vo.Board;
import com.admin.board.model.vo.BoardType;
import com.common.model.vo.PageInfo;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

/**
 * Servlet implementation class AdminBoardListViewController
 */
@WebServlet("/adminBoardSearch.bo")
public class BoardSearchController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BoardSearchController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String bt = request.getParameter("bt");
		String search = request.getParameter("search");
		String cPage = request.getParameter("cPage");
		int listCount = new BoardService().countBoardSearch(bt,search);
		int currentPage = cPage == null ? 1 : Integer.parseInt(cPage);
		PageInfo pageInfo = new PageInfo(listCount , currentPage);
		ArrayList<Board> list = new BoardService().selectBoardSearch(pageInfo, bt, search);
		if (list != null) {
			response.setContentType("application/json; charset=UTF-8");
			Gson gson = new Gson();
			JSONObject jMap = new JSONObject();
			jMap.put("pageInfo", pageInfo);
			jMap.put("list", list);
			new Gson().toJson(jMap,response.getWriter());
			
		} 
	}
		
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
