import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

	static int MOD = 1_000_000_007;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();

		int M = Integer.parseInt(br.readLine());

		long answer = 0;

		long p = 1;    // 분모
		long c = 0; // 분자
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int S = Integer.parseInt(st.nextToken());

			// 긱 분모와 분자를 통분해서 계산
			c = S * p + c * N;
			p *= N;

			// 모듈러 산술로 나머지 계산
			c %= MOD;
			p %= MOD;
		}

		// 기약 분수이면
		if (c % p != 0) {
			System.out.println(search(p, MOD - 2) * c % MOD);
		} else { // 기약 분수가 아닐 때
			System.out.println(c / p);
		}


		br.close();
	}

	// 페르마 소정리, 역원의 값 구하기
	static long search(long N, int index) {
		if (index == 1) {
			return N;
		}
		long tmp = search(N, index / 2);
		if (index % 2 == 1) {
			return tmp * tmp % MOD * N % MOD;
		} else {
			return tmp * tmp % MOD;
		}
	}
}