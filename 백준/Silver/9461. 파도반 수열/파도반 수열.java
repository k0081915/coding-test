import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static Long[] dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            dp = new Long[101];
            int x = Integer.parseInt(br.readLine());
            dp[1] = dp[2] = dp[3] = 1L;
            dp[4] = dp[1] + dp[3];
            dp[5] = dp[4];
            tri(x);
            System.out.println(dp[x]);
        }
    }

    static long tri(int N) {

        if (dp[N] == null) {
            dp[N] = tri(N - 5) + tri(N - 1);
        }

        return dp[N];
    }
}