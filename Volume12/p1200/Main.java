package p1200;

import java.util.Scanner;

public class Main {

	void run() {
		
		boolean[] nums = new boolean[32768];
		nums[0] = nums[1] = true;
		for(int i = 2; i < nums.length; i++) {
			if(!nums[i]) {
				int j = 2;
				while(i*j < nums.length) {
					nums[i*j] = true;
					j++;
				}
			}
		}
		
		Scanner sc = new Scanner(System.in);
		while(true) {
			int n = sc.nextInt();
			if(n == 0) break;
			
			int count = 0;
			for(int i = 2; i < n; i++) {
				if(!nums[i] && !nums[n-i]) count++;
			}
			if(n%2==0 && !nums[n/2])System.out.println(count/2+1);
			else System.out.println(count/2);
		}
	}
	
	public static void main(String[] args) {
		(new Main()).run();
	}
}
