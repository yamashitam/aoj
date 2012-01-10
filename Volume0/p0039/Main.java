package p0039;

import java.util.Scanner;

public class Main {

	void run() {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()) {
			String str = sc.next();
			
			int[] nums = new int[str.length()];
			for(int i = 0; i < nums.length; i++) {
				if(str.charAt(i)=='I')
					nums[i] = 1;
				else if(str.charAt(i)=='V')
					nums[i] = 5;
				else if(str.charAt(i)=='X')
					nums[i] = 10;
				else if(str.charAt(i)=='L')
					nums[i] = 50;
				else if(str.charAt(i)=='C')
					nums[i] = 100;
				else if(str.charAt(i)=='D')
					nums[i] = 500;
				else
					nums[i] = 1000;
			}
			
			int answer = nums[0];
			for(int i = 1; i < nums.length; i++) {
				if(nums[i-1]<nums[i]){
					answer -= nums[i-1];
					answer += (nums[i]-nums[i-1]);
				}
				else {
					answer += (nums[i]);
				}
			}
			System.out.println(answer);
		}
		
	}
	
	public static void main(String[] args) {
		(new Main()).run();
	}

}
