import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[N];
        int[] arr = new int[N];

        Map<Integer, Integer> map = new HashMap<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dp[0] = 1;
        int lis = 1;
        // 이전 값과 비교하기 위해 1부터 시작
        for (int i = 1; i < N; i++) {
            // 부분 수열은 최소값이 1이기 때문에 1로 초기화
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                // 현재 값이 이전 값보다 크면
                if (arr[i] > arr[j]) {
                    // dp를 갱신해준다
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    // lis도 갱신
                    lis = Math.max(lis, dp[i]);
                }
            }
        }

        sb.append(lis + "\n");

        Stack<Integer> stack = new Stack<>();
        // 배열을 거꾸로 탐색하면서
        for (int i = N - 1; i >= 0; i--) {
            // dp와 최대 lis가 같으면
            if (dp[i] == lis) {
                // 스택에 푸시하고
                stack.push(arr[i]);
                // lis를 하나 줄여준다
                lis--;
            }
        }

        while (!stack.isEmpty()) {
            sb.append(stack.pop() + " ");
        }

        System.out.println(sb);
    }

}