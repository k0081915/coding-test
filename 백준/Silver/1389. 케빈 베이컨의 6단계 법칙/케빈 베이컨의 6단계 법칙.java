import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N, M;
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());   // 사람 수
        M = Integer.parseInt(st.nextToken());   // 간선 수

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            graph.get(x).add(y);
            graph.get(y).add(x);
        }

        int minKB = Integer.MAX_VALUE;
        int result = -1;    // 최종 사람

        // 1번 사람부터 N번 사람까지 순회
        for (int i = 1; i <= N; i++) {
            int currentKB = 0;
//            for (int j = 1; j <= N; j++) {
//                // 자신을 제외한 다른 사람 모두 순회
//                if (i != j) {
//                    // 최단 거리를 구하여 더한다
//                    currentKB += bfs(i, j);
//                }
//            }
            // 반환된 distance 배열 값을 모두 더해줌
            currentKB += Arrays.stream(bfs(i)).sum();
            
            // minKB를 갱신하고 그때의 사람 번호를 저장한다
            if (currentKB < minKB) {
                minKB = currentKB;
                result = i;
            }
        }

        System.out.println(result);
        br.close();
    }

    // 두 사람 사이의 최단 거리를 반환
    static int[] bfs(int start) {
        boolean[] visited = new boolean[N + 1]; // 방문 여부
        int[] distance = new int[N + 1];    // start 사람부터 각 사람까지의 거리
        Queue<Integer> queue = new LinkedList<>();

        visited[start] = true;  // 방문 처리
        queue.offer(start); // 시작 사람을 큐에 넣음

        // 큐가 빌 때까지
        while (!queue.isEmpty()) {
            // 사람을 하나 꺼냄
            int currentPerson = queue.poll();

            // 현재 사람의 모든 친구를 확인
            for (int known : graph.get(currentPerson)) {
                // 방문하지 않았다면
                if (!visited[known]) {
                    visited[known] = true;  // 방문 처리
                    distance[known] = distance[currentPerson] + 1;  // 거리를 1 증가
                    queue.offer(known); // 큐에 추가
                }
            }
        }
        
        return distance;
    }

}