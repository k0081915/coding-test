import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

	static int N, M;
	static int[] input;
	static int[] arr; // 출력 배열
	static boolean[] visited;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
//		StringBuilder sb = new StringBuilder();

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		input = new int[N];
		visited = new boolean[N];
		arr = new int[M];

		// 배열 입력
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			input[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(input); // 오름차순 정렬

		permu(0); // 순열 재귀

		System.out.println(sb);
		br.close();
	}

	static void permu(int idx) {
		if (idx == M) { // 인덱스가 M과 같아지면
			// 배열을 M개 만큼 출력
			for (int i = 0; i < M; i++) {
				sb.append(arr[i]).append(" ");
			}
			sb.append("\n");
			return;
		}
		
		for (int i = 0; i < N; i++) {
			if(visited[i]) continue; // 중복 숫자를 넣으면 안되기 때문에 방문 여부 확인
			arr[idx] = input[i]; // 출력 배열에 값 넣어준다
			visited[i] = true; // 방문 처리
			permu(idx + 1); // 재귀 호출
			visited[i] = false; // 다음을 위해 다시 false 처리
		}
	}
}