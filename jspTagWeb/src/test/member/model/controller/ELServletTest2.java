package test.member.model.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import test.member.model.vo.Member;

/**
 * Servlet implementation class ELServletTest2
 */
@WebServlet("/jsp/ElServletTest2")
public class ELServletTest2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ELServletTest2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			HashMap<String, String>map = new HashMap<String,String>();
			map.put("name", "홍길동");
			map.put("age", "22");
			map.put("addr", "서울시");
			
			Member[] member = new Member[2];
			member[0]= new Member("lim","22","임꺽정");
			member[1]= new Member("gaksi","33","각시탈");
			
			ArrayList<Member> list= new ArrayList<Member>();
			list.add(new Member("kim","34","김세종"));
			list.add(new Member("king","pass22","킹재일"));
			
			HttpSession session= request.getSession();
			
			session.setAttribute("name", "김세션");
			
			request.setAttribute("memberlist", list);
			request.setAttribute("memberArr", member);
			request.setAttribute("member", map);
			request.getRequestDispatcher("/EL/jsp_EL_Test2.jsp").forward(request, response);
			
			
			
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
