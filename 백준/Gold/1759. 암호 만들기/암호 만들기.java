import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

	static int L, C;
	static String[] input;
	static String[] arr;

	static boolean[] visited;

	static StringBuilder sb = new StringBuilder();

	static Set<String> aeiou = new HashSet<>(Arrays.asList("a", "e", "i", "o", "u"));

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
//		StringBuilder sb = new StringBuilder();

		st = new StringTokenizer(br.readLine());
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		arr = new String[C];
		input = new String[C];
		visited = new boolean[C];

		input = br.readLine().split(" ");
		Arrays.sort(input);

		permu(0, 0);
		System.out.println(sb);

		br.close();
	}

	static void permu(int idx, int start) {
		if (idx == L) {
			// 최소 1개 모음, 최소 2개 자음 체크
			if (check()) {
				for (int i = 0; i < L; i++) {
					sb.append(arr[i]);
				}
				sb.append("\n");
			}

			return;
		}

		for (int i = start; i < C; i++) {
			if(visited[i]) continue;
			arr[idx] = input[i];
			visited[i] = true;
			permu(idx + 1, i);
			visited[i] = false;
		}
	}

	static boolean check() {
		int cnt1 = 0, cnt2 = 0;
		for (int i = 0; i < L; i++) {
			if (aeiou.contains(arr[i])) {
				cnt1++;
			} else {
				cnt2++;
			}
		}
		return cnt1 >= 1 && cnt2 >= 2;
	}

}