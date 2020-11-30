package com.naver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;



public class HeroDAO {
	private final String DRIVE = "oracle.jdbc.OracleDriver";
	private final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	private final String USER = "ezen";
	private final String PASSWORD = "ezen";
	
	public HeroDAO() {
		try {
			Class.forName(DRIVE);
			System.out.println("드라이브 로딩 성공");
		} catch (ClassNotFoundException e) {
			System.out.println("드라이브 로딩 실패");
			e.printStackTrace();
		}
	}
	public void insertHero(HeroDTO dto) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO Hero VAlUES (?,?,?,?,?,?)";
		
		try {
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, dto.getMid());
			pstmt.setInt(2, dto.getLv());
			pstmt.setInt(3, dto.getHp());
			pstmt.setInt(4, dto.getExp());
			pstmt.setInt(5, dto.getPower());
			pstmt.setString(6, dto.getWeapon());
			
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
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

	public void updateHero(HeroDTO dto) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "UPDATE Hero SET mid = ?,hp = ?,exp = ?,power = ?,weapon = ?  WHERE lv = ?";

		try {
			conn =DriverManager.getConnection(URL, USER, PASSWORD);
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, dto.getMid());
			pstmt.setInt(2, dto.getHp());
			pstmt.setInt(3, dto.getExp());
			pstmt.setInt(4, dto.getPower());
			pstmt.setString(5, dto.getWeapon());
			pstmt.setInt(6, dto.getLv());
			
			pstmt.executeUpdate();

		} catch (Exception e) {
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

	public void deleteHero(HeroDTO dto) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "DELETE FROM Hero WHERE mid =?";
		
		try {
			conn =DriverManager.getConnection(URL, USER, PASSWORD);
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, dto.getMid());
			
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
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
	public HeroDTO selectByMid(String mid) {
		HeroDTO dto =null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM Hero WHERE mid = ?";
		
		try {
			conn =DriverManager.getConnection(URL, USER, PASSWORD);
			pstmt = conn.prepareStatement(sql);
			
			pstmt .setString(1, mid);
			
			 rs = pstmt.executeQuery();
			 
			 if (rs.next()) {
				int lv = rs.getInt("lv");
				int hp = rs.getInt("hp");
				int exp = rs.getInt("exp");
				int power = rs.getInt("power");
				String weapon = rs.getString("weapon");
				
				dto = new HeroDTO(mid, lv, hp, exp, power, weapon); 
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if (rs != null) {
					rs.close();
				}
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
		return dto;
		
	}

	public List<HeroDTO> select() {
		List<HeroDTO> list = new ArrayList<HeroDTO>();
		Connection conn = null;
		PreparedStatement pstmt = null;		
		ResultSet rs = null;
		String sql = "SELECT * FROM Hero";
		
		try {
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				String mid = rs.getString("mid");
				int lv = rs.getInt("lv");
				int hp = rs.getInt("hp");
				int exp = rs.getInt("exp");
				int power = rs.getInt("power");
				String weapon = rs.getString("weapon");
				
				HeroDTO dto = new HeroDTO(mid, lv, hp, exp, power, weapon);
				list.add(dto);
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if (rs != null) {
					rs.close();
				}
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
		return list;
		
	}
	
	

}
