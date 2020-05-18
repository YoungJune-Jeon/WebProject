package notice.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import notice.model.service.NoticeService;
import notice.model.vo.PageData;


@WebServlet("/noticeSearch")
public class NoticeSearchSevlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public NoticeSearchSevlet() {
        super();
      
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		//1. 전송값에 한글이 있을 경우 인코딩 처리
		request.setCharacterEncoding("UTF-8");
		String search = request.getParameter("search");
		int currentPage=0;
		if(request.getParameter("currentPage")==null) {
			currentPage = 1;
		}else {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}
		PageData pd = new NoticeService().noticeSearchList(currentPage, search);
		RequestDispatcher view= request.getRequestDispatcher("/views/notice/noticeSearch.jsp");
		request.setAttribute("pageData", pd);
		request.setAttribute("search", search);
		view.forward(request, response);
		
		
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}














