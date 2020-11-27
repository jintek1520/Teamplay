package com.naver;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;


public class MonsterDAO {

	private final String DRIVER_NAME ="oracle.jdbc.OracleDriver";
	private final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	private final String USER_NAME = "ezen";
	private final String PASSWORD = "ezen";
	
	public MonsterDAO() {
		
		try {
			Class.forName("DRIVER_NAME");
			System.out.println("드라이버 로딩 성공");
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패");
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void insert(MemberDTO dto) {

		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO member VALUES (?, ?, ?, ?)";

		try {

			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", USER_NAME, PASSWORD);
			System.out.println("커넥션 연결 성공");

			pstmt = conn.prepareStatement(sql);
			System.out.println("preparedStatement 생성 성공");

			pstmt.setString(1, dto.getMid());
			pstmt.setString(2, dto.getName());
			pstmt.setString(3, dto.getJob());
			pstmt.setDate(4, (Date)dto.getBirth());

			pstmt.executeUpdate();

		} catch (Exception e) {
			System.out.println("preparedStatement 생성 실패");
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null) {
					pstmt.close();
				}

				if (conn != null) {
					conn.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}

	}
}
