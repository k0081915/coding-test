import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

	static int N;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		Stack<Integer> stack = new Stack<>();
		N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		boolean flag = true;

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int start = 1;
		for (int i = 0; i < N; i++) {
			if (!stack.isEmpty()) {
				if (stack.peek() == start) {
					stack.pop();
					start++;
					i--;
					continue;
				}
			}

			if (arr[i] == start) {
				start++;
			} else {
				stack.push(arr[i]);
			}

		}

		while (!stack.isEmpty()) {
			if (stack.pop() != start) {
				flag = false;
				break;
			}
			start++;
		}

		if(flag) System.out.println("Nice");
		else System.out.println("Sad");


		br.close();
	}

}