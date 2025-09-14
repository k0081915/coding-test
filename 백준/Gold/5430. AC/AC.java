import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

	static Deque<String> deque = new ArrayDeque<>();
	static int n;

	static StringBuilder sb = new StringBuilder();

	static boolean reverse = false;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
//		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		while (T-- > 0) {

			String p = br.readLine();
			n = Integer.parseInt(br.readLine());

			deque = new ArrayDeque<>();

			sb = new StringBuilder(br.readLine());
			sb.deleteCharAt(0);
			sb.deleteCharAt(sb.length() - 1);
			String[] str = sb.toString().split(",");

			if (n != 0) {
				for (int i = 0; i < str.length; i++) {
					deque.offerLast(str[i]);
				}
			}

			boolean flag = true;
			reverse = false;
			for (int i = 0; i < p.length(); i++) {
				if (p.charAt(i) == 'R') {
					reverse = !reverse;
				} else {
					if (!delete()) {
						flag = false;
						break;
					}
				}
			}
			if (flag) {
				printResult();
			}

		}

		br.close();
	}

	private static void printResult() {

//		if (deque.isEmpty()) {
//			System.out.println("error");
//			return;
//		}
		sb = new StringBuilder();
		sb.append("[");
		if (n != 0) {
			if(!deque.isEmpty()) {
				if (reverse) {
					while (deque.size() > 1) {
						sb.append(deque.removeLast()).append(",");
					}
					sb.append(deque.removeLast());
				} else {
					while (deque.size() > 1) {
						sb.append(deque.removeFirst()).append(",");
					}
					sb.append(deque.removeFirst());
				}
			}
		}
		sb.append("]");

		System.out.println(sb);
	}

	private static boolean delete() {

		if (deque.isEmpty()) {
			System.out.println("error");
			return false;
		}
		if (reverse) {
			deque.removeLast();
		} else {
			deque.removeFirst();
		}
		return true;
	}

}