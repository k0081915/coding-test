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

        // 1, 4, 9, 16 같이 제곱인 수는 제곱수가 하나 있다
        // N에서 dp[1], dp[4], dp[9] ...을 뺀 후 1을 더한 값이 가장 작은 것을 구한다
        for (int i = 1; i <= N; i++) {
            dp[i] = i;
            for (int j = 1; j * j <= i; j++) {
                if (dp[i] > dp[i - j * j] + 1) {
                    dp[i] = dp[i - j * j] + 1;
                }
            }
        }

        System.out.println(dp[N]);
    }

}