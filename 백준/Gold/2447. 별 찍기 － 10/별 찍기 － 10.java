import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

	static int N, K;
	static char[][] star;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(br.readLine());
		star = new char[N][N];

		// 공백으로 초기화
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				star[i][j] = ' ';
			}
		}

		drawStar(0, 0, N);

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				sb.append(star[i][j]);
			}
			sb.append("\n");
		}

		System.out.println(sb);

		br.close();
	}


	static void drawStar(int r, int c, int size) {
		// 기저 조건
		if (size == 1) {
			star[r][c] = '*';
			return;
		}

		// size * size 정사각형을 3 * 3 그리드로 나눔
		int newSize = size / 3;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (i == 1 && j == 1) continue; // 가운데 칸 공백 처리
				// 새로운 좌표에서 재귀 호출
				drawStar(r + i * newSize, c + j * newSize, newSize);
			}
		}
	}
}
