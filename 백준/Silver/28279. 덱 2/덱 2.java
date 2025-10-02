import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

	static int N;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		Deque<Integer> deque = new ArrayDeque<>();
		int N = Integer.parseInt(br.readLine());
		while (N-- > 0) {
			st = new StringTokenizer(br.readLine());
			int cmd = Integer.parseInt(st.nextToken());

			if (cmd == 1) {
				int num = Integer.parseInt(st.nextToken());
				deque.addFirst(num);
			} else if (cmd == 2) {
				int num = Integer.parseInt(st.nextToken());
				deque.addLast(num);
			} else if (cmd == 3) {
				if (!deque.isEmpty()) {
					System.out.println(deque.removeFirst());
				} else {
					System.out.println(-1);
				}
			} else if (cmd == 4) {
				if (!deque.isEmpty()) {
					System.out.println(deque.removeLast());
				} else {
					System.out.println(-1);
				}
			} else if (cmd == 5) {
				System.out.println(deque.size());
			} else if (cmd == 6) {
				if (deque.isEmpty()) {
					System.out.println(1);
				} else {
					System.out.println(0);
				}
			} else if (cmd == 7) {
				if (!deque.isEmpty()) {
					System.out.println(deque.peekFirst());
				} else {
					System.out.println(-1);
				}
			} else {
				if (!deque.isEmpty()) {
					System.out.println(deque.peekLast());
				} else {
					System.out.println(-1);
				}
			}
		}

		br.close();
	}

}