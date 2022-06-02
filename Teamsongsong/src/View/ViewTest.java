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
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // ����
		long beforeTime;
		long afterTime;
		double  gap;
		Member dao = new Member(); // ȸ������ Ŭ����
		MemberDTO dto = new MemberDTO(null, null, null);
		MusicList ml = new MusicList(); // �뷡���� Ŭ����
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
			mp3.play("C:/Users/smhrd/Desktop/MP3/effect/������.mp3");
			System.out.println("=====����ȭ��=====");
			System.out.println("[1]ȸ������ [2]�α��� [3]�α׾ƿ� \n[4]�������� [5]��ũ��ȸ [0]����");
			String menu = br.readLine(); // ������������� ���۸������
			if (menu.equals("1")) {
				System.out.print("id�Է�>>");
				dto.setId(br.readLine());
				System.out.print("pw�Է�>>");
				dto.setPw(br.readLine());
				System.out.print("�̸��Է�>>");
				dto.setName(br.readLine());
				dao.insert(dto);

			} else if (menu.equals("2")) {
				System.out.print("id�Է�>>");
				String id = br.readLine();
				dto.setId(id);
				System.out.print("pw�Է�>>");
				String pw = br.readLine();
				dto.setPw(pw);
				dao.login(dto);
				if (id.equals(dto.getId()) && pw.equals(dto.getPw())) {
					System.out.println(dto.getId() + "���� �� ���� : " + rk.scoreput(dto));
					stage1 = false; // �Է°��� ���̺� ��ġ�ؾ� ������������ �Ѿ
					stage1_1 = true;
				}
			} else if (menu.equals("0")) {
				System.out.println("����Ǿ����ϴ�.");
				stage1 = false;

			} else if (menu.equals("3")) {
				dto.signOut();

			} else if (menu.equals("4")) {
				System.out.println("�������� ����Դϴ�.");
				test = true;
				stage1 = false;
				stage2 = true;

			} else if (menu.equals("5")) {
				rk.top10();
			}

			else {
				System.out.println("�߸� �����̽��ϴ�.");
			}

			while (stage1_1) {
				System.out.println("[1]ȸ����������\t[2]�����̵�\t[3]��ŷ��ȸ\t[4]�ڷΰ��� ");
				String menu1_1 = br.readLine();
				if (menu1_1.equals("1")) {
					System.out.println("[1]��й�ȣ ����	[2]�̸� ����  [3]ȸ��Ż��");
					String P_N = br.readLine();
					if (P_N.equals("1") || P_N.equals("2")) {
						System.out.println("������ ��>>");
						String text = br.readLine();
						dao.Adjust(dto, P_N, text);
					}else if(P_N.equals("3")) {
						
						dao.delete(dto);
						stage1_1 =false;
						stage1 = true;
					} 
					else {
						System.out.println("�߸� �����̽��ϴ�.");
					}
				} else if (menu1_1.equals("2")) { // ����
					stage1_1 = false;
					stage2 = true;
				} else if (menu1_1.equals("3")) {
					System.out.println("��ŷ��ȸ"); // ���� �޼ҵ�
					rk.top10();

				}else if (menu1_1.equals("4")) {
					stage1_1= false;
					stage1 =true;

				}
				else {
					System.out.println("�߸��Է�, �ٽü������ּ���!");
				}

			} // stage1_1��

			while (stage2) {
				System.out.println("=====���� �غ�=====");
				System.out.println("[1]���ӷ꼳��\t[2]���̵����� �� ���ӽ���\t[3]�ڷΰ���");
				String menu2 = br.readLine();
				if (menu2.equals("1")) {
					System.out.println("���ӽ��� �� ���̵� ���� �� ����Ǯ�� �� ��ŷȮ��");
					System.out.println("�� ���̵��� ������й�� :�� ������ �� 7��, �� 5��, �� 3��\n  ��Ʈ ���� ���� 1��");
					System.out.println("�� ��Ʈ���� : �� �ѱ�����:�ʼ���Ʈ/��������:����&�� ���ĺ����� \n  \t   �� ��������Ʈ");
					System.out.println("�� ���׼� : 20����, �ð����Ѿ��� �𸣴� ������ �н�����");
					System.out.println("�� �����ۼ��� ���ǻ��� : ����X, �������� : �빮�ڷ� ����");
					System.out.println("�� ��ŷ : �� ������ �ְ������ΰ��ŵ˴ϴ�");

				} else if (menu2.equals("2")) {
					System.out.println("���̵� ��ȣ�� �������ּ���");
					System.out.println("[1]��	[2]��	[3]��");
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
						System.out.println("���̵��� 1/2/3�߿��� �������ּ���");
					}
				} else if (menu2.equals("3")) { 
						stage2= false;
						stage1 =true;
						stage1_1 =true;
				} else {
					System.out.println("�߸� �Է��ϼ̽��ϴ�.");
				}

			}

			while (stage3) {

				beforeTime =System.currentTimeMillis();
				for (int i = 1; i <= 5; i++) {
					System.out.println(i + "��° �����Դϴ�.");
					path = ml.diff(lv); // ������ ���̵��� ������ ����
					System.out.println(path);

					while (true) {
						if (mp3.isPlaying())
							mp3.stop(); // �� �ڲ� �뷡�� �鸱��..
						System.out.print("�����Է�>>");
						mp3.play(path);
						System.out.print("[0]��ŵ		[1]�ʼ���Ʈ	[2]������Ʈ>>");
						String ans = br.readLine();
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

					} // �� ������ while�� ��

				} // �����ݺ� for����
				afterTime =System.currentTimeMillis();
				gap =(afterTime-beforeTime)/1000.00;
				
				System.out.println(gap);
				System.out.println("=============���ӿ���=============");
				if (mp3.isPlaying()) mp3.stop();
				mp3.play("C:/Users/smhrd/Desktop/MP3/effect/��¦��.mp3");
				stage3 = false;
				stage3_1 = true;
				while (stage3_1) {

					if (minus < 0)
						minus = 0;
					sum = cnt * score;
					total = sum + minus;
					float convert =(float)Math.round((total*(60/gap))*100)/100;
					System.out.println("������: " + total+"��");
					System.out.println("��������: " +cnt+"��");
					System.out.println("Ǯ�̽ð�: " + gap+"��");
					System.out.println("1�д� ȯ������: " + convert+"��");
					
					if(rk.scoreput(dto) < total) {        // �� ������ ���ؼ� ū ������ �� ����
						rk.scoreUpdate(dto, total);
					}
					
					System.out.println("�絵���Ͻðڽ��ϱ�?  ");
					System.out.println("[1]�ƴϿ� [2]��, �絵��! ");
					String memu3_3 = br.readLine();
					if (memu3_3.equals("1")) { // �ƴϿ� ���ý�
						stage4 = true;
					} else { // �絵�� ���ý�
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
				System.out.println("===============��ŷȭ��===============");
				rk.top10();
				stage4 = false;
				System.out.println("[1]����ȭ�� [2]����");
				String menu4 = br.readLine();
				if (menu4.equals("1")) {
					stage1 = true;
					
				} else { //����
					stage1 = false;
				}
			}
		} // stage1��
		System.out.println("�ý��� ����");

//	sc.close();
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
