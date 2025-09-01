import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static Integer[][] dp = new Integer[41][2];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        dp[0][0] = 1;   // N=0 일 때 0 호출 횟수
        dp[0][1] = 0;   // N=0 일 때 1 호출 횟수
        dp[1][0] = 0;   // N=1 일 때 0 호출 횟수
        dp[1][1] = 1;   // N=1 일 때 1 호출 횟수
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            fibo(N);
            sb.append(dp[N][0] + " " + dp[N][1]).append("\n");
        }

        System.out.println(sb);
    }

    static Integer[] fibo(int N) {
        // N에 대한 0, 1의 호출 횟수가 없을 때(탐색하지 않은 값)
        if (dp[N][0] == null || dp[N][1] == null) {
            // 각 N에 대한 0, 1 호출 횟수를 재귀호출
            dp[N][0] = fibo(N - 1)[0] + fibo(N - 2)[0];
            dp[N][1] = fibo(N - 1)[1] + fibo(N - 2)[1];
        }
        // [N][0], [N][1]을 담고 있는 [N]을 반환
        return dp[N];
    }
}