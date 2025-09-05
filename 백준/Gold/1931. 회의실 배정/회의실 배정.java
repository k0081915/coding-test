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

        // 회의 수 입력
        N = Integer.parseInt(br.readLine());
        work = new int[N][2];

        // 회의 시간 입력
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 2; j++) {
                work[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 끝나는 시간을 기준으로 오름차순 정렬
        // 끝나는 시간이 같으면 시작 시간을 기준으로 정렬
        Arrays.sort(work, (o1, o2) -> o1[1] == o2[1] ? Integer.compare(o1[0], o2[0]) : Integer.compare(o1[1], o2[1]));

        int cnt = 0;
        int end = 0;
        for (int i = 0; i < N; i++) {
            // 끝나는 시간이 다음 회의 시작 시간보다 작거나 같으면
            // 횟수를 늘리고
            // 끝나는 시간 갱신
            if (end <= work[i][0]) {
                cnt++;
                end = work[i][1];
            }
        }

        System.out.println(cnt);
    }
}