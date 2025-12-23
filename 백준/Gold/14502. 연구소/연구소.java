import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

	static int[][] arr;
	static int[][] copy;
	static int N, M;
	static int max = Integer.MIN_VALUE;

	static int[] dx = {1, 0, -1, 0};
	static int[] dy = {0, 1, 0, -1};

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		arr = new int[N][M];

		// 배열 입력
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// 벽 세우기 시작 (0개부터)
		wall(0);

		System.out.println(max);
		br.close();
	}

	// 백트래킹 방식으로 벽 세우기
	static void wall(int count) {
		// 벽 개수가 3개 되면
		if (count == 3) {
			bfs(); // 감염 시작
			return;
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (arr[i][j] == 0) {
					arr[i][j] = 1; // 벽 세움
					wall(count + 1); // 벽 개수 + 1
					arr[i][j] = 0; // 다시 0으로 만듦
				}
			}
		}
	}

	// 바이러스 퍼뜨리기
	static void bfs() {
		Queue<int[]> queue = new LinkedList<>();

		// 벽을 세운 경우의 수마다 시뮬레이션 해야 하므로 
		// 복사본을 사용해야 한다
		copy = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				copy[i][j] = arr[i][j];
				// 바이러스의 위치를 큐에 넣음
				if (copy[i][j] == 2) {
					queue.add(new int[]{i, j});
				}
			}
		}

		while (!queue.isEmpty()) {
			int[] cur = queue.poll();
			int cx = cur[0];
			int cy = cur[1];

			for (int i = 0; i < 4; i++) {
				int nx = cx + dx[i];
				int ny = cy + dy[i];

				if(nx < 0 || nx >= N || ny < 0 || ny >= M) continue;

				// 빈 공간일 때
				if (copy[nx][ny] == 0) {
					copy[nx][ny] = 2; // 바이러스 감염
					queue.add(new int[]{nx, ny});
				}
			}
		}

		// 빈 공간 개수 세기
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (copy[i][j] == 0) {
					cnt++;
				}
			}
		}
		max = Math.max(max, cnt); // 최댓값 갱신
	}
}