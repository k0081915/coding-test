import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

	final static long MOD = 1000000007;
	static long[][] origin = {{1, 1}, {1, 0}};

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		long N = Long.parseLong(br.readLine());

		/*
		 *                n
		 *       | 1   1 |    | F(n+1)  F(n)  |
		 * A^n = |       |  = |               |
		 *       | 1   0 |    |  F(n)  F(n-1) |
		 */
		
		long[][] base = {{1, 1}, {1, 0}};

		// Fn을 구하려면 A 행렬을 n-1 제곱한 뒤 변환된 행렬 A11 원소를 출력
		System.out.println(pow(base, N - 1)[0][0]);

		br.close();
	}

	// 두 행렬을 곱해서 리턴
	static long[][] multiply(long[][] A, long[][] B) {
		long[][] mulArr = new long[2][2];
		for (int k = 0; k < 2; k++) {
			for (int i = 0; i < 2; i++) {
				for (int j = 0; j < 2; j++) {
					mulArr[i][j] += (A[i][k] * B[k][j]);
					mulArr[i][j] %= MOD;
				}
			}
		}
		return mulArr;
	}

	static long[][] pow(long[][] base, long expo) {
		// 지수가 1이면 자기 자신을 반환
		if (expo == 1 || expo == 0) {
			return base;
		}

		// 지수가 1보다 크면 지수를 반으로 나눔
		long[][] temp = pow(base, expo / 2);

		temp = multiply(temp, temp);
		// 지수가 홀수면 origin을 한번 더 곱해줘야 함
		// A^5 = A^2 * A^2 * A
		if (expo % 2 == 1L) {
			temp = multiply(temp, origin);
		}
		// 짝수면 temp만 서로 곱해줌
		return temp;
	}

}
