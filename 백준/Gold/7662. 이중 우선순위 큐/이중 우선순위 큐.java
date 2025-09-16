import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {


	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();


		// D 1 -> 최댓값 제거 (우선순위 큐 리버스)
		// D -1 -> 최솟값 제거 (우선순위 큐 기본)
		int T = Integer.parseInt(br.readLine());
		while (T-- > 0) {
			TreeMap<Long, Integer> map = new TreeMap<>();
			int k = Integer.parseInt(br.readLine());
			for (int i = 0; i < k; i++) {
				st = new StringTokenizer(br.readLine());
				String cmd = st.nextToken();
				long n = Long.parseLong(st.nextToken());

				if (cmd.equals("I")) {
					map.put(n, map.getOrDefault(n, 0) + 1);
				} else {
					if(map.isEmpty()) continue;
					if (n == 1) {
						long max = map.lastKey();
						if(map.get(max) == 1) map.remove(max);
						else map.put(max, map.get(max) - 1);
					} else {
						long min = map.firstKey();
						if(map.get(min) == 1) map.remove(min);
						else map.put(min, map.get(min) - 1);
					}
				}
			}
			if (map.isEmpty()) {
				sb.append("EMPTY\n");
			} else {
				sb.append(map.lastKey() + " " + map.firstKey()).append("\n");
			}
		}

		System.out.println(sb);

		br.close();
	}
}