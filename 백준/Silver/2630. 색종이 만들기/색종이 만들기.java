import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int[][] arr;
    static int blue = 0;
    static int white = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        // 색종이 정보 입력
        int N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 가장 큰 정사각형부터 분할 시작
        partition(0, 0, N);

        System.out.println(white);
        System.out.println(blue);

        br.close();
    }

    static void partition(int row, int col, int size) {
        // 현재 영역이 모두 같은 색인지 확인
        if (colorCheck(row, col, size)) {
            // 배열 값이 0이면 흰색이므로 흰색 +1
            if (arr[row][col] == 0) {
                white++;
            } else {
                // 배열 값이 1이면 파란색이므로 흰색 +1
                blue++;
            }
            // 같은 색이므로 더 이상 분할하지 않고 재귀 종료
            return;
        }

        // 색이 섞여있다면 4분할
        int newSize = size / 2;
        partition(row, col, newSize);   // part 1
        partition(row, col + newSize, newSize); // part 2
        partition(row + newSize, col, newSize); // part 3
        partition(row + newSize, col + newSize, newSize); // part 4
    }

    // 현재 영역에 색깔이 모두 같은지 확인하는 메서드
    static boolean colorCheck(int row, int col, int size) {
        // 첫번째 색깔
        int color = arr[row][col];
        for (int i = row; i < row + size; i++) {
            for (int j = col; j < col + size; j++) {
                // 다른 색깔이 나온다면 false 리턴
                if (color != arr[i][j]) {
                    return false;
                }
            }
        }
        // 다 같은 색이면 true 리턴
        return true;
    }
}