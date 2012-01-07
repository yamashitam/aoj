package p0527_0103;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.next());

		for(int i = 0; i < n; i++) {

			int score = 0;
			int out = 0;
			//それぞれの塁に走者がいるかどうか
			boolean first = false;
			boolean second = false;
			boolean third = false;
						
			while(true) {
				String str = sc.next();

				//HITなら一人ずつ走者を進め、ホームに返ってきたら点を追加
				if(str.equals("HIT")) {
					if(first) {
						if(second) {
							if(third) {
								score++;
								third = false;
							}
							second = false;
							third = true;
						}
						first = false;
						second = true;
					}
					first = true;
				}

				//HOMERUNなら塁にいる走者の分だけ点を追加
				else if(str.equals("HOMERUN")) {
					score++;
					if(first) {
						first = false;
						score++;
					}
					if(second) {
						second = false;
						score++;
					}
					if(third) {
						third = false;
						score++;
					}
				}

				//OUTならアウトのカウントをインクリメント
				else {
					out++;
				}

				if(out == 3) {
					System.out.println(score);
					break;
				}
			}
		}
	}
}