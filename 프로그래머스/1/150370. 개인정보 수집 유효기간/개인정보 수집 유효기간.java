import java.util.*;

class Solution {

    public static void main(String[] args) {
        String today = "2020.10.15";
        String[] terms = {"A 100"};
        String[] privacies = {"2018.06.16 A", "2008.02.15 A"};

        System.out.println(Arrays.toString(solution(today, terms, privacies)));

    }

    public static int[] solution(String today, String[] terms, String[] privacies) {
        int[] answer;

        ArrayList<Integer> list = new ArrayList<>();

        // 약관을 맵으로 저장해준다
        Map<String, Integer> termMap = new HashMap<>();
        for (String term : terms) {
            String[] spt = term.split(" ");
            termMap.put(spt[0], Integer.parseInt(spt[1]));
        }

        // 오늘 날짜를 연, 월, 일 int 형으로 나누어 저장해준다
        String[] todayArr = today.split("\\.");
        int ty = Integer.parseInt(todayArr[0]);
        int tm = Integer.parseInt(todayArr[1]);
        int td = Integer.parseInt(todayArr[2]);

        // 순서를 세기 위한 변수
        int order = 1;
        for (String privacy : privacies) {
            // pri[0]: 날짜, pri[1]: 약관 종류
            String[] pri = privacy.split(" ");
            // 개인정보 수집 일자도 연, 월, 일로 나눠준다
            String[] startDay = pri[0].split("\\.");
            int sy = Integer.parseInt(startDay[0]);
            int sm = Integer.parseInt(startDay[1]);
            int sd = Integer.parseInt(startDay[2]);

            // 월에 약관 종류에 맞는 유효기간을 더함
            sm = sm + termMap.get(pri[1]);
            // 월이 12를 넘으면
            if (sm > 12) {
                // 년에 12를 나눈 몫을 더해주고 월은 12를 나눈 나머지로 대입
                sy += sm / 12;
                sm = sm % 12;
            }
            // 월이 0이면 12월로 연도가 안 지났으므로
            if (sm == 0) {
                // 연도를 1 빼주고 sm을 12로 대입
                sy--;
                sm = 12;
            }


            // 오늘 연도와 유효기간 후 연도가 같고
            if (ty == sy) {
                // 오늘 월과 유효기간 후 월이 같고
                if (tm == sm) {
                    // 오늘 일이 유효기간 후 일 이상이면
                    if (td >= sd) {
                        // 파기 목록에 추가
                        list.add(order);
                    }
                } else if (tm > sm) {
                    // 연도가 같고 오늘 월이 더 크면 파기 목록 추가
                    list.add(order);
                }
            } else if (ty > sy) {
                // 오늘 연도가 더 크면 파기 목록 추가
                list.add(order);
            }

            // 순서를 증가
            order++;
        }

        // answer에 list에 있는 값을 넣어줌
        answer = new int[list.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = list.get(i);
        }

        return answer;
    }


}