package notice.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import notice.model.service.NoticeService;


@WebServlet("/deleteNoticeComment")
public class NoticeCommentDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public NoticeCommentDeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//View에서 넘겨받은 전송값 변수 저장
		int commentNo =Integer.parseInt(request.getParameter("commentNo"));
		int noticeNo = Integer.parseInt(request.getParameter("noticeNo"));
		
		NoticeService noticeService = new NoticeService();
		int result = noticeService.deleteNoticeComment(commentNo);
		if(result >0) {
			response.sendRedirect("/noticeSelect?noticeNo="+noticeNo);
		}else {
		response.sendRedirect("/views/notice/noticeError.html");
		
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
