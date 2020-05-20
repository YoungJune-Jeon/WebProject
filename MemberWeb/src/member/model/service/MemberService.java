package member.model.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import common.ConnectionFactory;
import member.model.dao.MemberDAO;
import member.model.vo.Member;

public class MemberService {
	
	private ConnectionFactory factory;
	
	public MemberService() {
		factory = ConnectionFactory.getConnection();
	}
	
	public Member selectMember(String userId, String userPwd) {
		Connection conn = null;
		Member member = null;
		
		try {
			conn = factory.createConnection();
			member = new MemberDAO().selectList(conn, userId, userPwd);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionFactory.close(conn);
		}
		return member;
	}
	
	public Member selectMemberOne(String userId) {
		Connection conn = null;
		Member member = null;
		
		try {
			conn = factory.createConnection();
			member = new MemberDAO().selectOne(conn, userId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return member;
	}
	
	public ArrayList<Member> selectMemberList() {
		Connection conn = null;
		ArrayList<Member> list = null;
		
		try {
			conn = factory.createConnection();
			list = new MemberDAO().selectMemberList(conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public int insertMember(Member member) {
		
		Connection conn = null;
		int result = 0;
		
		try {
			conn = factory.createConnection();
			result = new MemberDAO().insertMember(conn, member);
			
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
	
	public int deleteMember(String userId) {
		Connection conn = null;
		int result = 0;
		
		try {
			conn = factory.createConnection();
			result = new MemberDAO().deleteMember(conn, userId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (result > 0) {
			factory.commit(conn);
		} else {
			factory.rollback(conn);
		}
		return result;
	}
	
	public int updateMember(Member member) {
		Connection conn = null;
		int result = 0;
		
		try {
			conn = factory.createConnection();
			result = new MemberDAO().updateMember(conn, member);
			
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
}
