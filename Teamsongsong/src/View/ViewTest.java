package View;

import java.util.Date;
import java.util.Scanner;

import DB.Member;
import DB.MemberDTO;
import DB.MusicList;
import DB.Rank;
import DB.RankDTO;
import javazoom.jl.player.MP3Player;
import oracle.sql.DATE;

public class ViewTest {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Member dao = new Member(); // 회원정보 클래스
		MemberDTO dto = new MemberDTO(null, null);
		MusicList ml = new MusicList(); // 노래정보 클래스
		MP3Player mp3 = new MP3Player();
		int score = 0;
		int cnt = 0;
		int sum = 0;
		Rank rank = new Rank();

		String id;
		String pw;
		String name;
		String lv = null;
		String path = null;
		boolean stage1 = true;
		boolean stage2 = false;
		boolean stage3 = false;
		boolean stage4 = false;

		while (stage1) {
			System.out.println("=====노래제목맞추기 게임===== ");
			System.out.println("[1]회원가입 [2]로그인 [3]게임시작 [4]랭킹조회 [0]종료  ");
			int menu = sc.nextInt();
			if (menu == 1) {

				System.out.print("id입력>>");
				id = sc.next();
				System.out.print("pw입력>>");
				pw = sc.next();
				System.out.print("이름입력>>");
				name = sc.next();
				dao.insert(new MemberDTO(id, pw, name));

			} else if (menu == 2) {
				System.out.print("id입력>>");
				id = sc.next();
				System.out.print("pw입력>>");
				pw = sc.next();
				dto = new MemberDTO(id, pw);
				System.out.println(dao.login(dto));
//				if(dao.login(dto)) {
//					System.out.println("회원정보수정하시겠습니까? Y/N ");
//					String ans = sc.next();
//					if(ans.equals("Y")) {
//						System.out.println("[1]비밀번호 [2]이름");
//						int P_N =sc.nextInt();
//						System.out.println("수정내용>>");
//						String text= sc.next();
//						dao.Adjust(dto,P_N,text);
//						
//					}							
//					
//				}
				
			
			} 
			else if (menu == 3) { //게임시작
				stage1 = false;
				stage2 = true;
			}else if (menu == 4) { //게임시작
				System.out.println("랭킹조회");
			}
			
			else if(menu == 0){
				System.out.println("게임이 종료되었습니다.");
				stage1 = false;
				break;
			}else {
				System.out.println("잘못입력, 다시선택해주세요!");
			}
			
		} // while종료

		while (stage2) {
			System.out.println("난이도 번호를 선택해주세요");
			System.out.println("[1]상 [2]중 [3]하");
			lv = sc.next();
			
			if(lv.equals("1")) {
				score = 7;
				stage2 = false;
				stage3 = true;
			}else if (lv.equals("2")){
				score = 5;
				stage2 = false;
				stage3 = true;
			}else if (lv.equals("3")) {
				score = 3;
				stage2 = false;
				stage3 = true;
			}else {
				System.out.println("잘못 입력하셨습니다.");
			}
		}

		
		while(stage3) {
			for(int i =1 ; i<=3; i++) {
				if(mp3.isPlaying()) {mp3.stop();}
				System.out.println(i +"번째 문제입니다.");
				path = ml.diff(lv); //선택한 난이도의 랜덤곡 추출
				System.out.println(path);
				
				while(true) {
					mp3.play(path);
					System.out.print("정답입력>>");
					System.out.print("스킵 [0] , 초성힌트[1], 가수힌트[2]>>");
					String ans = sc.next();
					if(ans.equals(ml.getTitle(path))){
						System.out.println("정답*^^*");
						cnt++;
						rank.score(3);
						break;
					}else if(ans.equals("0")) {
						break;
					}else if(ans.equals("1")) {
							ml.ChoHint(path);
					}else if(ans.equals("2")) {
							ml.SingHint(path);
					}else {
						System.out.println("오답");
					}
					
				}
				
			}
			stage3 =false;
			stage4 =true;
			System.out.println("게임종료");
			// 채점 : 서영종
			sum = cnt *score;
			System.out.println("총점은: "+sum);
			
		}
	
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

