
import java.util.Arrays;
import java.util.HashMap;

class Solution {
    static int W;
    static int H;

    public static void main(String[] args) {

        String[] park = {"OSO", "OOO", "OXO", "OOO"};
        String[] routes = {"E 2", "S 3", "W 1"};


        System.out.println(Arrays.toString(solution(park, routes)));
    }

    public static int[] solution(String[] park, String[] routes) {
        // W -1, N -1, E 1, S 1
        int[] answer = new int[2];
        W = park[0].length();
        H = park.length;
        
        // 공원 초기화
        boolean[][] square = new boolean[park.length][park[0].length()];

        int startX = 0;
        int startY = 0;

        // true 장애물, false 길
        for (int i = 0; i < park.length; i++) {
            for (int j = 0; j < park[0].length(); j++) {
                if (park[i].charAt(j) == 'X') {
                    square[i][j] = true;
                }
                // 시작 위치 저장
                if (park[i].charAt(j) == 'S') {
                    startX = i;
                    startY = j;
                }
            }
        }

        // 다음으로 이동할 위치 변수
        int nextX = startX;
        int nextY = startY;
        
        for (int i = 0; i < routes.length; i++) {
            String[] route = routes[i].split(" ");
            String dir = route[0];
            int count = Integer.parseInt(route[1]);
            // 범위 내에 있는지 확인하는 변수
            boolean flag = true;

            // E, W는 y좌표를 움직이고
            // N, S는 x좌표를 움직인다
            for (int j = 0; j < count; j++) {
                if (dir.equals("E")) {
                    nextY += 1;
                } else if (dir.equals("S")) {
                    nextX += 1;
                } else if (dir.equals("W")) {
                    nextY -= 1;
                } else {
                    nextX -= 1;
                }
                // 움직인 좌표가 범위를 벗어났거나 장애물이라면
                // 움직이기 전 좌표로 되돌린다
                if ((nextX < 0 || nextX >= H || nextY < 0 || nextY >= W) || square[nextX][nextY]) {
                    flag = false;
                    nextX = startX;
                    nextY = startY;
                    break;
                } 
            }
            // 정상적으로 움직였다면 좌표를 옮거준다
            if (flag) {
                startX = nextX;
                startY = nextY;
            }
        }

        answer[0] = startX;
        answer[1] = startY;

        return answer;
    }

}