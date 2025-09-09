import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

    static int sum = 0;
    static int[] arr;   // 출력할 배열
    static int[] input;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

//        st = new StringTokenizer(br.readLine());
//        N = Integer.parseInt(st.nextToken());
//        M = Integer.parseInt(st.nextToken());
        arr = new int[9];
        input = new int[9];

        // 1~N까지의 수를 저장해둔다
        for (int i = 0; i < 9; i++) {
            input[i] = Integer.parseInt(br.readLine());
            sum += input[i];
        }

        for (int i = 0; i < 8; i++) {
            for (int j = i + 1; j < 9; j++) {
                int cnt = input[i] + input[j];
                if (sum - cnt == 100) {
                    input[i] = input[j] = 0;
                    for (int k = 0; k < 9; k++) {
                        if (input[k] != 0) {
                            System.out.println(input[k]);
                        }
                    }
                }
            }
        }


        br.close();
    }

    static void combi(int idx, int start) {
        // idx가 M과 같아지면
        if (idx == 7) {
            sum = 0;
            for (int i = 0; i < 7; i++) {
                sum += arr[i];
            }
            // 배열을 출력한다
            if (sum == 100) {
                for (int i = 0; i < 7; i++) {
                    sb.append(arr[i]).append("\n");
                }
                return;
            }
            return;
        }

        // 중복이 없게 해야하기 때문에 start 변수를 두어
        // 항상 현재 인덱스의 다음 인덱스부터 탐색하도록 한다
        for (int i = start; i < 9; i++) {
            arr[idx] = input[i];
            combi(idx + 1, i + 1);
        }
    }

}
