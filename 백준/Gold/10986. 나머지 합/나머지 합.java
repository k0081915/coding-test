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

		// count[r] => 누적 합 중, M으로 나눈 나머지가 r인 것의 개수
		long[] count = new long[M];
		count[0] = 1; // S[0] = 0 처리

		long prefixSum = 0;
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			// 누적 합 계산해서 M으로 나눈 나머지를 count 배열에 추가
			prefixSum = (prefixSum + Integer.parseInt(st.nextToken())) % M;
			count[(int) prefixSum]++;
		}

		long answer = 0;
		for (int i = 0; i < M; i++) {
			// 나머지가 i인 누적합 개수 중 2개를 뽑아 쌍을 만듦
			long k = count[i];
			answer += (k * (k - 1)) / 2;
		}

		System.out.println(answer);

		br.close();
	}

}
