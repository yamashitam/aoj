package p0502;

import java.util.Scanner;

public class Main {
	
	class Dice {
		int top, bottom, left, right, forward, back;
		
		public Dice() {
			top = 1;
			forward = 2;
			right = 3;
			left = 4;
			back = 5;
			bottom = 6;
		}

		void north() {
			int w = top;
			top = forward;
			forward = bottom;
			bottom = back;
			back = w;
		}
		
		void east() {
			int w = top;
			top = left;
			left = bottom;
			bottom = right;
			right = w;
		}
		
		void west() {
			int w = top;
			top = right;
			right = bottom;
			bottom = left;
			left = w;
		}
		
		void south() {
			int w = top;
			top = back;
			back = bottom;
			bottom = forward;
			forward = w;
		}
		
		void right() {
			int w = right;
			right = back;
			back = left;
			left = forward;
			forward = w;
		}
		
		void left() {
			int w = left;
			left = back;
			back = right;
			right = forward;
			forward = w;
		}
	}
	
	void run() {
		Scanner sc = new Scanner(System.in);
		while(true){
			int n = sc.nextInt();
			if(n==0)break;
			Dice dice = new Dice();
			int sum = 1;
			for(int i = 0; i < n; i++) {
				String str = sc.next();
				if(str.equals("North"))dice.north();
				else if(str.equals("East"))dice.east();
				else if(str.equals("West"))dice.west();
				else if(str.equals("South"))dice.south();
				else if(str.equals("Right"))dice.right();
				else dice.left();
				sum += dice.top;
			}
			System.out.println(sum);
		}
	}
	
	public static void main(String[] args) {
		(new Main()).run();
	}

}
