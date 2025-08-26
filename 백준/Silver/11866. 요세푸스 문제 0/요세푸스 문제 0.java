import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        // 원으로 이루어져 있기 때문에 큐로 구현
        Queue<Integer> que = new LinkedList<>();

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        // 1~N 까지 큐에 넣어줌
        for (int i = 1; i <= N; i++) {
            que.offer(i);
        }

        sb.append('<');
        // 큐에 하나만 남을 때까지 반복
        while (que.size() != 1) {
            // K - 1 동안 반복하면서 K번째 수가 가장 앞에 오도록 함
            for (int i = 0; i < K - 1; i++) {
                que.offer(que.poll());
            }
            // K번째 수를 제거하고 , 를 붙임
            sb.append(que.poll()).append(", ");
        }

        // 마지막 남은 수를 제거하고 > 를 붙임
        sb.append(que.poll()).append('>');

        System.out.println(sb);
    }
}