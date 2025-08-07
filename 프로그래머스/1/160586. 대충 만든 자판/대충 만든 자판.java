import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

class Solution {

    public static void main(String[] args) {
        String[] keymap = {"ABCE"};
        String[] targets = {"ABDE"};
        System.out.println(Arrays.toString(solution(keymap, targets)));

    }

    public static int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];

        // target의 각 단어가 keymap에서 가장 적게 카운트 되는 것을 찾기 위한 리스트
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < targets.length; i++) {
            // target 단여 당 키 치는 횟수
            int totalCnt = 0;
            for (int j = 0; j < targets[i].length(); j++) {
                // target의 각 문자를 돌 때마다 리스트를 초기화해줌
                list = new ArrayList<>();
                for (int k = 0; k < keymap.length; k++) {
                    // 몇번 눌렀을 때 target의 문자와 같아지는지 저장
                    int cnt = 0;
                    for (int l = 0; l < keymap[k].length(); l++) {
                        // target의 문자와 keymap의 문자와 같다면
                        if (targets[i].charAt(j) == keymap[k].charAt(l)) {
                            // cnt에 keymap의 인덱스 + 1 을 저장
                            cnt = l + 1;
                            // list에 추가해줌
                            list.add(cnt);
                            break;
                        }
                    }
                }
                // keymap중 가장 적게 누른 것을 판별해야 하기 때문에 정렬해주고
                Collections.sort(list);
                // 리스트가 비어있지 않다면
                if (!list.isEmpty()) {
                    // totalCnt에 가장 적게 나온 수를 더해준다
                    totalCnt += list.get(0);
                } else {
                    break;
                }
            }
            // 리스트가 비어있다면 맞는 문자가 없다는 것이기 때문에 -1을 저장
            if (list.isEmpty()) {
                totalCnt = -1;
            }
            answer[i] = totalCnt;
        }

        return answer;
    }


}