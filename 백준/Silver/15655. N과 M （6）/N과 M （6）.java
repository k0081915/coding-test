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
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

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
		permu(0, 0);

		br.close();
	}

	static void permu(int idx, int start) {
		if (idx == M) {
			for (int i = 0; i < M; i++) {
				System.out.print(arr[i] + " ");
			}
			System.out.println();
			return;
		}

		for (int i = start; i < N; i++) {
			if(numMap.get(input[i])) continue;
			arr[idx] = input[i];
			numMap.put(input[i], true);
			permu(idx + 1, i);
			numMap.put(input[i], false);
		}
	}
}