import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

	// 무게, 가치를 갖는 보석 클래스
	static class Bo {
		int weight;
		int value;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();

		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		Bo[] bo = new Bo[N];
		int[] bag = new int[K];
		long sum = 0;

		// 최대 힙, 가치가 높은 것부터 나오도록
		PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());

		// 보석 입력
		for (int i = 0; i < N; i++) {
			bo[i] = new Bo();
			st = new StringTokenizer(br.readLine());
			int w = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			bo[i].weight = w;
			bo[i].value = v;
		}

		// 가방 입력
		for (int i = 0; i < K; i++) {
			bag[i] = Integer.parseInt(br.readLine());
		}

		// 보석 무게 오름차순으로 정렬
		Arrays.sort(bo, Comparator.comparingInt(o -> o.weight));

		// 가방 오름차순 정렬
		Arrays.sort(bag);

		// 보석 인덱스
		int boIdx = 0;
		// 가방 개수만큼 순회
		for (int i = 0; i < K; i++) {
			int C = bag[i]; // 현재 가방 용량
			// 보석 인덱스가 N보다 작고 현재 보석 무게가 가방 용량보다 작거나 같을때
			while (boIdx < N && bo[boIdx].weight <= C) {
				queue.add(bo[boIdx].value); // 큐에 보석 가치 추가
				boIdx++; // 인덱스  +1
			}
			// 큐가 비어있지 않다면
			if (!queue.isEmpty()) {
				sum += queue.poll(); // 가치가 가장 큰 것을 꺼내서 더함
			}
		}

		System.out.println(sum);
		br.close();
	}
}
