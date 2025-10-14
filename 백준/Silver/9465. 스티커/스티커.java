import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.*;

public class Main {


	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int[][] sticker;
		int[][] dp;

		int T = Integer.parseInt(br.readLine());
		while (T-- > 0) {
			int n = Integer.parseInt(br.readLine());
			sticker = new int[2][n]; // 스티커 배열
			dp = new int[n][3]; // dp[i][상태], i열까지 갔을 때 얻을 수 있는 최대 점수
			// 상태 0: i 열에서 아무 스티커도 떼지 않음
			// 상태 1: i 열에서 위쪽 스티커를 뗌
			// 상태 2: i 열에서 아래쪽 스티커를 뗌

			// 스티커 배열 입력
			for (int i = 0; i < 2; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					sticker[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			// 초기 dp 설정
			dp[0][0] = 0;
			dp[0][1] = sticker[0][0];
			dp[0][2] = sticker[1][0];

			for (int i = 1; i < n; i++) {
				// i 열에서 아무 스티커도 떼지 않았으면 i-1 열에서 어떤 경우도 상관 없으므로 3가지 경우 중 가장 큰 값 저장
				dp[i][0] = Math.max(dp[i - 1][0], Math.max(dp[i - 1][1], dp[i - 1][2]));

				// i 열 위쪽 스티커를 뗐다면, i-1 열의 위쪽 스티커는 떼지 못하므로
				// 아무 스티커도 떼지 않는 경우와 아래쪽 스티커를 떼는 경우 중 큰 값 저장
				dp[i][1] = sticker[0][i] + Math.max(dp[i - 1][0], dp[i - 1][2]);

				// i 열 아래쪽 스티커를 뗐다면, i-1 열의 아래쪽 스티커는 떼지 못하므로
				// 아무 스티커도 떼지 않는 경우와 아래쪽 스티커를 떼는 경우 중 큰 값 저장
				dp[i][2] = sticker[1][i] + Math.max(dp[i - 1][0], dp[i - 1][1]);
			}

			// n-1 열까지의 경우 중 가장 큰 값 출력
			System.out.println(Math.max(dp[n - 1][0], Math.max(dp[n - 1][1], dp[n - 1][2])));

		}

		br.close();
	}


}
