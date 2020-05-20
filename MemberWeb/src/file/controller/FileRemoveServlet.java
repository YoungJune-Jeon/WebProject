package file.controller;

import java.io.File;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import file.model.service.FileService;


@WebServlet("/fileRemove")
public class FileRemoveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public FileRemoveServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		//View에서 보낸 전송값 변수 저장
		String filePath=request.getParameter("filePath");
		String fileUser=request.getParameter("fileUser");
		
		File file = new File(filePath);
		int result = new FileService().deleteFile(filePath);
		//DB데이터 삭제
		if(result > 0) { // DB데이터 삭제 성공 후
			file.delete(); // 실제 파일시스템 파일 삭제
			response.sendRedirect("/fileList");
		}else {
			System.out.println("파일삭제 실패");
			response.sendRedirect("/views/file/fileError.html");
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
