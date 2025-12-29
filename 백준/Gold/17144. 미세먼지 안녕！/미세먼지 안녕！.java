import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

	static int R, C, T;
	static int[][] arr;
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, -1, 0, 1};
	static ArrayList<Integer> refresh;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();

		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());

		arr = new int[R + 1][C + 1]; // 초기 배열
		refresh = new ArrayList<>(); // 공기청정기 위아래 좌표

		for (int i = 1; i <= R; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= C; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if(arr[i][j] == -1) refresh.add(i); // 공기청정기 위치를 저장
			}
		}

		for (int i = 0; i < T; i++) {
			spread(); // 미세먼지 확산
			operation(); // 공기청정기 작동
		}

		System.out.println(calculate());

		br.close();
	}

	static void spread() {

		// 확산을 한번에 해야 하기 때문에 원본 배열을 건드리지 않고 복사본을 사용함
		int[][] copy = new int[R + 1][C + 1];

		for (int i = 1; i <= R; i++) {
			for (int j = 1; j <= C; j++) {
				// 미세먼지가 있는 곳만 실행
				if (arr[i][j] > 0) {
					int cnt = 0; // 확산 가능한 인접 칸 개수
					int divide = arr[i][j] / 5;

					for (int k = 0; k < 4; k++) {
						int nx = i + dx[k];
						int ny = j + dy[k];

						// 이동한 위치가 배열 범위 X, 공기청정기 위치면 continue 
						if(nx <= 0 || nx > R || ny <= 0 || ny > C || arr[nx][ny] == -1) continue;

						cnt++; // 개수 + 1
						copy[nx][ny] += divide; // 인접 칸에 확산
					}
					// 자신의 값은 확산된 양만큼 빼줌
					copy[i][j] += arr[i][j] - cnt * divide;
				}

			}
		}

		// 원본 배열 갱신
		for (int i = 1; i <= R; i++) {
			for (int j = 1; j <= C; j++) {
				if (arr[i][j] != -1) {
					arr[i][j] = copy[i][j];
				}
			}
		}

	}

	static void operation() {
		upperOper(); // 위쪽 공기청정기
		lowerOper(); // 아래쪽 공기청정기
	}

	static void upperOper() {
		int upper = refresh.get(0); // 위쪽 공기청정기 x 좌표

		for (int i = upper - 1; i > 1; i--) arr[i][1] = arr[i - 1][1];
		for (int i = 1; i < C; i++) arr[1][i] = arr[1][i + 1];
		for (int i = 1; i < upper; i++) arr[i][C] = arr[i + 1][C];
		for (int i = C; i > 2; i--) arr[upper][i] = arr[upper][i - 1];
		arr[upper][2] = 0;
	}

	static void lowerOper() {
		int lower = refresh.get(1); // 아래쪽 공기청정기 x 좌표

		for (int i = lower + 1; i < R; i++) arr[i][1] = arr[i + 1][1];
		for (int i = 1; i < C; i++) arr[R][i] = arr[R][i + 1];
		for (int i = R; i > lower; i--) arr[i][C] = arr[i - 1][C];
		for (int i = C; i > 2; i--) arr[lower][i] = arr[lower][i - 1];
		arr[lower][2] = 0;
	}

	// 총 미세먼지 계산
	static int calculate() {
		int total = 0;
		for (int i = 1; i <= R; i++) {
			for (int j = 1; j <= C; j++) {
				if (arr[i][j] > 0) {
					total += arr[i][j];
				}
			}
		}
		return total;
	}
}
