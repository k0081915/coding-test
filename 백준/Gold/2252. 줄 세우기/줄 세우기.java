import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

	static int N, M;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		List<List<Integer>> graph = new ArrayList<>();
		int[] indegree = new int[N + 1];

		for (int i = 0; i < N + 1; i++) {
			graph.add(new ArrayList<>());
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			graph.get(a).add(b);
			indegree[b]++;
		}

		sb = topologicalSort(indegree, graph);

		System.out.println(sb);

		br.close();
	}

	static StringBuilder topologicalSort(int[] indegree, List<List<Integer>> graph) {
		Queue<Integer> queue = new LinkedList<>();
		Queue<Integer> result = new LinkedList<>();

		for (int i = 1; i < N + 1; i++) {
			if (indegree[i] == 0) {
				queue.offer(i);
			}
		}

		while (!queue.isEmpty()) {
			int node = queue.poll();
			result.offer(node);

			for (Integer i : graph.get(node)) {
				indegree[i]--;

				if (indegree[i] == 0) {
					queue.offer(i);
				}
			}
		}

		StringBuilder sb = new StringBuilder();
		for (Integer i : result) {
			sb.append(i + " ");
		}

		return sb;
	}
}
