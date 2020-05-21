package ajax.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/ajaxTest1")
public class AjaxTest1Servlet extends HttpServlet {
   private static final long serialVersionUID = 1L;
       
   
    public AjaxTest1Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

  
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      
      request.setCharacterEncoding("utf-8");
      String msg = request.getParameter("msg");
      System.out.println(msg);
      
   }

  
   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      // TODO Auto-generated method stub
      doGet(request, response);
   }

}