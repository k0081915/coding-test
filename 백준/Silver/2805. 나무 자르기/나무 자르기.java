import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;


public class Main {


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();


        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] tree = new int[N];

        int max = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            tree[i] = Integer.parseInt(st.nextToken());
            if (max < tree[i]) {
                max = tree[i];
            }
        }
        max++;

        int min = 0;
        int mid = 0;
        while (min < max) {
            mid = (min + max) / 2;

            long sum = 0;
            for (int i = 0; i < N; i++) {
                int diff = tree[i] - mid;
                if (diff >= 0) {
                    sum += diff;
                }
            }

            if (sum >= M) {
                min = mid + 1;
            } else {
                max = mid;
            }
        }

        System.out.println(min - 1);

        br.close();
    }


}
