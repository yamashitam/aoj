package p0002;

import java.util.Scanner;

public class Main {

	void run() {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()) {
			String str = sc.nextLine();
			String[] _str = str.split(" ");
			int a = Integer.parseInt(_str[0]);
			int b = Integer.parseInt(_str[1]);
			int c = a+b;
			int count = 0;
			while(c!=0) {
				c /= 10;
				count++;
			}
			System.out.println(count);
		}
	}
	
	public static void main(String[] args) {
		(new Main()).run();
	}

}
