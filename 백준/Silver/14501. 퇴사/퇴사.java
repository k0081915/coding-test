import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

	static int N;
	static int[] day; // 상담 기간
	static int[] wage; // 금액

	static int max;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(br.readLine());
		day = new int[N + 1];
		wage = new int[N + 1];

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			day[i] = x;
			wage[i] = y;
		}

		recur(1, 0); // 1일, 0원 부터 재귀 시작

		System.out.println(max);

		br.close();
	}

	static void recur(int today, int money) {
		// 상담 기간이 N이 넘으면
		if (today > N) {
			// 현재까지 최대 금액을 갱신
			max = Math.max(max, money);
			return;
		}

		// 오늘부터 상담기간이 지난 후가 N 이하라면 상담을 할 수 있다는 뜻
		if (today + day[today] - 1 <= N) {
			// 상담기간 다음 일, 쌓인 금액에 상담한 날짜의 금액을 더하여 재귀 호출
			recur(today + day[today], money + wage[today]);
		}

		// 상담을 못한다면 다음 날을 호출
		recur(today + 1, money);
	}

}