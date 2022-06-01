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
		
				
				
		System.out.println("총점은: " + total);
		System.out.println("맞은개수: " +cnt);
		System.out.println("풀이시간: " +gap/1000+"초");
		System.out.println("환산점수: " +(float)Math.round((total*(60000/gap))*100)/100);
		
	
		
	}

}
