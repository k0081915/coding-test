import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

	static int N, M;
	static int[] arr;
	static int[] input;
	static int[] numbers;

	static List<String> list = new ArrayList<>();

	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
//		StringBuilder sb = new StringBuilder();

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		input = new int[N];
		arr = new int[M];
		numbers = new int[M];


		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			input[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(input);
		combi(0);

		for (String s : list) {
			sb.append(s + "\n");
		}

		System.out.println(sb);

		br.close();
	}

	static void combi(int idx) {
		if (idx == M) {
			for (int i = 0; i < M - 1; i++) {
				if (arr[i] > arr[i + 1]) {
					return;
				}
			}

			String str = "";
			for (int i = 0; i < M; i++) {
				str += arr[i] + " ";
			}

			if(list.contains(str)) return;
			list.add(str);

			return;
		}

		for (int i = 0; i < N; i++) {
			arr[idx] = input[i];
			combi(idx + 1);
		}
	}
}
