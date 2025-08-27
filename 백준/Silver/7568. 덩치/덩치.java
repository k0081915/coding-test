import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int[][] data = new int[N][2];
//        int[] rank = new int[N];
        
        // 몸무게 키 데이터를 배열에 넣어준다
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 2; j++) {
                data[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        for (int i = 0; i < N; i++) {
            // 등급 1부터 시작해서
            int ranking = 1;
            for (int j = 0; j < N; j++) {
                // 다른사람의 몸무게와 키가 나보다 크다면
                if (data[i][0] < data[j][0] && data[i][1] < data[j][1]) {
                    // 등급 +1 해줌
                    ranking++;
                }
            }
            // 각 등급을 저장
            sb.append(ranking).append(" ");
        }
        
        System.out.println(sb);

    }
}