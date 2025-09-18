import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

// (숫자, 명령어) 쌍
class Pair {
	int num;
	String cmd;

	public Pair(int num, String cmd) {
		this.num = num;
		this.cmd = cmd;
	}
}

public class Main {


	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();


		int T = Integer.parseInt(br.readLine());
		while (T-- > 0) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());

			bfs(A, B);
		}

		br.close();
	}

	static void bfs(int A, int B) {
		boolean[] visited = new boolean[10000]; // 방문 처리 배열
		Queue<Pair> queue = new LinkedList<>();

		visited[A] = true; // 초기 숫자 A를 방문 처리
		queue.add(new Pair(A, "")); // 큐에 숫자와 명령어 쌍을 넣어준다

		while (!queue.isEmpty()) {
			Pair current = queue.poll(); // 현재 쌍을 꺼낸다
			int curNum = current.num; // 현재 숫자
			String curCmd = current.cmd; // 현재까지 명령어

			// 현재 숫자와 B가 같으면 현재까지 명령어를 출력한다
			if (curNum == B) {
				System.out.println(curCmd);
				return;
			}

			// 각 명령어에 맞는 숫자를 구해준다
			int nextNumD = (curNum * 2) % 10000; // 2배
			int nextNumS = (curNum - 1 >= 0) ? curNum - 1 : 9999; // -1
			int nextNumL = (curNum < 1000) ? curNum * 10 :
							(curNum % 1000) * 10 + curNum / 1000; // 왼쪽 이동
			int nextNumR = (curNum % 10) * 1000 + curNum / 10; // 오른쪽 이동

			// 각 숫자를 방문하지 않았으면 수행
			// 방문처리를 하고
			// (해당 숫자, 현재까지 명령어에 각 명령어를 더한 문자열)을 큐에 넣어준다
			if (!visited[nextNumD]) {
				visited[nextNumD] = true;
				queue.add(new Pair(nextNumD, curCmd + "D"));
			}
			if (!visited[nextNumS]) {
				visited[nextNumS] = true;
				queue.add(new Pair(nextNumS, curCmd + "S"));
			}
			if (!visited[nextNumL]) {
				visited[nextNumL] = true;
				queue.add(new Pair(nextNumL, curCmd + "L"));
			}
			if (!visited[nextNumR]) {
				visited[nextNumR] = true;
				queue.add(new Pair(nextNumR, curCmd + "R"));
			}
		}
	}
}