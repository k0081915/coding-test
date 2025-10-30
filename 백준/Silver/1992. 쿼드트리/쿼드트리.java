import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

	static int[][] arr;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
//		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());
		arr = new int[N][N];

		// 배열 입력
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < N; j++) {
				arr[i][j] = str.charAt(j) - '0';
			}
		}

		// 전체 사각형에서 시작
		partition(0, 0, N);

		System.out.println(sb);
		br.close();
	}

	static void partition(int r, int c, int size) {
		// 사각형이 모두 같은 숫자로 되어있는지 확인
		int flag = check(r, c, size);
		if (flag != -1) { // 같은 숫자라면
			sb.append(flag); // 리턴된 숫자 입력
			return;
		}

		// 다른 숫자로 되어있다면
		int newSize = size / 2; // 사각형 사이즈를 반으로 줄임
		sb.append("(");
		// 각 사분면에 맞는 첫번째 값을 설정하고 재귀호출해줌
		partition(r, c, newSize);
		partition(r, c + newSize, newSize);
		partition(r + newSize, c, newSize);
		partition(r + newSize, c + newSize, newSize);
		sb.append(")");

	}

	private static int check(int r, int c, int size) {
		int num = arr[r][c]; // 배열 첫번째 값
		for (int i = r; i < r + size; i++) {
			for (int j = c; j < c + size; j++) {
				// num과 다른 값이 나오면 -1 리턴
				if (num != arr[i][j]) {
					return -1;
				}
			}
		}
		return num; // 다 같은 숫자라면 num 리턴
	}
}
