package p0026;

import java.util.Scanner;

public class Main {

	void run() {
		Scanner sc = new Scanner(System.in);
		int[][] paper = new int[14][14];
		while(sc.hasNext()) {
			String str = sc.next();
			String[] strs = str.split(",");
			int x = Integer.parseInt(strs[0]);
			int y = Integer.parseInt(strs[1]);
			int size = Integer.parseInt(strs[2]);
			
			
			x+=2;
			y+=2;
			
			//¬
			if(size==1) {
				paper[x][y]++;
				paper[x-1][y]++;
				paper[x+1][y]++;
				paper[x][y-1]++;
				paper[x][y+1]++;				
			}
			//’†
			else if(size==2) {
				for(int i = -1; i <= 1; i++)paper[x+i][y-1]++;
				for(int i = -1; i <= 1; i++)paper[x+i][y]++;
				for(int i = -1; i <= 1; i++)paper[x+i][y+1]++;
			}
			//‘å
			else {
				paper[x][y-2]++;
				for(int i = -1; i <= 1; i++)paper[x+i][y-1]++;
				for(int i = -2; i <= 2; i++)paper[x+i][y]++;
				for(int i = -1; i <= 1; i++)paper[x+i][y+1]++;				
				paper[x][y+2]++;
			}
		}
		int max = 0;
		int count = 0;
		for(int i = 2; i < 12; i++) {
			for(int j = 2; j < 12; j++) {
				if(paper[i][j]==0)count++;
				else if(paper[i][j]>max) max = paper[i][j];
			}
		}
		System.out.println(count);
		System.out.println(max);
	}
	
	public static void main(String[] args) {
		(new Main()).run();
	}

}
