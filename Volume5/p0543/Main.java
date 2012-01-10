package p0543;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true) {
			int x = sc.nextInt();
			if(x == 0) break;
			
			for(int i = 0; i < 9; i++) {
				x -= sc.nextInt();
			}
			System.out.println(x);
		}
	}
}