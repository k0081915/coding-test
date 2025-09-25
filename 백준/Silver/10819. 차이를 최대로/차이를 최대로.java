import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

	static int N;
	static boolean[] visited; // 방문 배열
	static int[] arr; // 뽑아낸 수
	static int[] input;

	static int max = Integer.MIN_VALUE;


	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
//		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(br.readLine());
		// 초기화
		visited = new boolean[N];
		arr = new int[N];
		input = new int[N];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			input[i] = Integer.parseInt(st.nextToken());
		}

		permu(0);

		System.out.println(max);

		br.close();
	}

	static void permu(int idx) {
		if (idx == N) {
			int sum = 0;
			for (int i = 0; i < N - 1; i++) {
				sum += Math.abs(arr[i] - arr[i + 1]);
			}
			max = Math.max(max, sum);
			return;
		}

		for (int i = 0; i < N; i++) {
			if(visited[i]) continue;
			arr[idx] = input[i];
			visited[i] = true;
			permu(idx + 1);
			visited[i] = false;
		}
	}

}