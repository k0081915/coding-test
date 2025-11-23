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

	static int T;
	static int n, m, t;
	static int s, g, h;
	static List<List<Node>> graph; // 양방향 리스트
	static final int INF = Integer.MAX_VALUE;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		T = Integer.parseInt(br.readLine());
		while (T-- > 0) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken()); // 교차로 개수
			m = Integer.parseInt(st.nextToken()); // 도로 개수
			t = Integer.parseInt(st.nextToken()); // 목적지 후보 개수

			st = new StringTokenizer(br.readLine());
			s = Integer.parseInt(st.nextToken()); // 시작점
			g = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken()); // g, h 사이 도로 건넘

			// 그래프와 최소 거리 배열 초기화
			graph = new ArrayList<>();
			for (int i = 0; i <= n; i++) {
				graph.add(new ArrayList<>());
			}

			// 그래프 연결
			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				int d = Integer.parseInt(st.nextToken());

				graph.get(a).add(new Node(b, d));
				graph.get(b).add(new Node(a, d));
			}

			// 목적지 후보 입력
			List<Integer> list = new ArrayList<>();
			for (int i = 0; i < t; i++) {
				int x = Integer.parseInt(br.readLine());

				// s -> x 최단 경로가
				// s -> g -> h -> x 이거나 s -> h -> g -> x 둘 중 하나이면 후보 가능
				// dijk[s], dijk[g], dijk[h]를 구하자
				int[] distS = dijkstra(s);
				int[] distG = dijkstra(g);
				int[] distH = dijkstra(h);

				int sx = distS[x];
				int sghx = distS[g] + distG[h] + distH[x];
				int shgx = distS[h] + distH[g] + distG[x];

				// 후보 가능하면 리스트에 추가
				if (sx == sghx || sx == shgx) {
					list.add(x);
				}

			}
			
			// 오름차순 정렬
			list.sort(Integer::compareTo);
			// 결과 출력
			for (int num : list) {
				sb.append(num + " ");
			}
			sb.append("\n");

		}
		System.out.println(sb);


		br.close();
	}

	/**
	 * 다익스트라 수행
	 * @param start 
	 * @return 최소 거리 배열
	 */
	static int[] dijkstra(int start) {
		PriorityQueue<Node> queue = new PriorityQueue<>();
		boolean[] check = new boolean[n + 1];
		int[] dist = new int[n + 1];
		Arrays.fill(dist, INF);

		queue.add(new Node(start, 0));
		dist[start] = 0;

		while (!queue.isEmpty()) {
			Node curNode = queue.poll();
			int end = curNode.end;

			if(check[end]) continue;
			check[end] = true;

			for(Node node: graph.get(end)) {
				if (dist[node.end] > dist[end] + node.weight) {
					dist[node.end] = dist[end] + node.weight;
					queue.add(new Node(node.end, dist[node.end]));
				}
			}
		}
		return dist;
	}

}
