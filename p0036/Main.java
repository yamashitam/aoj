package p0036;

import java.util.Scanner;

public class Main {

	void run() {
		Scanner sc = new Scanner(System.in);
		
		int[][][] pattern = {
				{
					{0,1,1,0,0},
					{0,1,1,0,0},
					{0,0,0,0,0},
					{0,0,0,0,0}
				},
				{
					{0,1,0,0,0},
					{0,1,0,0,0},
					{0,1,0,0,0},
					{0,1,0,0,0}
				},
				{
					{0,1,1,1,1},
					{0,0,0,0,0},
					{0,0,0,0,0},
					{0,0,0,0,0}
				},
				{
					{0,1,0,0,0},
					{1,1,0,0,0},
					{1,0,0,0,0},
					{0,0,0,0,0}
				},
				{
					{0,1,1,0,0},
					{0,0,1,1,0},
					{0,0,0,0,0},
					{0,0,0,0,0}
				},
				{
					{0,1,0,0,0},
					{0,1,1,0,0},
					{0,0,1,0,0},
					{0,0,0,0,0}
				},
				{
					{0,1,1,0,0},
					{1,1,0,0,0},
					{0,0,0,0,0},
					{0,0,0,0,0}
				}
		};
		
		while(sc.hasNext()) {
			int[][] map = new int[14][12];
			for(int j = 0; j < 8; j++) {
				String str = sc.next();
				for(int i = 1; i < 9; i++) {
					if(str.charAt(i-1)=='1')map[i][j] = 1;
				}
			}
			
//			System.out.println("input done");
			for(int i = 1; i < 9; i++) {
				for(int j = 0; j < 8; j++) {
					if(map[i][j]==1) {
//						System.out.println("map(" + i + "," + j + ")");
						for(int k = 0; k < 7; k++) {
							boolean flag = false;
//							System.out.println("pattern " + k);
							for(int l = 0; l < 5; l++) {
								for(int m = 0; m < 4; m++) {
									if(map[(i-1)+(l)][(j)+(m)]!=pattern[k][m][l]) {
										flag = true;
//										System.out.println((i-1) + ", " + (j+m));
										break;
									}
								}
								if(flag)break;
							}
//							System.out.println("flag: " + flag);
							if(!flag){
								System.out.printf("%c\n",'A'+k);
								break;
							}
						}
						break;
					}
				}
			}
		}
	}
	
	public static void main(String[] args) {
		(new Main()).run();
	}

}
