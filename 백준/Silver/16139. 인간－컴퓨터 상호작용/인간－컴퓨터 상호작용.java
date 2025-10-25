import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();


		String str = br.readLine();
		int q = Integer.parseInt(br.readLine());

		String[] abc = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j",
				"k", "l", "m", "n", "o", "p", "q", "r", "s", "t",
				"u", "v", "w", "x", "y", "z"};
		HashMap<String, ArrayList<Integer>> map = new HashMap<>();

		for (int i = 0; i < 26; i++) {
			map.put(abc[i], new ArrayList<>());
		}
		for (int i = 0; i < str.length(); i++) {
			map.get(String.valueOf(str.charAt(i))).add(i);
//
//			if (map.containsKey(String.valueOf(str.charAt(i)))) {
//				map.get(String.valueOf(str.charAt(i))).add(i);
//			} else {
//				map.put(String.valueOf(str.charAt(i)), new ArrayList<>(List.of(i)));
//			}
		}

//		for (Map.Entry<String, ArrayList<Integer>> characterArrayListEntry : map.entrySet()) {
//			System.out.println("characterArrayListEntry.getKey() = " + characterArrayListEntry.getKey());
//			System.out.println("characterArrayListEntry.getValue() = " + characterArrayListEntry.getValue());
//			System.out.println("========");
//		}

		for (int i = 0; i < q; i++) {
			int cnt = 0;

			st = new StringTokenizer(br.readLine());
			String c = st.nextToken();
			int l = Integer.parseInt(st.nextToken());
			int r = Integer.parseInt(st.nextToken());

			ArrayList<Integer> list = map.get(c);
			for (int j = 0; j < list.size(); j++) {
				if (l <= list.get(j) && list.get(j) <= r) {
					cnt++;
				}
			}

			System.out.println(cnt);
		}

		br.close();
	}

}
