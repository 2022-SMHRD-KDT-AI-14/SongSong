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
				
				//3. SQL�� ����
				String sql = "select score,update from rank where id=?";
				
				try {
					psmt = conn.prepareStatement(sql);
					//?�� �ݵ�� execute���� �����Ǿ� �־�� ��.
					psmt.setString(1,dto.getId()); 
			
					rs = psmt.executeQuery();
					dto.setScore(rs.getString(1));
					dto.setUpdate(rs.getString(2));
				
				} catch (SQLException e) {
					System.out.println("sql�� �̻���");
				}
				finally {
					//4. ��������
					//rs,psmt,conn������ �ݱ�
					
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
		//1. �����ε�
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			System.out.println("����̹� ã�� ����");
		}
		
		
		//2. DB����
		String url = "jdbc:oracle:thin:@project-db-stu.ddns.net:1524:xe";
		String db_id = "campus_e_0516_3";
		String db_pw = "smhrd3";

		try {
			conn = DriverManager.getConnection(url, db_id, db_pw);
			if(conn != null) {
				System.out.println("DB���� ����");
			}
		} catch (SQLException e) {
			System.out.println("DB���� ����");
		}
	}


		

	
}
