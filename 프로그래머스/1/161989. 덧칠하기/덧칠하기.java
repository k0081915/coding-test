import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

class Solution {

    public static void main(String[] args) {
        int n = 4;
        int m = 1;
        int[] section = {1, 2, 3, 4};
        System.out.println(solution(n, m, section));

    }

    public static int solution(int n, int m, int[] section) {
        int answer = 0;

        boolean[] wall = new boolean[n];
        for (int i : section) {
            wall[i - 1] = true;
        }

        // n번을 돌면서 다시 칠해야 하는 곳부터 m만큼의 길이를 false로 바꾸면 되지 않을까?
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            // 다시 칠해야 하는 벽이라면
            if (wall[i]) {
                // 그 위치부터 m 길이만큼 칠한다
                for (int j = i; j < i + m; j++) {
                    // 길이가 전체 벽 길이를 넘어가면 탈출한다
                    if (j >= n) {
                        break;
                    }
                    wall[j] = false;
                }
                cnt++;
            }
        }
        answer = cnt;

        return answer;
    }


}