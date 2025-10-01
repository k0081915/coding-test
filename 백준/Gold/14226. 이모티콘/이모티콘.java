import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

	static int S;
	static int[][] emoji = new int[2001][2001];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		S = Integer.parseInt(br.readLine());
		for (int i = 0; i < 2001; i++) {
			for (int j = 0; j < 2001; j++) {
				emoji[i][j] = -1;
			}
		}

		System.out.println(bfs());
		br.close();
	}

	static int bfs() {
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[]{1, 0});
		emoji[1][0] = 0;

		while (!queue.isEmpty()) {
			int[] cur = queue.poll();
			int curS = cur[0];
			int curC = cur[1];

			if (curS == S) {
				return emoji[curS][curC];
			}
			int nextS = curS;
			int nextC = curC;
			for (int i = 0; i < 3; i++) {
				if (i == 0) {
					nextS = curS;
					nextC = curS;
				} else if (i == 1) {
					if (curC != 0) {
						nextS = curS + curC;
						nextC = curC;
					}
				} else {
					nextS = curS - 1;
					nextC = curC;
				}

				if(nextS < 0 || nextS > 2000 || nextC < 0 || nextC > 2000) continue;

				if (emoji[nextS][nextC] == -1) {
					emoji[nextS][nextC] = emoji[curS][curC] + 1;
					queue.add(new int[]{nextS, nextC});
				}
			}
		}
		return 0;
	}

}