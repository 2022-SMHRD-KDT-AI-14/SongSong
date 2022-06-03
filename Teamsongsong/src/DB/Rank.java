package DB;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
public class Rank {
	float score =0;
	int sum =0;
	Connection conn;
	PreparedStatement psmt;
	ResultSet rs;
	int cnt = 0;
	float result = 0;
	
	public float scoreput(MemberDTO dto) {    // �α��� �� ���̵��� ���� �� score�� result ������ ��ȯ
		connectRank();

		String sql = "select score from member where id = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, dto.getId());
			rs = psmt.executeQuery();

			if (rs.next()) {
				result = rs.getInt(1);
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
		return result;
	}
		
	public void top10() {    // score ���� 10�� �� ���
		connectRank();
		String sql = "select id, score, rnk from (select id, score, rank() over (order by score desc) as rnk from member) where rnk <= 10";
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			System.out.println("============================== TOP10��ŷ ==============================");
			System.out.printf("%10s\t%10s\t%10s%n","ID", "SCORE", "RANK");
			while (rs.next()) {
				String id = rs.getString(1);
				float score = rs.getFloat(2);
				int rr = rs.getInt(3);
				
				System.out.printf("%10s\t%10s\t%10s\t%n", id, score, rr );
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

	public void scoreUpdate(MemberDTO dto, float convert) { // ���� sum ��(���� jhs)�� �ش� ���̵� score �� ���� //(���� �� ������ ������ �� Ŭ ����)
		connectRank();

		String sql = "update member set score = ? where id = ?";
		try {
			String id = dto.getId();
			psmt = conn.prepareStatement(sql);
			psmt.setFloat(1, convert);
			psmt.setString(2, id);
			psmt.executeUpdate();

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
