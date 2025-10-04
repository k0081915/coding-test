import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {


	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		Map<String, Integer> map = new HashMap<>();
		List<String> list;

		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		while (N-- > 0) {
			String str = br.readLine();
			if(str.length() < M) continue;

			map.put(str, map.getOrDefault(str, 1) + 1);
			
		}

		list = new ArrayList<>(map.keySet());

		list.sort((o1, o2) -> {
			if (Objects.equals(map.get(o1), map.get(o2))) {
				if (o1.length() == o2.length()) {
					return o1.compareTo(o2);
				} else {
					return Integer.compare(o2.length(), o1.length());
				}
			}
			return Integer.compare(map.get(o2), map.get(o1));
		});

		for (String s : list) {
			sb.append(s).append("\n");
		}
		System.out.println(sb);

		br.close();
	}



}