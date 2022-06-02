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

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 선언
		long beforeTime;
		long afterTime;
		double  gap;
		Member dao = new Member(); // 회원정보 클래스
		MemberDTO dto = new MemberDTO(null, null, null);
		MusicList ml = new MusicList(); // 노래정보 클래스
		MP3Player mp3 = new MP3Player();
		int score = 0;
		int cnt = 0;
		int sum = 0;
		int minus = 0;
		int total = 0;
		Rank rk = new Rank();

		String lv = null;
		String path = null;
		boolean stage1 = true;
		boolean stage1_1 = false;
		boolean stage2 = false;
		boolean stage3 = false;
		boolean stage3_1 = false;
		boolean stage4 = false;
		boolean test = false;

		while (stage1) {
			if (mp3.isPlaying()) mp3.stop();
			mp3.play("C:/Users/smhrd/Desktop/MP3/effect/오프닝.mp3");
			System.out.println("=====시작화면=====");
			System.out.println("[1]회원가입 [2]로그인 [3]로그아웃 \n[4]연습게임 [5]랭크조회 [0]종료");
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
			}

			else {
				System.out.println("잘못 누르셨습니다.");
			}

			while (stage1_1) {
				System.out.println("[1]회원정보수정\t[2]게임이동\t[3]랭킹조회\t[4]뒤로가기 ");
				String menu1_1 = br.readLine();
				if (menu1_1.equals("1")) {
					System.out.println("[1]비밀번호 수정	[2]이름 수정  [3]회원탈퇴");
					String P_N = br.readLine();
					if (P_N.equals("1") || P_N.equals("2")) {
						System.out.println("수정할 값>>");
						String text = br.readLine();
						dao.Adjust(dto, P_N, text);
					}else if(P_N.equals("3")) {
						
						dao.delete(dto);
						stage1_1 =false;
						stage1 = true;
					} 
					else {
						System.out.println("잘못 누르셨습니다.");
					}
				} else if (menu1_1.equals("2")) { // 게임
					stage1_1 = false;
					stage2 = true;
				} else if (menu1_1.equals("3")) {
					System.out.println("랭킹조회"); // 혜수 메소드
					rk.top10();

				}else if (menu1_1.equals("4")) {
					stage1_1= false;
					stage1 =true;

				}
				else {
					System.out.println("잘못입력, 다시선택해주세요!");
				}

			} // stage1_1끝

			while (stage2) {
				System.out.println("=====게임 준비=====");
				System.out.println("[1]게임룰설명\t[2]난이도설정 후 게임시작\t[3]뒤로가기");
				String menu2 = br.readLine();
				if (menu2.equals("1")) {
					System.out.println("게임시작 ▶ 난이도 선택 ▶ 문제풀기 ▶ 랭킹확인");
					System.out.println("→ 난이도별 점수배분방식 :한 문제당 상 7점, 중 5점, 하 3점\n  힌트 사용시 감점 1점");
					System.out.println("→ 힌트종류 : ① 한글제목:초성힌트/영어제목:시작&끝 알파벳제시 \n  \t   ② 가수명힌트");
					System.out.println("→ 문항수 : 20문제, 시간제한없고 모르는 문제는 패스가능");
					System.out.println("→ 정답작성시 주의사항 : 띄어쓰기X, 영어제목 : 대문자로 기입");
					System.out.println("→ 랭킹 : 내 점수의 최고점으로갱신됩니다");

				} else if (menu2.equals("2")) {
					System.out.println("난이도 번호를 선택해주세요");
					System.out.println("[1]상	[2]중	[3]하");
					lv = br.readLine();
					if (lv.equals("1")) {
						score = 7;
						stage2 = false;
						stage3 = true;
					} else if (lv.equals("2")) {
						score = 5;
						stage2 = false;
						stage3 = true;
					} else if (lv.equals("3")) {
						score = 3;
						stage2 = false;
						stage3 = true;
					} else {
						System.out.println("난이도는 1/2/3중에서 선택해주세요");
					}
				} else if (menu2.equals("3")) { 
						stage2= false;
						stage1 =true;
						stage1_1 =true;
				} else {
					System.out.println("잘못 입력하셨습니다.");
				}

			}

			while (stage3) {

				beforeTime =System.currentTimeMillis();
				for (int i = 1; i <= 5; i++) {
					System.out.println(i + "번째 문제입니다.");
					path = ml.diff(lv); // 선택한 난이도의 랜덤곡 추출
					System.out.println(path);

					while (true) {
						if (mp3.isPlaying())
							mp3.stop(); // 왜 자꾸 노래가 들릴까..
						System.out.print("정답입력>>");
						mp3.play(path);
						System.out.print("[0]스킵		[1]초성힌트	[2]가수힌트>>");
						String ans = br.readLine();
						if (ans.equals(ml.getTitle(path))) {
							System.out.println("정답*^^*");
							cnt++;
							break;
						} else if (ans.equals("0")) {
							break;
						} else if (ans.equals("1")) {
							ml.ChoHint(path);
							minus -= 1;
						} else if (ans.equals("2")) {
							ml.SingHint(path);
							minus -= 1;
						} else {
							System.out.println("오답");
						
						}

					} // 한 문제당 while문 끝

				} // 문제반복 for문끝
				afterTime =System.currentTimeMillis();
				gap =(afterTime-beforeTime)/1000.00;
				
				System.out.println(gap);
				System.out.println("=============게임오버=============");
				if (mp3.isPlaying()) mp3.stop();
				mp3.play("C:/Users/smhrd/Desktop/MP3/effect/관짝밈.mp3");
				stage3 = false;
				stage3_1 = true;
				while (stage3_1) {

					if (minus < 0)
						minus = 0;
					sum = cnt * score;
					total = sum + minus;
					float convert =(float)Math.round((total*(60/gap))*100)/100;
					System.out.println("총점은: " + total+"점");
					System.out.println("맞은개수: " +cnt+"개");
					System.out.println("풀이시간: " + gap+"초");
					System.out.println("1분당 환산점수: " + convert+"점");
					
					if(rk.scoreput(dto) < total) {        // 전 점수와 비교해서 큰 값으로 값 갱신
						rk.scoreUpdate(dto, total);
					}
					
					System.out.println("재도전하시겠습니까?  ");
					System.out.println("[1]아니오 [2]예, 재도전! ");
					String memu3_3 = br.readLine();
					if (memu3_3.equals("1")) { // 아니오 선택시
						stage4 = true;
					} else { // 재도전 선택시
						stage3 = true;
					}
					stage3_1 = false;
					if (mp3.isPlaying())
						mp3.stop();

				}
			}

			while (stage4 && !test) {
				if (mp3.isPlaying())
					mp3.stop();
				System.out.println("===============랭킹화면===============");
				rk.top10();
				stage4 = false;
				System.out.println("[1]시작화면 [2]종료");
				String menu4 = br.readLine();
				if (menu4.equals("1")) {
					stage1 = true;
					
				} else { //종료
					stage1 = false;
				}
			}
		} // stage1끝
		System.out.println("시스템 종료");

//	sc.close();
	}// main끝

}// 맨끝

//		while (stage4) {
//			int i = 1;
//			System.out.printf("순위\tID\tScore\tDate");
//			RankDTO rdto = new RankDTO();
//			rdto.setId(dto.getId());
//			rank.show(rdto);
//			System.out.printf("%d\t%s\t%s", i, rdto.getId(), rdto.getScore(), rdto.getUpdate());
//		}
