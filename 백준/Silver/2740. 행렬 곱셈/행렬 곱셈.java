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
		int[][] A = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				A[i][j] = Integer.parseInt(st.nextToken());
			}
		}
// [0][0]*[0][0]+[0][1]*[1][0]  [0][0]*[0][1]+[0][1]*[1][1]  [0][0]*[0][2]+[0][1]*[1][2]
// [1][0]*[0][0]+[1][1]*[1][0]  [1][0]*[0][1]+[1][1]*[1][1]  [1][0]*[0][2]+[1][1]*[1][2]
// [2][0]*[0][0]+[2][1]*[1][0]  [2][0]*[0][1]+[2][1]*[1][1]  [2][0]*[0][2]+[2][1]*[1][2]

		st = new StringTokenizer(br.readLine());
		int M2 = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[][] B = new int[M2][K];
		for (int i = 0; i < M2; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < K; j++) {
				B[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int[][] C = new int[N][K];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < K; j++) {
				for (int k = 0; k < M; k++) {
					C[i][j] += A[i][k] * B[k][j];
				}
			}
		}

		for (int[] numbers : C) {
			for (int number : numbers) {
				sb.append(number + " ");
			}
			sb.append("\n");
		}

		System.out.println(sb);
		br.close();
	}


}
