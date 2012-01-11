package p0535;

import java.util.Scanner;

public class Main {
	
	private static int[][] map;
	private static boolean[][] visited;
	private static int ans;
	private static int[][] move = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
	private static void search(int x, int y, int k) {
		if(visited[x][y] || (map[x][y] == 0)) {
			ans = Math.max(ans, k);
			return;
		}
//		System.out.println(x + " " + y);

		visited[x][y] = true;
		for(int i = 0; i < 4; i++) {
			if(x+move[i][0]<0 || x+move[i][0]>=map.length || 
					y+move[i][1]<0 || y+move[i][1]>=map[0].length)
				continue;
			search(x+move[i][0], y+move[i][1], k+1);
		}
		visited[x][y] = false;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			int m = sc.nextInt();
			int n = sc.nextInt();
			if(m==0&&n==0)break;
			
			map = new int[n][m];
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < m; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			ans = 0;
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < m; j++) {
					if(map[i][j]==1) {
						visited = new boolean[n][m];
						search(i, j, 0);
					}
				}
			}
			System.out.println(ans);
		}
	}
}