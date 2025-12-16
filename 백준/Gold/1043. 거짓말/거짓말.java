import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

	static int N, M;
	static int[] parent;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		// 유니온 파인드 용 부모 배열 초기화
		parent = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			parent[i] = i;
		}

		// 진실을 아는 사람들 정보 저장
		st = new StringTokenizer(br.readLine());
		int truthNum = Integer.parseInt(st.nextToken());
		int[] truePeople = new int[truthNum];
		for (int i = 0; i < truthNum; i++) {
			truePeople[i] = Integer.parseInt(st.nextToken());
		}

		// 파티 정보 저장
		ArrayList<Integer>[] party = new ArrayList[M];
		for (int i = 0; i < M; i++) {
			party[i] = new ArrayList<>();
			st = new StringTokenizer(br.readLine());
			int come = Integer.parseInt(st.nextToken());

			int first = Integer.parseInt(st.nextToken());
			party[i].add(first);

			// 같은 파티에 온 사람들을 모두 같은 집합으로 묶음
			for (int j = 1; j < come; j++) {
				int next = Integer.parseInt(st.nextToken());
				party[i].add(next);
				union(first, next); // 첫번째 사람과 연결
			}
		}

		// 모든 파티 연결이 끝난 후, 갈 수 있는 파티 카운트
		int answer = 0;
		for (int i = 0; i < M; i++) {
			boolean isPossible = true;

			// 파티 참여자 중 한 명이라도 진실을 아는 사람과 연결되어 있는지 확인
			if (!party[i].isEmpty()) {
				int partyPerson = party[i].get(0); // 파티의 대표 한명만 확인해도 됨 (이미 묶였으므로)
				int partyRoot = find(partyPerson); // 파티원이 속한 파티의 대표 확인

				// 각 파티의 대표가 진실을 아는 사람들과 같은 집합이면
				// isPossible을 false로 바꾼뒤 break
				for (int truePerson : truePeople) {
					if (partyRoot == find(truePerson)) {
						isPossible = false;
						break;
					}
				}
			}

			// 거짓을 말할 수 있다면 answer++
			if (isPossible) {
				answer++;
			}
		}

		System.out.println(answer);

		br.close();
	}


	static int find(int x) {
		// 자기 자신의 부모가 자기 자신이면 더 이상 위로 올라갈 곳이 없음
		if (parent[x] == x) {
			return x;
		}
		// 재귀 호출 + 경로 압축
		// 자신의 부모의 진짜 부모를 찾아서 자신의 부모를 진짜 부모로 바꿈
		return parent[x] = find(parent[x]);
	}

	// 각 파티마다 참여 인원끼리 서로 연결된 그래프 형성
	static void union(int a, int b) {
		a = find(a);
		b = find(b);
		if (a != b) {
			parent[b] = a;
		}
	}
}
