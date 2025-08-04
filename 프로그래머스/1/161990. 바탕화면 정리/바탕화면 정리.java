import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

class Solution {

    public static void main(String[] args) {
        // 파일의 왼쪽 상단을 좌표로 표현하면
        // (0,1), (1,2), (2,3)
        // 오른쪽 하단을 좌표로 표현하면
        // (1,2), (2,3), (3,4)
        // 원래 좌표에 +1 씩 해준 것과 같다
        String[] wallpaper = {"..........", ".....#....", "......##..", "...##.....", "....#....."};
        System.out.println(Arrays.toString(solution(wallpaper)));
    }

    public static int[] solution(String[] wallpaper) {
        int[] answer = new int[4];

        ArrayList<Integer> lux = new ArrayList<>();
        ArrayList<Integer> luy = new ArrayList<>();
        ArrayList<Integer> rdx = new ArrayList<>();
        ArrayList<Integer> rdy = new ArrayList<>();

        // 각 파일마다 왼쪽 위 꼭짓점(x,y)과 오른쪽 아래 꼭짓점(x+1,y+1)을 리스트에 저장한다
        for (int i = 0; i < wallpaper.length; i++) {
            for (int j = 0; j < wallpaper[0].length(); j++) {
                if (wallpaper[i].charAt(j) == '#') {
                    lux.add(i);
                    luy.add(j);
                    rdx.add(i + 1);
                    rdy.add(j + 1);
                }
            }
        }

        // 오름차순으로 정렬
        // 왼쪽 위 꼭짓점
        // 가장 작은 x: 가장 위에 있는 파일
        // 가장 작은 y: 가장 왼쪽에 있는 파일
        // 오른쪽 아래 꼭짓점
        // 가장 큰 x: 가장 아래 있는 파일
        // 가장 큰 y: 가장 오른쪽에 있는 파일
        Collections.sort(lux);
        Collections.sort(luy);
        Collections.sort(rdx);
        Collections.sort(rdy);

        // 존재하는 파일의 가장 왼쪽 위 꼭짓점에서 가장 오른쪽 아래 꼭짓점까지 드래그하면
        // 모든 파일을 선택할 수 있다.
        answer[0] = lux.get(0);
        answer[1] = luy.get(0);
        answer[2] = rdx.get(rdx.size() - 1);
        answer[3] = rdy.get(rdy.size() - 1);


        return answer;
    }


}