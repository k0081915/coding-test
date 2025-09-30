import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

	static int N, K;
	static int min = 987654321;
	static int count;
	static int[] visited = new int[100001];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		// 수빈의 위치가 동생보다 뒤에 있으면 -1 씩 하는 경우밖에 없음
		if (N >= K) {
			System.out.println((N - K) + "\n1");
			return;
		}

		bfs(); // bfs 호출
		System.out.println(min + "\n" + count);
		br.close();
	}

	static void bfs() {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(N); // 큐에 시작 지점 추가
		visited[N] = 1; // 방문 처리

		while (!queue.isEmpty()) {
			int cur = queue.poll();

			// 현재 방문 시간이 최소 시간보다 크면 return
			if(min < visited[cur]) return;

			for (int i = 0; i < 3; i++) {
				int next;
				if(i == 0) next = cur + 1;
				else if(i == 1) next = cur - 1;
				else next = cur * 2;

				// 배열 범위 밖이면 continue
				if(next < 0 || next > 100000) continue;

				// 다음 위치가 K와 같으면
				if (next == K) {
					min = visited[cur]; // 최소 시간 갱신
					count++; // 횟수 증가
				}

				// 방문하지 않았거나 다음 방문 시간이 현재 방문 시간과 같다면
				if (visited[next] == 0 || visited[next] == visited[cur] + 1) {
					queue.add(next); // 큐에 추가
					visited[next] = visited[cur] + 1; // 시간 갱신
				}
			}

		}
	}

}