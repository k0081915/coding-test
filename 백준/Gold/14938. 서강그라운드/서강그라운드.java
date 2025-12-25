import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

	static class Node implements Comparable<Node> {
		int end;
		int weight;

		Node(int end, int weight) {
			this.end = end;
			this.weight = weight;
		}

		@Override
		public int compareTo(Node node) {
			// 거리 짧은 순 정렬
			return Integer.compare(this.weight, node.weight);
		}
	}

	static int n, m, r;
	static int[] item;
	static ArrayList<ArrayList<Node>> graph;
	static int INF = 987654321;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();

		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken()); // 지역
		m = Integer.parseInt(st.nextToken()); // 수색범위
		r = Integer.parseInt(st.nextToken()); // 길

		item = new int[n + 1];
		graph = new ArrayList<>();

		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= n; i++) {
			item[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i <= n; i++) {
			graph.add(new ArrayList<>());
		}

		for (int i = 0; i < r; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int l = Integer.parseInt(st.nextToken());

			graph.get(a).add(new Node(b, l));
			graph.get(b).add(new Node(a, l));
		}

		int max = 0;
		for (int i = 1; i <= n; i++) {
			// 지역 1번부터 하나씩 다익스트라 실행해서 최댓값 갱신
			max = Math.max(max, dijkstra(i));
		}

		System.out.println(max);

		br.close();
	}

	static int dijkstra(int start) {
		PriorityQueue<Node> queue = new PriorityQueue<>();
		int[] dist = new int[n + 1]; // 시작점에서 각 노드까지 거리 배열
		Arrays.fill(dist, INF); // INF 값으로 초기화

		queue.add(new Node(start, 0));
		dist[start] = 0;

		while (!queue.isEmpty()) {
			Node curNode = queue.poll();
			int curNum = curNode.end;
			int curWeight = curNode.weight;

			// 이미 처리된 경로보다 더 긴 경로라면 스킵
			if(dist[curNum] < curWeight) continue;

			// 연결된 모든 노드 탐색
			for (Node node : graph.get(curNum)) {
				// 현재 길이 + 연결된 노드까지 길이가 원래 경로보다 작으면
				if (dist[node.end] > dist[curNum] + node.weight) {
					// 거리 갱신
					dist[node.end] = dist[curNum] + node.weight;
					// 큐에 노드 추가
					queue.add(new Node(node.end, node.weight + curWeight));

				}
			}
		}

		// 수색 범위 내에 있는 아이템 합산
		int total = 0;
		for (int i = 1; i <= n; i++) {
			if (dist[i] <= m) {
				total += item[i];
			}
		}

		return total;
	}

}