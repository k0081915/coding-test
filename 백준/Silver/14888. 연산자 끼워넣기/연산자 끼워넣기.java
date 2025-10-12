import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

	static int N;
	static int[] number;
	static int[] op = new int[4];

	static int min = Integer.MAX_VALUE;
	static int max = Integer.MIN_VALUE;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
//		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(br.readLine());
		number = new int[N];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			number[i] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 4; i++) {
			op[i] = Integer.parseInt(st.nextToken());
		}

		// 시작 숫자를 숫자 배열의 첫번째 숫자로
		solve(number[0], 1);

		System.out.println(max + "\n" + min);
		br.close();
	}


	static void solve(int num, int idx) {
		if (idx == N) { // 모든 숫자를 다 사용했을 경우
			// 최솟값, 최댓값 갱신
			min = Math.min(min, num);
			max = Math.max(max, num);
			return;
		}

		// 4가지 연산자에 대해 각각 시도
		for (int i = 0; i < 4; i++) {
			// 해당 연산자가 남아 있으면
			if (op[i] > 0) {
				// 연산자 개수 감소
				op[i]--;

				// 연산자에 따라 계산하고 재귀 호출
				if (i == 0) { // +
					solve(num + number[idx], idx + 1);
				} else if (i == 1) { // -
					solve(num - number[idx], idx + 1);
				} else if (i == 2) { // *
					solve(num * number[idx], idx + 1);
				} else { // /
					solve(num / number[idx], idx + 1);
				}

				// 다음 경로 탐색을 위해 연산자 개수 복구
				op[i]++;
			}
		}
	}


}
