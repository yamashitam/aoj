package p0527_0067;

import java.util.Scanner;

public class Main {

	static boolean[][] map, check;
	static int count;
	
	//陸続きで探索できる範囲に訪問済みのチェックをいれる
	private static void search(int i, int j) {
		if(check[i][j])
			return;
		
		check[i][j] = true;
		
		if(map[i-1][j]) {
			search(i-1, j);
		}
		if(map[i+1][j]) {
			search(i+1, j);
		}
		if(map[i][j-1]) {
			search(i, j-1);
		}
		if(map[i][j+1]) {
			search(i, j+1);
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		while(sc.hasNext()) {
			map = new boolean[14][14];
			check = new boolean[14][14];
			count = 0;
			//陸地をtrue, 海をfalseとしてmapを構成
			for(int i = 1; i <= 12; i++) {
				String str = sc.next();
				for(int j = 1; j <= 12; j++) {
					if(str.charAt(j-1) == '1') {
						map[i][j] = true;
					}
					else {
						map[i][j] = false;
					}
				}
			}
			
			//陸地のマスかつ未訪問のマスであればcountをインクリメントしてsearch開始
			for(int i = 1; i <= 12; i++) {
				for(int j = 1; j <= 12; j++) {					
					if(map[i][j] && !check[i][j]) {
						count++;
						search(i, j);
					}
				}
			}			
			System.out.println(count);
		}
	}
}