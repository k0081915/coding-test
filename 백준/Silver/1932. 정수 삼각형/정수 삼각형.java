import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.*;

public class Main {

	static int N;

	static int[][] tri;
	static int[][] dp;


	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();


		N = Integer.parseInt(br.readLine());
		tri = new int[N][N];
		dp = new int[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j <= i; j++) {
				tri[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// dp 배열에 초기값 설정
		dp[0][0] = tri[0][0];
		int max = dp[0][0];
		
		// 위에서 아래로 내려오면서 각 위치까지의 합의 최댓값 계산
		for (int i = 1; i < N; i++) {
			for (int j = 0; j <= i; j++) {
				if (j == 0) { // 왼쪽 끝
					dp[i][j] = dp[i - 1][j] + tri[i][j];
				} else if (j == i) { // 오른쪽 끝
					dp[i][j] = dp[i - 1][j - 1] + tri[i][j];
				} else { // 중간 (두 경로 중 더 큰 값을 선택)
					dp[i][j] = Math.max(dp[i - 1][j - 1], dp[i - 1][j]) + tri[i][j];
				}
				// 최댓값 갱신
				max = Math.max(max, dp[i][j]);
			}
		}

		System.out.println(max);

		br.close();
	}


}
