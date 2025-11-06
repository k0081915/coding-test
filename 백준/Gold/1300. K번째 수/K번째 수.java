import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

	static int N, k;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(br.readLine());
		k = Integer.parseInt(br.readLine());

		// x는 low <= x <= high 범위를 갖는다
		long high = k;
		long low = 1;

		// lower-bound
		while (low < high) {
			long mid = (low + high) / 2;
			long cnt = 0;

			// 임의의 x에 대해 i번째 행을 나눔으로써 x보다 작거나 같은 원소의 개수 누적합을 구한다
			// 이 때 각 행의 원소의 개수가 N(열 개수)를 초과하지 않는 선에서 합해준다
			for (int i = 1; i <= N; i++) {
				cnt += Math.min(mid / i, N);
			}

			// cnt가 많다는 것은 임의의 x(mid)보다 작은 수가 B[k]보다 많다는 뜻
			if (k <= cnt) {
				high = mid;
			} else {
				low = mid + 1;
			}
		}

		System.out.println(low);


		br.close();
	}
}
