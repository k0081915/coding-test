import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N, M;
    static String[][] arr;
    static boolean[][] visited;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int count;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new String[N][M];
        visited = new boolean[N][M];

        int startX = 0;
        int startY = 0;
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                arr[i][j] = String.valueOf(str.charAt(j));
                if (arr[i][j].equals("I")) {
                    startX = i;
                    startY = j;
                }
            }
        }

        dfs(startX, startY);


        if (count == 0) {
            System.out.println("TT");
        } else {
            System.out.println(count);
        }

        br.close();
    }

    static void dfs(int x, int y) {
        visited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
                if (!visited[nx][ny] && !arr[nx][ny].equals("X")) {
                    dfs(nx, ny);
                    if (arr[nx][ny].equals("P")) {
                        count++;
                    }
                }
            }
        }
    }

}