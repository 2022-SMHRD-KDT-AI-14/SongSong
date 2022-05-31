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
		Member dao = new Member(); // ȸ������ Ŭ����
		MemberDTO dto = new MemberDTO(null, null);
		MusicList ml = new MusicList(); // �뷡���� Ŭ����
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
			System.out.println("=====�뷡������߱� ����===== ");
			System.out.println("[1]ȸ������ [2]�α��� [3]���ӽ��� [4]��ŷ��ȸ [0]����  ");
			int menu = sc.nextInt();
			if (menu == 1) {

				System.out.print("id�Է�>>");
				id = sc.next();
				System.out.print("pw�Է�>>");
				pw = sc.next();
				System.out.print("�̸��Է�>>");
				name = sc.next();
				dao.insert(new MemberDTO(id, pw, name));

			} else if (menu == 2) {
				System.out.print("id�Է�>>");
				id = sc.next();
				System.out.print("pw�Է�>>");
				pw = sc.next();
				dto = new MemberDTO(id, pw);
				System.out.println(dao.login(dto));
//				if(dao.login(dto)) {
//					System.out.println("ȸ�����������Ͻðڽ��ϱ�? Y/N ");
//					String ans = sc.next();
//					if(ans.equals("Y")) {
//						System.out.println("[1]��й�ȣ [2]�̸�");
//						int P_N =sc.nextInt();
//						System.out.println("��������>>");
//						String text= sc.next();
//						dao.Adjust(dto,P_N,text);
//						
//					}							
//					
//				}
				
			
			} 
			else if (menu == 3) { //���ӽ���
				stage1 = false;
				stage2 = true;
			}else if (menu == 4) { //���ӽ���
				System.out.println("��ŷ��ȸ");
			}
			
			else if(menu == 0){
				System.out.println("������ ����Ǿ����ϴ�.");
				stage1 = false;
				break;
			}else {
				System.out.println("�߸��Է�, �ٽü������ּ���!");
			}
			
		} // while����

		while (stage2) {
			System.out.println("���̵� ��ȣ�� �������ּ���");
			System.out.println("[1]�� [2]�� [3]��");
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
				System.out.println("�߸� �Է��ϼ̽��ϴ�.");
			}
		}

		
		while(stage3) {
			for(int i =1 ; i<=3; i++) {
				if(mp3.isPlaying()) {mp3.stop();}
				System.out.println(i +"��° �����Դϴ�.");
				path = ml.diff(lv); //������ ���̵��� ������ ����
				System.out.println(path);
				
				while(true) {
					mp3.play(path);
					System.out.print("�����Է�>>");
					System.out.print("��ŵ [0] , �ʼ���Ʈ[1], ������Ʈ[2]>>");
					String ans = sc.next();
					if(ans.equals(ml.getTitle(path))){
						System.out.println("����*^^*");
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
						System.out.println("����");
					}
					
				}
				
			}
			stage3 =false;
			stage4 =true;
			System.out.println("��������");
			// ä�� : ������
			sum = cnt *score;
			System.out.println("������: "+sum);
			
		}
	
	}// main��

}// �ǳ�
		

		
		
//		while (stage4) {
//			int i = 1;
//			System.out.printf("����\tID\tScore\tDate");
//			RankDTO rdto = new RankDTO();
//			rdto.setId(dto.getId());
//			rank.show(rdto);
//			System.out.printf("%d\t%s\t%s", i, rdto.getId(), rdto.getScore(), rdto.getUpdate());
//		}

