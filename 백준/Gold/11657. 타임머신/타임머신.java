import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Edge {
	int start, end, weight;

	Edge(int start, int end, int weight) {
		this.start = start;
		this.end = end;
		this.weight = weight;
	}
}

public class Main {

	static int N, M;

	static long[] dist;
	static final int INF = 987654321;
	static Edge[] edges;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 도시
		M = Integer.parseInt(st.nextToken()); // 노선

		edges = new Edge[M + 1]; // 간선 리스트
		dist = new long[N + 1]; // 최단 거리 배열
		Arrays.fill(dist, INF); // INF 값으로 초기화

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());

			edges[i] = new Edge(a, b, c);
		}

		// 음수 사이클이 있으면 -1 출력
		if (bellmanFord()) {
			sb.append("-1");
		} else {
			// 없으면 결과 출력
			for (int i = 2; i <= N; i++) {
				if (dist[i] == INF) {
					sb.append("-1\n");
				} else {
					sb.append(dist[i] + "\n");
				}
			}
		}

		System.out.println(sb);

		br.close();
	}

	static boolean bellmanFord() {
		dist[1] = 0; // 시작 노드 0으로 초기화

		for (int i = 1; i < N; i++) { // N-1 만큼 반복
			for (int j = 0; j < M; j++) { // 모든 간선 확인
				Edge edge = edges[j];
				if (dist[edge.start] != INF && dist[edge.end] > dist[edge.start] + edge.weight) {
					dist[edge.end] = dist[edge.start] + edge.weight; // 거리 갱신
				}
			}
		}

		// 음수 사이클 판별
		// 한번 더 확인했을 때 갱신이 된다면 음수 사이클이 있는 것
		for (int i = 0; i < M; i++) {
			Edge edge = edges[i];
			if (dist[edge.start] != INF && dist[edge.end] > dist[edge.start] + edge.weight) {
				return true;
			}
		}

		// 음수 사이클이 없으면 false 리턴
		return false;
	}

}
