import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

	static int N, cnt;
	static int[] queen; // queen[i] = j -> i행 j열에 퀸이 있음

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
//		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(br.readLine());
		queen = new int[N];

		nQueen(0); // 0번째 행부터 퀸을 놓음

		System.out.println(cnt);
		br.close();
	}


	static void nQueen(int row) {

		if (row == N) { // 모든 행에 퀸을 다 놓았으면
			cnt++; // 경우의 수 +1
			return; // 리턴
		}

		// row번째 행의 0~N-1 열을 탐색
		for (int i = 0; i < N; i++) {
			queen[row] = i; // row번째 행, i번째 열에 퀸을 놓음
			if (isPossible(row)) { // 퀸을 놓은 곳이 조건에 맞는 지 확인
				nQueen(row + 1); // 조건에 맞으면 row + 1
			}
		}
	}

	// row번째 행에 놓은 퀸이 0~row-1 번째 행에 놓인 퀸과 같은 열, 대각선 방향에 있지 않은지 확인
	static boolean isPossible(int row) {
		for (int i = 0; i < row; i++) {
			// queen[i] == queen[row] -> 같은 열
			// |row - i| == |queen[row] - queen[i]| -> 같은 대각선
			if (queen[i] == queen[row] || Math.abs(row - i) == Math.abs(queen[row] - queen[i])) return false;
		}
		return true;
	}
}
