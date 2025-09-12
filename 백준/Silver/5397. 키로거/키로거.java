import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {


	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		List<Character> list = new LinkedList<>();

		int N = Integer.parseInt(br.readLine());

		int cnt = 0;
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			list = new LinkedList<>();
			cnt = 0;
			for (int j = 0; j < str.length(); j++) {
				char c = str.charAt(j);
				if (c == '<') {
					cnt--;
					if (cnt < 0) {
						cnt = 0;
					}
				} else if (c == '>') {
					cnt++;
					if (cnt > list.size()) {
						cnt = list.size();
					}
				} else if (c == '-') {
					if (cnt > 0) {
						list.remove(--cnt);
					}
				} else {
					list.add(cnt++, c);
				}
			}
			for (Character c : list) {
				sb.append(c);
			}
			sb.append('\n');
		}

		System.out.println(sb);

		br.close();
	}
}