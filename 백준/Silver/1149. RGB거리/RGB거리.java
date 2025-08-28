import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    final static int Red = 0;
    final static int Green = 1;
    final static int Blue = 2;

    static int[][] dp;
    static int[][] cost;


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        cost = new int[N][3];
        dp = new int[N][3];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            cost[i][Red] = Integer.parseInt(st.nextToken());
            cost[i][Green] = Integer.parseInt(st.nextToken());
            cost[i][Blue] = Integer.parseInt(st.nextToken());
        }

        dp[0][Red] = cost[0][Red];
        dp[0][Green] = cost[0][Green];
        dp[0][Blue] = cost[0][Blue];

        // bottom-up
//        for (int i = 1; i < N; i++) {
//            cost[i][Red] += Math.min(cost[i - 1][Green], cost[i - 1][Blue]);
//            cost[i][Green] += Math.min(cost[i - 1][Red], cost[i - 1][Blue]);
//            cost[i][Blue] += Math.min(cost[i - 1][Red], cost[i - 1][Green]);
//        }
//        System.out.println(Math.min(cost[N - 1][Red], Math.min(cost[N - 1][Green], cost[N - 1][Blue])));

        System.out.println(Math.min(paintCost(N - 1, Red), Math.min(paintCost(N - 1, Green), paintCost(N - 1, Blue))));
    }

    // top-down
    static int paintCost(int N, int color) {
        if (dp[N][color] == 0) {
            if (color == Red) {
                dp[N][Red] = Math.min(paintCost(N - 1, Green), paintCost(N - 1, Blue)) + cost[N][Red];
            } else if (color == Green) {
                dp[N][Green] = Math.min(paintCost(N - 1, Red), paintCost(N - 1, Blue)) + cost[N][Green];
            } else {
                dp[N][Blue] = Math.min(paintCost(N - 1, Red), paintCost(N - 1, Green)) + cost[N][Blue];
            }
        }
        return dp[N][color];
    }

}