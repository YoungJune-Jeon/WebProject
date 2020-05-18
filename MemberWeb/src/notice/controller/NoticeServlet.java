package notice.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import notice.model.service.NoticeService;
import notice.model.vo.Notice;
import notice.model.vo.PageData;



/**
 * Servlet implementation class NoticeServlet
 */
@WebServlet("/notice")
public class NoticeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public NoticeServlet() {
        super();
       
    }

	
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        //1. 전송값에 한글이 있을 경우 인코딩
        //2. View에서 보낸 전송값 변수 저장
        //3. 비즈니스 로직을 처리할 서비스 클래스 메소드로 값을 전달 및 결과 받기
        
        //페이지 번호 누를때마다 다음페이지로 이동할수 있게 currentPage를 if문으로 걸어줌
        int currentPage=0;
        if(request.getParameter("currentPage")==null) {
           currentPage=1;
        }else {
           currentPage=Integer.parseInt(request.getParameter("currentPage"));
        }
        PageData pageData = new NoticeService().selectNoticeList(currentPage);
        
        RequestDispatcher view = request.getRequestDispatcher("/views/notice/noticeAll.jsp");
        request.setAttribute("pageData", pageData);
        view.forward(request,  response);
     }

	

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
