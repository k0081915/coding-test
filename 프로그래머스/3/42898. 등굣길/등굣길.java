import java.util.*;

class Solution {

	public static void main(String[] args) {


		int m = 4;
		int n = 3;
		int[][] puddles = {{1,2},{2, 1}};
		System.out.println(solution(m, n, puddles));

	}

	public static int solution(int m, int n, int[][] puddles) {
		int answer = 0;
		final int MOD = 1000000007;
		int[][] arr = new int[n + 1][m + 1];
		long[][] dp = new long[n + 1][m + 1];
		dp[0][0] = dp[1][0] = dp[0][1] = 0;
		dp[1][1] = 0;
		if (m == 1) {
			dp[2][1] = 1;
		} else if (n == 1) {
			dp[1][2] = 1;
		} else {
			dp[1][2] = dp[2][1] = 1;
		}

		for(int[] puddle : puddles) {
			arr[puddle[1]][puddle[0]] = 1;
			dp[puddle[1]][puddle[0]] = 0;
		}

		arr[1][1] = 1;
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				if(arr[i][j] == 1 || dp[i][j] != 0) continue;
				dp[i][j] = (dp[i - 1][j] + dp[i][j - 1]) % MOD;
			}
		}

		return (int) dp[n][m] % MOD;
	}

}
