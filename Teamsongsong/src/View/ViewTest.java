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

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // ����
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
	
	public static void main(String[] args) throws IOException {
		art();
		while (stage1) {
			if(!stage1_1) { //stage2���� stage1_1�� �ڷΰ��� ����� ���� ���ǹ��ʿ�
				System.out.println("=============================== HELLO ===============================");
				System.out.println("[1]ȸ������\t[2]�α���\t[3]�α׾ƿ�\n[4]��������\t[5]��ũ��ȸ\t[0]����");
				STAGE1();// ȸ������ �� �α��� �޼���
			}
			while (stage1_1) {
				System.out.println("============================== MY PAGE ==============================");
				System.out.println("[1]ȸ����������\t[2]�����̵�\t[3]��ŷ��ȸ\t[4]�ڷΰ��� ");
				STAGE1_1();// ȸ���������� & ���ӽ��۸޼���
			} // stage1_1��

			while (stage2) {
				System.out.println("========================== ARE YOU READY? ===========================");
				System.out.println("[1]���ӷ꼳��\t[2]���̵����� �� ���ӽ���\t[3]�ڷΰ���");
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
		
		System.out.println("�ý��� ����");

	}// main��

	
	
	
	public static void art() {
		System.out.println("\n\t�˾Ƽ� ã�ư��� ����");
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
		mp3.play("C:/Users/smhrd/Desktop/MP3/effect/������.mp3");
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
			if(mp3.isPlaying()) {
				mp3.stop();
			}
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
		} else {
			System.out.println("�߸� �����̽��ϴ�.");
		}
	}// STAGE1 ��

	

	public static void STAGE1_1() throws IOException {
		
		String menu1_1 = br.readLine();
		if (menu1_1.equals("1")) {
			
			while(true) {
				System.out.println("[1]��й�ȣ ����\t[2]�̸� ����\t[3]ȸ��Ż��\t[4]�ڷΰ���");
				String P_N = br.readLine();
				if (P_N.equals("1") || P_N.equals("2")) {
					System.out.print("������ ��>> ");
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
					System.out.println("�߸� �����̽��ϴ�.");
				}
			}
		
		
		}
		else if (menu1_1.equals("2")) { // ����
			stage1_1 = false;
			stage2 = true;
		} else if (menu1_1.equals("3")) {
			System.out.println("��ŷ��ȸ"); // ���� �޼ҵ�
			rk.top10();

		} else if (menu1_1.equals("4")) {
			stage1_1 = false;
			stage1 = true;

		} else {
			System.out.println("�߸��Է�, �ٽü������ּ���!");
		}
	}// STAGE1_1 ��
	
	

	public static void STAGE2() throws IOException {
		String menu2 = br.readLine();
		if (menu2.equals("1")) {
			Rule();// ���� �� ���� �޼���

		} else if (menu2.equals("2")) {
			Level();// ���̵� ���� �޼���

		}  else if (menu2.equals("3")) { 
			stage2= false;
			stage1 =true;
			stage1_1 =true;
		} else {
			System.out.println("�߸� �Է��ϼ̽��ϴ�.");
		}
	} //STAGE2 ��
	
	
	
	public static void STAGE3() throws IOException{
		if (mp3.isPlaying())
			mp3.stop();
		beforeTime = System.currentTimeMillis();
		for (int i = 1; i <= 10; i++) {
			System.out.println(i + "��° �����Դϴ�.");
			path = ml.diff(lv); // ������ ���̵��� ������ ����
			SubmitAns();//��ȼ��� �޼���

		} // �����ݺ� for����
		afterTime = System.currentTimeMillis();
		gap = (afterTime - beforeTime) / 1000.00;
		if (mp3.isPlaying()) {
			mp3.stop();
		}
		stage3 = false;
		stage3_1 = true;

	}// stage3 ��
		
	
	
	public static void STAGE3_1() throws IOException{
		Calcu();// ���� �������� �޼���

		if (rk.scoreput(dto) < total) { // �� ������ ���ؼ� ū ������ �� ����
			rk.scoreUpdate(dto, total);
		}

		System.out.println("�絵���Ͻðڽ��ϱ�?  ");
		System.out.println("[1]�ƴϿ�\t[2]��, �絵��! ");
		String memu3_3 = br.readLine();
		if (memu3_3.equals("1")) { // �ƴϿ� ���ý�
			stage4 = true;
			if (test) {
				System.out.println("�������� �ʱ�ȭ������ ���ư��ϴ�.");
				stage1 = true;
			}
		} else if (memu3_3.equals("2")) { // �絵�� ���ý�
			stage3 = true;
		}
		stage3_1 = false;
		

	
	} //STAGE3_1 ��
	
	
	
	public static void STAGE4() throws IOException{
		rk.top10();
		stage4 = false;
		System.out.println("[1]����ȭ��\t[2]����");
		String menu4 = br.readLine();
		if (menu4.equals("1")) {
			stage1 = true;
	
		} else { // ����
			if(mp3.isPlaying()) mp3.stop();
			stage1 = false;
		}
	}//STAGE4 ��

	
	
	public static void Rule() throws IOException {
		System.out.println("���ӽ��� �� ���̵� ���� �� ����Ǯ�� �� ��ŷȮ��");
		System.out.println("�� ���̵��� ������й�� :�� ������ �� 10��, �� 8��, �� 6��\n  �ʼ���Ʈ -2��\t��������Ʈ -1��");
		System.out.println("�� ��Ʈ���� : �� �ѱ�����:�ʼ���Ʈ/��������:ó������ �ΰ��� ���ĺ����� \n  \t   �� ��������Ʈ");
		System.out.println("�� ���׼� : 10����, �ð����Ѿ��� �𸣴� ������ �н�����");
		System.out.println("�� �����ۼ��� ���ǻ��� : ����X, �������� : �빮�ڷ� ����");
		System.out.println("�� ��ŷ : �� ������ �ְ������ΰ��ŵ˴ϴ�");

	}

	
	
	public static void Level() throws IOException {
		System.out.println("���̵� ��ȣ�� �������ּ���");
		System.out.println("[1]��\t[2]��\t[3]��");
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
			System.out.println("���̵��� 1/2/3�߿��� �������ּ���");
		}
	}

	
		
	public static void SubmitAns() throws IOException {
				
		while (true) {
			MP3Player mp3_1 =new MP3Player();
			 
			if (mp3_1.isPlaying()) {
				mp3_1.stop(); // �� �ڲ� �뷡�� �鸱��..
			} mp3_1.play(path);
			
			System.out.print("�����Է�>>");
			System.out.print("[0]��ŵ\t[1]�ʼ���Ʈ\t[2]������Ʈ>> ");
			
			ans3 = br.readLine();
			if (ans3 != null) {
				mp3.stop();
			}
			if (ans3.equals(ml.getTitle(path))) {
				System.out.println("******�� ���ϼ̾��******");
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
				System.out.println("����");

			}
			
		}
	}

	

	public static void Calcu() throws IOException {
		if (mp3.isPlaying()) {
			mp3.stop();
		}
		// ���⿡
		mp3.play("C:/Users/smhrd/Desktop/MP3/effect/��¦��.mp3");
		if (minus < 0)
			minus = 0;
		sum = cnt * score;
		total = sum + minus;
		float convert = (float) Math.round((total * (60 / gap)) * 100) / 100;
		System.out.println("������: " + total + "��");
		System.out.println("��������: " + cnt + "��");
		System.out.println("Ǯ�̽ð�: " + gap + "��");
		System.out.println("1�д� ȯ������: " + convert + "��");

	}

}// �ǳ�
