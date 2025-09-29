import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

	static int l;

	static int[][] chess;
	static boolean[][] visited;
	static int[] dx = {-2, -2, 2, 2, -1, -1, 1, 1};
	static int[] dy = {-1, 1, -1, 1, -2, 2, -2, 2};

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		while (T-- > 0) {
			l = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			int startX = Integer.parseInt(st.nextToken());
			int startY = Integer.parseInt(st.nextToken());

			st = new StringTokenizer(br.readLine());
			int dstX = Integer.parseInt(st.nextToken());
			int dstY = Integer.parseInt(st.nextToken());

			chess = new int[l][l];
			visited = new boolean[l][l];
			visited[startX][startY] = true;

			bfs(startX, startY);

			System.out.println(chess[dstX][dstY]);

		}

		br.close();
	}

	static void bfs(int startX, int startY) {
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[]{startX, startY});

		while (!queue.isEmpty()) {
			int[] current = queue.poll();
			int curX = current[0];
			int curY = current[1];
			for (int i = 0; i < 8; i++) {
				int nextX = curX + dx[i];
				int nextY = curY + dy[i];
				if (nextX >= 0 && nextX < l && nextY >= 0 && nextY < l) {
					if (!visited[nextX][nextY]) {
						chess[nextX][nextY] = chess[curX][curY] + 1;
						queue.add(new int[]{nextX, nextY});
						visited[nextX][nextY] = true;
					}
				}
			}
		}
	}

}