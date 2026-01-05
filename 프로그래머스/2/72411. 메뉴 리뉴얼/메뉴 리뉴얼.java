import java.util.*;

/*
1. 각 손님들이 주문할 때 가장 많이 함께 주문한 단품메뉴를 코스요리 메뉴로
2. 코스요리 메뉴는 최소 2가지 이상 단품메뉴로 구성
3. 최소 2명 이상의 손님이 주문한 단품메뉴 조합
3-1. 단품메뉴 조합을 짰으면 그 조합이 무조건 다른 사람 주문에도 전체가 포함되어야 함
4. 정답은 사전순 오름차순으로 정렬
 */
class Solution {

	static Map<String, Integer> map; // 메뉴를 저장할 map
	static int max = 0; // 구성한 메뉴 중 가장 많이 나온 것을 코스요리로 구성해야 함

	// orders: 각 손님들이 주문한 단품메뉴
	// course: 추가하고 싶어하는 코스요리 단품메뉴 갯수
	public static String[] solution(String[] orders, int[] course) {

		ArrayList<String> list = new ArrayList<>(); // 코스요리 메뉴를 담을 리스트

		// 코스요리 배열 순회
		for (int c : course) {
			// map, max 초기화
			map = new HashMap<>();
			max = 0;

			// 주문 배열 순회
			for (String order : orders) {
				// 주문을 오름차순으로 정렬
				char[] str = order.toCharArray();
				Arrays.sort(str);
				order = new String(str);
				// dfs 호출
				dfs(order, "", -1, c, 0);
			}

			// map 순회
			for (String key : map.keySet()) {
				// 구성한 메뉴를 주문한 횟수가 2 이상이고 max 값고 같으면
				if (map.get(key) >= 2 && max == map.get(key)) {
					list.add(key); // 리스트에 추가
				}
			}
		}

		Collections.sort(list); // 오름차순으로 정렬

		// String 배열로 저장
		String[] answer = list.toArray(new String[list.size()]);

		return answer;
	}

	static void dfs(String order, String key, int index, int end, int depth) {
		// 구성한 메뉴 개수가 원하는 개수와 같아지면
		if (depth == end) {
			// map에 <해당 메뉴, 나온 개수> 를 저장한다
			map.put(key, map.getOrDefault(key, 0) + 1);
			// 최댓값 갱신
			max = Math.max(max, map.get(key));
			return;
		}

		// 개수가 같지 않으면 dfs 재귀 호출해서 맞을 때까지 반복
		for (int i = index + 1; i < order.length(); i++) {
			dfs(order, key + order.charAt(i), i, end, depth + 1);
		}
	}

}
