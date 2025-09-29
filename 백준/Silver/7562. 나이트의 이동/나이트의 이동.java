import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

	static int l;

	static int[][] chess; // 체스 배열
	static boolean[][] visited; // 방문 배열
	
	// 나이트 이동 경로
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

			chess = new int[l][l]; // 체스 배열 초기화
			visited = new boolean[l][l]; // 방문 배열 초기화
			visited[startX][startY] = true; // 시작 지점 방문 처리

			bfs(startX, startY); // 시작 지점에서 bfs 호출

			sb.append(chess[dstX][dstY]).append("\n");
		}

		System.out.println(sb);

		br.close();
	}
	
	static void bfs(int startX, int startY) {
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[]{startX, startY});

		while (!queue.isEmpty()) {
			int[] current = queue.poll();
			int curX = current[0];
			int curY = current[1];
			// 나이트의 이동 경로를 모두 탐색
			for (int i = 0; i < 8; i++) {
				int nextX = curX + dx[i];
				int nextY = curY + dy[i];
				// 이동한 좌표가 배열 범위 내에 있고
				if (nextX >= 0 && nextX < l && nextY >= 0 && nextY < l) {
					// 방문하지 않았다면
					if (!visited[nextX][nextY]) {
						chess[nextX][nextY] = chess[curX][curY] + 1; // 이동 횟수를 1 더함
						queue.add(new int[]{nextX, nextY}); // 다음 좌표 큐에 추가
						visited[nextX][nextY] = true; // 방문 처리
					}
				}
			}
		}
	}

}