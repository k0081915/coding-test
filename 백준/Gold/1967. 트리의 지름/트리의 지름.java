import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

	static class Node {
		int end;
		int weight;

		Node(int end, int weight) {
			this.end = end;
			this.weight = weight;
		}
	}

	static int N;
	static ArrayList<ArrayList<Node>> list = new ArrayList<>();
	static boolean[] visited;
	static int max, target;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(br.readLine());

		visited = new boolean[N + 1];

		for (int i = 0; i < N + 1; i++) {
			list.add(new ArrayList<>());
		}
		
		for (int i = 0; i < N - 1; i++) {
			st = new StringTokenizer(br.readLine());
			int parent = Integer.parseInt(st.nextToken());
			int child = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());

			// 트리의 경로를 탐색해야 하기 때문에
			// 양방향으로 구성
			list.get(parent).add(new Node(child, weight));
			list.get(child).add(new Node(parent, weight));
		}

		// 루트 노드에서 시작해서 가장 먼 노드를 찾음
		dfs(1, 0);
		// 방문 배열 초기화
		Arrays.fill(visited, false);
		max = 0;
		// 찾은 노드에서 가장 먼 노드를 찾는데 그때 거리 값이 최댓값
		dfs(target, 0);

		System.out.println(max);

		br.close();
	}

	static void dfs(int start, int sum) {
		visited[start] = true; // 방문 처리
		
		// sum > max 이면 최댓값, 타겟 갱신
		if (sum > max) {
			max = sum;
			target = start;
		}

		// 이어진 노드들 모두 탐색
		for (Node node : list.get(start)) {
			if (!visited[node.end]) {
				dfs(node.end, node.weight + sum);
			}
		}
	}

}
