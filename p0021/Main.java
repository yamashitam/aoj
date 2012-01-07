package p0021;

import java.util.Scanner;

public class Main {
	
	void run() {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		for(int i = 0; i < n; i++) {
			double ax = sc.nextDouble();
			double ay = sc.nextDouble();
			double bx = sc.nextDouble();
			double by = sc.nextDouble();
			double cx = sc.nextDouble();
			double cy = sc.nextDouble();
			double dx = sc.nextDouble();
			double dy = sc.nextDouble();
			
			Double d = new Double(0.1);
			if((by-ay)*(dx-cx)==(dy-cy)*(bx-ax)) {
				System.out.println("YES");
			}
			else {
				System.out.println("NO");
			}
		}
	}

	public static void main(String[] args) {
		(new Main()).run();
	}
}
