package DB;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
public class Rank {
	int score =0;
	int sum =0;
	Connection conn;
	PreparedStatement psmt;
	ResultSet rs;
	int cnt = 0;
	public void input(MemberDTO dto) {    //	 ���� sum ���� �ش� ���̵� score �� ����
		try {
			Class.forName("oracle.jdbc.driver.OracleDrive"
					+ "r");
			System.out.println("����̹� ���� ����!");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		String db_id = "hr";
		String db_pw = "hr";
		try {
			conn = DriverManager.getConnection(url, db_id, db_pw);
			if (conn != null) {
				System.out.println("DB ���� ����!");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		 
		String sql = "update member set score = ? where id = ?";
		try {
			String iid = dto.getId();
			sum = 1;
			psmt = conn.prepareStatement(sql);
			psmt.setInt(score, sum);
			psmt.setString(1, iid);
			cnt = psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				
				if (psmt != null) {
					psmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void show()
	{
		connectRank();
		String sql = "select * from rank";
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while(rs.next()) {
				String id = rs.getString(1);
				int score = rs.getInt(2);
				System.out.printf("%s �� ���� : %d\n", id, score);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (psmt != null) {
					psmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}


	public void scoreUpdate(MemberDTO dto, int SUM) { // ���� sum ���� �ش� ���̵� score �� ����(���� �� ������ ������ �� Ŭ ����)
		int cnt =0;
		connectRank();
//----------------------------------------------------------------------------------------
//		sum = 2;
		String sql = "update member set score = ? where id = ?";
		try {
			psmt = conn.prepareStatement(sql);
			
			
//			psmt.setString(1, SUM);
			psmt.setInt(1, SUM);
			psmt.setString(2, dto.getId());
//			rs = psmt.executeQuery();
			cnt = psmt.executeUpdate();
			System.out.println(cnt);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (psmt != null) {
					psmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
		
	
	
	public void scoreUpdate1(MemberDTO dto, int total) { // ���� sum ���� �ش� ���̵� score �� ����(���� �� ������ ������ �� Ŭ ����)
		connectRank();
		
		System.out.println("���Ӿ��̵�: "+dto.getId());
		System.out.println("��������:"+total);
		
		
		String sql = "update rank set score= ? where id = ?";
		
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, total);
			psmt.setString(2, dto.getId());
			int cnt = psmt.executeUpdate();
			System.out.println("��ȭ�� ���� �� "+cnt);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (psmt != null) {
					psmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}


	private void connectRank() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
//			System.out.println("����̹� ���� ����!");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		String url = "jdbc:oracle:thin:@project-db-stu.ddns.net:1524:xe";
		String db_id = "campus_e_0516_3";
		String db_pw = "smhrd3";

		
		
		try {
			conn = DriverManager.getConnection(url, db_id, db_pw);
			if (conn != null) {
//				System.out.println("DB ���� ����!");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
		
	
	
	
	public void rank() {    // score ���� 3�� �� ���
		connectRank();
		 
		String sql = "select rownum, id, score from (select id, score from member order by score desc) where rownum < 4";
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			System.out.println("=======���� 3�� ��ŷ=======");
			System.out.printf("%10s\t%10s\t%10s%n", "RANK","ID", "SCORE");
			while (rs.next()) {
				int indd = rs.getInt(1);
				String id = rs.getString(2);
				int score = rs.getInt(3);
				
				System.out.printf("%10s\t%10s\t%10s\t%n", indd, id, score);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (psmt != null) {
					psmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	
	
}























//package DB;
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//
//public class Rank {
//
//	int score =0;
//	int sum =0;
//	Connection conn;
//	PreparedStatement psmt;
//	ResultSet rs;
//	
//	public void score(int num) {
//		
//		sum += num; 
//	}
//	
//	public RankDTO show(RankDTO dto) {
//		
//				connectRank();
//				
//				//3. SQL�� ����
//				String sql = "select score,update from rank where id=?";
//				
//				try {
//					psmt = conn.prepareStatement(sql);
//					//?�� �ݵ�� execute���� �����Ǿ� �־�� ��.
//					psmt.setString(1,dto.getId()); 
//			
//					rs = psmt.executeQuery();
//					dto.setScore(rs.getString(1));
//					dto.setUpdate(rs.getString(2));
//				
//				} catch (SQLException e) {
//					System.out.println("sql�� �̻���");
//				}
//				finally {
//					//4. ��������
//					//rs,psmt,conn������ �ݱ�
//					
//					try {
//						if(rs !=null) {
//							rs.close();}
//						if(psmt !=null) {
//							psmt.close();}
//						if(conn !=null) {
//							conn.close();}
//					} catch (SQLException e) {
//						e.printStackTrace();
//					}
//					
//				}
//				return dto;
//				
//			}
//
//	private void connectRank() {
//		//1. �����ε�
//		try {
//			Class.forName("oracle.jdbc.driver.OracleDriver");
//		} catch (ClassNotFoundException e) {
//			System.out.println("����̹� ã�� ����");
//		}
//		
//		
//		//2. DB����
//		String url = "jdbc:oracle:thin:@project-db-stu.ddns.net:1524:xe";
//		String db_id = "campus_e_0516_3";
//		String db_pw = "smhrd3";
//
//		try {
//			conn = DriverManager.getConnection(url, db_id, db_pw);
//			if(conn != null) {
//				System.out.println("DB���� ����");
//			}
//		} catch (SQLException e) {
//			System.out.println("DB���� ����");
//		}
//	}
//
//
//		
//
//	
//}
