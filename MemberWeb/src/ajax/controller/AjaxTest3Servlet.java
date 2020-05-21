package ajax.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/ajaxTest3")
public class AjaxTest3Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public AjaxTest3Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int number1= Integer.parseInt(request.getParameter("num1"));
		int number2= Integer.parseInt(request.getParameter("num2"));
		PrintWriter out = response.getWriter();
		out.print(number1 + number2);
		
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
