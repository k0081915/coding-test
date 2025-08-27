import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            LinkedList<int[]> que = new LinkedList<>();

            // 큐에 위치와 중요도 배열을 넣는다
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                que.offer(new int[]{i, Integer.parseInt(st.nextToken())});
            }

            // 몇번째로 꺼내는지 확인하는 변수
            int cnt = 0;
            while (!que.isEmpty()) {
                // 큐에서 처음 원소를 꺼냄
                int[] poll = que.poll();
                boolean isMax = true;

                // 큐의 크기만큼
                for (int i = 0; i < que.size(); i++) {
                    // 꺼낸 원소의 중요도보다 큐에 있는 원소의 중요도가 크면
                    if (poll[1] < que.get(i)[1]) {
                        // 가장 큰 중요도를 갖는 원소의 앞에 있는 원소를 뒤로 보낸다
                        que.offer(poll);
                        for (int j = 0; j < i; j++) {
                            que.offer(que.poll());
                        }
                        // 최댓값이 아니므로 false
                        isMax = false;
                        break;
                    }
                } // for

                // 최댓값이 아니면 다음 원소로 넘어감
                if (!isMax) {
                    continue;
                }

                // 최댓값이면 횟수를 증가
                cnt++;
                // 해당 원소가 찾으려는 원소와 같다면 탈출
                if (poll[0] == M) {
                    break;
                }
            } // while
            sb.append(cnt).append('\n');
        } // while

        System.out.println(sb);

    }
}