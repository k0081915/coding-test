import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

	static int N, K;

	static int[] visited = new int[100001];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		System.out.println(bfs(N));
		br.close();
	}

	static int bfs(int start) {
		Deque<Integer> queue = new ArrayDeque<>();
		queue.add(N); // 큐에 시작 지점 추가
		visited[N] = 1; // 방문 처리

		while (!queue.isEmpty()) {
			int cur = queue.poll();
			int nx = cur + 1; // x + 1 위치
			int px = cur - 1; // x - 1 위치
			int tx = cur * 2; // 2 * x 위치

			// 현재 위치가 동생 위치와 같다면 배열 값 - 1 반환(방문 처리를 1로 해주었기 때문에 -1 해줌)
			if(cur == K) return visited[cur] - 1;

			// 각 상황마다 배열 범위 안이면
			// 방문하지 않았다면 이동한 시간을 갱신하고
			// 방문했다면 현재 들어있는 값과 새로 갱신할 값 중 작은 값을 대입한다
			if (tx <= 100000 && visited[tx] == 0) {
				visited[tx] = visited[cur];
				queue.addFirst(tx);
			}

			if (px >= 0 && visited[px] == 0) {
				visited[px] = visited[cur] + 1;
				queue.addLast(px);
			}

			if (nx <= 100000 && visited[nx] == 0) {
				visited[nx] = visited[cur] + 1;
				queue.addLast(nx);
			}

		}
		return -1;
	}

}