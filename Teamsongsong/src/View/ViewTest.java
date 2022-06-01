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
		Member dao = new Member(); // ȸ������ Ŭ����
		MemberDTO dto = new MemberDTO(null, null, null);
		MusicList ml = new MusicList(); // �뷡���� Ŭ����
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
			System.out.println("=====����ȭ��=====");
			System.out.println("[1]ȸ������ [2]�α��� [3]���� ");
			int menu = sc.nextInt();
			if (menu == 1) {
				System.out.print("id�Է�>>");
				dto.setId(sc.next());
				System.out.print("pw�Է�>>");
				dto.setPw(sc.next());
				System.out.print("�̸��Է�>>");
				dto.setName(sc.next());
				dao.insert(dto);

			} else if (menu == 2) {
				System.out.print("id�Է�>>");
				String id = sc.next();
				dto.setId(id);
				System.out.print("pw�Է�>>");
				String pw =sc.next();
				dto.setPw(pw);
				dao.login(dto);
				if (id.equals(dto.getId()) &&  pw.equals(dto.getPw())) { 
					stage1 = false; //�Է°��� ���̺� ��ġ�ؾ� ������������ �Ѿ
					stage1_1 = true;
				}
			} else if (menu == 3) {
				System.out.println("����Ǿ����ϴ�.");
				stage1 = false;

			} else {
				System.out.println("�߸� �����̽��ϴ�.");
			}
		} // stage1��

		while (stage1_1) {
			System.out.println("[1]ȸ����������\t[2]�����̵�\t[3]��ŷ��ȸ ");
			int menu1_1 = sc.nextInt();
			if (menu1_1 == 1) {
				System.out.println("[1]��й�ȣ ����	[2]�̸� ����");
				int P_N = sc.nextInt();
				if(P_N==1 || P_N==2){
					System.out.println("������ ��>>");
					String text = sc.next();
					dao.Adjust(dto, P_N, text);
				}else {
					System.out.println("�߸� �����̽��ϴ�.");
				}
			} else if (menu1_1 == 2) { // ����
				stage1_1 = false;
				stage2 = true;
			} else if (menu1_1 == 3) {
				System.out.println("��ŷ��ȸ"); //���� �޼ҵ�

			} else {
				System.out.println("�߸��Է�, �ٽü������ּ���!");
			}

		} // stage1_1��

		while (stage2) {
			System.out.println("=====���� �غ�=====");
			System.out.println("[1]���ӷ꼳��\t[2]���̵����� �� ���ӽ���");
			int menu2 =sc.nextInt();
			if(menu2 == 1) {
				System.out.println("����� �����~");
			}else if(menu2 ==2) {
				System.out.println("���̵� ��ȣ�� �������ּ���");
				System.out.println("[1]��	[2]��	[3]��");
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
					System.out.println("���̵��� 1/2/3�߿��� �������ּ���");
				}
			}
			else {
				System.out.println("�߸� �Է��ϼ̽��ϴ�.");
			}
		
		}

	while(stage3)

	{
		for (int i = 1; i <= 3; i++) {
			if (mp3.isPlaying()) {
				mp3.stop();
			}
			System.out.println(i + "��° �����Դϴ�.");
			path = ml.diff(lv); // ������ ���̵��� ������ ����
			System.out.println(path);

			while (true) {
				mp3.play(path);
				System.out.print("�����Է�>>");
				System.out.print("[0]��ŵ		[1]�ʼ���Ʈ	[2]������Ʈ>>");
				String ans = sc.next();
				if (ans.equals(ml.getTitle(path))) {
					System.out.println("����*^^*");
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
					System.out.println("����");
				}

			}

		}
		stage3 = false;
		stage4 = true;
		System.out.println("��������");
		// ä�� : ������
		System.out.println(minus);
		sum = cnt * score;
		System.out.println(sum);
		System.out.println("������: " + (sum-minus));

	}

	while(stage4)
	{
//		rank.scoreUpdate(dto,100);
	}

	sc.close();
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
