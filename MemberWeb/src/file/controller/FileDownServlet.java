package file.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.model.vo.Member;

@WebServlet("/fileDown")
public class FileDownServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public FileDownServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 한글인코딩 처리
		request.setCharacterEncoding("utf-8");
		// view에서 보낸 전송값 변수 저장
		String filePath = request.getParameter("filePath");
		String fileUser = request.getParameter("fileUser");
		// 비지니스 로직
		HttpSession session = request.getSession();
		String userId = ((Member) session.getAttribute("member")).getUserId();
		if (fileUser.equals(userId)) {
			File file = new File(filePath);
			// 페이지를 Byte타입으로 설정하여 다운로드 페이지임을 명시
			String fileName = new String(file.getName().getBytes(), "ISO-8859-1");
			response.setContentType("application/octet-stream");
			response.setContentLength((int) file.length());
			// 파일 다운로드를 위한 HTTP Header 설정
			response.setHeader("Content-Disposition", "attachment;filename" + fileName);

			//파일과 서블릿을 연결하는 부분
			FileInputStream fileIn = new FileInputStream(file);
			//파일을 보내기 위한 스트림 생성
			ServletOutputStream out = response.getOutputStream();
			
			byte []outputByte = new byte[4096];
			
			while(fileIn.read(outputByte,0,4096)!=-1) {
				out.write(outputByte,0,4096);
			}
			fileIn.close();
			out.flush();
			out.close();
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
