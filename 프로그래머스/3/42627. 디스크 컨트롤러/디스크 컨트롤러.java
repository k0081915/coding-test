import java.util.*;

class Solution {

	public static void main(String[] args) {

		// 1 <= jobs <= 500
		// [작업 요청 시점, 작업 소요 시간]
		// 1. 작업 소요 시간 짧음 / 2. 작업 요청 시간 빠름 / 3. 작업의 번호 작음 순으로 우선순위 높음
		int[][] jobs = {{0, 10}, {0, 1}, {100, 1}};

		System.out.println(solution(jobs));

	}

    public static int solution(int[][] jobs) {
		Queue<Job> queue = new LinkedList<>();
		PriorityQueue<Job> waitQueue = new PriorityQueue<>();

		// 작업을 시작 순서 오름차순으로 정렬
		// 시작 순서가 같으면 작업 소요 시간 오름차순 정렬
		Arrays.sort(jobs, (a, b) -> {
			if (a[0] == b[0]) {
				return Integer.compare(a[1], b[1]);
			}
			return Integer.compare(a[0], b[0]);
		});

		// 큐에 id를 매긴 작업을 순서대로 넣음
		for (int i = 0; i < jobs.length; i++) {
			queue.add(new Job(i, jobs[i][0], jobs[i][1]));
		}

		// 현재 시간을 초기 작업의 시작 시간으로 설정
		int cur = queue.peek().start;
		int total = 0;
		waitQueue.add(queue.poll()); // 대기 큐에 초기 작업을 추가

		while (!waitQueue.isEmpty()) {
			// 큐에 시작 시간이 같은 것이 있는지 확인
//			while (!queue.isEmpty() && cur > queue.peek().start) {
//				// 있으면 시작시간이 다르거나 큐가 빌 때까지 대기 큐에 추가
//				waitQueue.add(queue.poll());
//			}

			// 대기 큐의 가장 앞에 있는 작업의 시작 시간이 현재 시간과 같거나 작으면 수행 가능
			if (waitQueue.peek().start <= cur) {
				Job curJob = waitQueue.poll(); // 대기 큐에서 하나 꺼냄
				cur += curJob.work; // 현재 시간에 작업 시간 더함
				total += cur - curJob.start; // 전체 시간에 작업이 완료되는데 걸린 총 시간 더함

				// 큐가 비어있지 않으면
				if (!queue.isEmpty()) {
					// 현재 시간보다 시작 시간이 작은 작업을 조건 만족하는 동안 대기 큐에 추가
					while (!queue.isEmpty() && cur >= queue.peek().start) {
						waitQueue.add(queue.poll());
					}
				}
			}

			// 큐가 비어있지 않은데
			if (!queue.isEmpty()) {
				// 대기 큐가 비어있다면
				if (waitQueue.isEmpty()) {
					// 현재 시간을 가장 최근 요청 작업의 시작 시간으로 맞추고
					cur = queue.peek().start;
					// 가장 최근 요청 작업을 대기 큐에 추가
					waitQueue.add(queue.poll());
				}
			}

		}

		return total / jobs.length;
	}

}

class Job implements Comparable<Job> {
	int id, start, work;

	public Job(int id, int start, int work) {
		this.id = id;
		this.start = start;
		this.work = work;
	}

	@Override
	public int compareTo(Job o) {
		// 1. 작업 소요 시간 짧음 / 2. 작업 요청 시간 빠름 / 3. 작업의 번호 작음 순으로 우선순위 높음
		if (work == o.work) {
			if (start == o.start) {
				return Integer.compare(id, o.id);
			}
			return Integer.compare(start, o.start);
		}
		return Integer.compare(work, o.work);
	}

}