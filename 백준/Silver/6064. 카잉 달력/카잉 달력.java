import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;


public class Main {


	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		while (T-- > 0) {
			st = new StringTokenizer(br.readLine());
			int M = Integer.parseInt(st.nextToken());
			int N = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());

			int answer = -1;
			for (int i = x; i <= M * N; i += M) {
				if ((i - 1) % N + 1 == y) {
					answer = i;
					break;
				}
			}

			System.out.println(answer);
		}

		br.close();
	}

}