import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

	static int N;
	static boolean[] visited; // 방문 배열
	static int[] arr; // 뽑아낸 수
	static int[] input;




	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
//		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(br.readLine());
		// 초기화
		visited = new boolean[N];
		arr = new int[N];
		input = new int[N];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			input[i] = Integer.parseInt(st.nextToken());
		}


		find();

		br.close();
	}

	static void find() {
		// 교환할 위치 i-1 찾기
		int i = N - 1;
		while (i > 0 && input[i - 1] >= input[i]) {
			i--;
		}
		// 마지막 순열인 경우 -1 출력
		if (i <= 0) {
			System.out.println(-1);
			return;
		}

		// 교환할 대상 j 찾기
		int j = N - 1;
		while (input[j] <= input[i - 1]) {
			j--;
		}

		// 두 값 교환
		swap(i - 1, j);

		// i부터 끝까지의 순열 뒤집기
		int k = N - 1;
		while (i < k) {
			swap(i, k);
			i++;
			k--;
		}

		// 결과 출력
		for (int num : input) {
			System.out.print(num + " ");
		}

	}

	static void swap(int i, int j) {
		int tmp = input[i];
		input[i] = input[j];
		input[j] = tmp;
	}




}