package notice.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.model.vo.Member;
import notice.model.dao.NoticeDAO;
import notice.model.service.NoticeService;
import notice.model.vo.NoticeComment;




@WebServlet("/noticeCommentWrite")
public class NoticeCommentWriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	
	
    public NoticeCommentWriteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
    
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String content = request.getParameter("comment");
		int noticeNo = Integer.parseInt(request.getParameter("noticeNo"));
		String userId = null;
		
		HttpSession session = request.getSession();
		if (session != null && (session.getAttribute("member") != null)) {
			userId = ((Member)session.getAttribute("member")).getUserId();;
		} else {
			/*response.sendRedirect("/views/notice/serviceFailed.html"); 이건 로그인이 필요할 경우*/
			userId = "annonymous";
		}
		
		int result = new NoticeService().insertComment(content, noticeNo, userId);
		if (result > 0) {
			response.sendRedirect("/noticeSelect?noticeNo=" + noticeNo);
		} else {
			response.sendRedirect("/views/notice/noticeError.html");
		}
	}

	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
