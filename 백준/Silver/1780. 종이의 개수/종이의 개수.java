import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

	static int[][] arr;
	static int minus, zero, plus;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
//		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());
		arr = new int[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		partition(0, 0, N);

		System.out.println(minus + "\n" + zero + "\n" + plus);

		br.close();
	}

	static void partition(int r, int c, int size) {
		if (checkNum(r, c, size)) {
			if (arr[r][c] == -1) {
				minus++;
			} else if (arr[r][c] == 0) {
				zero++;
			} else {
				plus++;
			}
			return;
		}

		int ns = size / 3;
		partition(r, c, ns);
		partition(r, c + ns, ns);
		partition(r, c + 2 * ns, ns);

		partition(r + ns, c, ns);
		partition(r + ns, c + ns, ns);
		partition(r + ns, c + 2 * ns, ns);

		partition(r + 2 * ns, c, ns);
		partition(r + 2 * ns, c + ns, ns);
		partition(r + 2 * ns, c + 2 * ns, ns);
	}

	static boolean checkNum(int r, int c, int size) {
		int num = arr[r][c];
		for (int i = r; i < r + size; i++) {
			for (int j = c; j < c + size; j++) {
				if (num != arr[i][j]) {
					return false;
				}
			}
		}
		return true;
	}
}
