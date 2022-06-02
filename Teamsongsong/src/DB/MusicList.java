package DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

import javazoom.jl.player.MP3Player;

public class MusicList {
	ArrayList<String> arr = new ArrayList<String>(); // �ߺ����� Ȯ�ο�
	MP3Player mp3;
	Connection conn;
	PreparedStatement psmt;
	ResultSet rs;

	// ���̵����� �޼ҵ�
	public String diff(String str) {

		String path = null;
		connectMusic();
		String sql = "select path from (select * from musiclist where diff = ? order by dbms_random.value) where rownum <= 1";

		try {
			psmt = conn.prepareStatement(sql);
			if (str.equals("1")) {
				psmt.setString(1, "��");
			} else if (str.equals("2")) {
				psmt.setString(1, "��");
			} else if (str.equals("3")) {
				psmt.setString(1, "��");
			} else {
				System.out.println("�߸� �Է��ϼ̽��ϴ�.");
			}

			rs = psmt.executeQuery();
			if (rs.next()) {
				path = rs.getString(1);
			}
			arr.add(path);
			for (int i = 0; i < arr.size() - 1; i++) {
				if (path.equals(arr.get(i))) { // ������ ����Ȱ�� ��ΰ� �������
					rs = psmt.executeQuery(); // �ٽ� sql �����ϰ�
					if (rs.next()) {
						path = rs.getString(1);
					} // ���Ӱ� ��θ� ������
					arr.add(path); // ���ιٲ� ��θ� �����Ѵ�.
					i = 0;
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("sql�� �̻���");
		}

		finally {
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
			} catch (final SQLException e) {
				e.printStackTrace();
			}

		}
		return path;

	}

	// ������� �޼ҵ�
	public void play(String path) {

		mp3 = new MP3Player();
		if (mp3.isPlaying()) {
			mp3.stop();
		}
		mp3.play(path);

	}

	// ����Ȯ��(�뷡����) �޼ҵ�
	public String getTitle(String path) {

		connectMusic();
		String result = null;
		// 3. SQL�� ����
		String sql = "select title from musiclist where path= ?";

		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, path);
			// ?�� �ݵ�� execute���� �����Ǿ� �־�� ��.
			rs = psmt.executeQuery();

			if (rs.next()) {
				result = rs.getString(1);

			}

		} catch (SQLException e) {
			e.printStackTrace();
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
			} catch (final SQLException e) {
				e.printStackTrace();
			}

		}
		return result;

	}

	
	public void letMeKnow(String path) {
		connectMusic();
		// 3. SQL�� ����
		String sql = "select singer, title from musiclist where path= ?";

		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, path);
			// ?�� �ݵ�� execute���� �����Ǿ� �־�� ��.
			rs = psmt.executeQuery();

			if (rs.next()) {
				System.out.printf("����: %s - %s\n\n",rs.getString(1),rs.getString(2));
			}

		} catch (SQLException e) {
			e.printStackTrace();
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
			} catch (final SQLException e) {
				e.printStackTrace();
			}

		}
	}
	
	
	// ������Ʈ �޼ҵ�
	public void SingHint(String path) {

		connectMusic();
		// 3. SQL�� ����
		String sql = "select singer from musiclist where path= ?";

		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, path);
			// ?�� �ݵ�� execute���� �����Ǿ� �־�� ��.
			rs = psmt.executeQuery();

			if (rs.next()) {
				String result = rs.getString(1);
				System.out.println("������: " + result);
			}

		} catch (SQLException e) {
			e.printStackTrace();
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
			} catch (final SQLException e) {
				e.printStackTrace();
			}

		}

	}// �޼ҵ� ��

	// �����ε�, DB���� �޼ҵ�
	private void connectMusic() {
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
//					System.out.println("DB���� ����");
			}
		} catch (SQLException e) {
			System.out.println("DB���� ����");
		}
	}

	// �ʼ���Ʈ �޼ҵ�
	public void ChoHint(String path) {
		final String[] CHO = { "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��",
				"��" };

		String text = getTitle(path);

		for (int i = 0; i < text.length(); i++) {
			char uniVal = text.charAt(i);
			if (uniVal < 0xAC00) {
				System.out.print(uniVal + " ");
				if (i == 1)
					i = text.length();
			}
			// �ѱ��� ��츸 �����ؾ� �ϱ� ������ 0xAC00���� �Ʒ��� ������ �����Ѵ�
			if (uniVal >= 0xAC00) {
				uniVal = (char) (uniVal - 0xAC00);
				char cho = (char) (uniVal / 28 / 21);
				System.out.print(CHO[cho]);
			} else {
				System.out.print(" ");
			}
		}
		System.out.println();
	}

}// �ǳ�
