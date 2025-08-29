import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        // dp[i][j] : i 번째 줄에서 j 번째 칸에 동물을 놓을 수 있는 경우의 수
        long[][] dp = new long[N + 1][3];

        dp[1][0] = dp[1][1] = dp[1][2] = 1;

        // 2번째 줄에 아무 동물도 안놓을 경우
        // 첫번째 줄에 동물 놓는 경우의 수와 같다
        // dp[2][0] = dp[1][0] + dp[1][1] + dp[1][2] = 3
        
        // 2번째 줄에 첫번째 칸에 동물을 놓을 경우
        // (1, 1)과 (2, 2)에 동물을 놓을 수 없으므로 (1,0),(1,2)에 놓는 경우의 수를 더한다
        // dp[2][1] = dp[1][0] + dp[1][2] = 2
        
        // 2번째 줄에 두번째 칸에 동물을 놓을 경우
        // (1,0),(1,1)에 동물을 놓는 경우의 수를 더한다
        // dp[2][2] = dp[1][0] + dp[1][1] = 2
        
        // 점화식을 구하면
        // dp[i][0] = dp[i - 1][0] + dp[i - 1][1] + dp[i - 1][2]
        // dp[i][1] = dp[i - 1][0] + dp[i - 1][2]
        // dp[i][2] = dp[i - 1][0] + dp[i - 1][1]
        for (int i = 2; i <= N; i++) {
            dp[i][0] = (dp[i - 1][0] + dp[i - 1][1] + dp[i - 1][2]) % 9901;
            dp[i][1] = (dp[i - 1][0] + dp[i - 1][2]) % 9901;
            dp[i][2] = (dp[i - 1][0] + dp[i - 1][1]) % 9901;
        }


        System.out.println((dp[N][0] + dp[N][1] + dp[N][2]) % 9901);
    }

}