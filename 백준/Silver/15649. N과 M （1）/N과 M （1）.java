import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N, M;
    static StringBuilder sb = new StringBuilder();

    static boolean[] check;
    static int[] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
//        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N + 1];
        check = new boolean[N + 1];


        permu(0);
        System.out.println(sb);
        br.close();
    }

    static void permu(int idx) {
        // idx가 M과 같아지면 수열 출력
        if (idx == M) {
            for (int i = 0; i < M; i++) {
                sb.append(arr[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        // 1~N까지의 수를 선택
        for (int i = 1; i <= N; i++) {
            // 이미 선택한 적이 있으면 continue
            if (check[i]) {
                continue;
            }
            // 사용 처리 한다
            check[i] = true;
            // 해당 위치에 i를 넣는다
            arr[idx] = i;
            // 위치를 1 증가시키고 재귀 호출
            permu(idx + 1);
            // i로 시작하는 모든 경우의 수를 했기 때문에 다시 i를 사용하지 않았다고 해준다
            check[i] = false;
        }
    }

}