import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

	static int count; // 방문 카운트

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());

		find(N, r, c);
		System.out.println(count);

		br.close();
	}

	// 분할 정복
	static void find(int N, int r, int c) {
		// N이 0이 되면 종료 (사각형이 더이상 안만들어짐)
		if (N == 0) {
			return;
		}

		// 주어진 N의 반을 구한다
		int half = (int) Math.pow(2, N - 1);
		int square = half * half; // 반으로 나눈 사각형의 넓이

		// 1사분면(왼쪽 위)
		if (r < half && c < half) {
			find(N - 1, r, c);
		}
		// 2사분면(오른쪽 위)
		else if (r < half && c >= half) {
			count += square; // 1시분면 크기만큼 더함
			find(N - 1, r, c - half); // 좌표 재조정
		}
		// 3사분면(왼쪽 아래)
		else if (r >= half && c < half) {
			count += 2 * square; // 1, 2사분면 크기만큼 더함
			find(N - 1, r - half, c); // 좌표 재조정
		}
		// 4사분면(오른쪽 아래)
		else {
			count += 3 * square; // 1, 2, 3사분면 크기만큼 더함
			find(N - 1, r - half, c - half); // 좌표 재조정
		}
	}
}