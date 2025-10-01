import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

	static int N, M;

	static int[][] arr;
	static int[][] visited; // 방문 + 벽 파괴 횟수 저장

	static int[] dx = {-1, 1, 0, 0}; // 상하
	static int[] dy = {0, 0, -1, 1}; // 좌우

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		visited = new int[N][M];

		// 배열 입력
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				arr[i][j] = str.charAt(j) - '0';
				visited[i][j] = Integer.MAX_VALUE; // 각 위치의 최솟값을 찾기 위해 큰 값 초기 설정
			}
		}

		bfs(); // bfs 호출

		// bfs를 다 돌면 벽 파괴 횟수가 저장되어 있음
		System.out.println(visited[N - 1][M - 1]);
		br.close();
	}

	static void bfs() {
		Deque<int[]> queue = new ArrayDeque<>(); // 우선순위를 위해 Deque 사용
		queue.add(new int[]{0, 0}); // 시작 위치 큐에 추가
		visited[0][0] = 0; // 방문 처리

		while (!queue.isEmpty()) {
			int[] cur = queue.poll(); // 큐에서 하나씩 뺌
			int cx = cur[0];
			int cy = cur[1];

			// 상하좌우 탐색
			for (int i = 0; i < 4; i++) {
				int nx = cx + dx[i];
				int ny = cy + dy[i];

				// 범위 밖이면 continue
				if(nx < 0 || nx > N - 1 || ny < 0 || ny > M - 1) continue;

				// 방문하지 않았다면
				if (visited[nx][ny] == Integer.MAX_VALUE) {
					// 배열 값이 0이면
					if (arr[nx][ny] == 0) {
						// 현재 경로가 더 효율적이면
						if (visited[cx][cy] < visited[nx][ny]) {
							visited[nx][ny] = visited[cx][cy]; // 다음 경로 갱신
							queue.addFirst(new int[]{nx, ny}); // 큐의 맨 앞에 추가
							// 항상 가중치가 0인 것부터 체크
						}
					} else { // 배열 값이 1이면 벽을 부숴야함
						// 현재 경로가 더 효율적이면
						if (visited[cx][cy] + 1 < visited[nx][ny]) {
							visited[nx][ny] = visited[cx][cy] + 1; // 다음 경로 갱신
							queue.addLast(new int[]{nx, ny}); // 큐의 맨 뒤에 추가
						}
					}

				}

			}
		}
	}

}