import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

	static int N;
	static char[][] arr;
	static int max;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(br.readLine());
		arr = new char[N][N];

		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < N; j++) {
				arr[i][j] = str.charAt(j);
			}
		}

		check();

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (j + 1 < N) {
					swap(i, j, i, j + 1);
					check();
					swap(i, j, i, j + 1);
				}

				if (i + 1 < N) {
					swap(i, j, i + 1, j);
					check();
					swap(i, j, i + 1, j);
				}
			}
		}

		System.out.println(max);
		br.close();
	}

	static void swap(int x1, int y1, int x2, int y2) {
		char tmp = arr[x1][y1];
		arr[x1][y1] = arr[x2][y2];
		arr[x2][y2] = tmp;
	}

	static void check() {
		int cnt1;
		int cnt2;
		// 가로 체크
		for (int i = 0; i < N; i++) {
			cnt1 = 1;
			for (int j = 0; j < N - 1; j++) {
				if (arr[i][j] == arr[i][j + 1]) {
					cnt1++;
					max = Math.max(max, cnt1);
				} else {
					cnt1 = 1;
				}
			}
		}

		for (int j = 0; j < N; j++) {
			cnt2 = 1;
			for (int i = 0; i < N - 1; i++) {
				if (arr[i][j] == arr[i + 1][j]) {
					cnt2++;
					max = Math.max(max, cnt2);
				} else {
					cnt2 = 1;
				}
			}
		}
	}

}