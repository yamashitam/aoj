package p0538;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true) {
			int n = sc.nextInt();
			if(n==0)break;
			
			int m = sc.nextInt();
			String str = sc.next();

			int ans = 0;
			int io = 0;
			int count = 0;
			for(int i = 0; i < m; i++) {
				if(io == 0 && str.charAt(i) == 'I'){
//					System.out.println("find I: " + i );
					count++;
					if(count == n*2+1){
						ans += 1;
						int _io = 1;
						int j = 1;
						for(; i + j < m; j++) {
							if(_io == 0 && str.charAt(i+j) == 'I')
								_io = 1;
							else if(_io == 1 && str.charAt(i+j) == 'O')
								_io = 0;
							else
								break;
						}
						if(_io == 1)
							ans += j/2;
						else
							ans += (j-1)/2;

						i += (j-1);
						count = 0;
						io = 0;
					}
					else {
						io = 1;
					}
				}
				else if(io == 1 && str.charAt(i) == 'O'){
//					System.out.println("find O: " + i );
					count++;
					io = 0;
				}
				else if(str.charAt(i) == 'I') {
					count = 1;
					io = 1;
				}
				else {
//					System.out.println("not found: " + i);
					count = 0;
					io = 0;
				}
			}
			System.out.println(ans);
		}
	}
}