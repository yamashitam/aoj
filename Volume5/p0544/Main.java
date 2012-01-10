package p0544;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			if(n == 0 && m == 0) break;
			
			int[] map = new int[n];
			for(int i = 0; i < n; i++) {
				map[i] = sc.nextInt();
			}
			int[] sai = new int[m];
			for(int i = 0; i < m; i++) {
				sai[i] = sc.nextInt();
			}

			int place = 0;
			for(int i = 0; i < m; i++) {
				place += sai[i];
				
				if(place >= n-1) {
					System.out.println(i+1);
					break;
				}

				if(map[place] != 0) {
					place += map[place];
					if(place >= n-1) {
						System.out.println(i+1);
						break;
					}
				}

			}
		}
	}
}
