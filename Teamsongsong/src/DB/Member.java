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
	
	
	
	// 계정생성 메소드
		public int insert(MemberDTO dto) {
			int cnt = 0;

			// 1. 동적로딩
			// ojdbc6.jar파일
			conn = null; // db연결 객체
			psmt = null; // sql전달 객체

			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				System.out.println("드라이버 로딩 성공");

				// 2. DB연결
				String url = "jdbc:oracle:thin:@project-db-stu.ddns.net:1524:xe";
				String db_id = "campus_e_0516_3";
				String db_pw = "smhrd3";

				
				
				conn = DriverManager.getConnection(url, db_id, db_pw);
				if(conn !=null) {
					System.out.println("db접속 성공");
				}

				// 3. SQL실행
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
				System.out.println("드라이버 로딩 실패");
			} // 오라클 드라이버 클래스 찾기
			catch (SQLException e) {
				System.out.println("회원가입 실패, id를 새롭게 만들어주세요");
			}
			
			// 4. 종료
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
	
	// 로그인 메소드
		public boolean login(MemberDTO dto) { //매개변수 parameter
			boolean finalresult = false;
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
			

			
			//3. SQL문 실행
			
			//id, pw 매개변수로 설정된 상태임
			//member 테이블의 PW column SELECT
			//ID의 값이 id인 것
			//결과와 pw를 비교해서
			//일치시 "로그인성공", 불일치시 "로그인실패"
			
			String sql = "select pw,name from member where id=?";
			
			try {
				psmt = conn.prepareStatement(sql);
				//?는 반드시 execute전에 설정되어 있어야 함.
				psmt.setString(1,dto.getId()); 
		
				rs = psmt.executeQuery();
				
				if(rs.next()) {
//					if(rs.getString(1) = pw) {
//						System.out.println("결과 일치");
//					}
					String result = rs.getString(1); //rs.getString("pw") 똑같음
					if(result.equals(dto.getPw())) {
						System.out.println(rs.getString(2)+"님 환영합니다!!");
						finalresult=true;
						
					}else {
						System.out.println("로그인 실패");
					}
				}
			
			
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

					System.out.println("로그인 정보 다시입력");

				}
				
				
				
				
			}
			return finalresult;
		}

		// 로그인 메소드
		public void Adjust(MemberDTO dto,int P_N,String text) { //매개변수 parameter
			
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
			

			String sql=null;
			//3. SQL문 실행
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
					System.out.println(text+"로 변경완료!");
				}
			
				
				
			} catch (SQLException e1) {
				System.out.println("sql실행 도중 입력값에 문제가 있어요");
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

					System.out.println("로그인 정보 다시입력");

				}
				
				
				
				
			}
			
		}


	
		
		
	
}
