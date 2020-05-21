package file.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import file.model.vo.FileData;

public class FileDao {

	public int uploadFile(Connection conn, FileData data) {
		// TODO Auto-generated method stub
		PreparedStatement pstmt = null;
	
		int result = 0;
		String query="INSERT INTO FILETBL VALUES(?,?,?,?,?)";
		
		try {
			pstmt=conn.prepareStatement(query);
			
			pstmt.setString(1, data.getFileName());
			pstmt.setString(2, data.getFilePath());
			pstmt.setLong(3, data.getFileSize());
			pstmt.setString(4, data.getFileUser());
			pstmt.setTimestamp(5, data.getUploadTime());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				pstmt.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		return result;
	}

	public ArrayList<FileData> selectFileList(Connection conn, String userId) {
		// TODO Auto-generated method stub
		ArrayList<FileData> list =new ArrayList<FileData>();
		PreparedStatement pstmt = null;
		ResultSet rset=null;
		String query = "SELECT * FROM FILETBL WHERE FILEUSER=?";
		try {
			pstmt=conn.prepareStatement(query);
			pstmt.setString(1, userId);
			rset=pstmt.executeQuery();
			while(rset.next()) {
				FileData data = new FileData();
				data.setFileName(rset.getString("FILENAME"));
				data.setFilePath(rset.getString("FILEPATH"));
				data.setFileSize(rset.getLong("FILESIZE"));
				data.setFileUser(rset.getString("FILEUSER"));
				data.setUploadTime(rset.getTimestamp("UPLOADTIME"));
				
				list.add(data);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}

	public int deleteFile(Connection conn, String filePath) {
		// TODO Auto-generated method stub
		int result = 0;
		PreparedStatement pstmt =null;
		
		String query = "DELETE FROM FILETBL WHERE FILEPATH=?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, filePath);
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				pstmt.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		return result;
	}

}
