import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

	static int N;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());
		Deque<Integer> qs = new ArrayDeque<>();
		int[] qors = new int[N];
		int[] input = new int[N];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			qors[i] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			input[i] = Integer.parseInt(st.nextToken());
		}


		for (int i = 0; i < N; i++) {
			if (qors[i] == 0) {
				qs.addFirst(input[i]);
			}
		}

		int M = Integer.parseInt(br.readLine());
		int[] arr = new int[M];
		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < M; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			qs.add(arr[i]);
			sb.append(qs.pollFirst() + " ");
		}

		System.out.println(sb);

		br.close();
	}

}