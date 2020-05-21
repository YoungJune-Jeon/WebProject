package notice.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import notice.model.service.noticeService;

/**
 * Servlet implementation class NoticeCommentModifyServlet
 */
@WebServlet("/modifyComment")
public class NoticeCommentModifyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoticeCommentModifyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String comment=request.getParameter("modComment");
		int noticeNo=Integer.parseInt(request.getParameter("modNoticeNo"));
		int commentNo=Integer.parseInt(request.getParameter("modCommentNo"));
		
	
		
		int result = new noticeService().modifyNoticeComment(commentNo,noticeNo,comment);
		
		if(result > 0) {
			response.sendRedirect("/noticeSelect?noticeNo="+noticeNo);
		}
		else {
			response.sendRedirect("/views/notice/noticeError.html");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
