package DB;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class Member {

	Connection conn;
	PreparedStatement psmt;
	ResultSet rs;

	
	// �������� �޼ҵ�
	public void insert(MemberDTO dto) {

		connectMember();
		// 3. SQL����
		String id = dto.getId();
		String pw = dto.getPw();
		String name = dto.getName();
		String sql = "insert into member values(?,?,?,0)";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			psmt.setString(2, pw);
			psmt.setString(3, name);
			psmt.executeUpdate();
			System.err.println(name + "��~ ������ �����մϴ�^^");
//			updateForRank(dto);
		} catch (SQLException e) {
			System.out.println("ȸ������ ����, id�� ���Ӱ� ������ּ���");
		}

		// 4. ����
		finally {
			try {
				if (psmt != null)
					psmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}

	}

	// �α��� �޼ҵ�
	public MemberDTO login(MemberDTO dto) { 

		connectMember();
		// 3. SQL�� ����
		String sql = "select pw,name from member where id=?";

		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, dto.getId());
			rs = psmt.executeQuery();

			if (rs.next()) {
				dto.setName(rs.getString(2));
				if (rs.getString(1).equals(dto.getPw())) {
					System.out.println(dto.getName() + "�� ȯ���մϴ�!!");
				} else {
					System.out.println("�α��� ����");
					dto.setId("");
					dto.setPw("");
					dto.setName("");
				}
			} else {
				System.out.println("������ ��Ȯ�ϰ� �Է��ϼ���");
				dto.setId("");
				dto.setPw("");
				dto.setName("");
			}

		} catch (SQLException e) {
			System.out.println("sql�� �̻���");
		} finally {
			// 4. ��������
			// rs,psmt,conn������ �ݱ�

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
		return dto;
	}

	// ȸ���������� �޼ҵ�
	public void Adjust(MemberDTO dto, String P_N, String text) { 

		connectMember();
		String sql = null;
		// 3. SQL�� ����
		if (P_N.equals("1")) { // �������
			sql = "update member set set =? where id=?";
		} else { // �̸�����
			sql = "update member set name =? where id=?";
		}

		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, text);
			psmt.setString(2, dto.getId());
			rs = psmt.executeQuery();
			if (rs.next()) {
				System.out.println(text + "�� ����Ϸ�!");
			}

		} catch (SQLException e1) {
			System.out.println("sql���� ���� �Է°��� ������ �־��");
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

				System.out.println("�α��� ���� �ٽ��Է�");
			}
		}
	}

	// �����ε�, DB���� �޼ҵ�
	private void connectMember() {
		// 1. �����ε�
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			System.out.println("����̹� ã�� ����");
		}

		// 2. DB����
		String url = "jdbc:oracle:thin:@project-db-stu.ddns.net:1524:xe";
		String db_id = "campus_e_0516_3";
		String db_pw = "smhrd3";

		try {
			conn = DriverManager.getConnection(url, db_id, db_pw);
			if (conn != null) {
//						System.out.println("DB���� ����");
			}
		} catch (SQLException e) {
			System.out.println("DB���� ����");
		}
	}

	
//	//ȸ�����Խ� ��ũDB �ڵ�������Ʈ
//	public void updateForRank(MemberDTO dto) {
//
//		connectMember();
//		// 3. SQL����
//		String id = dto.getId();
//		String sql = "insert into rank values(?,null)";
//		try {
//			psmt = conn.prepareStatement(sql);
//			psmt.setString(1, id);
//			psmt.executeUpdate();
//			System.err.println("������Ʈ �Ϸ�");
//		} catch (SQLException e) {
//			System.out.println("������Ʈ ����");
//		}
//
//		// 4. ����
//		finally {
//			try {
//				if (psmt != null)
//					psmt.close();
//				if (conn != null)
//					conn.close();
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//
//		}
//
//	}
//	
//	

}
