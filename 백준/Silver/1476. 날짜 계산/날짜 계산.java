import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;


public class Main {


	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		st = new StringTokenizer(br.readLine());
		int E = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][][] arr = new int[16][29][20];

		int day = 1;
		for (int i = 1, j = 1, k = 1; ; i++, j++, k++) {
			if (i > 15) i = 1;
			if (j > 28) j = 1;
			if (k > 19) k = 1;
			arr[i % 16][j % 29][k % 20] = day++;
			if(i == 15 && j == 28 && k == 19) break;
		}

		System.out.println(arr[E][S][M]);

		br.close();
	}

}