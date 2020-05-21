package file.controller;

import java.io.File;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import file.model.service.FileService;

/**
 * Servlet implementation class FileRemoveServlet
 */
@WebServlet("/fileRemove")
public class FileRemoveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FileRemoveServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 한글 인코딩 처리
		request.setCharacterEncoding("utf-8");
		
		// Views에서 보낸 전송값 변수 저장
		String filePath = request.getParameter("filePath");
		String fileUser = request.getParameter("fileUser");
		
		// 자바 객체(실제파일과 연결되는 객체)
		File file = new File(filePath);
		
		int result = new FileService().deleteFile(filePath);
		
		// DB에서 정보를 삭제했으면실제 파일도 삭제하는 코드
		if(result > 0) {
			file.delete();
			response.sendRedirect("/fileList");
		} else {
			System.out.println("파일삭제 실패");
			response.sendRedirect("/views/file/fileError.html");
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
