import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {

    static final int SIZE = 100; // 글자판 크기는 항상 100 x 100
    static char[][] map;         // 글자판 저장 배열

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // SWEA 1216은 테스트케이스가 10개로 고정
        for (int tc = 1; tc <= 10; tc++) {

            // 테스트케이스 번호 입력
            int testCaseNumber = Integer.parseInt(br.readLine());

            map = new char[SIZE][SIZE];

            // 100줄의 글자판 입력
            for (int i = 0; i < SIZE; i++) {
                map[i] = br.readLine().toCharArray();
            }

            int answer = 0;

            // 가장 긴 회문 길이를 찾기 위해 100부터 1까지 감소하며 검사
            for (int len = SIZE; len >= 1; len--) {
                if (existsPalindrome(len)) {
                    answer = len;
                    break; // 가장 긴 길이부터 검사했으므로 찾는 순간 정답
                }
            }

            sb.append("#")
              .append(testCaseNumber)
              .append(" ")
              .append(answer)
              .append('\n');
        }

        System.out.print(sb);
    }

    // 길이가 len인 회문이 가로 또는 세로 방향에 하나라도 있는지 확인
    static boolean existsPalindrome(int len) {

        // 가로 방향 검사
        for (int row = 0; row < SIZE; row++) {
            for (int start = 0; start <= SIZE - len; start++) {
                if (isRowPalindrome(row, start, len)) {
                    return true;
                }
            }
        }

        // 세로 방향 검사
        for (int col = 0; col < SIZE; col++) {
            for (int start = 0; start <= SIZE - len; start++) {
                if (isColPalindrome(col, start, len)) {
                    return true;
                }
            }
        }

        return false;
    }

    // 특정 행 row에서 start부터 start + len - 1까지가 회문인지 확인
    static boolean isRowPalindrome(int row, int start, int len) {
        int left = start;
        int right = start + len - 1;

        // 양쪽 끝에서부터 가운데로 좁혀 오며 비교
        while (left < right) {
            if (map[row][left] != map[row][right]) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }

    // 특정 열 col에서 start행부터 start + len - 1행까지가 회문인지 확인
    static boolean isColPalindrome(int col, int start, int len) {
        int top = start;
        int bottom = start + len - 1;

        // 위아래 끝에서부터 가운데로 좁혀 오며 비교
        while (top < bottom) {
            if (map[top][col] != map[bottom][col]) {
                return false;
            }

            top++;
            bottom--;
        }

        return true;
    }
}