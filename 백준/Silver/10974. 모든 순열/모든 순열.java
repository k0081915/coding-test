import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[] arr;
    static boolean[] check;
    static int[] input;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
//        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        arr = new int[N + 1];
        check = new boolean[N + 1];
        input = new int[N + 1];


        permu(0);

        System.out.println(sb);

        br.close();
    }

    private static void permu(int idx) {
        if (idx == N) {
            for (int i = 0; i < N; i++) {
                sb.append(arr[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 1; i <= N; i++) {
            if (check[i]) {
                continue;
            }
            check[i] = true;
            arr[idx] = i;
            permu(idx + 1);
            check[i] = false;
        }
    }

}
