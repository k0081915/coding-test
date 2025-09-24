import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

	static int N;
	static int[][] status;
	static boolean[] visited;
	static int[] arr;

	static int min = Integer.MAX_VALUE;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(br.readLine());
		status = new int[N + 1][N + 1];
		visited = new boolean[N + 1];
		arr = new int[N + 1];

		// 능력치 배열 입력
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				status[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		combi(0);

		System.out.println(min);

		br.close();
	}

	static void combi(int idx) {


		// N 명의 팀원이 모두 뽑혔을 경우
		if (idx == N) {
			diff(); // 두 팀 능력치 차이 계산
			return;
		}

		visited[idx] = true; // 방문 처리
		combi(idx + 1); // 재귀 호출
		visited[idx] = false; // 다음 조합을 위해 false 처리
		combi(idx + 1);

	}

	static void diff() {
		ArrayList<Integer> startTeam = new ArrayList<>();
		ArrayList<Integer> linkTeam = new ArrayList<>();

		for (int i = 1; i <= N; i++) {
			if(visited[i]) startTeam.add(i); // 방문했다면 스타트 팀
			else linkTeam.add(i); // 방문하지 않았다면 링크 팀
		}

		int sum1 = 0;
		int sum2 = 0;

		// 스타트 팀 능력치 계산
		for (int i = 0; i < startTeam.size() - 1; i++) {
			for (int j = i + 1; j < startTeam.size(); j++) {
				int member1 = startTeam.get(i);
				int member2 = startTeam.get(j);
				sum1 += status[member1][member2] + status[member2][member1];
			}
		}

		// 링크 팀 능력치 계산
		for (int i = 0; i < linkTeam.size() - 1; i++) {
			for (int j = i + 1; j < linkTeam.size(); j++) {
				int member1 = linkTeam.get(i);
				int member2 = linkTeam.get(j);
				sum2 += status[member1][member2] + status[member2][member1];
			}
		}

		// 능력치 차이 계산 후 최솟값 갱신
		int diff = Math.abs(sum1 - sum2);
		min = Math.min(min, diff);
	}

	static int countPeople() {
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			if (!visited[i]) {
				cnt++;
			}
		}

		return cnt;
	}

}