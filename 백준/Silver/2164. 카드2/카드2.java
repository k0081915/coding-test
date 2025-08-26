import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        // 큐에 1~N까지 숫자를 추가
        Deque<Integer> que = new ArrayDeque<>();
        int N = Integer.parseInt(br.readLine());
        for (int i = 1; i <= N; i++) {
            que.offer(i);
        }

        // 카드가 한 장 남을 때까지 반복
        while (que.size() > 1) {
            // 맨 앞 숫자를 없애고
            que.poll();
            // 큐의 맨 앞 숫자를 없애고 저장해둔 뒤
            Integer poll = que.poll();
            // 맨 뒤에 추가해줌
            que.offer(poll);
        }

        // 남은 한 장 출력
        System.out.println(que.poll());
    }
}