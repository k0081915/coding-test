import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int[][] arr;
    static boolean[][] visited;
    static int[] dx = {0, -1, 0, 1}; // 좌우
    static int[] dy = {-1, 0, 1, 0}; // 상하

    static int M;
    static int N;
    static int K;
    static int cnt = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();


        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            // 개수 초기화
            cnt = 0;

            // M, N, K 입력
            st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());   // 가로
            N = Integer.parseInt(st.nextToken());   // 세로
            K = Integer.parseInt(st.nextToken());   // 배추 위치 수

            arr = new int[M][N];
            visited = new boolean[M][N];
            while (K-- > 0) {
                // 배추 위치 입력
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                arr[x][y] = 1;
            }

            for (int i = 0; i < M; i++) {
                for (int j = 0; j < N; j++) {
                    // 배추가 있고 방문하지 않은 노드일 때만 dfs 호출
                    if (arr[i][j] == 1 && !visited[i][j]) {
                        dfs(i, j);
                        cnt++;
                    }
                }
            }

            System.out.println(cnt);
        }


    }

    static void dfs(int x, int y) {
        // 방문 처리
        visited[x][y] = true;

        // 상하좌우 탐색
        for (int i = 0; i < 4; i++) {

            int nx = x + dx[i];
            int ny = y + dy[i];

            // 배열 범위 내에서만 탐색
            if (nx >= 0 && nx < M && ny >= 0 && ny < N) {
                // 방문하지 않았고 배추가 있으면 dfs 호출
                if (!visited[nx][ny] && arr[nx][ny] == 1) {
                    dfs(nx, ny);
                }
            }
        }
    }
}