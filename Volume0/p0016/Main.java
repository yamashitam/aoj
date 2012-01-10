package p0016;

import java.util.Scanner;

public class Main {
	
	void run() {
		Scanner sc = new Scanner(System.in);
		double x = 0, y = 0;
		int dir = 90;
		while(true) {
			String str = sc.next();
			String[] strs = str.split(",");
			int step = Integer.parseInt(strs[0]);
			int theta = Integer.parseInt(strs[1]);
			if(step==0&&theta==0)break;

			x = x + step*Math.cos(dir*Math.PI/180);
			y = y + step*Math.sin(dir*Math.PI/180);
			
			dir -= theta;
		}
		System.out.println((int)x);
		System.out.println((int)y);
	}
	
	public static void main(String[] args) {
		(new Main()).run();
	}

}
