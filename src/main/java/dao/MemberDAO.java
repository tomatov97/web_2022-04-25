package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dto.MemberDTO;

public class MemberDAO {
	
	public boolean insertMemberInfo(MemberDTO memberInfo) {
		Connection conn = Database.getConnection();
		PreparedStatement pstmt = null;
		
		String sql = "INSERT INTO userInfo(id,pw,name) VALUES(?,?,?)";
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, memberInfo.getId());
			pstmt.setString(1, memberInfo.getPw());
			pstmt.setString(1, memberInfo.getName());
			
			int count = pstmt.executeUpdate(); 
			
			return count == 1;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			return false;
		} finally {
			Database.closePstmt(pstmt);
			Database.closeConnection(conn);
		} // try문 끝		
	}
	
	// DAO는 데이터베이스와 커뮤니케이션이 핵심
	// 쿼리를 실행하고 결과룰 받아오는 기능에 집중해야함
	// 더 정확하게 객체 지향적인 프러그래밍을 하려면 쿼리를 실행하고 결과만 받아오도록 해야함
	public MemberDTO selectMemberInfo(MemberDTO memberInfo) {
		Connection conn = Database.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT * FROM userInfo WHERE id = ? AND pw = ?";
		
		MemberDTO returnMemberInfo = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, memberInfo.getId());
			pstmt.setString(2, memberInfo.getPw());
			
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				String id = rs.getString("id");
				String pw = rs.getString("pw");
				String name = rs.getString("name");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			Database.closeResultSet(rs);
			Database.closePstmt(pstmt);
			Database.closeConnection(conn);
		}
		// try문 끝
		
		return returnMemberInfo;
	}
	
}
