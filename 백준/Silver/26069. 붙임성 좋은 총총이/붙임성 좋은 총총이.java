import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {


	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int cnt = 0;
		Map<String, Boolean> map = new HashMap<>();
		int N = Integer.parseInt(br.readLine());
		while (N-- > 0) {
			st = new StringTokenizer(br.readLine());
			String str1 = st.nextToken();
			String str2 = st.nextToken();

			if (str1.equals("ChongChong") || str2.equals("ChongChong")) {
				map.put(str1, true);
				map.put(str2, true);
				continue;
			}

			if (map.getOrDefault(str1, false)) {
				map.put(str2, map.getOrDefault(str1, false));
			} else if (map.getOrDefault(str2, false)) {
				map.put(str1, map.getOrDefault(str2, false));
			} else {
				map.put(str1, false);
				map.put(str2, false);
			}

		}

		for (String s : map.keySet()) {
			if (map.get(s)) {
				cnt++;
			}
		}

		System.out.println(cnt);

		br.close();
	}



}