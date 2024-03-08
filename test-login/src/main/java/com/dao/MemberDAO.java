package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.dto.MemberVO;
import com.dao.MemberDAO;

public class MemberDAO {

	private static MemberDAO instance = new MemberDAO();
	private Connection con = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	private MemberDAO() {
	}
	
	public static MemberDAO getInstance() {
		return instance;
	}
	
	public Connection getConnection() throws Exception {
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "ezen";
		String password = "1234";
		
		// 1. 드라이브 로드
		Class.forName("oracle.jdbc.driver.OracleDriver");
		// 2. DB 연결
		return DriverManager.getConnection(url, user, password);

	}
	
	// ID 중복체크
	public int confirmID(String userid) {
		
		int result = -1;
		String sql = "select userid from member where userid = ?";
		try {
			// 1. 연결
			con = getConnection();
			// 2. sql문 전송
			pstmt = con.prepareStatement(sql);
			// 3. 연결
			pstmt.setString(1, userid);
			// 4. 실행 및 결과값 받기
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				result = 1;	// 중복된 ID(사용 불가)
			}
			else {
				result = -1;// 중복되지 않은 ID(사용 가능)
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			try {	// 자원 반납
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	
	// 회원가입
	public int insertMember(MemberVO vo) {
		int result = -1;
		
		String sql = "insert into member values(?, ?, ?, ?, ?, ?)";
		
		try {
			// 1. 연결
			con = getConnection();

			// 2. sql 구문 전송
			pstmt = con.prepareStatement(sql);
			
			// 3. 맵핑(연결)
			pstmt.setString(1, vo.getName());
			pstmt.setString(2, vo.getUserid());
			pstmt.setString(3, vo.getPwd());
			pstmt.setInt(4, vo.getAdmin());
			
			// 4. 구문 실행
			result = pstmt.executeUpdate();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	
	// 가입 회원 체크
	public int userCheck(String userid, String pwd) {
		int result = -1;
		
		String sql = "select pwd from member where userid = ?";
		
		try {
			con = getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, userid);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				if(rs.getString("pwd").equals(pwd)) {
					result = 1;	// 로그인 성공
				}
				else {
					result = -1;// 비밀번호 불일치
				}
			}
			else {
				result = 0;		// 아이디 불일치
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		return result;
	}
	
	// 로그인 한 회원정보 가져오기
	public MemberVO getMember(String userid) {
		String sql = "select * from member where userid=?";
		MemberVO vo = new MemberVO();
		
		try {
			con = getConnection();				// 연결
			pstmt = con.prepareStatement(sql);	// 전송
			pstmt.setString(1, userid);			// 맵핑
			rs = pstmt.executeQuery();			// 실행
			
			if(rs.next()) {
				String name = rs.getString("name");
				
				vo.setName(name);
				vo.setUserid(rs.getString("userid"));
				vo.setPwd(rs.getString("pwd"));
				vo.setAdmin(rs.getInt("admin"));
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		return vo;
	}

	public int updateMember(MemberVO vo) {
		int result = -1;
		
		String sql = "update member set name=?, pwd=?, admin=? where userid=?";
		
		try {
			// 1. 연결
			con = getConnection();

			// 2. sql 구문 전송
			pstmt = con.prepareStatement(sql);
			
			// 3. 맵핑(연결)
			pstmt.setString(1, vo.getName());
			pstmt.setString(2, vo.getUserid());
			pstmt.setString(3, vo.getPwd());
			pstmt.setInt(4, vo.getAdmin());
			pstmt.setString(5, vo.getUserid());
			
			// 4. 구문 실행
			result = pstmt.executeUpdate();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	
}
