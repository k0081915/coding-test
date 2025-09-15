import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

	static int N;
	static char[][] arr;
	static boolean[][] visited;

	static int[] dx = {-1, 1, 0, 0}; // 상하
	static int[] dy = {0, 0, -1, 1}; // 좌우

	static Queue<int[]> queue = new LinkedList<>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(br.readLine());
		arr = new char[N][N];
		visited = new boolean[N][N];

		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < N; j++) {
				arr[i][j] = str.charAt(j);
			}
		}

		int normalCount = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (arr[i][j] == 'R' && !visited[i][j]) {
					dfsR(i, j);
					normalCount++;
				}
			}
		}

		visited = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (arr[i][j] == 'G' && !visited[i][j]) {
					dfsG(i, j);
					normalCount++;
				}
			}
		}

		visited = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (arr[i][j] == 'B' && !visited[i][j]) {
					dfsB(i, j);
					normalCount++;
				}
			}
		}

		int rgCount = 0;
		visited = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if ((arr[i][j] == 'G' || arr[i][j] == 'R') && !visited[i][j]) {
					dfsRG(i, j);
					rgCount++;
				}
			}
		}

		visited = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (arr[i][j] == 'B' && !visited[i][j]) {
					dfsB(i, j);
					rgCount++;
				}
			}
		}

		System.out.println(normalCount + " " + rgCount);

		br.close();
	}

	static void dfsR(int x, int y) {
		visited[x][y] = true;

		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
				if (!visited[nx][ny] && arr[nx][ny] == 'R') {
					visited[nx][ny] = true;
					dfsR(nx, ny);
				}
			}
		}
	}

	static void dfsG(int x, int y) {
		visited[x][y] = true;

		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
				if (!visited[nx][ny] && arr[nx][ny] == 'G') {
					visited[nx][ny] = true;
					dfsG(nx, ny);
				}
			}
		}
	}

	static void dfsB(int x, int y) {
		visited[x][y] = true;

		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
				if (!visited[nx][ny] && arr[nx][ny] == 'B') {
					visited[nx][ny] = true;
					dfsB(nx, ny);
				}
			}
		}
	}

	static void dfsRG(int x, int y) {
		visited[x][y] = true;

		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
				if (!visited[nx][ny] && (arr[nx][ny] == 'R' || arr[nx][ny] == 'G')) {
					visited[nx][ny] = true;
					dfsRG(nx, ny);
				}
			}
		}
	}
}