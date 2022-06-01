package View;
import java.util.Scanner;

import DB.Member;
import DB.MemberDTO;
import DB.MusicList;
import javazoom.jl.player.MP3Player;
//import DB.Rank;
//import DB.RankDTO;
//import java.util.Date;
//import oracle.sql.DATE;

public class ViewTest {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Member dao = new Member(); // 회원정보 클래스
		MemberDTO dto = new MemberDTO(null, null, null);
		MusicList ml = new MusicList(); // 노래정보 클래스
		MP3Player mp3 = new MP3Player();
		int score = 0;
		int cnt = 0;
		int sum = 0;
		int minus =0;
//		Rank rank = new Rank();

		String lv = null;
		String path = null;
		boolean stage1 = true;
		boolean stage1_1 = true;
		boolean stage2 = false;
		boolean stage3 = false;
		boolean stage4 = false;

		while (stage1) {
			System.out.println("=====시작화면=====");
			System.out.println("[1]회원가입 [2]로그인 [3]종료 ");
			int menu = sc.nextInt();
			if (menu == 1) {
				System.out.print("id입력>>");
				dto.setId(sc.next());
				System.out.print("pw입력>>");
				dto.setPw(sc.next());
				System.out.print("이름입력>>");
				dto.setName(sc.next());
				dao.insert(dto);

			} else if (menu == 2) {
				System.out.print("id입력>>");
				String id = sc.next();
				dto.setId(id);
				System.out.print("pw입력>>");
				String pw =sc.next();
				dto.setPw(pw);
				dao.login(dto);
				if (id.equals(dto.getId()) &&  pw.equals(dto.getPw())) { 
					stage1 = false; //입력값과 테이블값 일치해야 다음페이지로 넘어감
					stage1_1 = true;
				}
			} else if (menu == 3) {
				System.out.println("종료되었습니다.");
				stage1 = false;

			} else {
				System.out.println("잘못 누르셨습니다.");
			}
		} // stage1끝

		while (stage1_1) {
			System.out.println("[1]회원정보수정\t[2]게임이동\t[3]랭킹조회 ");
			int menu1_1 = sc.nextInt();
			if (menu1_1 == 1) {
				System.out.println("[1]비밀번호 수정	[2]이름 수정");
				int P_N = sc.nextInt();
				if(P_N==1 || P_N==2){
					System.out.println("수정할 값>>");
					String text = sc.next();
					dao.Adjust(dto, P_N, text);
				}else {
					System.out.println("잘못 누르셨습니다.");
				}
			} else if (menu1_1 == 2) { // 게임
				stage1_1 = false;
				stage2 = true;
			} else if (menu1_1 == 3) {
				System.out.println("랭킹조회"); //혜수 메소드

			} else {
				System.out.println("잘못입력, 다시선택해주세요!");
			}

		} // stage1_1끝

		while (stage2) {
			System.out.println("=====게임 준비=====");
			System.out.println("[1]게임룰설명\t[2]난이도설정 후 게임시작");
			int menu2 =sc.nextInt();
			if(menu2 == 1) {
				System.out.println("어찌고 저찌고~");
			}else if(menu2 ==2) {
				System.out.println("난이도 번호를 선택해주세요");
				System.out.println("[1]상	[2]중	[3]하");
				lv = sc.next();
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
			}
			else {
				System.out.println("잘못 입력하셨습니다.");
			}
		
		}

	while(stage3)

	{
		for (int i = 1; i <= 3; i++) {
			if (mp3.isPlaying()) {
				mp3.stop();
			}
			System.out.println(i + "번째 문제입니다.");
			path = ml.diff(lv); // 선택한 난이도의 랜덤곡 추출
			System.out.println(path);

			while (true) {
				mp3.play(path);
				System.out.print("정답입력>>");
				System.out.print("[0]스킵		[1]초성힌트	[2]가수힌트>>");
				String ans = sc.next();
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

			}

		}
		stage3 = false;
		stage4 = true;
		System.out.println("게임종료");
		// 채점 : 서영종
		System.out.println(minus);
		sum = cnt * score;
		System.out.println(sum);
		System.out.println("총점은: " + (sum-minus));

	}

	while(stage4)
	{
//		rank.scoreUpdate(dto,100);
	}

	sc.close();
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
