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
		int[] arr = new int[N];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int max = Integer.MIN_VALUE;
		int sum = 0;
		int cnt = 0;
		int idx = 0;
		for (int i = 0; i < N; i++) {
			sum += arr[i];
			cnt++;

			if (cnt == K) {
				max = Math.max(max, sum);
				sum -= arr[idx++];
				cnt--;
			}
		}

		System.out.println(max);
		br.close();
	}

}
