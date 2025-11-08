import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

	static int N;
	static int[] arr;
	static ArrayList<Integer> lis = new ArrayList<>();


	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(br.readLine());
		arr = new int[N];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		LIS();

		System.out.println(lis.size());

		br.close();
	}

	static void LIS() {
		for (int i = 0; i < N; i++) {
			int num = arr[i];
			if (lis.isEmpty()) {
				lis.add(num);
				continue;
			}

			if (lis.get(lis.size() - 1) < num) {
				lis.add(num);
			} else {
				int lo = 0;
				int hi = lis.size() - 1;
				while (lo < hi) {
					int mid = (lo + hi) / 2;

					if (num <= lis.get(mid)) {
						hi = mid;
					} else {
						lo = mid + 1;
					}
				}
				lis.set(lo, num);
			}
		}
	}

}
