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

	@Override
	public int compareTo(Node o) {
		return Integer.compare(weight, o.weight);
	}
}

public class Main {

	static int N, E;
	static int v1, v2;
	static ArrayList<ArrayList<Node>> graph = new ArrayList<>();
	static int[] dist1, distV1, distV2;
	static final int INF = 200_000_000;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();


		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		dist1 = new int[N + 1];
		distV1 = new int[N + 1];
		distV2 = new int[N + 1];

		for (int i = 0; i <= N; i++) {
			graph.add(new ArrayList<>());
		}

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());

			graph.get(a).add(new Node(b, c));
			graph.get(b).add(new Node(a, c));
		}

		st = new StringTokenizer(br.readLine());
		v1 = Integer.parseInt(st.nextToken());
		v2 = Integer.parseInt(st.nextToken());

		dist1 = dijkstra(1);
		distV1 = dijkstra(v1);
		distV2 = dijkstra(v2);

		int answer1 = dist1[v1] + distV1[v2] + distV2[N];
		int answer2 = dist1[v2] + distV2[v1] + distV1[N];

		if (Math.min(answer1, answer2) >= INF) {
			System.out.println(-1);
		} else {
			System.out.println(Math.min(answer1, answer2));
		}

		br.close();
	}

	static int[] dijkstra(int start) {
		PriorityQueue<Node> queue = new PriorityQueue<>();
		int[] dist = new int[N + 1];
		Arrays.fill(dist, INF);

		queue.offer(new Node(start, 0));
		dist[start] = 0;

		while (!queue.isEmpty()) {
			Node curNode = queue.poll();
			int cur = curNode.end;

			for (Node node : graph.get(cur)) {
				if (dist[node.end] > dist[cur] + node.weight) {
					dist[node.end] = dist[cur] + node.weight;
					queue.offer(new Node(node.end, dist[node.end]));
				}
			}
		}

		return dist;
	}
}
