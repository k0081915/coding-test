import java.util.*;

class Solution {

	public static void main(String[] args) {

		String[][] plans = {{"science", "12:40", "50"},
		{"music", "12:20", "40"},
		{"history", "14:00", "30"},
		{"computer", "12:30", "100"}};

		System.out.println(Arrays.toString(solution(plans)));

	}

	static HashMap<Integer, String> hashMap = new HashMap<>();

	// 과제 시작 시간 순서대로 진행
	// 진행 중에 다른 과제가 시작되면 다른 과제부터 먼저 진행
	// 다른 과제 끝냈는데 잠시 멈춰둔 과제가 있으면 그거부터 수행
	// 멈춰둔 과제가 많으면 가장 최근에 멈춘 과제부터 수행
    public static String[] solution(String[][] plans) {
        String[] answer = {};

		// 과제 배열 int형으로 리팩토링
		int[][] newPlans = refactoring(plans);

		answer = solve(newPlans);

		return answer;
	}

	static String[] solve(int[][] plans) {
		String[] result = new String[plans.length];
		ArrayDeque<Integer[]> taskQ = new ArrayDeque<>();

		int time = 0;
		int index = 0;
		for (int[] plan : plans) {
			int id = plan[0];
			int start = plan[1];
			int playtime = plan[2];

			// 현재 과제 시작 시간보다 빨리 이전 과제를 끝낼 수 있는 경우
			while (!taskQ.isEmpty() && time + taskQ.peekFirst()[1] <= start) {
				time += taskQ.peekFirst()[1]; // 현재 시간 갱신
				result[index++] = hashMap.get(taskQ.pollFirst()[0]); // 결과 배열에 끝난 과제 이름 저장
			}

			// taskQ가 비어있으면
			if (taskQ.isEmpty()) {
				// taskQ에 과제 id와 과제 해결 시간을 마지막에 넣어줌
				taskQ.addLast(new Integer[]{id, playtime});
				time = start; // 현재 시간 갱신
			} else if (time + taskQ.peekFirst()[1] > start) { // 현재 과제 시작 시간보다 현재 시간 + 큐에 들어있는 과제 해결시간이 크면
				// 큐에 들어있는 과제 해결시간을 진행한 시간만큼 감소
				taskQ.peekFirst()[1] -= (start - time);
				// 가장 최근에 멈춘 과제부터 시작해야 하므로 큐의 맨 앞에 추가
				taskQ.addFirst(new Integer[]{id, playtime});
				time = start; // 현재 시간 갱신
			}
		}

		// 큐에 과제가 남아있으면 앞에서 부터 빼서 결과 배열에 넣어줌
		while (!taskQ.isEmpty()) {
			result[index++] = hashMap.get(taskQ.pollFirst()[0]);
		}

		return result;
	}

	static int[][] refactoring(String[][] plans) {
		// 시작 시간 오름차순으로 정렬
		Arrays.sort(plans, (a, b) -> a[1].compareTo(b[1]));
		// int 형의 plans
		int[][] intPlans = new int[plans.length][3];
		for (int i = 0; i < plans.length; i++) {
			intPlans[i][0] = i;
			intPlans[i][1] = timeToInt(plans[i][1]);
			intPlans[i][2] = Integer.parseInt(plans[i][2]);
			hashMap.put(i, plans[i][0]); // id와 과제이름을 매핑
		}

		return intPlans;
	}

	// hh:mm -> 분으로 나타냄 12:20 -> 740
	static int timeToInt(String time) {
		return Integer.parseInt(time.substring(0, 2)) * 60 + Integer.parseInt(time.substring(3, 5));
	}
}