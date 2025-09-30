import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

	static int N, K;
	static int[] visited = new int[100001];
	static int[] parent = new int[100001];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		// 수빈의 위치가 동생보다 뒤에 있으면 -1 씩 하는 경우밖에 없음
		if (N >= K) {
			System.out.println(N - K);
			for (int i = N; i >= K; i--) {
				System.out.print(i + " ");
			}
			return;
		}

		bfs(); // bfs 호출
		
		sb.append(visited[K] - 1).append("\n"); // 최소 시간
		
		// K부터 N까지 경로를 거꾸로 추적하기 위해 stack 사용
		Stack<Integer> stack = new Stack<>();
		int current = K; // K부터 시작
		// 걸린 시간동안 수행
		for (int i = 0; i <= visited[K] - 1; i++) {
			stack.push(current); // 스택에 current 푸시
			current = parent[current]; // current를 이전 경로로 갱신
		}
		
		// 스택이 빌 때까지 출력
		while (!stack.isEmpty()) {
			sb.append(stack.pop()).append(" ");
		}

		System.out.println(sb);
		br.close();
	}

	static void bfs() {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(N); // 큐에 시작 지점 추가
		visited[N] = 1; // 방문 처리

		while (!queue.isEmpty()) {
			int cur = queue.poll();

			// 현재 위치가 K랑 같으면 return
			if(cur == K) return;

			for (int i = 0; i < 3; i++) {
				int next;
				if(i == 0) next = cur + 1;
				else if(i == 1) next = cur - 1;
				else next = cur * 2;

				// 배열 범위 밖이면 continue
				if(next < 0 || next > 100000) continue;

				// 방문하지 않았으면
				if (visited[next] == 0) {
					queue.add(next); // 큐에 추가
					visited[next] = visited[cur] + 1; // 시간 갱신
					parent[next] = cur; // 이전 위치를 저장
				}
			}

		}
	}

}