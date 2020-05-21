package file.model.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import common.ConnectionFactory;
import file.model.dao.FileDao;
import file.model.vo.FileData;


public class FileService {
	
	private ConnectionFactory factory;
	
	public FileService() {
		factory=new ConnectionFactory();
	}

	public int uploadFile(FileData data) {
		Connection conn=null;
		int result = 0;
		
		try {
			conn=factory.createConnection();
			result = new FileDao().uploadFile(conn,data);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(result>0) {
			factory.commit(conn);
		}
		else {
			factory.rollback(conn);
		}
		return result;
	}

	public ArrayList<FileData> selectFileList(String userId) {
		// TODO Auto-generated method stub
		
		Connection conn =null;
		ArrayList<FileData> list = null;
		
		try {
			conn=factory.createConnection();
			list = new FileDao().selectFileList(conn,userId);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return list;
	}

	public int deleteFile(String filePath) {
		Connection conn= null;
		int result=0;
		
		try {
			conn=factory.createConnection();
			result =new FileDao().deleteFile(conn,filePath);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(result > 0) {
			factory.commit(conn);
		}
		else {
			factory.rollback(conn);
		}
		return result;
	}

}
