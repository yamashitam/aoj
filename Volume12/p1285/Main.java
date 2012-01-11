package p1285;

import java.util.Scanner;

public class Main {

	void run() {
		Scanner sc = new Scanner(System.in);
		while(true) {
			int n = sc.nextInt();
			int w = sc.nextInt();
			
			if(n==0&&w==0) break;
			
			int[] param = new int[n];
			int max = -1;
			for(int i = 0; i < n; i++) {
				param[i] = sc.nextInt();
				max = Math.max(max, param[i]);
			}
			int histnum = max/w+1;
			int[] hist = new int[histnum];
			int _max = 0;
			for(int i = 0; i < n; i++) {
				hist[param[i]/w]++;
				_max = Math.max(_max, hist[param[i]/w]);
			}
			double ink = 0;
			for(int i = 0; i < histnum; i++) {
				ink += ((double)hist[i]/(double)_max)*((double)(histnum-1-i)/(double)(histnum-1));
			}
			ink += 0.01;
			System.out.println(ink);
		}
	}
	
	public static void main(String[] args) {
		(new Main()).run();
	}
}
