package View;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import DB.Member;
import DB.MemberDTO;
import DB.MusicList;
import DB.Rank;
import javazoom.jl.player.MP3Player;

public class ViewTest {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 선언
	static long beforeTime;
	static long afterTime;
	static double gap;
	static Member dao = new Member(); // 회원정보 클래스
	static MemberDTO dto = new MemberDTO(null, null, null);
	static MusicList ml = new MusicList(); // 노래정보 클래스
	static MP3Player mp3 = new MP3Player();
	static int score = 0;
	static int cnt = 0;
	static int sum = 0;
	static int minus = 0;
	static int total = 0;
	static Rank rk = new Rank();
	static String lv = null;
	static String path = null;
	static boolean stage1 = true;
	static boolean stage1_1 = false;
	static boolean stage2 = false;
	static boolean stage3 = false;
	static boolean stage3_1 = false;
	static boolean stage4 = false;
	static boolean test = false;
	static String ans3;
	
	public static void main(String[] args) throws IOException {
		art();
		while (stage1) {
			if(!stage1_1) { //stage2에서 stage1_1로 뒤로가기 기능을 위해 조건문필요
				System.out.println("=============================== HELLO ===============================");
				System.out.println("[1]회원가입\t[2]로그인\t[3]로그아웃\n[4]연습게임\t[5]랭크조회\t[0]종료");
				STAGE1();// 회원가입 및 로그인 메서드
			}
			while (stage1_1) {
				System.out.println("============================== MY PAGE ==============================");
				System.out.println("[1]회원정보수정\t[2]게임이동\t[3]랭킹조회\t[4]뒤로가기 ");
				STAGE1_1();// 회원정보수정 & 게임시작메서드
			} // stage1_1끝

			while (stage2) {
				System.out.println("========================== ARE YOU READY? ===========================");
				System.out.println("[1]게임룰설명\t[2]난이도설정 후 게임시작\t[3]뒤로가기");
				STAGE2();
			}

			while (stage3) {
				System.out.println("============================ GAME START! ============================");
					STAGE3();
				
				while (stage3_1) {
				System.out.println("============================= GAME OVER =============================");
					STAGE3_1();
				}
			}

			while (stage4 && !test) {
				STAGE4();
			}
		}
		
		System.out.println("시스템 종료");

	}// main끝

	
	
	
	public static void art() {
		System.out.println("\n\t알아서 찾아가는 서비스");
		System.out.println("\r\n"
				+ "\r\n"
				+ "                                                                      \r\n"
				+ "             @-               ~$               :#                     \r\n"
				+ "   $$$$$$$$ -@   =@@@@@@@@@@@ ~#        ~$     :#      !!!!!!!!!!!!   \r\n"
				+ "   .......@. @-      #;  -@   ~#        ~$     :#      $$$$$#@$$$$$   \r\n"
				+ "          #  @-      #$  ;@   ~#        *@     :#           =@        \r\n"
				+ "     .;  ,$  @-     ,@$  @@-  ~#;:.     @@-    :@;;        ,@@-       \r\n"
				+ "     -@  :=  @~     ~#:#-=$!  ~@#$.    =*$=    :@##.       =*$@       \r\n"
				+ "     -@  !*  @#$$  ~@. !@~ @! ~#      =@. *=.  :#        .$;  *#,     \r\n"
				+ "     -@      @-    =:  :=  ~@-~#    .*@,   *@, :#      ,~#!    *#;~   \r\n"
				+ " .@@@@@@@@@@ @-       ;#      ~#     *         :#     =@#   -=   ;@;  \r\n"
				+ "  ~~~~~~~~~, @-               .,           .   ,~      .    ~#        \r\n"
				+ "    ..       @-      #@@@@@@@@@#       .;@$==$@!            ~#        \r\n"
				+ "    **       @-      .........:#       $=.    .*$           ~#        \r\n"
				+ "    ==                        ~#      .@       ,@-   .;;;;;;=@;;;;;;; \r\n"
				+ "    ==                        ~#      .@.      -@-   .$$$$$$$$$$$$$$= \r\n"
				+ "    =@$$$$$$$$$               ~#       =@=    =#:                     \r\n"
				+ "    :!!!!!!!!!!               ~#        -!*$$*!-                      \r\n"
				+ "                                                                      \r\n"
				+ "                                                                      \r\n"
				+ "");
	}
	

	public static void STAGE1() throws IOException {
		if (mp3.isPlaying())
			mp3.stop();
		mp3.play("C:/Users/smhrd/Desktop/MP3/effect/오프닝.mp3");
		String menu = br.readLine(); // 성능향상을위해 버퍼리더사용
		if (menu.equals("1")) {
			System.out.print("id입력>>");
			dto.setId(br.readLine());
			System.out.print("pw입력>>");
			dto.setPw(br.readLine());
			System.out.print("이름입력>>");
			dto.setName(br.readLine());
			dao.insert(dto);

		} else if (menu.equals("2")) {
			System.out.print("id입력>>");
			String id = br.readLine();
			dto.setId(id);
			System.out.print("pw입력>>");
			String pw = br.readLine();
			dto.setPw(pw);
			dao.login(dto);
			if (id.equals(dto.getId()) && pw.equals(dto.getPw())) {
				System.out.println(dto.getId() + "님의 전 점수 : " + rk.scoreput(dto));
				stage1 = false; // 입력값과 테이블값 일치해야 다음페이지로 넘어감
				stage1_1 = true;
			}
		} else if (menu.equals("0")) {
			if(mp3.isPlaying()) {
				mp3.stop();
			}
			System.out.println("종료되었습니다.");
			stage1 = false;
		} else if (menu.equals("3")) {
			dto.signOut();
		} else if (menu.equals("4")) {
			System.out.println("연습게임 모드입니다.");
			test = true;
			stage1 = false;
			stage2 = true;
		} else if (menu.equals("5")) {
			rk.top10();
		} else {
			System.out.println("잘못 누르셨습니다.");
		}
	}// STAGE1 끝

	

	public static void STAGE1_1() throws IOException {
		
		String menu1_1 = br.readLine();
		if (menu1_1.equals("1")) {
			
			while(true) {
				System.out.println("[1]비밀번호 수정\t[2]이름 수정\t[3]회원탈퇴\t[4]뒤로가기");
				String P_N = br.readLine();
				if (P_N.equals("1") || P_N.equals("2")) {
					System.out.print("수정할 값>> ");
					String text = br.readLine();
					dao.Adjust(dto, P_N, text);
					break;
				} else if (P_N.equals("3")) {
					dao.delete(dto);
					stage1_1 = false;
					stage1 = true;
				}else if (P_N.equals("4")) {
					break;
				} else {
					System.out.println("잘못 누르셨습니다.");
				}
			}
		
		
		}
		else if (menu1_1.equals("2")) { // 게임
			stage1_1 = false;
			stage2 = true;
		} else if (menu1_1.equals("3")) {
			System.out.println("랭킹조회"); // 혜수 메소드
			rk.top10();

		} else if (menu1_1.equals("4")) {
			stage1_1 = false;
			stage1 = true;

		} else {
			System.out.println("잘못입력, 다시선택해주세요!");
		}
	}// STAGE1_1 끝
	
	

	public static void STAGE2() throws IOException {
		String menu2 = br.readLine();
		if (menu2.equals("1")) {
			Rule();// 게임 룰 설명 메서드

		} else if (menu2.equals("2")) {
			Level();// 난이도 설정 메서드

		}  else if (menu2.equals("3")) { 
			stage2= false;
			stage1 =true;
			stage1_1 =true;
		} else {
			System.out.println("잘못 입력하셨습니다.");
		}
	} //STAGE2 끝
	
	
	
	public static void STAGE3() throws IOException{
		if (mp3.isPlaying())
			mp3.stop();
		beforeTime = System.currentTimeMillis();
		for (int i = 1; i <= 10; i++) {
			System.out.println(i + "번째 문제입니다.");
			path = ml.diff(lv); // 선택한 난이도의 랜덤곡 추출
			SubmitAns();//답안선택 메서드

		} // 문제반복 for문끝
		afterTime = System.currentTimeMillis();
		gap = (afterTime - beforeTime) / 1000.00;
		if (mp3.isPlaying()) {
			mp3.stop();
		}
		stage3 = false;
		stage3_1 = true;

	}// stage3 끝
		
	
	
	public static void STAGE3_1() throws IOException{
		Calcu();// 최종 점수산출 메서드

		if (rk.scoreput(dto) < total) { // 전 점수와 비교해서 큰 값으로 값 갱신
			rk.scoreUpdate(dto, total);
		}

		System.out.println("재도전하시겠습니까?  ");
		System.out.println("[1]아니오\t[2]예, 재도전! ");
		String memu3_3 = br.readLine();
		if (memu3_3.equals("1")) { // 아니오 선택시
			stage4 = true;
			if (test) {
				System.out.println("연습모드라서 초기화면으로 돌아갑니다.");
				stage1 = true;
			}
		} else if (memu3_3.equals("2")) { // 재도전 선택시
			stage3 = true;
		}
		stage3_1 = false;
		

	
	} //STAGE3_1 끝
	
	
	
	public static void STAGE4() throws IOException{
		rk.top10();
		stage4 = false;
		System.out.println("[1]시작화면\t[2]종료");
		String menu4 = br.readLine();
		if (menu4.equals("1")) {
			stage1 = true;
	
		} else { // 종료
			if(mp3.isPlaying()) mp3.stop();
			stage1 = false;
		}
	}//STAGE4 끝

	
	
	public static void Rule() throws IOException {
		System.out.println("게임시작 ▶ 난이도 선택 ▶ 문제풀기 ▶ 랭킹확인");
		System.out.println("→ 난이도별 점수배분방식 :한 문제당 상 10점, 중 8점, 하 6점\n  초성힌트 -2점\t가수명힌트 -1점");
		System.out.println("→ 힌트종류 : ① 한글제목:초성힌트/영어제목:처음부터 두개의 알파벳제시 \n  \t   ② 가수명힌트");
		System.out.println("→ 문항수 : 10문제, 시간제한없고 모르는 문제는 패스가능");
		System.out.println("→ 정답작성시 주의사항 : 띄어쓰기X, 영어제목 : 대문자로 기입");
		System.out.println("→ 랭킹 : 내 점수의 최고점으로갱신됩니다");

	}

	
	
	public static void Level() throws IOException {
		System.out.println("난이도 번호를 선택해주세요");
		System.out.println("[1]상\t[2]중\t[3]하");
		lv = br.readLine();
		if (lv.equals("1")) {
			score = 10;
			stage2 = false;
			stage3 = true;
		} else if (lv.equals("2")) {
			score = 8;
			stage2 = false;
			stage3 = true;
		} else if (lv.equals("3")) {
			score = 6;
			stage2 = false;
			stage3 = true;
		} else {
			System.out.println("난이도는 1/2/3중에서 선택해주세요");
		}
	}

	
		
	public static void SubmitAns() throws IOException {
				
		while (true) {
			MP3Player mp3_1 =new MP3Player();
			 
			if (mp3_1.isPlaying()) {
				mp3_1.stop(); // 왜 자꾸 노래가 들릴까..
			} mp3_1.play(path);
			
			System.out.print("정답입력>>");
			System.out.print("[0]스킵\t[1]초성힌트\t[2]가수힌트>> ");
			
			ans3 = br.readLine();
			if (ans3 != null) {
				mp3.stop();
			}
			if (ans3.equals(ml.getTitle(path))) {
				System.out.println("******참 잘하셨어요******");
				ml.letMeKnow(path);
				cnt++;
				break;
			} else if (ans3.equals("0")) {
				ml.letMeKnow(path);
				break;
			} else if (ans3.equals("1")) {
				ml.ChoHint(path);
				minus -= 2;
			} else if (ans3.equals("2")) {
				ml.SingHint(path);
				minus -= 1;
			} else {
				System.out.println("오답");

			}
			
		}
	}

	

	public static void Calcu() throws IOException {
		if (mp3.isPlaying()) {
			mp3.stop();
		}
		// 여기에
		mp3.play("C:/Users/smhrd/Desktop/MP3/effect/관짝밈.mp3");
		if (minus < 0)
			minus = 0;
		sum = cnt * score;
		total = sum + minus;
		float convert = (float) Math.round((total * (60 / gap)) * 100) / 100;
		System.out.println("총점은: " + total + "점");
		System.out.println("맞은개수: " + cnt + "개");
		System.out.println("풀이시간: " + gap + "초");
		System.out.println("1분당 환산점수: " + convert + "점");

	}

}// 맨끝
