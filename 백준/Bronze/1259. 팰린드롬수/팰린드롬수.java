import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        while (true) {
            int N = Integer.parseInt(br.readLine());
            // 0이면 반복문 종료
            if (N == 0) {
                break;
            }
            // 정수를 문자열로 바꿈
            String stNum = String.valueOf(N);
            // 캐릭터 배열로 치환
            char[] chNum = stNum.toCharArray();

            // 확인 변수
            boolean flag = true;
            // 문자 배열 길이 동안 반복
            for (int i = 0; i < chNum.length; i++) {
                // 처음과 끝을 비교하면서 다르다면
                if (chNum[i] != chNum[chNum.length - i - 1]) {
                    // flag 를 false로 하고 빠져나간다
                    flag = false;
                    break;
                }
            }
            // flag가 true면 yes, false면 no
            if (flag) {
                sb.append("yes").append('\n');
            } else {
                sb.append("no").append('\n');
            }
        }

        System.out.println(sb);
    }
}