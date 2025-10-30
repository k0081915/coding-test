import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();


		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		char[][] board = new char[N][M];
		int[][] cost_w = new int[N][M];
		int[][] cost_b = new int[N][M];
		int[][] sum = new int[N + 1][M + 1];

		// W로 시작하는 패턴을 기준으로, 색을 바꿔야 하면 1, 아니면 0인 비용 맵을 만들어서
		// 동시에 누적 합을 계산한다
		// 1-based 인덱싱을 위해 N+1, M+1 크기로 선언
		for (int i = 1; i <= N; i++) {
			String str = br.readLine();
			for (int j = 1; j <= M; j++) {
				char c = str.charAt(j - 1);
				int cost;

				// i+j가 짝수면 W가 와야함
				// i+j가 홀수면 B가 와야함
				if ((i + j) % 2 == 0) { // W 자리
					cost = (c == 'B') ? 1 : 0;
				} else { // B 자리
					cost = (c == 'W') ? 1 : 0;
				}

				// 2차원 누적 합
				sum[i][j] = cost + sum[i - 1][j] + sum[i][j - 1] - sum[i - 1][j - 1];
			}
		}
//		for (int i = 1; i <= N; i++) {
//			for (int j = 1; j <= M; j++) {
//				System.out.print(sum[i][j] + " ");
//			}
//			System.out.println();
//		}

		// 2. 모든 K x K 영역을 탐색하며 최솟값을 찾습니다.
		int minCost = Integer.MAX_VALUE;
		int kSquare = K * K;

		// K x K 영역의 왼쪽 위 꼭짓점 (r, c)
		for (int r = 1; r <= N - K + 1; r++) {
			for (int c = 1; c <= M - K + 1; c++) {

				// K x K 영역의 오른쪽 아래 꼭짓점 (r2, c2)
				int r2 = r + K - 1;
				int c2 = c + K - 1;

//				System.out.println(r + " " + c + " " + r2 + " " + c2);
				// 누적 합을 이용해 O(1)에 K x K 영역의 비용 계산
				// costW: 'W'로 시작하는 패턴을 기준으로 칠하는 비용
				int costW = sum[r2][c2] - sum[r - 1][c2] - sum[r2][c - 1] + sum[r - 1][c - 1];

				// costB: 'B'로 시작하는 패턴을 기준으로 칠하는 비용
				// 'B' 패턴 비용 = (전체 칸) - ('W' 패턴 비용)
				int costB = kSquare - costW;

				// 두 패턴 중 더 적은 비용을 최솟값과 비교
				minCost = Math.min(minCost, costW);
				minCost = Math.min(minCost, costB);
			}
		}

		System.out.println(minCost);



		br.close();
	}

}
