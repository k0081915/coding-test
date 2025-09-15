import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

	static int N, M, H;
	static int[][][] arr;
	static int[][][] days;

	static int[] dx = {-1, 1, 0, 0, 0, 0}; // 상하
	static int[] dy = {0, 0, -1, 1, 0, 0}; // 좌우
	static int[] dh = {0, 0, 0, 0, -1, 1}; // 앞뒤

	static Queue<int[]> queue = new LinkedList<>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		arr = new int[H][N][M];
		days = new int[H][N][M];

		for (int i = 0; i < H; i++) {
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < M; k++) {
					days[i][j][k] = -1;
				}
			}
		}

		for (int i = 0; i < H; i++) {
			for (int j = 0; j < N; j++) {
				st = new StringTokenizer(br.readLine());
				for (int k = 0; k < M; k++) {
					arr[i][j][k] = Integer.parseInt(st.nextToken());
					if (arr[i][j][k] == 1) {
						queue.add(new int[]{i, j, k});
						days[i][j][k] = 0;
					}
				}
			}
		}

		bfs();

		boolean check = true;
		for (int[][] ints : arr) {
			for (int[] anInt : ints) {
				for (int i : anInt) {
					if (i == 0) {
						check = false;
					}
				}
			}
		}
		if (check) {
			int max = 0;
			for (int[][] day : days) {
				for (int[] ints : day) {
					for (int i : ints) {
						max = Math.max(max, i);
					}
				}
			}
			System.out.println(max);
		} else {
			System.out.println(-1);
		}
		br.close();
	}

	static void bfs() {

		while(!queue.isEmpty()) {
			int[] coord = queue.poll();
			int h = coord[0];
			int x = coord[1];
			int y = coord[2];
			for (int i = 0; i < 6; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				int nh = h + dh[i];

				if (nx >= 0 && nx < N && ny >= 0 && ny < M && nh >= 0 && nh < H) {
					if (days[nh][nx][ny] == -1 && arr[nh][nx][ny] == 0) {
						queue.add(new int[]{nh, nx, ny});
						days[nh][nx][ny] = days[h][x][y] + 1;
						arr[nh][nx][ny] = 1;
					}
				}
			}
		}
	}
}