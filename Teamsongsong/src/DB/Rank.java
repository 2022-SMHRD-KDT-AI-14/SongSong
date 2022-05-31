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
	
	public void score(int num) {
		
		sum += num; 
	}
	
	public RankDTO show(RankDTO dto) {
		
				connectRank();
				
				//3. SQL문 실행
				String sql = "select score,update from rank where id=?";
				
				try {
					psmt = conn.prepareStatement(sql);
					//?는 반드시 execute전에 설정되어 있어야 함.
					psmt.setString(1,dto.getId()); 
			
					rs = psmt.executeQuery();
					dto.setScore(rs.getString(1));
					dto.setUpdate(rs.getString(2));
				
				} catch (SQLException e) {
					System.out.println("sql문 이상함");
				}
				finally {
					//4. 연결종료
					//rs,psmt,conn순으로 닫기
					
					try {
						if(rs !=null) {
							rs.close();}
						if(psmt !=null) {
							psmt.close();}
						if(conn !=null) {
							conn.close();}
					} catch (SQLException e) {
						e.printStackTrace();
					}
					
				}
				return dto;
				
			}

	private void connectRank() {
		//1. 동적로딩
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 찾기 실패");
		}
		
		
		//2. DB연결
		String url = "jdbc:oracle:thin:@project-db-stu.ddns.net:1524:xe";
		String db_id = "campus_e_0516_3";
		String db_pw = "smhrd3";

		try {
			conn = DriverManager.getConnection(url, db_id, db_pw);
			if(conn != null) {
				System.out.println("DB연결 성공");
			}
		} catch (SQLException e) {
			System.out.println("DB연결 실패");
		}
	}


		

	
}
