import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N, K;
    static int[] visited = new int[100001]; // 방문 여부

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());   // 수빈 위치
        K = Integer.parseInt(st.nextToken());   // 동생 위치

        System.out.println(bfs(N));

        br.close();
    }

    static int bfs(int node) {
        Queue<Integer> queue = new LinkedList<>();

        visited[node] = 1;  // 방문 처리
        queue.offer(node);

        // 큐가 빌 때까지
        while (!queue.isEmpty()) {
            int nextIndex = queue.poll();

            // 동생 위치에 도착했으면
            if (nextIndex == K) {
                // 배열 값 - 1 리턴
                return visited[nextIndex] - 1;
            }
            // x - 1이 범위 안이고, 방문하지 않았다면
            if (nextIndex - 1 >= 0 && visited[nextIndex - 1] == 0) {
                // x - 1 위치 값 = x 위치 값 + 1
                visited[nextIndex - 1] = visited[nextIndex] + 1;
                // x - 1 위치를 큐에 넣는다
                queue.offer(nextIndex - 1);
            }
            // x + 1이 범위 안이고, 방문하지 않았다면
            if (nextIndex + 1 <= 100000 && visited[nextIndex + 1] == 0) {
                // x + 1 위치 값 = x 위치 값 + 1
                visited[nextIndex + 1] = visited[nextIndex] + 1;
                // x + 1 위치를 큐에 넣는다
                queue.offer(nextIndex + 1);
            }
            // 2 * x가 범위 안이고, 방문하지 않았다면
            if (2 * nextIndex <= 100000 && visited[2 * nextIndex] == 0) {
                // 2 * x 위치 값 = x 위치 값 + 1
                visited[2 * nextIndex] = visited[nextIndex] + 1;
                // 2 * x 위치를 큐에 넣는다
                queue.offer(2 * nextIndex);
            }
        }

        return -1;
    }

}