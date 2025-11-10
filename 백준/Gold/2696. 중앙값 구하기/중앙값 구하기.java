import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

	static int T;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();

		T = Integer.parseInt(br.readLine());
		while (T-- > 0) {
			PriorityQueue<Integer> maxQ = new PriorityQueue<>(Comparator.reverseOrder()); // 내림차순 큐
			PriorityQueue<Integer> minQ = new PriorityQueue<>(); // 오름차순 큐
			int M = Integer.parseInt(br.readLine());
			int cnt = 0;

			sb.append(M / 2 + 1).append("\n"); // 중앙값 개수

			for (int i = 0; i < M; i++) {
				// 10개씩 입력
				if (i % 10 == 0) {
					st = new StringTokenizer(br.readLine());
				}
				int x = Integer.parseInt(st.nextToken());

				// minQ와 maxQ에 값을 번갈아가며 넣는다
				if (minQ.size() == maxQ.size()) {
					maxQ.offer(x);
				} else {
					minQ.offer(x);
				}

				if (!minQ.isEmpty()) { // minQ가 비어있지 않다면
					if (maxQ.peek() > minQ.peek()) { // maxQ 최댓값 > minQ 최솟값이면
						// 값을 서로 교환해줌
						int p1 = maxQ.poll();
						int p2 = minQ.poll();

						maxQ.offer(p2);
						minQ.offer(p1);
						// maxQ에는 중앙값보다 작거나 같은 값이 들어있고
						// minQ에는 중앙값보다 큰 값이 들어있게 된다
					}
				}

				// 홀수 번째일 때 (index는 짝수)
				if (i % 2 == 0) {
					// 10개씩 나눠서 출력
					// maxQ의 최댓값을 출력하면 중앙값이다
					if (cnt == 9 || i == M - 1) {
						sb.append(maxQ.peek() + "\n");
						cnt = 0;
					} else {
						sb.append(maxQ.peek() + " ");
					}
					cnt++;
				}
			}
		}

		System.out.println(sb);

		br.close();
	}
}
