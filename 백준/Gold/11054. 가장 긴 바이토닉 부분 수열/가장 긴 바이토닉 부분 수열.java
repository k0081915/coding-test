import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {


	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		int[] dp1 = new int[N]; // arr[i]를 마지막 원소로 가지는 가장 긴 증가하는 부분 수열의 길이
		int[] dp2 = new int[N]; // arr[i]를 첫번째 원소로 가지는 가장 긴 감소하는 부분 수열의 길이

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		// LIS 계산 (왼쪽 -> 오른쪽)
		for (int i = 0; i < N; i++) {
			dp1[i] = 1;
			for (int j = 0; j < i; j++) {
				if (arr[j] < arr[i] && dp1[i] < dp1[j] + 1) {
					dp1[i] = dp1[j] + 1;
				}
			}
		}

		// LDS 계산 (오른쪽 -> 왼쪽)
		for (int i = N - 1; i >= 0; i--) {
			dp2[i] = 1;
			for (int j = N - 1; j > i; j--) {
				if (arr[j] < arr[i] && dp2[i] < dp2[j] + 1) {
					dp2[i] = dp2[j] + 1;
				}
			}
		}

		// 모든 배열값을 정점으로 두고 LIS, LDS를 계산하여 최댓값을 계산한다
		int max = 0;
		for (int i = 0; i < N; i++) {
			max = Math.max(max, dp1[i] + dp2[i] - 1);
		}

		System.out.println(max);

		br.close();
	}


}
