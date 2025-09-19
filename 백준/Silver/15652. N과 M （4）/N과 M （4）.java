import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

	static int N, M;
	static int[] arr; // 출력 배열
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
//		StringBuilder sb = new StringBuilder();

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[M];

		permu(0, 1); // 순열 재귀

		System.out.println(sb);
		br.close();
	}

	static void permu(int idx, int start) {
		if (idx == M) { // 인덱스가 M과 같아지면
			// 배열을 M개 만큼 출력
			for (int i = 0; i < M; i++) {
				sb.append(arr[i]).append(" ");
			}
			sb.append("\n");
			return;
		}

		// start~N 까지 수 (중복 가능)
		for (int i = start; i <= N; i++) {
			arr[idx] = i; 
			permu(idx + 1, i); // 재귀 호출
		}
	}
}