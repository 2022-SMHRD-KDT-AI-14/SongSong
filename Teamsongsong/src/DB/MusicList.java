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
	ArrayList<String> arr = new ArrayList<String>(); // 중복문제 확인용
	MP3Player mp3;
	Connection conn;
	PreparedStatement psmt;
	ResultSet rs;

	// 난이도선택 메소드
	public String diff(String str) {

		String path = null;
		connectMusic();
		String sql = "select path from (select * from musiclist where diff = ? order by dbms_random.value) where rownum <= 1";

		try {
			psmt = conn.prepareStatement(sql);
			if (str.equals("1")) {
				psmt.setString(1, "상");
			} else if (str.equals("2")) {
				psmt.setString(1, "중");
			} else if (str.equals("3")) {
				psmt.setString(1, "하");
			} else {
				System.out.println("잘못 입력하셨습니다.");
			}

			rs = psmt.executeQuery();
			if (rs.next()) {
				path = rs.getString(1);
			}
			arr.add(path);
			for (int i = 0; i < arr.size() - 1; i++) {
				if (path.equals(arr.get(i))) { // 이전에 재생된곡과 경로가 같은경우
					rs = psmt.executeQuery(); // 다시 sql 실행하고
					if (rs.next()) {
						path = rs.getString(1);
					} // 새롭게 경로를 따오며
					arr.add(path); // 새로바뀐 경로를 저장한다.
					i = 0;
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("sql문 이상함");
		}

		finally {
			// 4. 연결종료
			// rs,psmt,conn순으로 닫기

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

	// 음악재생 메소드
	public void play(String path) {

		mp3 = new MP3Player();
		if (mp3.isPlaying()) {
			mp3.stop();
		}
		mp3.play(path);

	}

	// 정답확인(노래제목) 메소드
	public String getTitle(String path) {

		connectMusic();
		String result = null;
		// 3. SQL문 실행
		String sql = "select title from musiclist where path= ?";

		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, path);
			// ?는 반드시 execute전에 설정되어 있어야 함.
			rs = psmt.executeQuery();

			if (rs.next()) {
				result = rs.getString(1);

			}

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("sql문 이상함");
		} finally {
			// 4. 연결종료
			// rs,psmt,conn순으로 닫기

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
		// 3. SQL문 실행
		String sql = "select singer, title from musiclist where path= ?";

		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, path);
			// ?는 반드시 execute전에 설정되어 있어야 함.
			rs = psmt.executeQuery();

			if (rs.next()) {
				System.out.printf("정답: %s - %s\n\n",rs.getString(1),rs.getString(2));
			}

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("sql문 이상함");
		} finally {
			// 4. 연결종료
			// rs,psmt,conn순으로 닫기

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
	
	
	// 가수힌트 메소드
	public void SingHint(String path) {

		connectMusic();
		// 3. SQL문 실행
		String sql = "select singer from musiclist where path= ?";

		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, path);
			// ?는 반드시 execute전에 설정되어 있어야 함.
			rs = psmt.executeQuery();

			if (rs.next()) {
				String result = rs.getString(1);
				System.out.println("가수명: " + result);
			}

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("sql문 이상함");
		} finally {
			// 4. 연결종료
			// rs,psmt,conn순으로 닫기

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

	}// 메소드 끝

	// 동적로딩, DB연결 메소드
	private void connectMusic() {
		// 1. 동적로딩
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 찾기 실패");
		}

		// 2. DB연결
		String url = "jdbc:oracle:thin:@project-db-stu.ddns.net:1524:xe";
		String db_id = "campus_e_0516_3";
		String db_pw = "smhrd3";

		try {
			conn = DriverManager.getConnection(url, db_id, db_pw);
			if (conn != null) {
//					System.out.println("DB연결 성공");
			}
		} catch (SQLException e) {
			System.out.println("DB연결 실패");
		}
	}

	// 초성힌트 메소드
	public void ChoHint(String path) {
		final String[] CHO = { "ㄱ", "ㄲ", "ㄴ", "ㄷ", "ㄸ", "ㄹ", "ㅁ", "ㅂ", "ㅃ", "ㅅ", "ㅆ", "ㅇ", "ㅈ", "ㅉ", "ㅊ", "ㅋ", "ㅌ", "ㅍ",
				"ㅎ" };

		String text = getTitle(path);

		for (int i = 0; i < text.length(); i++) {
			char uniVal = text.charAt(i);
			if (uniVal < 0xAC00) {
				System.out.print(uniVal + " ");
				if (i == 1)
					i = text.length();
			}
			// 한글일 경우만 시작해야 하기 때문에 0xAC00부터 아래의 로직을 실행한다
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

}// 맨끝
