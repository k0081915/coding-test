import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

	static int K, V, E;
	static int[] part; // -1, 1 영역으로 나눔

	static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
	static boolean flag; // 이분 그래프인지 판별

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		K = Integer.parseInt(br.readLine());

		while (K-- > 0) {
			st = new StringTokenizer(br.readLine());
			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());

			graph = new ArrayList<>();
			part = new int[V + 1];
			for (int i = 0; i <= V; i++) {
				graph.add(new ArrayList<>());
			}

			// 간선 연결
			for (int i = 0; i < E; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				graph.get(x).add(y);
				graph.get(y).add(x);
			}

			for (int i = 1; i <= V; i++) {
				// 방문하지 않은 노드면
				if (part[i] == 0) {
					flag = bfs(i); // bfs 호출
				}
				if(!flag) break; // 이분 그래프가 아니면 빠져나온다
			}

			// 결과 출력
			if(flag) System.out.println("YES");
			else System.out.println("NO");
		}
		br.close();
	}

	static boolean bfs(int node) {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(node);

		// 현재 노드의 파트를 1로 정함
		part[node] = 1;

		while (!queue.isEmpty()) {
			int poll = queue.remove();

			for (int next : graph.get(poll)) {
				// 현재 노드와 연결되어 있는 노드들의 파트가 같다면 이분 그래프가 아니다 
				if(part[poll] == part[next]) return false;

				// 방문하지 않았다면
				if (part[next] == 0) {
					part[next] = part[poll] * -1; // 현재 파트와 다르게 설정한다
					queue.add(next); // 큐에 추가
				}
			}
		}
		// 다 통과하면 이분 그래프이다
		return true;
	}

}