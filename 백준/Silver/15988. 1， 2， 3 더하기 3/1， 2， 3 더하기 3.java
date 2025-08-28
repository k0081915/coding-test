import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());


        long[] dp = new long[1000001];
        dp[1] = 1;  // 1
        dp[2] = 2;  // 1+1, 2
        dp[3] = 4;  // 1+1+1, 2+1, 1+2, 3

        // ?..+1이면 i-1의 합을 구하면 되고
        // ?..+2면 i-2의 합을
        // ?..+3이면 i-3의 합을 구한다
        // 모두 더한 것이 i의 총 경우의 수가 나온다
        for (int i = 4; i <= 1000000; i++) {
            dp[i] = (dp[i-1] + dp[i-2] + dp[i-3]) % 1000000009;
        }
        for (int i = 0; i < T; i++) {
            System.out.println(dp[Integer.parseInt(br.readLine())]);
        }




//        System.out.println(dp[N]);
    }

}