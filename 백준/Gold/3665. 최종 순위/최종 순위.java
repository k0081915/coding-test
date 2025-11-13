import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

	static int N;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
//		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		while (T-- > 0) {
			N = Integer.parseInt(br.readLine());

			List<List<Integer>> graph = new ArrayList<>(); // 인접 리스트
			int[] indegree = new int[N + 1]; // 진입 차수 배열
			int[] rank = new int[N + 1]; // 순위 배열

			// 리스트 초기화
			for (int i = 0; i < N + 1; i++) {
				graph.add(new ArrayList<>());
			}

			// 순위 입력
			st = new StringTokenizer(br.readLine());
			for (int i = 1; i < N + 1; i++) {
				rank[i] = Integer.parseInt(st.nextToken());
			}

			// 2중 for문을 돌면서 그래프를 이어줌
			// 예) 5가 1등이기 때문에 5->4, 5->3, 5->2, 5->1
			// 진입 차수도 같이 계산
			for (int i = 1; i < N; i++) {
				for (int j = i + 1; j < N + 1; j++) {
					graph.get(rank[i]).add(rank[j]);
					indegree[rank[j]]++;
				}
			}

			int M = Integer.parseInt(br.readLine());
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());

				// 간선 재배치
				// a, b가 들어왔다면 a, b의 등수를 바꿔야 함
				if (graph.get(a).contains(b)) { // a의 등수가 b보다 높았다면
					// a에 연결된 b를 지우고
					graph.get(a).remove((Integer) b);
					// b에 a를 연결
					graph.get(b).add(a);
					// a의 진입 차수 +1
					indegree[a]++;
					// b의 진입 차수 -1
					indegree[b]--;
				} else if (graph.get(b).contains(a)) { // b의 등수가 a보다 높았다면
					// b에 연결된 a를 지우고
					graph.get(b).remove((Integer) a);
					// a에 b를 연결
					graph.get(a).add(b); 
					// b의 진입 차수 +1
					indegree[b]++;
					// a의 진입 차수 -1
					indegree[a]--;
				}
			}

			// 위상 정렬 수행
			System.out.println(topologicalSort(indegree, graph));
		}


		br.close();
	}

	static String topologicalSort(int[] indegree, List<List<Integer>> graph) {
		Queue<Integer> queue = new LinkedList<>(); // indegree 값이 0이 된 노드 저장
		Queue<Integer> result = new LinkedList<>(); // 결과 출력
		StringBuilder sb = new StringBuilder();

		for (int i = 1; i < N + 1; i++) {
			// indegree가 0인 것을 큐에 추가
			if (indegree[i] == 0) {
				// 순위가 높은 것부터 큐에 넣음
				queue.offer(i);
			}
		}

		// 큐가 빌 때까지
		while (!queue.isEmpty()) {
			int node = queue.poll(); // 큐에서 하나 뽑음
			result.offer(node); // 결과 큐에 추가

			// 꺼낸 노드와 이어진 노드들 탐색
			for (Integer i : graph.get(node)) {
				indegree[i]--; // 연결된 노드의 indegree -1

				// indegree가 0이 되면
				if (indegree[i] == 0) {
					queue.offer(i); // 큐에 추가
				}
			}
		}

		// 정렬 결과에 N개의 노드가 모두 포함되지 않으면
		// 등수가 바뀐 결과 A->B인데 B->C이고 C->A와 같은 사이클이 발생한 경우
		if (result.size() != N) {
			// 불가능
			return "IMPOSSIBLE";
		} else {
			// 결과 출력
			for (Integer i : result) {
				sb.append(i + " ");
			}
			return sb.toString();
		}

	}
}
