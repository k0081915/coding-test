import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

	static final int INF = 987654321;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		int[][] arr = new int[n + 1][n + 1];

		// 배열 초기화
		for (int i = 0; i < n + 1; i++) {
			for (int j = 0; j < n + 1; j++) {
				arr[i][j] = INF;
				if(i == j) arr[i][j] = 0;
			}
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());

			// 동일한 노선이 입력될 수 있으므로 그 중에 가장 작은 비용을 선택
			arr[a][b] = Math.min(arr[a][b], c);
		}

		// 플로이드 워셜
		for (int k = 1; k <= n; k++) {
			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= n; j++) {
					if (arr[i][j] > arr[i][k] + arr[k][j]) {
						arr[i][j] = arr[i][k] + arr[k][j];
					}
				}
			}
		}

		// 결과 출력
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				// 거리가 INF면 0 출력
				if (arr[i][j] == INF) {
					arr[i][j] = 0;
				}
				sb.append(arr[i][j] + " ");
			}
			sb.append("\n");
		}

		System.out.println(sb);

		br.close();
	}

}
