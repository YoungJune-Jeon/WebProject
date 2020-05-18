package notice.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import notice.model.vo.Notice;

public class NoticeDAO {

	public ArrayList<Notice> selectNoticeList(Connection conn, int currentPage, int recordCountPerPage) {
		ArrayList<Notice> nList = new ArrayList<Notice>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		// 최근 글부터 출력하려면 order by noticeno에 desc 뒤에 붙여줌
		String query = "SELECT * FROM (SELECT NOTICE.*, ROW_NUMBER() OVER(ORDER BY NOTICENO DESC) AS NUM FROM NOTICE) WHERE NUM BETWEEN ? AND ?";

		// start에 1, end에 10이 되어 10씩 페이지마다 짤려서 출력할수 있게
		int start = currentPage * recordCountPerPage - (recordCountPerPage - 1);
		int end = currentPage * recordCountPerPage;
		try {
			// pstmt=conn.createStatement();
			pstmt = conn.prepareStatement(query);
			// rset=pstmt.executeQuery();

			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			rset = pstmt.executeQuery();
			while (rset.next()) { // 여러개 가져와야 하니까 while, 하나만 일때는 if
				Notice notice = new Notice();
				notice.setNoticeNo(rset.getInt("NOTICENO"));
				notice.setContents(rset.getString("CONTENTS"));
				notice.setSubject(rset.getString("SUBJECT"));
				notice.setUserId(rset.getString("USERID"));
				notice.setRegDate(rset.getDate("REGDATE"));
				nList.add(notice);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				rset.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return nList;

	}

	// 페이지의 전체 갯수 알기
	public int totalCount(Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int recordTotalCount = 0;

		String query = "SELECT COUNT(*) AS TOTALCOUNT FROM NOTICE";
		// 게시글 총 갯수 알아오는 쿼리

		try {
			pstmt = conn.prepareStatement(query);
			rset = pstmt.executeQuery();

			if (rset.next()) {
				recordTotalCount = rset.getInt("TOTALCOUNT");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				rset.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return recordTotalCount;

	}

	// 페이지의 갯수를 정하기 위해 네비게이션을 만든다
	public String getPageNavi(Connection conn, int currentPage, int recordCountPerPage, int naviCountPerPage) {
		int recordTotalCount = totalCount(conn);
		int pageTotalCount = 0; // 전체 페이지의 수
		// 전체 게시물 갯수 124개, 10개씩 페이지 만들면 페이지 갯수는 13페이지

		// 페이지 갯수 구하는 식
		if (recordTotalCount % recordCountPerPage > 0) {
			pageTotalCount = recordTotalCount / recordCountPerPage + 1;
			// 마지막 4개의 글이 마지막 13페이지에 출력될 수 있도록 하는 식
		} else {
			pageTotalCount = recordTotalCount / recordCountPerPage;
		}

		// 첫번째 페이지를 기준으로 네비게이션을 구해야 하므로 현재 페이지 정보를 확인하여
		// 0보다 크고 전체 페이지 수보다는 작은 위치에 있는지 확인
		// (오류방지용)
		// 옆으로 가기 버튼을 누를때 1페이지는 1페이지여야 하고 0이어서는 안됨
		if (currentPage < 1) {
			currentPage = 1;
		} else if (currentPage > pageTotalCount) {
			currentPage = pageTotalCount;
			// 화살표 버튼 누르다보면 계속 증가하므로
			// 최대값보다 증가 못하고 최소값보다 감소 못하게
		}

		// startnavi=페이지 네비게이션이 1,2,3,4,5로 바뀌어야 하는데
		// 몇개의 페이지로 만들것인지 정하는것이 스타트네비이다.
		// 6 7 8 9 10 1 2 3 4 5
		int startNavi = ((currentPage - 1) / naviCountPerPage) * naviCountPerPage + 1;

		// currentPage=8, naviCountPerPage=5;
		// ((8-1/5)/*5+1=6
		// currentPage=42, naviCountPerPage=5
		// 41 42 43 44 45
		// ((42-1)/5)*5+1=41
		int endNavi = startNavi + naviCountPerPage - 1;

		// 오류방지용2
		if (endNavi > pageTotalCount) {
			endNavi = pageTotalCount;
		}

		// <1 2 3 4 5>
		// '<' 모양과 '>' 모양을 준비하기 위해 필요한 변수

		// true일때는 꺽쇠가 보여야(필요)하고 false일때는 꺽쇠가 안보여야(필요하지않아야)함
		boolean needPrev = true;
		boolean needNext = true;

		if (startNavi == 1) {
			needPrev = false;
		}

		if (endNavi == pageTotalCount) {
			needNext = false;
		}

		// 모든 준비는 끝남
		StringBuilder sb = new StringBuilder();
		if (needPrev) {
			sb.append("<a href='/notice?currentPage=" + (startNavi - 1) + "'><</a>");
		}

		for (int i = startNavi; i <= endNavi; i++) {
			if (i == currentPage) {
				sb.append("<a href='/notice?currentPage=" + i + "'><b>" + i + "</b></a>"); // 진하게 표시하기 위해서 볼드체

			} else {
				sb.append("<a href='/notice?currentPage=" + i + "'>" + i + "</a>");
			}
		}

		if (needNext) {
			sb.append("<a href='/notice?currentPage=" + (endNavi + 1) + "'>></a>");
		}
		return sb.toString();
	}

	public ArrayList<Notice> noticeSearchList(Connection conn, int currentPage, int recordCountPerPage, String search) {

		ArrayList<Notice> list = new ArrayList<Notice>();
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		String query = "SELECT * FROM (SELECT NOTICE.*, ROW_NUMBER() OVER(ORDER BY NOTICENO DESC) AS NUM FROM NOTICE WHERE SUBJECT LIKE '%"
				+ search + "%') WHERE NUM BETWEEN ? AND ?";
		int start = currentPage * recordCountPerPage - (recordCountPerPage - 1);
		int end = currentPage * recordCountPerPage;

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			rset = pstmt.executeQuery();
			while (rset.next()) {
				Notice notice = new Notice();
				notice.setNoticeNo(rset.getInt("NOTICENO"));
				notice.setContents(rset.getString("CONTENTS"));
				notice.setSubject(rset.getString("SUBJECT"));
				notice.setUserId(rset.getString("USERID"));
				notice.setRegDate(rset.getDate("REGDATE"));
				list.add(notice);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
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

	public int searchTotalCount(Connection conn, String search) {

		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int recordTotalCount = 0;
		String query = "SELECT COUNT(*) AS TOTALCOUNT FROM NOTICE WHERE SUBJECT LIKE '%" + search + "%'";
		// 게시물 총갯수 구할수 있음.

		try {
			pstmt = conn.prepareStatement(query);
			rset = pstmt.executeQuery();

			if (rset.next()) {
				recordTotalCount = rset.getInt("TOTALCOUNT");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				rset.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return recordTotalCount;
	}

	public String getSearchPageNavi(Connection conn, int currentPage, int recordCountPerPage, int naviCountPerPage,
			String search) {

		int recordTotalCount = searchTotalCount(conn, search);
		int pageTotalCount = 0;

		// 78, 10=>8개
		if (recordTotalCount % recordCountPerPage > 0) {
			pageTotalCount = recordTotalCount / recordCountPerPage + 1;
		} else {
			pageTotalCount = recordTotalCount / recordCountPerPage;
		}

		// 오류감지
		if (currentPage < 1) {
			currentPage = 1;
		} else if (currentPage > pageTotalCount) {
			currentPage = pageTotalCount;
		}

		int startNavi = ((currentPage - 1) / naviCountPerPage) * naviCountPerPage + 1;

		int endNavi = startNavi + naviCountPerPage - 1;

		// 오류감지
		if (endNavi > pageTotalCount) {
			endNavi = pageTotalCount;
		}

		boolean needPrev = true;
		boolean needNext = true;

		if (startNavi == 1) {
			needPrev = false;
		}

		if (endNavi == pageTotalCount) {
			needNext = false;
		}

		// 모양만들기
		StringBuilder sb = new StringBuilder();
		if (needPrev) {
			sb.append("<a href='/noticeSearch?search=" + (startNavi - 1) + "&currentPage='><</a>");
		}

		for (int i = startNavi; i <= endNavi; i++) {
			if (i == currentPage) {
				sb.append("<a href='/noticeSearch?search=" + search + "&currentPage=" + i + "'><b>" + i + "</b></a>");
				// 진하게 표시하기 위해서 볼드체

			} else {
				sb.append("<a href='/noticeSearch?search=" + search + "&currentPage=" + i + "'>" + i + "</a>");
			}
		}

		if (needNext) {
			sb.append("<a href='/noticeSearch?currentPage=" + (endNavi + 1) + "'>></a>");
		}
		return sb.toString();
	}

	public int insertNotice(Connection conn, String subject, String content, String userId) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "INSERT INTO NOTICE VALUES(SEQ_NOTICE.NEXTVAL,?,?,?,SYSDATE)";

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, subject);
			pstmt.setString(2, content);
			pstmt.setString(3, userId);
			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return result;
	}

	public Notice noticeSelect(Connection conn, int noticeNo) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Notice notice = null;
		String query = "SELECT * FROM NOTICE WHERE NOTICENO=?";

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, noticeNo);
			rset = pstmt.executeQuery();
			if (rset.next()) {
				notice = new Notice();
				notice.setNoticeNo(rset.getInt("NOTICENO"));
				notice.setSubject(rset.getString("SUBJECT"));
				notice.setContents(rset.getString("CONTENTS"));
				notice.setUserId(rset.getString("USERID"));
				notice.setRegDate(rset.getDate("REGDATE"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return notice;
	}
}
