package file.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import file.model.service.FileService;
import file.model.vo.FileData;
import member.model.vo.Member;



@WebServlet("/fileList")
public class FileListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public FileListServlet() {
        super();
      
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session =request.getSession();
		String userId =((Member)session.getAttribute("member")).getUserId();
		ArrayList<FileData>list = new FileService().selectFileList(userId);
		if(!list.isEmpty()) {
			request.getRequestDispatcher("/views/file/fileList.jsp").forward(request, response);
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
