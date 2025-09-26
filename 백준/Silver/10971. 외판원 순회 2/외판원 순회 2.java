import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

	static int N;
	static boolean[] visited; // 방문 배열
	static int[][] arr; // 뽑아낸 수
	static int[] input;

	static int max = Integer.MIN_VALUE;
	static int minCost = Integer.MAX_VALUE;


	static int sum;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
//		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(br.readLine());
		// 초기화
		visited = new boolean[N];
		arr = new int[N][N];
		input = new int[N];


		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < N; i++) {
			visited[i] = true; // 시작 지점 방문 처리
			recur(i, i, 0, 0); // 0번 도시부터 재귀 호출
			visited = new boolean[N]; // 방문 배열 초기화
		}

		System.out.println(minCost);

		br.close();
	}

	static void recur(int start, int cur, int depth, int cost) {
		// 현재 비용이 최소 비용을 넘었다면 return
		if (cost >= minCost) {
			return;
		}

		// N개의 도시를 모두 방문했을 경우 
		if (depth == N - 1) {
			// 마지막 도시에서 출발 도시로 돌아올 수 있는지 확인
			if (arr[cur][start] != 0) {
				// 최솟값 갱신
				minCost = Math.min(minCost, cost + arr[cur][start]);
			}
			return;
		}

		for (int i = 0; i < N; i++) {
			// 방문했거나 갈 수 없는 경우면 continue
			if(visited[i] || arr[cur][i] == 0) continue;
			visited[i] = true; // 방문 처리
			recur(start, i, depth + 1, cost + arr[cur][i]); // 비용을 더해줌
			visited[i] = false; // 다음을 위해 false 처리
		}
	}

}