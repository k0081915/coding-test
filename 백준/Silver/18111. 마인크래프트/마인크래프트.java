import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int[][] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        arr = new int[N][M];

        int min = 256;
        int max = 0;

        // 주어진 배열에서 최소, 최대 높이를 찾는다
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] < min) {
                    min = arr[i][j];
                }
                if (arr[i][j] > max) {
                    max = arr[i][j];
                }
            }
        }

        // 최소 ~ 최대 높이 구간을 탐색한다
        int time = Integer.MAX_VALUE;
        int h = 0;
        for (int i = min; i <= max; i++) {
            // 시간과 블럭 초기화
            int count = 0;
            int block = B;

            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    // 현재 높이 < 배열 높이
                    if (i < arr[j][k]) {
                        // 블럭을 빼주어야 하기 때문에 시간은 2배 걸림
                        count += ((arr[j][k] - i) * 2);
                        // 제거한 블럭을 가지고 있는 블럭에 더한다
                        block += (arr[j][k] - i);
                    }
                    // 현재 높이 > 배열 높이
                    else {
                        // 블럭을 설치해야 하기 때문에 시간을 1배 더해준다
                        count += (i - arr[j][k]);
                        // 가지고 있는 블럭에서 높이 차 만큼 빼준다
                        block -= (i - arr[j][k]);
                    }
                }
            }

            // 블럭이 음수가 되면 반복문 탈출
            if (block < 0) {
                break;
            }

            // 최소 시간을 구한다
            if (count <= time) {
                time = count;
                // 그때의 높이를 저장
                h = i;
            }
        }

        System.out.println(time + " " + h);
        br.close();
    }

}