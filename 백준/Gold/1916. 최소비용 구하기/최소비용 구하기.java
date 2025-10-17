import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
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
		return this.weight - o.weight;
	}
}

public class Main {

	static int N, M;
	static ArrayList<Node>[] graph;
	static int[] dist;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		dist = new int[N + 1];
		graph = new ArrayList[N + 1];

		Arrays.fill(dist, Integer.MAX_VALUE);
		for (int i = 1; i <= N; i++) {
			graph[i] = new ArrayList<>();
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			graph[start].add(new Node(end, weight));
		}

		st = new StringTokenizer(br.readLine());
		int startCity = Integer.parseInt(st.nextToken());
		int endCity = Integer.parseInt(st.nextToken());

		dijkstra(startCity);

		System.out.println(dist[endCity]);

		br.close();
	}

	static void dijkstra(int start) {
		PriorityQueue<Node> queue = new PriorityQueue<>();

		dist[start] = 0;
		queue.add(new Node(start, 0));

		while (!queue.isEmpty()) {
			Node cur = queue.poll();
			int curCity = cur.end;
			int curWeight = cur.weight;

			if (curWeight > dist[curCity]) {
				continue;
			}

			for (Node node : graph[curCity]) {
				int newWeight = curWeight + node.weight;
				if (newWeight < dist[node.end]) {
					dist[node.end] = newWeight;
					queue.add(new Node(node.end, dist[node.end]));
				}
			}
		}
	}

}
