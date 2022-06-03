package View;

import java.util.Date;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

import DB.Member;
import DB.MemberDTO;
import DB.MusicList;
import DB.Rank;
import javazoom.jl.player.MP3Player;
import oracle.sql.DATE;

public class Test {
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
	
	public static void main(String[] args) {

		
//		int total =15;
//		int cnt =4;
//		double gap=37922.0;
//		
//				
//				
//		System.out.println("총점은: " + total);
//		System.out.println("맞은개수: " +cnt);
//		System.out.println("풀이시간: " +gap/1000+"초");
//		System.out.println("환산점수: " +(float)Math.round((total*(60000/gap))*100)/100);
//		String absoultePath = "C:/Users/smhrd/git/Teamsongsong/Teamsongsong/src/View/../../music/music/벤 - 열애중.mp3";
		
	}

}
