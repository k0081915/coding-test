import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

	static int N;

	static StringBuilder sb = new StringBuilder();


	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
//		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(br.readLine());

		long answer = (long) (Math.pow(2, N) - 1);

		hanoi(N, 1, 2, 3);
		System.out.println(answer);
		System.out.println(sb);
		br.close();
	}


	static void hanoi(int n, int from, int tmp, int to) {
		// 기저 조건
		if (n == 0) {
			return;
		}

		hanoi(n - 1, from, to, tmp);
		sb.append(from + " " + to).append("\n");
		hanoi(n - 1, tmp, from, to);
	}
}
