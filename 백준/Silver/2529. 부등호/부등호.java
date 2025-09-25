import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

	static int N;
	static boolean[] visited;
	static int[] arr;
	static String[] simbol;

	static int[] maxNum;
	static int[] minNum;

	static long max = Long.MIN_VALUE;
	static long min = Long.MAX_VALUE;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(br.readLine());
		visited = new boolean[10];
		arr = new int[N + 1];
		simbol = new String[N];
		maxNum = new int[N + 1];
		minNum = new int[N + 1];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			simbol[i] = st.nextToken();
		}


		combi(0);

		for (int i = 0; i < maxNum.length; i++) {
			sb.append(maxNum[i]);
		}
		sb.append("\n");
		for (int i = 0; i < minNum.length; i++) {
			sb.append(minNum[i]);
		}

		System.out.println(sb);
		br.close();
	}

	static void combi(int idx) {


		if (idx == N + 1) {
			for (int i = 0; i < N; i++) {
				if (simbol[i].equals("<")) {
					if (arr[i] > arr[i + 1]) return;
				} else {
					if(arr[i] < arr[i + 1]) return;
				}
			}
			String str = "";
			for (int i = 0; i < N + 1; i++) {
				str += String.valueOf(arr[i]);
			}
			long num = Long.parseLong(str);
			if (max < num) {
				max = num;
				maxNum = arr.clone();
			}
			if (min > num) {
				min = num;
				minNum = arr.clone();
			}
			return;
		}

		for (int i = 0; i <= 9; i++) {
			if(visited[i]) continue;
			arr[idx] = i;
			visited[i] = true; // 방문 처리
			combi(idx + 1); // 재귀 호출
			visited[i] = false; // 다음 조합을 위해 false 처리
		}

	}



}