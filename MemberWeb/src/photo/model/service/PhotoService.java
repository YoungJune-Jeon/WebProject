
package photo.model.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import common.ConnectionFactory;
import photo.model.dao.PhotoDAO;
import photo.model.vo.Photo;

public class PhotoService {

	private ConnectionFactory factory;

	public PhotoService() {
		factory = ConnectionFactory.getConnection();
	}

	public int insertPhoto(Photo photo) {
		Connection conn = null;
		int result = 0;

		try {
			conn = factory.createConnection();
			result = new PhotoDAO().insertPhoto(conn, photo);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (result > 0) {
			factory.commit(conn);
		} else {
			factory.rollback(conn);
		}

		return result;
	}

	public int totalCount() {
		Connection conn = null;
		int totalCount = 0;
		return totalCount;
	}

	public ArrayList<Photo> morePhoto(int start) {
		Connection conn = null;
		ArrayList<Photo> list = null;
		int length =5; // 한번더 가지고 올 사진수
		int end = start + length -1;
		

		try {
			conn = factory.createConnection();
			list = new PhotoDAO().morePhoto(conn, start, end);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	public ArrayList<Photo>morePhoto(Connection conn, int start , int end){
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Photo> list new ArrayList<Photo>();
		String query ="SELECT *FROM(SELECT ROWNUM AS RNUM, p.* FROM(SELECT * FROM PHOTO "
				+ "ORDER BY PHOTO_NO DESC)p)SHERE RNUM ? AND ?";
		
		pstmt =conn.prepareStatement(query);
		pstmt.setInt(1, start);
		pstmt.setInt(2, end);
		rset = pstmt.executeQuery();
		while(rset.next()) {
			Photo photo =new Photo();
			photo.setPhotoNo(rset.getInt("PHOTO_NO"));
			photo.setPhotoContent(rset.getString("PHOTO_CONTENT"));
			photo.setPhotoFileName(rset.getString("PHOTO_FILENAME"));
			photo.setPhotoFilepath(rset.getString("PHOTO_FILEPATH"));
			photo.setPhotoWriter(rset.getString("PHOTO_WRITER"));
			photo.setPhotoReadCount(rset.getInt("PHOTO_READCOUNT"));
			photo.setPhotoDate(rset.getDate("PHOTO_DATE"));
			list.add(photo);
		
	}
	      return list;
}

}








