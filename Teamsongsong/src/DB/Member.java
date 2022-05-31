package DB;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.ldap.PagedResultsResponseControl;

import DB.MemberDTO;

public class Member {

	Connection conn ;
	PreparedStatement psmt;
	ResultSet rs;
	
	
	
	// �������� �޼ҵ�
		public int insert(MemberDTO dto) {
			int cnt = 0;

			// 1. �����ε�
			// ojdbc6.jar����
			conn = null; // db���� ��ü
			psmt = null; // sql���� ��ü

			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				System.out.println("����̹� �ε� ����");

				// 2. DB����
				String url = "jdbc:oracle:thin:@project-db-stu.ddns.net:1524:xe";
				String db_id = "campus_e_0516_3";
				String db_pw = "smhrd3";

				
				
				conn = DriverManager.getConnection(url, db_id, db_pw);
				if(conn !=null) {
					System.out.println("db���� ����");
				}

				// 3. SQL����
				String id =dto.getId();
				String pw =dto.getPw();
				String name = dto.getName();
				String sql = "insert into member values(?,?,?)";
				psmt = conn.prepareStatement(sql);
				psmt.setString(1,id);
				psmt.setString(2,pw);
				psmt.setString(3,name);
				
				cnt = psmt.executeUpdate();

			} catch (ClassNotFoundException e) {
				System.out.println("����̹� �ε� ����");
			} // ����Ŭ ����̹� Ŭ���� ã��
			catch (SQLException e) {
				System.out.println("ȸ������ ����, id�� ���Ӱ� ������ּ���");
			}
			
			// 4. ����
			finally {
				try {
					if(psmt !=null) psmt.close();
					if(conn != null) conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				
			
			}

			return cnt;
		}
	
	// �α��� �޼ҵ�
		public boolean login(MemberDTO dto) { //�Ű����� parameter
			boolean finalresult = false;
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
			

			
			//3. SQL�� ����
			
			//id, pw �Ű������� ������ ������
			//member ���̺��� PW column SELECT
			//ID�� ���� id�� ��
			//����� pw�� ���ؼ�
			//��ġ�� "�α��μ���", ����ġ�� "�α��ν���"
			
			String sql = "select pw,name from member where id=?";
			
			try {
				psmt = conn.prepareStatement(sql);
				//?�� �ݵ�� execute���� �����Ǿ� �־�� ��.
				psmt.setString(1,dto.getId()); 
		
				rs = psmt.executeQuery();
				
				if(rs.next()) {
//					if(rs.getString(1) = pw) {
//						System.out.println("��� ��ġ");
//					}
					String result = rs.getString(1); //rs.getString("pw") �Ȱ���
					if(result.equals(dto.getPw())) {
						System.out.println(rs.getString(2)+"�� ȯ���մϴ�!!");
						finalresult=true;
						
					}else {
						System.out.println("�α��� ����");
					}
				}
			
			
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

					System.out.println("�α��� ���� �ٽ��Է�");

				}
				
				
				
				
			}
			return finalresult;
		}

		// �α��� �޼ҵ�
		public void Adjust(MemberDTO dto,int P_N,String text) { //�Ű����� parameter
			
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
			

			String sql=null;
			//3. SQL�� ����
			if(P_N==1) {
				sql = "update member set name =? where id=?";
			
			}else{
				sql = "update member set pw =? where id=?";
				
			}
			
			try {
				psmt.setString(1,text);
				psmt.setString(2,dto.getId());
				psmt = conn.prepareStatement(sql);
				rs = psmt.executeQuery();
				if(rs.next()) {
					System.out.println(text+"�� ����Ϸ�!");
				}
			
				
				
			} catch (SQLException e1) {
				System.out.println("sql���� ���� �Է°��� ������ �־��");
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

					System.out.println("�α��� ���� �ٽ��Է�");

				}
				
				
				
				
			}
			
		}


	
		
		
	
}
