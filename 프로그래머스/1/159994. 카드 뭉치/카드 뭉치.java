import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

//        st = new StringTokenizer(br.readLine());

        String[] cards1 = {"i", "water", "drink"};
        String[] cards2 = {"want", "to"};
        String[] goal = {"i", "want", "to", "drink", "water"};


        System.out.println(solution(cards1, cards2, goal));
    }

    public static String solution(String[] cards1, String[] cards2, String[] goal) {
        String answer = "";



        // 문장이 만들어 질 수 있는지 확인하는 변수
        boolean check;
        // 이미 체크한 단어를 넘어가기 위한 변수
        int idx1 = 0;
        int idx2 = 0;
        for (int i = 0; i < goal.length; i++) {
            check = false;
            // cards1을 돌면서 목표 단어와 똑같다면
            if (cards1[idx1].equals(goal[i])) {
                // 인덱스를 하나 늘려준다
                idx1++;
                // 인덱스가 cards1의 길이를 넘어가면 -1 해준다
                if (idx1 >= cards1.length) {
                    idx1--;
                }
                // check를 true로 바꿔준다
                check = true;
            }
            // cards1에서 목표 단어와 맞는게 없을 때만 cards2를 탐색한다
            if(!check) {
                // cards2을 돌면서 목표 단어와 똑같다면
                if (cards2[idx2].equals(goal[i])) {
                    // 인덱스를 하나 늘려준다
                    idx2++;
                    // 인덱스가 cards2의 길이를 넘어가면 -1 해준다
                    if (idx2 >= cards2.length) {
                        idx2--;
                    }
                    // check를 true로 바꿔준다
                    check = true;
                }
            }
            // cards1과 card2를 다 돌았는데 check가 false라면
            if (!check) {
                // No를 반환한다
                answer = "No";
                return answer;
            }
        }
        // for문을 빠져나왔다면 Yes를 반환한다
        answer = "Yes";

        return answer;

    }


}
