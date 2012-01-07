package p0001;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] list = new int[10];
		for(int i = 0; i < 10; i++) {
			list[i] = sc.nextInt();
		}
		Arrays.sort(list);
		System.out.println(list[9]);
		System.out.println(list[8]);
		System.out.println(list[7]);
	}

}
