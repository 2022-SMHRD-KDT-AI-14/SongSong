package View;

import java.util.Date;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

import oracle.sql.DATE;

public class Test {

	public static void main(String[] args) {

		
		int total =15;
		int cnt =4;
		double gap=37922.0;
		
				
				
		System.out.println("������: " + total);
		System.out.println("��������: " +cnt);
		System.out.println("Ǯ�̽ð�: " +gap/1000+"��");
		System.out.println("ȯ������: " +(float)Math.round((total*(60000/gap))*100)/100);
		
	
		
	}

}
