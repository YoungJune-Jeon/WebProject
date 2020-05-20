package file.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import file.model.vo.FileData;

public class FileDAO {
	
	public int uploadFile(Connection conn, FileData fileData) {
		
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = "INSERT INTO FILETBL VALUES(?,?,?,?,?)";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, fileData.getFileName());
			pstmt.setString(2, fileData.getFilePath());
			pstmt.setLong(3, fileData.getFileSize());
			pstmt.setString(4, fileData.getFileUser());
			pstmt.setTimestamp(5, fileData.getUploadTime());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	
	public ArrayList<FileData>selectFileList(Connection conn , String userId){
		PreparedStatement pstmt = null;
		ResultSet rset = null;
	
		ArrayList<FileData>list = new ArrayList <FileData>();
		String query =" SELECT * FROM FILETBL WHERE FILEUSER=?";
		
		try {
		pstmt = conn.prepareStatement(query);
		pstmt.setString(1, userId);
		rset = pstmt.executeQuery();
		while(rset.next()) {
			FileData data = new FileData();
			data.setFileName(rset.getString("FILENAME"));
			data.setFilePath(rset.getString("FILEPATH"));
			data.setFileSize(rset.getLong("FILESIZE"));
			data.setFileUser(rset.getString("FILEUSER"));
			data.setUploadTime(rset.getTimestamp("UPLOADTIME"));
			list.add(data);
			
		}
	}catch(SQLException e) {
		e.printStackTrace();
	}finally {
		try {
			pstmt.close();
			rset.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
		return list;
	}
	
	public int deleteFile(Connection conn, String filePath) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query ="DELETE FILETBL WHERE FILEPATH=?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, filePath);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	
}


















