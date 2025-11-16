import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Node implements Comparable<Node> {

	int end;
	int weight;

	public Node(int end, int weight) {
		this.end = end;
		this.weight = weight;
	}

	// 우선순위 큐에서 꺼낼 때 가중치가 작은 것부터 나오도록 설정
	@Override
	public int compareTo(Node o) {
		return Integer.compare(weight, o.weight);
	}
}

public class Main {

	static int V, E, K;
	static List<List<Node>> graph = new ArrayList<>(); // 단방향 리스트
	static int[] dist; // 최소 거리 저장
	static final int INF = Integer.MAX_VALUE;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();


		st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(br.readLine()); // 시작 정점

		dist = new int[V + 1];
		Arrays.fill(dist, INF); // 거리를 INF로 초기화

		for (int i = 0; i <= V; i++) {
			graph.add(new ArrayList<>());
		}

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());

			// u에서 시작해서 v로 끝나는 가중치 w 노드 추가
			graph.get(u).add(new Node(v, w));
		}

		// 다익스트라 수행
		dijkstra(K);

		for (int i = 1; i <= V; i++) {
			if(dist[i] == INF) sb.append("INF" + "\n");
			else sb.append(dist[i] + "\n");
		}
		System.out.println(sb);

		br.close();
	}

	static void dijkstra(int start) {
		PriorityQueue<Node> queue = new PriorityQueue<>();
		boolean[] check = new boolean[V + 1]; // 방문 확인

		// 큐애 시작 정점과 가중치 0 노드 추가
		queue.offer(new Node(start, 0));
		// 자신의 거리는 0으로 초기화
		dist[start] = 0;

		// 큐가 빌 때까지
		while (!queue.isEmpty()) {
			// 큐에서 하나씩 빼면서 확인
			Node curNode = queue.poll();
			int cur = curNode.end;

			// 해당 정점을 방문했으면 continue
			if (check[cur]) continue;

			// 방문 처리
			check[cur] = true;

			// 해당 정점과 이어진 모든 노드 확인
			for (Node node : graph.get(cur)) {
				// 이어진 노드까지의 기존 거리가 현재 노드까지 거리 + 이어진 노드까지 가중치 보다 크면
				if (dist[node.end] > dist[cur] + node.weight) {
					dist[node.end] = dist[cur] + node.weight; // 거리 갱신
					queue.offer(new Node(node.end, dist[node.end])); // 큐에 이어진 노드와 새로운 거리 추가
				}
			}
		}
	}

}
