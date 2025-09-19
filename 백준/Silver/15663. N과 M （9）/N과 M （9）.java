import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

	static int N, M;
	static int[] input; 
	static int[] arr;

	static boolean[] visited;
	static StringBuilder sb = new StringBuilder();

	static Map<Integer, Boolean> map = new HashMap<>();
	static List<String> list = new ArrayList<>();

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
			map.put(input[i], false);
		}
		Arrays.sort(input);
		permu(0);

		for (String s : list) {
			sb.append(s);
		}
		System.out.println(sb);
		br.close();
	}

	static void permu(int idx) {
		if (idx == M) {
			StringBuilder tmp = new StringBuilder();
			for (int i = 0; i < M; i++) {
//				sb.append(arr[i] + " ");
				tmp.append(arr[i]).append(" ");
			}
			tmp.append("\n");
			if (!list.contains(tmp.toString())) {
				list.add(tmp.toString());
			}
			return;
		}

		for (int i = 0; i < N; i++) {
//			if(map.get(input[i])) continue;
			if(visited[i]) continue;
			visited[i] = true;
//			map.put(input[i], true);
			arr[idx] = input[i];
			permu(idx + 1);
			visited[i] = false;
//			map.put(input[i], false);
		}
	}
}