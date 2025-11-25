import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {


	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());
		int[][] arr = new int[N][3];
		int[][] dp_max = new int[N][3]; // 최대값 찾기 위한 dp
		int[][] dp_min = new int[N][3]; // 최솟값 찾기 위한 dp

		// 배열 입력
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
			arr[i][2] = Integer.parseInt(st.nextToken());
		}
		// dp 배열 초기화
		dp_max[0][0] = arr[0][0];
		dp_max[0][1] = arr[0][1];
		dp_max[0][2] = arr[0][2];
		dp_min[0][0] = arr[0][0];
		dp_min[0][1] = arr[0][1];
		dp_min[0][2] = arr[0][2];

		// 최댓값을 찾으려면 항상 초댓
		for (int i = 1; i < N; i++) {
			dp_max[i][0] = arr[i][0] + Math.max(dp_max[i - 1][0], dp_max[i - 1][1]);
			dp_max[i][1] = arr[i][1] + Math.max(dp_max[i - 1][0], Math.max(dp_max[i - 1][1], dp_max[i - 1][2]));
			dp_max[i][2] = arr[i][2] + Math.max(dp_max[i - 1][1], dp_max[i - 1][2]);

			dp_min[i][0] = arr[i][0] + Math.min(dp_min[i - 1][0], dp_min[i - 1][1]);
			dp_min[i][1] = arr[i][1] + Math.min(dp_min[i - 1][0], Math.min(dp_min[i - 1][1], dp_min[i - 1][2]));
			dp_min[i][2] = arr[i][2] + Math.min(dp_min[i - 1][1], dp_min[i - 1][2]);
		}

		int max = Math.max(dp_max[N - 1][0], Math.max(dp_max[N - 1][1], dp_max[N - 1][2]));
		int min = Math.min(dp_min[N - 1][0], Math.min(dp_min[N - 1][1], dp_min[N - 1][2]));

		System.out.println(max + " " + min);
		br.close();
	}
}
