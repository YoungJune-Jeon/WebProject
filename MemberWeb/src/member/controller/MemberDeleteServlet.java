package member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.model.service.MemberService;
import member.model.vo.Member;




@WebServlet("/mdelete")
public class MemberDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public MemberDeleteServlet() {
        super();
    }

	
    
    
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	//1. 전송값에 한글이 있을 경우 인코딩 처리
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		//View에서 보낸 정보가 없으므로
		//Session을 통해 userId 값을 가져와서 저장함.
		String userId = ((Member)session.getAttribute("member")).getUserId();
		//3. 비지니스 로직
		int result = new MemberService().deleteMember(userId);
		if(result > 0) {			
		 response.sendRedirect("/logout");
		}else {
		response.sendRedirect("/views/member/memberError.html");
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
