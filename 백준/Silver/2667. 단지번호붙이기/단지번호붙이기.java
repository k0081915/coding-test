import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

    static int N;

    static int[][] apart;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    static boolean[][] visited;

    static ArrayList<Integer> list = new ArrayList<>();
    static int count = 1;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        apart = new int[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < N; j++) {
                int num = Integer.parseInt(String.valueOf(line.charAt(j)));
                apart[i][j] = num;
            }
        }

        int cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (apart[i][j] == 1 && !visited[i][j]) {
                    count = 1;
                    dfs(i, j);
                    cnt++;
                    list.add(count);
                }
            }
        }

        sb.append(cnt).append("\n");
        Collections.sort(list);

        for (Integer i : list) {
            sb.append(i).append("\n");
        }

        System.out.println(sb);

        br.close();
    }

    static void dfs(int x, int y) {
        visited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && ny >= 0 && nx < N && ny < N) {
                if (apart[nx][ny] == 1 && !visited[nx][ny]) {
                    dfs(nx, ny);
                    count++;
                }
            }
        }
    }
}
