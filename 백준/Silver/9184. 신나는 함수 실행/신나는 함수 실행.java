import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

	static int N, cnt;
	static int[][][] dp = new int[21][21][21];


	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i <= 20; i++) {
			for (int j = 0; j <= 20; j++) {
				dp[0][i][j] = 1;
				dp[i][0][j] = 1;
				dp[i][j][0] = 1;
			}
		}
		for (int i = 1; i <= 20; i++) {
			for (int j = 1; j <= 20; j++) {
				for (int k = 1; k <= 20; k++) {
					if (i < j && j < k) {
						dp[i][j][k] = dp[i][j][k - 1] + dp[i][j - 1][k - 1] - dp[i][j - 1][k];
					} else {
						dp[i][j][k] = dp[i - 1][j][k] + dp[i - 1][j - 1][k] + dp[i - 1][j][k - 1] - dp[i - 1][j - 1][k - 1];
					}
				}
			}
		}
		while (true) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());

			if(a == -1 && b == -1 && c == -1) break;
			sb.append("w(" + a + ", " + b + ", " + c + ")" + " = ");

			if (a <= 0 || b <= 0 || c <= 0) {
				a = 0;
				b = 0;
				c = 0;
			} else if (a > 20 || b > 20 || c > 20) {
				a = 20;
				b = 20;
				c = 20;
			}

			sb.append(dp[a][b][c] + "\n");
		}
		System.out.println(sb);

		br.close();
	}

	static void solve(int a, int b, int c) {
		if (a <= 0 || b <= 0 || c <= 0) {

		}
	}

}