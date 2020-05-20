package file.model.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import common.ConnectionFactory;
import file.model.dao.FileDAO;
import file.model.vo.FileData;

public class FileService {

	private ConnectionFactory factory;

	public FileService() {
		factory = ConnectionFactory.getConnection();
	}

	public int uploadFile(FileData fileData) {

		Connection conn = null;
		int result = 0;

		try {
			conn = factory.createConnection();
			result = new FileDAO().uploadFile(conn, fileData);

			if (result > 0) {
				factory.commit(conn);
			} else {
				factory.rollback(conn);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	public ArrayList<FileData> selectFileList(String userId) {
		Connection conn = null;
		ArrayList<FileData> list = new ArrayList<FileData>();
		try {
			conn = factory.createConnection();
			list = new FileDAO().selectFileList(conn, userId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

}
