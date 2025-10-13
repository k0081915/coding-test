import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

	static int A, B;
	static int min = Integer.MAX_VALUE;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		st = new StringTokenizer(br.readLine());
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());

		dfs(A, 1);

		if (min == Integer.MAX_VALUE) {
			System.out.println(-1);
		} else {
			System.out.println(min);
		}

		br.close();
	}

	static void dfs(long num, int cnt) {
		if (num > B) {
			return;
		}
		if (num == B) {
			min = Math.min(min, cnt);
			return;
		}

		dfs(num * 2, cnt + 1);
		dfs(num * 10 + 1, cnt + 1);
	}
}
