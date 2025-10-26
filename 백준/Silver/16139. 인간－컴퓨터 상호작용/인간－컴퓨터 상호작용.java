import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();


		String str = br.readLine();
		int q = Integer.parseInt(br.readLine());

		// 문자열 0번부터 i번 인덱스까지 문자 c가 총 몇번 나왔는지 누적 합
		// 문자열 인덱스 1번부터 시작
		int[][] sum = new int[26][str.length() + 1];

		for (int i = 1; i <= str.length(); i++) {
			// i-1 번째까지 모든 알파벳 누적 합을 복사
			for (int j = 0; j < 26; j++) {
				sum[j][i] = sum[j][i - 1];
			}
			// 현재 문자에 해당하는 누적값 1 증가
			sum[str.charAt(i - 1) - 'a'][i]++;
		}


		for (int i = 0; i < q; i++) {

			st = new StringTokenizer(br.readLine());
			char c = st.nextToken().charAt(0);
			int l = Integer.parseInt(st.nextToken());
			int r = Integer.parseInt(st.nextToken());

			// l ~ r 사이의 c 개수 = (1~r+1 까지 c 개수) - (1~l 까지 c 개수)
			int cnt = sum[c - 'a'][r + 1] - sum[c - 'a'][l];

			sb.append(cnt).append("\n");
		}

		System.out.println(sb);
		br.close();
	}

}
