import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();


		int N = Integer.parseInt(br.readLine());
		int[] dist = new int[N - 1];
		int[] price = new int[N];
		int[] desc_price = new int[N];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N - 1; i++) {
			dist[i] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			price[i] = Integer.parseInt(st.nextToken());
		}

		// 비용이 최소가 되려면
		// 리터당 가격이 낮아지는 방향으로 가야한다
		desc_price[0] = price[0]; // 첫 도시는 반드시 기름을 넣어야 하므로 초기값
		for (int i = 1; i < N; i++) {
			// 현재 도시의 기름값이 내림차순 정렬된 이전 값보다 작으면 갱신
			// 작지 않으면 이전 값 그대로 저장
			desc_price[i] = Math.min(price[i], desc_price[i - 1]);
		}

		long result = 0;
		for (int i = 0; i < N - 1; i++) {
			// 마지막 도시를 제외하고 결과를 계산
			result += (long) desc_price[i] * dist[i];
		}

		System.out.println(result);

		br.close();
	}

}
