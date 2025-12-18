import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

	static char[][] map;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());

		// 세로: N, 가로: 2 * N - 1
		map = new char[N][2 * N - 1];

		// 배열을 공백으로 초기화
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < 2 * N - 1; j++) {
				map[i][j] = ' ';
			}
		}

		// 재귀 시작 (행 0, 열 N-1이 꼭짓점)
		draw(0, N - 1, N);

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < 2 * N - 1; j++) {
				sb.append(map[i][j]);
			}
			sb.append('\n');
		}

		System.out.println(sb);
		br.close();
	}

	static void draw(int r, int c, int n) {
		// 기저 조건: 높이가 3일 때 직접 그리기
		if (n == 3) {
			map[r][c] = '*';			// 1번째 줄
			map[r + 1][c - 1] = '*';	// 2번째 줄
			map[r + 1][c + 1] = '*';
			map[r + 2][c - 2] = '*';	// 3번째 줄
			map[r + 2][c - 1] = '*';
			map[r + 2][c] = '*';
			map[r + 2][c + 1] = '*';
			map[r + 2][c + 2] = '*';
			return;
		}

		int size = n / 2;

		// 그려야 하는 꼭짓점을 좌표로 넘긴다
		// 위쪽 삼각형
		draw(r, c, size);

		// 왼쪽 아래 삼각형
		draw(r + size, c - size, size);

		// 오른쪽 아래 삼각형
		draw(r + size, c + size, size);
	}
}
