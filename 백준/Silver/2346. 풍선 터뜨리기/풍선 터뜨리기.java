import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

	static int N;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		Deque<int[]> queue = new ArrayDeque<>();
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		sb.append("1 ");
		int num = arr[0];

		for (int i = 1; i < N; i++) {
			queue.add(new int[]{i + 1, arr[i]});
		}

		while(!queue.isEmpty()) {
			if (num > 0) {
				for (int i = 1; i < num; i++) {
					queue.add(queue.poll());
				}
				int[] poll = queue.poll();
				num = poll[1];
				sb.append(poll[0] + " ");
			} else {
				for (int i = 1; i < -num; i++) {
					queue.addFirst(queue.pollLast());
				}
				int[] poll = queue.pollLast();
				num = poll[1];
				sb.append(poll[0] + " ");
			}
		}
		System.out.println(sb);

		br.close();
	}

}