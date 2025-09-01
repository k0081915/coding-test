import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    static Integer[] dp;
    static int[] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        dp = new Integer[N + 1];
        arr = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        dp[0] = arr[0];
        dp[1] = arr[1];

        // N이 1이 나올 수 있으니 N이 2 이상일 때만 dp[2] 초기 설정
        if (N >= 2) {
            dp[2] = arr[1] + arr[2];
        }

        System.out.println(stair(N));
    }


    static int stair(int N) {
        if (dp[N] == null) {
            dp[N] = Math.max(stair(N - 2), stair(N - 3) + arr[N - 1]) + arr[N];
        }
        return dp[N];
    }

}
