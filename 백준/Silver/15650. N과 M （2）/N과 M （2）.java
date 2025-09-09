import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static int[] arr;   // 출력할 배열
    static int[] input;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        input = new int[N];

        // 1~N까지의 수를 저장해둔다
        for (int i = 0; i < N; i++) {
            input[i] = i + 1;
        }
        // 0 위치부터 시작
        combi(0, 0);

        System.out.println(sb);

        br.close();
    }

    static void combi(int idx, int start) {
        // idx가 M과 같아지면
        if (idx == M) {
            // 배열을 출력한다
            for (int i = 0; i < M; i++) {
                sb.append(arr[i]).append(" ");
            }
            sb.append("\n");
        }

        // 중복이 없게 해야하기 때문에 start 변수를 두어 
        // 항상 현재 인덱스의 다음 인덱스부터 탐색하도록 한다
        for (int i = start; i < N; i++) {
            arr[idx] = input[i];
            combi(idx + 1, i + 1);
        }
    }
}
