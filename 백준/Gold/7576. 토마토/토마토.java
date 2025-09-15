import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

	static int N, M, H;
	static int[][] arr;
	static int[][] days;

	static int[] dx = {-1, 1, 0, 0, 0, 0}; // 상하
	static int[] dy = {0, 0, -1, 1, 0, 0}; // 좌우

	static Queue<int[]> queue = new LinkedList<>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken()); // 가로
		N = Integer.parseInt(st.nextToken()); // 세로
		arr = new int[N][M]; // 토마토 배열
		days = new int[N][M]; // 최대 며칠이 걸렸는지 확인하는 배열

		// days 배열을 -1로 초기화하면 방문 여부도 같이 확인할 수 있다
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				days[i][j] = -1;
			}
		}

		// 토마토 배열 입력
		boolean state = false;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if (arr[i][j] == 1) {
					// 큐에 좌표를 넣어준다
					queue.add(new int[]{i, j});
					// days 배열 값을 0으로 한다 (방문 처리)
					days[i][j] = 0;
				} else if (arr[i][j] == 0) {
					state = true; // 익지 않은 과일이 있으면 state를 true
				}
			}
		}

		// state가 true일 때만 bfs를 호출한다
		if(state) bfs();

		// bfs 탐색 후 토마토가 모두 익었는지 확인하는 변수
		boolean check = true;
		for (int[] ints : arr) {
			for (int i : ints) {
				// 0이 하나라도 남아있으면
				if (i == 0) {
					check = false; // check 변수를 false로
				}
			}
		}
		// 다 익었다면
		if (check) {
			// days 배열에서 최댓값을 찾아 출력한다
			int max = 0;
			for (int[] day : days) {
				for (int i : day) {
					max = Math.max(max, i);
				}
			}
			System.out.println(max);
		} else {
			// 익지 않았다면 -1을 출력
			System.out.println(-1);
		}
		br.close();
	}

	static void bfs() {
		// 큐가 빌 때까지
		while(!queue.isEmpty()) {
			// 큐에서 좌표 하나를 뺀다
			int[] coord = queue.poll();
			int x = coord[0];
			int y = coord[1];
			for (int i = 0; i < 6; i++) {
				// 상하좌우 탐색
				int nx = x + dx[i];
				int ny = y + dy[i];

				// 해당 죄표가 배열 범위 안에 있고
				if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
					// 방문하지 않았고 익지 않은 토마토라면
					if (days[nx][ny] == -1 && arr[nx][ny] == 0) {
						queue.add(new int[]{nx, ny}); // 큐에 넣어줌
						days[nx][ny] = days[x][y] + 1; // days 배열에 며칠이 지났는지 기록
						arr[nx][ny] = 1; // 익음 상태로 바꿔준다
					}
				}
			}
		}
	}
}