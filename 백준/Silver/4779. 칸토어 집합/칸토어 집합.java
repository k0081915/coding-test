import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

	static StringBuilder sb;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
//		StringBuilder sb = new StringBuilder();

		String str;
		while ((str = br.readLine()) != null) {
			int N = Integer.parseInt(str);

			sb = new StringBuilder();
			for (int i = 0; i < Math.pow(3, N); i++) {
				sb.append("-");
			}

			recur(0, (int) Math.pow(3, N));

			System.out.println(sb);

		}

//		br.close();
	}

	static void recur(int idx, int length) {
		if (length == 1) {
			return;
		}

		int newLength = length / 3;

		recur(idx, newLength);

		for (int i = idx + newLength; i < idx + 2 * newLength; i++) {
			sb.setCharAt(i, ' ');
		}
		recur(idx + 2 * newLength, newLength);

	}

}