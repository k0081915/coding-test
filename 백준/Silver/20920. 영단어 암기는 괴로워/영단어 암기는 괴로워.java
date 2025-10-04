import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {


	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		Map<String, Integer> map = new HashMap<>();

		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		while (N-- > 0) {
			String str = br.readLine();
			if(str.length() < M) continue;

			// map에 추가
			// map에 str이 이미 존재하면 value + 1
			map.put(str, map.getOrDefault(str, 1) + 1);
		}

		// 리스트에 map의 키들을 추가해줌
		List<String> list = new ArrayList<>(map.keySet());

		list.sort((o1, o2) -> {
			// 단어 나온 횟수가 같으면
			if (Objects.equals(map.get(o1), map.get(o2))) {
				// 단어 길이가 같으면
				if (o1.length() == o2.length()) {
					// 사전순으로 앞인 단어를 앞으로
					return o1.compareTo(o2);
				} else { // 단어 길이가 다르면
					// 단어 길이가 긴 것을 앞으로
					return Integer.compare(o2.length(), o1.length());
				}
			}
			// 단어 나온 횟수가 많은 것을 앞으로
			return Integer.compare(map.get(o2), map.get(o1));
		});

		// 리스트 출력
		for (String s : list) {
			sb.append(s).append("\n");
		}
		System.out.println(sb);

		br.close();
	}



}