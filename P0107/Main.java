package p0527_0107;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		while(true) {
			int x, y, z;
			x = sc.nextInt();
			y = sc.nextInt();
			z = sc.nextInt();
			if(x == 0 && y == 0 && z == 0) {
				break;
			}
			
			//直方体のチーズの最も長い辺を取り除く
			int a, b;
			if(x > y && x > z) {
				a = y;
				b = z;
			}
			else if(y > z && y > x) {
				a = x;
				b = z;
			}
			else {
				a = x;
				b = y;
			}
			//基準面に外接する円の半径の二乗
			int t = (a*a + b*b);

			int n = sc.nextInt();
			for(int i = 0; i < n; i++) {
				int h = sc.nextInt();
				//半径hの円から通すことができるかどうか
				if((h*h)*4 <= t) {
					System.out.println("NA");
				}
				else {
					System.out.println("OK");
				}
			}
		}
	}
}