import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int[][] com;
    static boolean[] visited;
    static int cnt = 0;

    static int N;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        com = new int[N + 1][N + 1];
        visited = new boolean[N + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            com[x][y] = com[y][x] = 1;
        }

        dfs(1);

        System.out.println(cnt - 1);
    }

    static void dfs(int start) {
        visited[start] = true;
        cnt++;

        for (int i = 0; i <= N; i++) {
            if (com[start][i] == 1 && !visited[i]) {
                dfs(i);
            }
        }
    }
}