import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.*;

public class Main {

	static int[][] sudoku = new int[9][9]; // 스토쿠 배열
	static ArrayList<int[]> list = new ArrayList<>(); // 숫자가 0인 위치 저장
	static boolean flag;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		// 스도쿠를 입력받고 0이 나오면 위치를 저장한다
		for (int i = 0; i < 9; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 9; j++) {
				sudoku[i][j] = Integer.parseInt(st.nextToken());
				if(sudoku[i][j] == 0) list.add(new int[]{i, j});
			}
		}

		// 0부터 시작
		dfs(0);

		br.close();
	}

	static void dfs(int idx) {
		if(flag) return; // flag가 true면 리턴

		// 모든 0 좌표를 탐색했으면
		if (idx == list.size()) {
			// 스도쿠 출력
			for (int[] ints : sudoku) {
				for (int num : ints) {
					System.out.print(num + " ");
				}
				System.out.println();
			}
			// flag를 true로 설정
			flag = true;

			return;
		}

		// list에서 하나씩 좌표를 꺼냄
		int[] coord = list.get(idx); 
		int row = coord[0];
		int col = coord[1];

		// 0 위치에 1~9까지 숫자를 하나씩 넣어봄
		for (int i = 1; i < 10; i++) {
			// 넣은 숫자가 가능하다면
			if (isPossible(row, col, i)) {
				sudoku[row][col] = i; // 0 위치에 숫자를 넣음
				dfs(idx + 1); // 다음 인덱스로 넘어감
				sudoku[row][col] = 0; // 다음 탐색을 위해 0으로 돌려놓음
			}
		}
	}

	private static boolean isPossible(int row, int col, int number) {
		// 같은 행, 열에 같은 숫자가 있으면 false
		for (int i = 0; i < 9; i++) {
			if(sudoku[row][i] == number || sudoku[i][col] == number) return false;
		}

		// (row, col)이 속한 3 * 3 행렬을 찾음
		// row, col을 3 * 3 행렬의 첫번째 위치로 이동
		// 1,2,3 -> 0 / 4,5,6 -> 3 / 7,8,9 -> 6
		row = row / 3 * 3;
		col = col / 3 * 3;

		// 3 * 3 행렬에서 같은 숫자가 있으면 false
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (sudoku[row + i][col + j] == number) {
					return false;
				}
			}
		}

		// 모두 통과하면 true
		return true;
	}

}
