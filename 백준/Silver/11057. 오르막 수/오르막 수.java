import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        // 자릿수와 첫번째 자리에 0~9가 나오는 경우를 따져본다
        long[][] dp = new long[N + 1][10];

        // 자릿수가 1인 경우는 0~9 한가지씩 이므로 1로 초기화
        for (int i = 0; i < 10; i++) {
            dp[1][i] = 1;
        }

        // 자릿수가 2인 경우를 따져보면
        // _0 -> 자릿수가 1이고 첫째 자리에 0이 나오는 경우의 수 => dp[2][0] = dp[1][0]
        // _1 -> 자릿수가 1이고 첫째 자리에 0, 1이 나오는 경우의 수 => dp[2][1] =  dp[1][0] + dp[1][1]
        // ...
        // 점화식을 세워보면 dp[i][j] = sum(dp[i - 1][0 ~ j])
        for (int i = 2; i <= N; i++) {
            for (int j = 0; j < 10; j++) {
                for (int k = 0; k <= j; k++) {
                    dp[i][j] += dp[i - 1][k] % 10007;
                }
            }
        }

        // 첫째 자리가 0~9 까지 모든 경우의 수를 더해준다
        long total = 0;
        for (int i = 0; i < 10; i++) {
            total += dp[N][i] % 10007;
        }

        System.out.println(total % 10007);
    }

}