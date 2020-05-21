package notice.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import notice.model.service.noticeService;
import notice.model.vo.Notice;
import notice.model.vo.pageData;

/**
 * Servlet implementation class noticeServlet
 */
@WebServlet("/notice")
public class NoticeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoticeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int currentPage=0;
		if(request.getParameter("currentPage")==null) {
			currentPage=1;
		}
		else {
			currentPage=Integer.parseInt(request.getParameter("currentPage"));
		}
		pageData pgData= new noticeService().selectNoticeList(currentPage);
		
		RequestDispatcher view = request.getRequestDispatcher("/views/notice/noticeAll.jsp");
		request.setAttribute("pageData", pgData);
		view.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
