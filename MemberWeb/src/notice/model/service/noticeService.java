package notice.model.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import common.ConnectionFactory;
import notice.model.dao.noticeDao;
import notice.model.vo.Notice;
import notice.model.vo.NoticeComment;
import notice.model.vo.pageData;

public class noticeService {
	
	private ConnectionFactory factory;
	
	public noticeService() {
		factory= ConnectionFactory.getConnection();
	}
	public pageData selectNoticeList(int currentPage) {
		Connection conn =null;
		ArrayList<Notice> noticeList=null;
		int recordCountPerPage=10;
		int naviCountPerPage=5;
		pageData pd = new pageData();
		try {
			conn=factory.createConnection();
			noticeList = new noticeDao().selectNoticeList(conn,currentPage,recordCountPerPage);
			pd.setPageList(noticeList);
			pd.setPageNavi(new noticeDao().getPageNavi(conn, currentPage, recordCountPerPage, naviCountPerPage));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return pd;
	}
	public pageData noticeSearchList(int currentPage, String search) {
		
		Connection conn = null;
		int recordCountPerPage=10;
		int naviCountPerPage=5;
		
		pageData pd = new pageData();
		
		try {
			conn=factory.createConnection();
			pd.setPageList(new noticeDao().noticeSearchList(conn,currentPage,recordCountPerPage,search));
			pd.setPageNavi(new noticeDao().getSearchPageNavi(conn,currentPage,recordCountPerPage,naviCountPerPage,search));
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return pd;
	}
	public int insertNotice(String subject, String content, String userId) {
		int result =0;
		Connection conn =null;
		try {
			conn =factory.createConnection();
			result= new noticeDao().insertNotice(conn,subject,content,userId);
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
	public Notice noticeSelect(int noticeNo) {
		Notice notice = null;
		Connection conn = null;
		ArrayList<NoticeComment> cmtList= null;
		try {
			
			conn=factory.createConnection();
			notice=new noticeDao().noticeSelect(conn,noticeNo);
			cmtList = new noticeDao().noticeComment(conn,noticeNo);
			
			notice.setComments(cmtList);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return notice;
	}
	public int modifyNotice(String subject, String content, int noticeNo) {
		// TODO Auto-generated method stub
		int result = 0;
		Connection conn= null;
		
		try {
			conn=factory.createConnection();
			result = new noticeDao().noticeModify(conn,subject,content,noticeNo);
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
	public int deleteNotice(int noticeNo) {
		// TODO Auto-generated method stub
		int result =0 ;
		
		Connection conn= null;
		
		try {
			conn=factory.createConnection();
			result = new noticeDao().deleteNotice(conn,noticeNo);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}if(result>0) {
			factory.commit(conn);
		}
		else {
			factory.rollback(conn);
		}
		
		return result;
	}
	public int noticeCommentWrite(String userId, int noticeNo, String comment) {
		
		int result =0;
		Connection conn= null;
		
		try {
			conn=factory.createConnection();
			result = new noticeDao().noticeCommentWrite(conn,userId,noticeNo,comment);
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
	public int modifyNoticeComment(int commentNo, int noticeNo, String comment) {
		// TODO Auto-generated method stub
		Connection conn = null;
		int result= 0;
		
		try {
			conn=factory.createConnection();
			result= new noticeDao().modifyNoticeComment(conn,commentNo,noticeNo,comment);
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
	public int deleteComment(int commentNo) {
		// TODO Auto-generated method stub
		
		int result = 0;
		Connection conn=null;
		try {
			conn=factory.createConnection();
			result = new noticeDao().deleteComment(conn,commentNo);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return result;
	}

}
