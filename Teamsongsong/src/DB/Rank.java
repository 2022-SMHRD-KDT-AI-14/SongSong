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
	int result = 0;
	
	public int scoreput(MemberDTO dto) {    // 로그인 한 아이디의 갱신 전 score값 result 값으로 반환
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
		
	public void top10() {    // score 상위 10명 값 출력
		connectRank();
		String sql = "select id, score, rnk from (select id, score, rank() over (order by score desc) as rnk from member) where rnk <= 10";
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			System.out.println("================상위 10명 랭킹================");
			System.out.printf("%10s\t%10s\t%10s%n","ID", "SCORE", "RANK");
			while (rs.next()) {
				String id = rs.getString(1);
				int score = rs.getInt(2);
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

	public void scoreUpdate(MemberDTO dto, int total) { // 최종 sum 값(변수 jhs)을 해당 아이디에 score 값 갱신 //(새로 한 게임의 점수가 더 클 때만)
		connectRank();

		String sql = "update member set score = ? where id = ?";
		try {
			String id = dto.getId();
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, total);
			psmt.setString(2, id);
			cnt = psmt.executeUpdate();

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
	

//	public void scoreUpdate(MemberDTO dto, int SUM) { // 최종 sum 값을 해당 아이디에 score 값 갱신(새로 한 게임의 점수가 더 클 때만)
//		int cnt =0;
//		connectRank();
////----------------------------------------------------------------------------------------
////		sum = 2;
//		String sql = "update member set score = ? where id = ?";
//		try {
//			psmt = conn.prepareStatement(sql);
//			
//			
////			psmt.setString(1, SUM);
//			psmt.setInt(1, SUM);
//			psmt.setString(2, dto.getId());
////			rs = psmt.executeQuery();
//			cnt = psmt.executeUpdate();
//			System.out.println(cnt);
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			try {
//				if (rs != null) {
//					rs.close();
//				}
//				if (psmt != null) {
//					psmt.close();
//				}
//				if (conn != null) {
//					conn.close();
//				}
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//		}
//	}
//		
//	
//	
//	public void scoreUpdate1(MemberDTO dto, int total) { // 최종 sum 값을 해당 아이디에 score 값 갱신(새로 한 게임의 점수가 더 클 때만)
//		connectRank();
//		
//		System.out.println("접속아이디: "+dto.getId());
//		System.out.println("받은점수:"+total);
//		
//		
//		String sql = "update rank set score= ? where id = ?";
//		
//		try {
//			psmt = conn.prepareStatement(sql);
//			psmt.setInt(1, total);
//			psmt.setString(2, dto.getId());
//			int cnt = psmt.executeUpdate();
//			System.out.println("변화된 행의 수 "+cnt);
//			
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			try {
//				if (rs != null) {
//					rs.close();
//				}
//				if (psmt != null) {
//					psmt.close();
//				}
//				if (conn != null) {
//					conn.close();
//				}
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//		}
//	}


	private void connectRank() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
//			System.out.println("드라이버 연결 성공!");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		String url = "jdbc:oracle:thin:@project-db-stu.ddns.net:1524:xe";
		String db_id = "campus_e_0516_3";
		String db_pw = "smhrd3";

		try {
			conn = DriverManager.getConnection(url, db_id, db_pw);
			if (conn != null) {
//				System.out.println("DB 연결 성공!");
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
//				//3. SQL문 실행
//				String sql = "select score,update from rank where id=?";
//				
//				try {
//					psmt = conn.prepareStatement(sql);
//					//?는 반드시 execute전에 설정되어 있어야 함.
//					psmt.setString(1,dto.getId()); 
//			
//					rs = psmt.executeQuery();
//					dto.setScore(rs.getString(1));
//					dto.setUpdate(rs.getString(2));
//				
//				} catch (SQLException e) {
//					System.out.println("sql문 이상함");
//				}
//				finally {
//					//4. 연결종료
//					//rs,psmt,conn순으로 닫기
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
//		//1. 동적로딩
//		try {
//			Class.forName("oracle.jdbc.driver.OracleDriver");
//		} catch (ClassNotFoundException e) {
//			System.out.println("드라이버 찾기 실패");
//		}
//		
//		
//		//2. DB연결
//		String url = "jdbc:oracle:thin:@project-db-stu.ddns.net:1524:xe";
//		String db_id = "campus_e_0516_3";
//		String db_pw = "smhrd3";
//
//		try {
//			conn = DriverManager.getConnection(url, db_id, db_pw);
//			if(conn != null) {
//				System.out.println("DB연결 성공");
//			}
//		} catch (SQLException e) {
//			System.out.println("DB연결 실패");
//		}
//	}
//
//
//		
//
//	
//}
