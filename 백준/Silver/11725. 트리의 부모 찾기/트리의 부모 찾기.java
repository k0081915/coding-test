import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

	static int N;
	static ArrayList<ArrayList<Integer>> list = new ArrayList<>(); // 인접 리스트 선언
	static int[] parent; // 최종 출력할 부모 배열

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		// 노드 개수
		N = Integer.parseInt(br.readLine());
		parent = new int[N + 1];

		for (int i = 0; i <= N; i++) {
			list.add(new ArrayList<>());
		}

		for (int i = 0; i < N - 1; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());

			// 입력받은 노드를 양쪽 모두 연결
			list.get(x).add(y);
			list.get(y).add(x);
		}

		// 루트 노드인 1부터 시작
		bfs();

		// 2~N 까지 부모를 출력
		for (int i = 2; i <= N; i++) {
			System.out.println(parent[i]);
		}

		br.close();
	}

	static void bfs() {
		Queue<Integer> queue = new LinkedList<>();
		boolean[] visited = new boolean[N + 1]; // 방문 여부
		visited[1] = true; // 1 방문 처리
		queue.add(1); // 큐에 1 추가

		// 큐가 빌 때까지
		while (!queue.isEmpty()) {
			int cur = queue.poll(); // 큐에서 노드 하나 꺼냄
			// 꺼낸 노드와 연결된 노드를 모두 탐색
			for (int i : list.get(cur)) {
				// 그 노드를 방문하지 않았을 때
				if (!visited[i]) {
					parent[i] = cur; // 꺼낸 노드와 연결된 노드의 부모를 꺼낸 노드로 설정
					visited[i] = true; // 방문 처리
					queue.add(i); // 큐에 노드를 추가
				}
			}
		}
	}
}