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
	static Member dao = new Member(); // ȸ������ Ŭ����
	static MemberDTO dto = new MemberDTO(null, null, null);
	static MusicList ml = new MusicList(); // �뷡���� Ŭ����
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
//		System.out.println("������: " + total);
//		System.out.println("��������: " +cnt);
//		System.out.println("Ǯ�̽ð�: " +gap/1000+"��");
//		System.out.println("ȯ������: " +(float)Math.round((total*(60000/gap))*100)/100);
//		String absoultePath = "C:/Users/smhrd/git/Teamsongsong/Teamsongsong/src/View/../../music/music/�� - ������.mp3";
		
	}

}
