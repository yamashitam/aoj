package p0500;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			int n = sc.nextInt();
			if(n==0)break;
			
			int a, b;
			a = b = 0;
			for(int i = 0; i < n; i++) {
				int x = sc.nextInt();
				int y = sc.nextInt();
				if(x > y) {
					a += (x+y);
				}
				else if(x < y) {
					b += (x+y);
				}
				else {
					a += x;
					b += y;
				}
			}
			System.out.println(a + " " + b);
		}
	}
}