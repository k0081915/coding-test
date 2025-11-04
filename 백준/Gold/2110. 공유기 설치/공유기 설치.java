import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

	static int N, C;
	static int[] house;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		house = new int[N];

		for (int i = 0; i < N; i++) {
			house[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(house); // 정렬

		int high = house[N - 1] - house[0]; // 공유기 사이 최대 거리
		int low = 1; // 공유기 사이 최소 거리
		int answer = 0;

		// 이분 탐색 시작
		while (low <= high) {
			int mid = (low + high) / 2; // 죄대 최소의 반을 테스트
			if (isPossible(mid)) { // mid 거리에서 가능하면
				answer = mid; // 답 갱신
				low = mid + 1; // 더 큰 거리도 가능한지 탐색하기 위해 최소 거리를 갱신
			} else { // mid 거리에서 불가능하면
				high = mid - 1; // 거리를 줄여야 하므로 최대 거리 갱신
			}
		}

		System.out.println(answer);

		br.close();
	}

	// 설치 가능 여부 확인
	private static boolean isPossible(int mid) {
		// 첫번째 집에 공유기를 무조건 설치한다고 가정
		int count = 1;
		int last_position = house[0]; // 마지막 공유기 설치 위치

		for (int i = 1; i < N; i++) {
			// 현재 집이 마지막 설치 위치로부터 거리 mid 이상 떨어져 있다면
			if (house[i] - last_position >= mid) {
				// 공유기를 하나 설치하고 마지막 공유기 설치 위치 갱신
				count++;
				last_position = house[i];
			}
		}

		// count가 C 이상이면 true, 아니면 false
		return count >= C;
	}
}
