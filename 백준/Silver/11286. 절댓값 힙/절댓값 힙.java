import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {


	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		// 우선순위 큐를 선언할 때 정렬기준을 절댓값으로 비교한다고 해준다
		PriorityQueue<Long> queue = new PriorityQueue<>((o1, o2) -> {
			// 절댓값이 같으면 작은 것을 먼저 출력하게 한다
			if(Math.abs(o1) == Math.abs(o2)) return Long.compare(o1, o2);
			return Long.compare(Math.abs(o1), Math.abs(o2));
		});
		int N = Integer.parseInt(br.readLine());

		for (int i = 0; i < N; i++) {
			long num = Long.parseLong(br.readLine());
			// 입력이 0이면
			if (num == 0) {
				// 큐가 비어있으면 0 출력
				if (queue.isEmpty()) {
					sb.append(0).append('\n');
				} else {
					// 비어있지 않으면 값 출력
					sb.append(queue.poll()).append('\n');
				}
			} else {
				// 입력이 0이 아니면 큐에 추가
				queue.add(num);
			}
		}

		System.out.println(sb);

		br.close();
	}
}