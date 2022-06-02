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

	
	// 계정생성 메소드
	public void insert(MemberDTO dto) {

		connectMember();
		// 3. SQL실행
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
			System.err.println(name + "님~ 가입을 축하합니다^^");
//			updateForRank(dto);
		} catch (SQLException e) {
			System.out.println("회원가입 실패, id를 새롭게 만들어주세요");
		}

		// 4. 종료
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

	// 로그인 메소드
	public MemberDTO login(MemberDTO dto) { 

		connectMember();
		// 3. SQL문 실행
		String sql = "select pw,name from member where id=?";

		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, dto.getId());
			rs = psmt.executeQuery();

			if (rs.next()) {
				dto.setName(rs.getString(2));
				if (rs.getString(1).equals(dto.getPw())) {
					System.out.println(dto.getName() + "님 환영합니다!!");
				} else {
					System.out.println("로그인 실패");
					dto.setId("");
					dto.setPw("");
					dto.setName("");
				}
			} else {
				System.out.println("정보를 정확하게 입력하세요");
				dto.setId("");
				dto.setPw("");
				dto.setName("");
			}

		} catch (SQLException e) {
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
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
		return dto;
	}

	// 회원정보수정 메소드
	public void Adjust(MemberDTO dto, String P_N, String text) { 

		connectMember();
		String sql = null;
		// 3. SQL문 실행
		if (P_N.equals("1")) { // 비번수정
			sql = "update member set set =? where id=?";
		} else { // 이름수정
			sql = "update member set name =? where id=?";
		}

		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, text);
			psmt.setString(2, dto.getId());
			rs = psmt.executeQuery();
			if (rs.next()) {
				System.out.println(text + "로 변경완료!");
			}

		} catch (SQLException e1) {
			System.out.println("sql실행 도중 입력값에 문제가 있어요");
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

				System.out.println("로그인 정보 다시입력");
			}
		}
	}

	// 동적로딩, DB연결 메소드
	private void connectMember() {
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
//						System.out.println("DB연결 성공");
			}
		} catch (SQLException e) {
			System.out.println("DB연결 실패");
		}
	}

	
//	//회원가입시 랭크DB 자동업데이트
//	public void updateForRank(MemberDTO dto) {
//
//		connectMember();
//		// 3. SQL실행
//		String id = dto.getId();
//		String sql = "insert into rank values(?,null)";
//		try {
//			psmt = conn.prepareStatement(sql);
//			psmt.setString(1, id);
//			psmt.executeUpdate();
//			System.err.println("업데이트 완료");
//		} catch (SQLException e) {
//			System.out.println("업데이트 실패");
//		}
//
//		// 4. 종료
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
