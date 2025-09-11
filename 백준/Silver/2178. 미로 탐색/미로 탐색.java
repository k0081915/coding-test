import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

	static int N, M;
	static int[][] arr;	// 미로 배열
	static boolean[][] visited; // 방문 확인

	static int[] dx = {-1, 1, 0, 0}; // 상하
	static int[] dy = {0, 0, -1, 1}; // 좌우


	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		visited = new boolean[N][M];


		// 배열을 입력받는다
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				int num = str.charAt(j) - '0';
				arr[i][j] = num;
			}
		}
		
		// 좌표 (0,0)은 시작지점이므로 방문 처리
		visited[0][0] = true;
		// bfs 호출
		bfs();
		System.out.println(arr[N - 1][M - 1]);
		br.close();
	}

	static void bfs() {
		Queue<int[]> queue = new LinkedList<>();

		// 큐에 (0, 0)을 넣는다
		queue.add(new int[]{0, 0});

		// 큐가 차있을 동안
		while (!queue.isEmpty()) {
			// 들어있는 첫번째 좌표를 꺼낸다
			int[] poll = queue.remove();
			for (int i = 0; i < 4; i++) {
				// 현재 좌표에서 상하좌우 좌표를 구한다
				int nx = poll[0] + dx[i];
				int ny = poll[1] + dy[i];

				// 좌표가 배열 범위 안에 있고
				if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
					// 방문하지 않았고 좌표값이 0이 아닐 때
					if (!visited[nx][ny] && arr[nx][ny] != 0) {
						// 새로운 x, y 좌표를 큐에 넣는다
						queue.add(new int[]{nx, ny});
						// 방문 처리
						visited[nx][ny] = true;
						// 새로운 좌표값에 전 좌표값 + 1을 해준다
						arr[nx][ny] = arr[poll[0]][poll[1]] + 1;
					}
				}
			}
		}
	}
	
}