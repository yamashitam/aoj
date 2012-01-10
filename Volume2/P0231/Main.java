package p0231;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

//橋に関するイベントを表すクラス
class Event {
	//乗ったのか降りたのか
	public boolean isIn;
	//該当者の体重
	public int weight;
	//そのときの時間
	public int time;

	public Event(boolean isIn, int weight, int time) {
		this.isIn = isIn;
		this.weight = weight;
		this.time = time;
	}
}

//イベントを時間順でソートするためのComparator
class EventComp implements Comparator<Event> {
	@Override
	public int compare(Event e1, Event e2) {
		if(e1.time-e2.time == 0){
			//同時刻の場合は降りる方が先に評価される
			if(!e1.isIn) {
				return -1;
			}
			else {
				return 1;
			}
		}
		return e1.time - e2.time;
	}
}

public class Main {

	static Scanner sc;
	static int n;

	//橋が壊れないかどうかをシミュレートする
	private static boolean solve() {
		Event[] events = new Event[n*2];

		//読み込みに応じてイベントを生成
		for(int i = 0; i < n; i++) {
			int m = sc.nextInt();
			int a = sc.nextInt();
			int b = sc.nextInt();
			events[i] = new Event(true, m, a);
			events[n+i] = new Event(false, m, b);
		}

		Arrays.sort(events, new EventComp());

		int w = 0;
		//それぞれのイベントに対して体重を、乗った場合は加算、降りた場合は減算する
		for(Event e : events) {
			if(!e.isIn)
				w -= e.weight;
			else
				w += e.weight;

			//橋が壊れた
			if(w > 150)
				return false;
		}
		return true;
	}

	public static void main(String[] args) {
		sc = new Scanner(System.in);

		while(true) {
			n = sc.nextInt();
			if(n == 0)
				break;

			if(solve())
				System.out.println("OK");
			else
				System.out.println("NG");
		}
	}
}