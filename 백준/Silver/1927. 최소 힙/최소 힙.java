import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        // 최소 힙을 구현하기 위해 우선순위 큐 사용
        PriorityQueue<Integer> minQue = new PriorityQueue<>();

        
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            int cmd = Integer.parseInt(br.readLine());
            // cmd가 0보다 크면
            if (cmd > 0) {
                // 큐에 자연수를 추가
                minQue.offer(cmd);
            } else {
                // cmd가 0이고 큐가 비어있지 않을 때
                if (!minQue.isEmpty()) {
                    // 가장 작은 값을 꺼내온다
                    sb.append(minQue.poll()).append('\n');
                } else {
                    // 큐가 비어있으면 0을 출력
                    sb.append(0).append('\n');
                }
            }
        }

        System.out.println(sb);
    }
}