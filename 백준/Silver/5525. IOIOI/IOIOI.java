import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {


	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		List<Character> list = new LinkedList<>();

		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		String str = br.readLine();

		int count = 0; // 연속된 IOI 패턴 개수
		int result = 0; // 최종 개수
		for (int i = 0; i < M - 2; i++) {
			// 현재 위치에서 연속된 세 글자가 IOI 인지 확인
			if (str.charAt(i) == 'I' && str.charAt(i + 1) == 'O' && str.charAt(i + 2) == 'I') {
				count++; // 연속 카운트 증가

				// 연속 카운트가 N에 도달하면 P_N을 찾은 것
				if (count == N) {
					result++; // 최종 개수 증가
					// 다음 IOI는 이전 I를 공유한다
					// IOIOI (N=2)에서 다음 IOI는 세번째 I부터 시작
					// 따라서 count를 하나 줄여야 한다
					count--;
				}
				i++; // OI 만큼 건너뛰기
			} else {
				count = 0;	// 패턴이 깨지면 초기화
			}
		}

		System.out.println(result);

		br.close();
	}
}