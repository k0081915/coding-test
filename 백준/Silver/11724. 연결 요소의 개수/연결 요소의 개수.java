import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N;
    static int[][] arr;
    static boolean[] visited;
    static Queue<Integer> queue;
    static int count;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        arr = new int[N + 1][N + 1];
        visited = new boolean[N + 1];

        // 정점을 받아서 서로 연결해준다
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            arr[u][v] = arr[v][u] = 1;
        }

        // 방문하지 않은 노드일 때만 bfs를 호출한다
        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {
                bfs(i);
            }
        }
        System.out.println(count);
        br.close();
    }
    
    static void bfs(int node) {
        queue = new LinkedList<>();
        // 방문 처리
        visited[node] = true;
        queue.offer(node);

        while (!queue.isEmpty()) {
            // 큐에서 값을 꺼내서 그 값과 연결된 노드들을 큐에 넣고 방문 처리
            // 큐가 빌 때까지 반복한다
            int idx = queue.poll();
            for (int i = 1; i <= N; i++) {
                if (!visited[i] && arr[idx][i] == 1) {
                    queue.offer(i);
                    visited[i] = true;
                }
            }
        }
        // bfs가 호출된 횟수 = 연결 요소의 개수
        count++;
    }
}