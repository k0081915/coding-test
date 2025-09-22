import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

	static boolean[] broken = new boolean[10];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		final int baseChannel = 100;

		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());

		if (M != 0) {
			st = new StringTokenizer(br.readLine());
			// 고장난 버튼은 true
			for (int i = 0; i < M; i++) {
				broken[Integer.parseInt(st.nextToken())] = true;
			}
		}


		// N까지 +, - 만 눌러서 갈 수 있는 경우를 기본으로 잡는다
		int answer = Math.abs(N - baseChannel);

		for (int i = 0; i <= 1000000; i++) {
			// 채널번호 i를 완전히 누를 수 있으면
			if (isPossible(i)) {
				// i를 누르는 횟수(i의 자릿수) + N까지 +,-로 가는 거리
				int cnt = String.valueOf(i).length() + Math.abs(N - i);
				answer = Math.min(answer, cnt); // 최솟값을 갱신
			}
		}


		System.out.println(answer);

		br.close();
	}

	static boolean isPossible(int channel) {
		// 채널 번호의 각 자릿수를 누를 수 있는지 확인
		String str = String.valueOf(channel);
		for (int i = 0; i < str.length(); i++) {
			// 고장난 버튼이 하나라도 있으면 false
			if (broken[Integer.parseInt(String.valueOf(str.charAt(i)))]) {
				return false;
			}
		}
		return true;
	}

}