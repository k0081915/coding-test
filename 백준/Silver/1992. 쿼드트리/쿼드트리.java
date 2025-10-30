import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

	static int[][] arr;
	static int N;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
//		StringBuilder sb = new StringBuilder();


		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];

		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < N; j++) {
				arr[i][j] = str.charAt(j) - '0';
			}
		}

//		sb.append("(");
		partition(0, 0, N);
//		sb.append(")");

		System.out.println(sb);
		br.close();
	}

	static void partition(int r, int c, int size) {
		int flag = check(r, c, size);
		if (flag != -1) {
			sb.append(flag);
			return;
		}

		int newSize = size / 2;
		sb.append("(");
		partition(r, c, newSize);
		partition(r, c + newSize, newSize);
		partition(r + newSize, c, newSize);
		partition(r + newSize, c + newSize, newSize);
		sb.append(")");

	}

	private static int check(int r, int c, int size) {
		int num = arr[r][c];
		for (int i = r; i < r + size; i++) {
			for (int j = c; j < c + size; j++) {
				if (num != arr[i][j]) {
					return -1;
				}
			}
		}
		return num;
	}
}
