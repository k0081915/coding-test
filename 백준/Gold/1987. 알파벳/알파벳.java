import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

	static int R, C;
	static char[][] board;
	static int[] visited;
	static int max;

	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();

		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		board = new char[R][C];
		visited = new int[26]; // 방문한 알파벳을 쳐내기 위한 배열

		// 보드 입력
		for (int i = 0; i < R; i++) {
			String str = br.readLine();
			for (int j = 0; j < C; j++) {
				board[i][j] = str.charAt(j);
			}
		}

		// (0,0)부터 시작하는데 첫 칸을 포함
		dfs(0, 0, 1);

		System.out.println(max);

		br.close();
	}

	static void dfs(int r, int c, int sum) {
		visited[board[r][c] - 'A'] = 1; // 방문 처리

		// sum > max 이면 최댓값 갱신
		if (sum > max) {
			max = sum;
		}

		// 상하좌우 탐색
		for (int i = 0; i < 4; i++) {
			int nr = r + dx[i];
			int nc = c + dy[i];

			// 배열 범위 안이면
			if (nr >= 0 && nr < R && nc >= 0 && nc < C) {
				// 방문하지 않은 곳이면
				if (visited[board[nr][nc] - 'A'] == 0) {
					// dfs 수행
					dfs(nr, nc, sum + 1);
				}
			}
		}
		// 백트래킹: 다시 방문 처리를 해제함
		visited[board[r][c] - 'A'] = 0;
	}
}
