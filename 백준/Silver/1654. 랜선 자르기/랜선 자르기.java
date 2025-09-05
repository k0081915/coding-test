import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int[] lan = new int[K];
        long max = 0;
        for (int i = 0; i < K; i++) {
            lan[i] = Integer.parseInt(br.readLine());
            // 입력한 길이 중 최댓값을 찾는다
            if (max < lan[i]) {
                max = lan[i];
            }
        }
        
        max++;

        long min = 0;
        long mid = 0;

        while (min < max) {

            mid = (min + max) / 2; // 현재 시도하는 랜선의 길이

            long count = 0;
            for (int i = 0; i < lan.length; i++) {
                // 각 랜선을 mid 길이로 잘라 총 몇개가 나오는지 계산
                count += lan[i] / mid;
            }

            /**
             * count < N -> 랜선을 너무 길게 잘랐다
             * 더 짧게 잘라야 개수가 늘어나므로, 최대 길이를 줄인다
             */
            if (count < N) {
                max = mid;
            }
            /**
             * count >= N -> 랜선을 너무 짧게 잘랐거나 딱 맞다
             * 더 길게 잘라도 될 수 있으므로, 최소 길이를 늘린다
             */
            else {
                min = mid + 1;
            }
        }

        // Upper Bound 방식으로 찾았으므로 min - 1
        System.out.println(min - 1);

        br.close();
    }
}