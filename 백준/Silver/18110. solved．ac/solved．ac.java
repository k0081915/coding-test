import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        // N의 15%
        int cut = (int) Math.round(N * 0.15);
        // 제외한 다음 의견 수
        int cutN = N - 2 * cut;

        int[] op = new int[N];

        for (int i = 0; i < N; i++) {
            op[i] = Integer.parseInt(br.readLine());
        }

        // 의견을 받고 정렬
        Arrays.sort(op);

        int total = 0;
        // 제외당하지 않은 사용자의 의견만 더해서 평균을 구해줌
        for (int i = cut; i < N - cut; i++) {
            total += op[i];
        }

        System.out.println((int) Math.round((double) total / cutN));
    }
}