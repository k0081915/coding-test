import java.util.*;

class Solution {

    public static void main(String[] args) {

        String t = "111111111111111111";
        String p = "12222222";

        System.out.println(solution(t, p));

    }

    public static int solution(String t, String p) {
        int answer = 0;

        // p를 정수화시킨다
        long pnum = Long.parseLong(p);

        // t에서 p의 길이를 뺀 것 동안 반복
        for (int i = 0; i < t.length() - p.length() + 1; i++) {
            // p의 길이만큼 잘라서 숫자를 저장
            long num = Long.parseLong(t.substring(i, i + p.length()));

            // 숫자 p 보다 num이 작거나 같으면 횟수 증가
            if (num <= pnum) {
                answer++;
            }
        }

        return answer;
    }


}