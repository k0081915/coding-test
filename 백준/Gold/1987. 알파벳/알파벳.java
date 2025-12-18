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
		visited = new int[26];

		for (int i = 0; i < R; i++) {
			String str = br.readLine();
			for (int j = 0; j < C; j++) {
				board[i][j] = str.charAt(j);
			}
		}

		dfs(0, 0, 1);

		System.out.println(max);

		br.close();
	}

	static void bfs(int r, int c) {
		Queue<int[]> queue = new LinkedList<>();
		Set<Character> set = new HashSet<>();

		queue.add(new int[] {r, c});
		set.add(board[r][c]);

		while (!queue.isEmpty()) {
			int[] cur = queue.poll();
			int cr = cur[0];
			int cc = cur[1];

			for (int i = 0; i < 4; i++) {
				int nr = cr + dx[i];
				int nc = cc + dy[i];

				if (nr >= 0 && nr < R && nc >= 0 && nc < C) {
					if (!set.contains(board[nr][nc])) {
						System.out.println(board[nr][nc]);
						set.add(board[nr][nc]);
						queue.add(new int[]{nr, nc});
					}

				}
			}
		}
	}

	static void dfs(int r, int c, int sum) {
		visited[board[r][c] - 'A'] = 1;

		if (sum > max) {
			max = sum;
		}

		for (int i = 0; i < 4; i++) {
			int nr = r + dx[i];
			int nc = c + dy[i];

			if (nr >= 0 && nr < R && nc >= 0 && nc < C) {
				if (visited[board[nr][nc] - 'A'] == 0) {
					dfs(nr, nc, sum + 1);
				}
			}
		}
		visited[board[r][c] - 'A'] = 0;
	}
}
