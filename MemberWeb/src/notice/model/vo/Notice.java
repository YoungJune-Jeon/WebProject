package notice.model.vo;

import java.util.ArrayList;

public class Notice {
	
	public Notice() {

	}

	private int noticeNo;
	private String subject;
	private String userId;
	private String contents;
	private String regDate;
	
	private ArrayList<NoticeComment> comments=null;
	// 댓글

	

	public ArrayList<NoticeComment> getComments() {
		return comments;
	}

	public void setComments(ArrayList<NoticeComment> comments) {
		this.comments = comments;
	}

	public int getNoticeNo() {
		return noticeNo;
	}

	public void setNoticeNo(int noticeNo) {
		this.noticeNo = noticeNo;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public String getRegDate() {
		return regDate;
	}

	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}
	
}
