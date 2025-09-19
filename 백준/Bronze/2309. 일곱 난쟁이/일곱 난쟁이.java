import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

	static int[] input = new int[9];
	static int[] arr = new int[9];
	static boolean[] visited = new boolean[9];
	static int[] little = new int[7];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < 9; i++) {
			input[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(input);

		permu(0, 0);

		Arrays.sort(little);
		for (int i : little) {
			System.out.println(i);
		}
		br.close();
	}

	static void permu(int idx, int sum) {
		if (idx == 7) {
			if (sum == 100) {
				for (int i = 0; i < 7; i++) {
					little[i] = arr[i];
				}
			}
			return;
		}

		for (int i = 0; i < 9; i++) {
			if(visited[i]) continue;
			arr[idx] = input[i];
			visited[i] = true;
			permu(idx + 1, sum + arr[idx]);
			visited[i] = false;
		}
	}
}