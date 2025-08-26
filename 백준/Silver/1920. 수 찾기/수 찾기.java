import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        // N 입력
        int N = Integer.parseInt(br.readLine());
        // 중복을 고려하지 않아도 되므로 해시셋으로 구현
        HashSet<Long> set = new HashSet<>();

        // N개의 정수를 입력받고 셋에 추가
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            set.add(Long.parseLong(st.nextToken()));
        }

        // M개의 정수를 입력받고
        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            long mNum = Long.parseLong(st.nextToken());
            // 셋에 입력받은 정수가 존재하면
            if (set.contains(mNum)) {
                // 1 출력
                sb.append(1).append('\n');
            } else {
                // 존재하지 않으면 0 출력
                sb.append(0).append('\n');
            }
        }

        System.out.println(sb);
    }
}