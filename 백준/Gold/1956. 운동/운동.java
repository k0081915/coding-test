import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

	static int V, E;
	static final int INF = 987654321;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();

		st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());

		// [시작점 -> 끝점]의 거리 저장
		// INF로 초기화
		int[][] arr = new int[V + 1][V + 1];
		for (int i = 0; i <= V; i++) {
			for (int j = 0; j <= V; j++) {
				arr[i][j] = INF;
			}
		}

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());

			// a -> b의 거리
			arr[a][b] = c;
		}

		// 플로이드-워셜 알고리즘 사용
		for (int k = 1; k <= V; k++) {
			for (int i = 1; i <= V; i++) {
				for (int j = 1; j <= V; j++) {
					if (arr[i][j] > arr[i][k] + arr[k][j]) {
						arr[i][j] = arr[i][k] + arr[k][j];
					}
				}
			}
		}

		int answer = INF;
		for (int i = 1; i <= V; i++) {
			// 사이클을 판단해야 하니 arr[i][i] 확인
			// 사이클이 존재하면
			if (arr[i][i] != INF) {
				// 결과에 최솟값 저장
				answer = Math.min(answer, arr[i][i]);
			}
		}

		// 사이클이 존재하지 않으면 -1 출력
		if (answer == INF) {
			System.out.println(-1);
		} else {
			System.out.println(answer);
		}

		br.close();
	}
}
