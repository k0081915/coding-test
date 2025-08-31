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
        int K = Integer.parseInt(st.nextToken());

        int[] money = new int[N];
        for (int i = 0; i < N; i++) {
            money[i] = Integer.parseInt(br.readLine());
        }

        int total = 0;
        // money 배열을 역순으로 탐색하면서 진행
        for (int i = money.length - 1; i >= 0; i--) {
            if (K >= money[i]) {
                total += K / money[i];
                K %= money[i];
            }
        }

        System.out.println(total);
    }

}
