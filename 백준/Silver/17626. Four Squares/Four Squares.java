import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();


        int N = Integer.parseInt(br.readLine());

        int[] dp = new int[N + 1];
        dp[1] = 1;

        int min;
        // 2부터 N까지 dp 배열을 채워나간다
        for (int i = 2; i <= N; i++) {
            min = Integer.MAX_VALUE;    // i에 대한 최솟값을 찾기 위해 초기화
            // i보다 작은 모든 제곱수(j * j)를 탐색
            for (int j = 1; j * j <= i; j++) {
                // dp[i]는 dp[i - j*j]에 j*j 항 하나를 더한 것과 같다
                int temp = dp[i - j * j] + 1;
                min = Math.min(min, temp);
            }
            // 가장 작은 값으로 dp[i]로
            dp[i] = min;
        }

        System.out.println(dp[N]);

    }
}