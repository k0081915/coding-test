import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

	static int N, K;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();


		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		int[] weight = new int[N + 1];
		int[] value = new int[N + 1];
		int[] dp = new int[K + 1];

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			weight[i] = Integer.parseInt(st.nextToken());
			value[i] = Integer.parseInt(st.nextToken());
		}


		for (int i = 1; i <= N; i++) {
			// K부터 탐색하여 담을 수 있는 무게 한계치가 넘지 않을 때까지 반복
			for (int j = K; j - weight[i] >= 0; j--) {
				dp[j] = Math.max(dp[j], dp[j - weight[i]] + value[i]);
			}
		}

		System.out.println(dp[K]);
		br.close();
	}

}
