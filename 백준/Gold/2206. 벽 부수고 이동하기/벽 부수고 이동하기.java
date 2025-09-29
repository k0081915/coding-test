import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

	static int N, M;

	static int[][] arr;
	static int[][][] visited; // 3차원 방문 배열 (x좌표, y좌표, 벽을 부쉈는지 여부)

	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		visited = new int[N][M][2];
		// 0 -> 벽을 부수지 않고 도착한 상태
		// 1 -> 벽을 부수고 도착한 상태

		for (int i = 0; i < N; i++) {
			String line = br.readLine();
			for (int j = 0; j < M; j++) {
				arr[i][j] = line.charAt(j) - '0';
			}
		}

		// 시작 지점 1로 초기화
		visited[0][0][0] = visited[0][0][1] = 1;

		int result = bfs(); // bfs 호출
		if (result == 0) {
			System.out.println(-1);
		} else {
			System.out.println(result);
		}

		br.close();
	}

	static int bfs() {
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[]{0, 0, 0}); // 큐에 시작 지점 추가

		while (!queue.isEmpty()) {
			int[] current = queue.poll();
			int curX = current[0];
			int curY = current[1];
			int broken = current[2];
			
			// 현재 위치가 끝 위치라면 위치 배열 값 리턴
			if (curX == N - 1 && curY == M - 1) {
				return visited[curX][curY][broken];
			}

			for (int i = 0; i < 4; i++) {
				// 사방 탐색
				int nextX = curX + dx[i];
				int nextY = curY + dy[i];
				// 이동한 좌표가 배열 범위 내에 있고
				if (nextX >= 0 && nextX < N && nextY >= 0 && nextY < M) {
					// 벽이 없다면
					if (arr[nextX][nextY] == 0) {
						// 방문하지 않았다면
						if (visited[nextX][nextY][broken] == 0) {
							visited[nextX][nextY][broken] = visited[curX][curY][broken] + 1; // 이동 거리 +1
							queue.add(new int[]{nextX, nextY, broken}); // 다음 좌표, 상태 큐에 추가
						}
					} else { // 벽이 있는 경우
						if (broken == 0) { // 벽을 한번도 안 부쉈을 때만 이동 가능
							if (visited[nextX][nextY][1] == 0) { // 방문하지 않았다면
								visited[nextX][nextY][1] = visited[curX][curY][broken] + 1; // 이동 거리 +1
								// 다음 좌표, 상태 큐에 추가 (벽을 부쉈으니 이후에는 항상 1로 넘김)
								queue.add(new int[]{nextX, nextY, 1});
							}
						}
					}
				}
			}
		}
		return 0;
	}

}