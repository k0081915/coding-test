import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N;
    static int[][] work;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        work = new int[N][2];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 2; j++) {
                work[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        Arrays.sort(work, (o1, o2) -> o1[1] == o2[1] ? Integer.compare(o1[0], o2[0]) : Integer.compare(o1[1], o2[1]));

        int cnt = 0;
        int end = 0;
        for (int i = 0; i < N; i++) {
            if (end <= work[i][0]) {
                cnt++;
                end = work[i][1];
            }
        }

        System.out.println(cnt);
    }
}