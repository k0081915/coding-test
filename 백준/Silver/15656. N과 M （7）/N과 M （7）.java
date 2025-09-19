import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

	static int N, M;
	static int[] input; 
	static int[] arr;

	static boolean[] visited;

	static Map<Integer, Boolean> numMap = new HashMap<>();

	static Map<Integer, Integer> map = new HashMap<>();

	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
//		StringBuilder sb = new StringBuilder();

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		input = new int[N];
		visited = new boolean[N];
		arr = new int[M];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			input[i] = Integer.parseInt(st.nextToken());
			map.put(input[i], map.getOrDefault(input[i], 0) + 1);
			numMap.put(input[i], false);
		}
		Arrays.sort(input);
		permu(0);

		System.out.println(sb);
		br.close();
	}

	static void permu(int idx) {
		if (idx == M) {
			for (int i = 0; i < M; i++) {
				sb.append(arr[i] + " ");
			}
			sb.append("\n");
			return;
		}

		for (int i = 0; i < N; i++) {
			arr[idx] = input[i];
			permu(idx + 1);
		}
	}
}