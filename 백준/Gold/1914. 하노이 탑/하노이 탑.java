import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
//        StringBuilder sb = new StringBuilder();
        sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        // N이 20보다 클 경우에는 공식을 사용하여 계산
        // 2^N - 1
        // N = 100 이면 2^100을 계산해야 하기 때문에 BigInteger를 사용
        BigInteger num = new BigInteger("2");
        sb.append(num.pow(N).subtract(new BigInteger("1")));

        // N이 20 이하일 때만 과정 출력
        if (N <= 20) {
            sb.append("\n");
            hanoi(N, 1, 2, 3);
        }

        System.out.println(sb);

        br.close();
    }

    static void hanoi(int N, int from, int tmp, int to) {
        // 옮길 원반이 0개면 return
        if (N == 0) {
            return;
        }

        // 첫번째 장대에서 가장 아랫칸을 제외한 나머지 원반들을 두번째 장대로 옮김
        hanoi(N - 1, from, to, tmp);
        sb.append(from).append(" ").append(to).append("\n");
        // 나머지 원반들을 두번째 장대에서 세번째 장대로 옮김
        hanoi(N - 1, tmp, from, to);
    }
}
