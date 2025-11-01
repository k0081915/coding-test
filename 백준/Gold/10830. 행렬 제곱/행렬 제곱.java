import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

	static int N;
	static int[][] arr;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		long B = Long.parseLong(st.nextToken());
		arr = new int[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int[][] pow = pow(arr, B);

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(pow[i][j] % 1000 + " ");
			}
			System.out.println();
		}

		br.close();
	}

	// 두 행렬을 곱해서 리턴
	static int[][] multiply(int[][] A, int[][] B) {
		int[][] mulArr = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < N; k++) {
					mulArr[i][j] += (A[i][k] * B[k][j]) % 1000;
				}
			}
		}
		return mulArr;
	}

	static int[][] pow(int[][] base, long expo) {
		// 지수가 1이면 자기 자신을 반환
		if (expo == 1) {
			// 1000으로 나눈 나머지를 저장
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					base[i][j] = base[i][j] % 1000;
				}
			}
			return base;
		}

		// 지수가 1보다 크면 지수를 반으로 나눔
		int[][] temp = pow(base, expo / 2);

		// 지수가 홀수면 A를 한번 더 곱해줘야 함
		// A^5 = A^2 * A^2 * A
		if (expo % 2 == 1) {
			return multiply(multiply(temp, temp), base);
		}
		// 짝수면 temp만 서로 곱해줌
		return multiply(temp, temp);
	}

}
