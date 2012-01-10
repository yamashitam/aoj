package p0558;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	
	class Point {
		int x, y;
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	void run() {
		Scanner sc = new Scanner(System.in);
		int h = sc.nextInt();
		int w = sc.nextInt();
		int n = sc.nextInt();
		char[][] map = new char[h][w];
		Point start = new Point(-1, -1);
		for(int i = 0; i < h; i++) {
			String str = sc.next();
			for(int j = 0; j < w; j++) {
				map[i][j] = str.charAt(j);
				if(map[i][j]=='S') start = new Point(i, j);
			}
		}

		//		System.out.println("input done");
		

		int[][] move = {{0,1},{0,-1},{1,0},{-1,0}};
		int answer = 0;
		for(int i = 0; i < n; i++) {
//			System.out.println("search:" + i);
			List<Point> q = new ArrayList<Point>();
			q.add(start);
			int[][] steps = new int[h][w];
			for(int j = 0; j < h; j++) {
				for(int k = 0; k < w; k++) {
					steps[j][k] = Integer.MAX_VALUE;
				}
			}
			steps[start.x][start.y] = 0;

			while(!q.isEmpty()) {
				List<Point> next = new ArrayList<Point>();
				for(Point p : q) {
//					System.out.println("get p(" + p.x + ", " + p.y + ")");
					boolean flag = false;
					for(int j = 0; j < move.length; j++) {
						int x = p.x+move[j][0];
						int y = p.y+move[j][1];
//						System.out.println("move to" + x + ", " + y);
						if(0 <= x && x < h && 0 <= y && y < w) {
							if(map[x][y]=='X')continue;
							
							if(map[x][y]==((i+1)+'0')) {
//								System.out.println("find at (" + x + ", " + y + ")");
								//H‚×‚½
								start = new Point(x, y);
								next.clear();
								answer += (steps[p.x][p.y]+1);
								flag = true;
								break;
							}
							else {
								//‚·‚·‚Þ
//								System.out.println("steps"+x + ", " + y + ":" + steps[x][y]);
								if(steps[x][y]>steps[p.x][p.y]+1) {
//									System.out.println("next add:" + x + ", " + y);
									steps[x][y] = steps[p.x][p.y]+1;
									next.add(new Point(x,y));
								}
							}
						}
					}
//					for(Point r : next)System.out.println(r.x + ", " + r.y);

					if(flag) break;
				}
				q = next;
			}
		}
		System.out.println(answer);
	}
	
	public static void main(String[] args) {
		(new Main()).run();
	}
}