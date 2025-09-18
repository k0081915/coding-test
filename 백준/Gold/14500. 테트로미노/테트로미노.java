import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

	static int N, M;
	static int[][] arr; // 입력 배열
	static boolean[][] visited; // 방문 퍼리
	static int[] dx = {-1, 1, 0, 0}; // 상하
	static int[] dy = {0, 0, -1, 1}; // 좌우

	static int max; // 결과값

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		visited = new boolean[N][M];

		// 배열 입력
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				visited[i][j] = true; // 시작점 방문 처리
				dfs(i, j, 1, arr[i][j]); // 시작점에서 dfs 호출, depth=1, sum=현재 칸의 값
				visited[i][j] = false; // 다음 탐색을 위해 false 처리
				oh(i, j); // 'ㅗ' 모양은 dfs 경로로 만들 수 없기 때문에 따로 처리
			}
		}

		System.out.println(max);

		br.close();
	}

	static void dfs(int x, int y, int depth, int sum) {
		// depth가 4가 되면 최댓값을 갱신하고 리턴
		if (depth == 4) {
			max = Math.max(max, sum);
			return;
		}

		for (int i = 0; i < 4; i++) {
			// 상하좌우 탐색
			int nx = x + dx[i];
			int ny = y + dy[i];

			// 배열 범위 안에 있고
			if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
				// 방문하지 않았다면
				if (!visited[nx][ny]) {
					visited[nx][ny] = true; // 방문 처리
					// depth + 1, sum에 배열 값을 더해서 재귀 호출
					dfs(nx, ny, depth + 1, sum + arr[nx][ny]);
					visited[nx][ny] = false; // 다음 탐색을 위해 false 처리
				}
			}
		}
	}

	static void oh(int x, int y) {
		// (x, y)가 중심점이 되는 4가지 'ㅗ' 모양 확인
		int wingCount = 4;
		int sum = arr[x][y];
		int minWing = 1001;

		for (int i = 0; i < 4; i++) {
			// 상하좌우 확인
			int nx = x + dx[i];
			int ny = y + dy[i];

			// 날개가 범위를 벗어나면
			if (nx < 0 || nx >= N || ny < 0 || ny >= M) {
				wingCount--; // 날개 카운트 -1
				continue;
			}

			sum += arr[nx][ny]; // 모든 날개를 다 더함
			minWing = Math.min(minWing, arr[nx][ny]); // 날개 중 최소를 찾음
		}

		// 날개가 3개 미만이면 'ㅗ' 모양 불가
		if (wingCount < 3) {
			return;
		} else if (wingCount == 4) { // 날개가 4개면
			sum -= minWing; // 그 중 가장 작은 날개를 하나 빼면 그것이 'ㅗ' 모양 중 가장 큰 수
		}

		max = Math.max(max, sum); // 최댓값 갱신
	}

}