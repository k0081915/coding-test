import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {


	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();


		int N = Integer.parseInt(br.readLine());
		int[] A = new int[N];
		int[] B = new int[N];
		int[] dp = new int[N];

		// A, B 전봇대에 전깃줄 입력
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());

			A[i] = start;
			B[i] = end;
		}

		// A 전봇대를 오름차순으로 정렬하면
		// B 전봇대도 오름차순으로 증가해야만 전깃줄이 겹치지 않는다
		for (int i = 0; i < N - 1; i++) {
			for (int j = i; j < N; j++) {
				if (A[i] > A[j]) {
					int tmp = A[i];
					A[i] = A[j];
					A[j] = tmp;
					int tmp2 = B[i];
					B[i] = B[j];
					B[j] = tmp2;
				}
			}
		}

		// B 전봇대에서 증가하는 부분 수열을 최대로 구하면
		// 그것이 전깃줄을 최대로 설치할 수 있는 개수이다
		int max = 0;
		for (int i = 0; i < N; i++) {
			dp[i] = 1;
			for (int j = 0; j < i; j++) {
				if (B[j] < B[i]) {
					dp[i] = Math.max(dp[i], dp[j] + 1);
					max = Math.max(max, dp[i]);
				}
			}
		}

		// 최소로 제거하는 전깃줄을 구해야 하기 때문에 N에서 빼준다
		System.out.println(N - max);

		br.close();
	}


}
