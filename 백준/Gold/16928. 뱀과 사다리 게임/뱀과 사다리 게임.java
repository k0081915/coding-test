import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

	static int N, M;
	static int[] count = new int[101];// 각 칸에 도착하기까지 걸린 주사위 횟수
	static boolean[] visited = new boolean[101]; // 방문 처리

	static HashMap<Integer, Integer> ladder = new HashMap<>(); // 사다리
	static HashMap<Integer, Integer> snake = new HashMap<>(); // 뱀

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			// 사다리 칸은 유일하기 때문에 탐색하기 쉽게 해시맵에 시작점과 끝점을 넣는다
			ladder.put(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			// 뱀 칸은 유일하기 때문에 탐색하기 쉽게 해시맵에 시작점과 끝점을 넣는다
			snake.put(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}

		count[1] = 0; // 시작점은 0으로 초기화
		visited[1] = true; // 시작점을 방문처리 한다
		bfs(1); // 시작점에서 bfs 호출

		System.out.println(count[100]); // 100 칸의 count 수 출력

		br.close();
	}

	static void bfs(int start) {
		// 큐에 시작점을 넣음
		Queue<Integer> queue = new LinkedList<>();
		queue.add(start);

		while (!queue.isEmpty()) {
			int current = queue.poll();

			// 각 위치에서 1~6을 더한 위치를 모두 확인
			for (int i = 1; i <= 6; i++) {
				int next = current + i;
				if (next > 100) return; // 다음 위치가 100이 넘으면 return
				if(visited[next]) continue; // 이미 방문한 위치라면 continue

				// 다음 위치가 사다리 칸이면 위치를 사다리 타고 올라간 위치로 결정
				if (ladder.containsKey(next)) {
					next = ladder.get(next);
				}
				// 다음 위치가 뱀 칸이면 위치를 뱀 타고 내려간 위치로 결정
				else if (snake.containsKey(next)) {
					next = snake.get(next);
				}

				// 방문하지 않은 위치면
				if (!visited[next]) {
					visited[next] = true; // 방문 처리
					queue.add(next); // 큐에 추가
					count[next] = count[current] + 1; // 전 위치의 주사위 카운트 + 1 해줌
				}
			}
		}
	}

}