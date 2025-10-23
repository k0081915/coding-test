import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
        StringTokenizer st;

		String str1 = br.readLine();
		String str2 = br.readLine();
		int[][] dp = new int[str1.length() + 1][str2.length() + 1]; // LSC 길이

		// str1과 str2의 문자를 비교
		for (int i = 1; i <= str1.length(); i++) {
			for (int j = 1; j <= str2.length(); j++) {
				// 두 문자가 같으면
				if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
					// i, j가 오기 전까지 LCS 길이에 1을 더한 값
					dp[i][j] = dp[i - 1][j - 1] + 1;
				} else { // 두 문자가 다르면
					// str1[1...i-1]와 str2[1...j]를 비교한 값
					// str1[1...i]와 str2[1...j-1]를 비교한 값
					// 두 값 중 큰 값 저장
					dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
				}
			}
		}

		// 두 문자열 전체의 LCS 길이 출력
		System.out.println(dp[str1.length()][str2.length()]);
		
        br.close();
    }


}
