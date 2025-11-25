import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {


	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());
		int[][] arr = new int[N + 1][N + 1];
		int[][][] dp = new int[N + 1][N + 1][3];

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// dp[r][c][0]: 가로, [1]: 세로, [2]: 대각선
		dp[1][2][0] = 1;

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				// 현재 칸이 벽이면 continue
				if(arr[i][j] == 1) continue;
				
				// 가로로 오는 경우 (이전: 가로, 대각선)
				dp[i][j][0] += dp[i][j - 1][0] + dp[i][j - 1][2];

				// 세로로 오는 경우 (이전: 세로, 대각선)
				// 1행에서는 세로 이동 불가능하므로 2행부터 체크
				if (i > 1) {
					dp[i][j][1] += dp[i - 1][j][1] + dp[i - 1][j][2];
				}

				// 대각선으로 오는 경우 (이전: 가로, 세로, 대각선)
				// 1행과 1열에서는 불가능하고, 대각선은 주변 3칸이 다 비어있어야 함
				if (i > 1 && j > 1 && arr[i - 1][j] == 0 && arr[i][j - 1] == 0) {
					dp[i][j][2] += dp[i - 1][j - 1][0] + dp[i - 1][j - 1][1] + dp[i - 1][j - 1][2];
				}
			}
		}

		// (N, N)에서 모든 경우의 수를 더함
		System.out.println(dp[N][N][0] + dp[N][N][1] + dp[N][N][2]);
		br.close();
	}
}
