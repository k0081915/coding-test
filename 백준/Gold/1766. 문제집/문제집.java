import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

	static int N;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();

		ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
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

		topologySort(indegree, graph);

		br.close();
	}

	static void topologySort(int[] indegree, ArrayList<ArrayList<Integer>> grpah) {
		PriorityQueue<Integer> queue = new PriorityQueue<>();
		Queue<Integer> result = new LinkedList<>();

		for (int i = 1; i < N + 1; i++) {
			if (indegree[i] == 0) {
				queue.offer(i);
			}
		}

		while (!queue.isEmpty()) {
			int node = queue.poll();
			result.offer(node);

			for (Integer i : grpah.get(node)) {
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

		System.out.println(sb);
	}











//	static String topologicalSort(int[] indegree, List<List<Integer>> graph) {
//		Queue<Integer> queue = new LinkedList<>(); // indegree 값이 0이 된 노드 저장
//		Queue<Integer> result = new LinkedList<>(); // 결과 출력
//		StringBuilder sb = new StringBuilder();
//
//		for (int i = 1; i < N + 1; i++) {
//			// indegree가 0인 것을 큐에 추가
//			if (indegree[i] == 0) {
//				// 순위가 높은 것부터 큐에 넣음
//				queue.offer(i);
//			}
//		}
//
//		// 큐가 빌 때까지
//		while (!queue.isEmpty()) {
//			int node = queue.poll(); // 큐에서 하나 뽑음
//			result.offer(node); // 결과 큐에 추가
//
//			// 꺼낸 노드와 이어진 노드들 탐색
//			for (Integer i : graph.get(node)) {
//				indegree[i]--; // 연결된 노드의 indegree -1
//
//				// indegree가 0이 되면
//				if (indegree[i] == 0) {
//					queue.offer(i); // 큐에 추가
//				}
//			}
//		}
//
//		// 정렬 결과에 N개의 노드가 모두 포함되지 않으면
//		// 등수가 바뀐 결과 A->B인데 B->C이고 C->A와 같은 사이클이 발생한 경우
//		if (result.size() != N) {
//			// 불가능
//			return "IMPOSSIBLE";
//		} else {
//			// 결과 출력
//			for (Integer i : result) {
//				sb.append(i + " ");
//			}
//			return sb.toString();
//		}
//
//	}
}
