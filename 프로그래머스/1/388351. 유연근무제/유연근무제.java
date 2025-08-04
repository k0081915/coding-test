class Solution {

    public static int solution(int[] schedules, int[][] timelogs, int startday) {
        int answer = 0;

        for (int i = 0; i < timelogs.length; i++) {
            // 한 사람마다 출근 인정 시간을 지켰는지 확인
            if (isPossible(schedules[i], timelogs[i], startday)) {
                answer++;
            }
        }

        return answer;
    }

    static boolean isPossible(int standard, int[] time, int startday) {
        // 출근 희망 시간을 시, 분으로 나눠줌
        int hour = standard / 100;
        int min = standard % 100;
        min += 10;

        // 분에 10을 더했을 때 60이 넘어가면 시간을 늘려줌
        if (min >= 60) {
            hour++;
            min -= 60;
        }

        // 출근 인정 시간
        int maxTime = hour * 100 + min;

        
        for (int i = 0; i < time.length; i++) {
            // 토, 일 이면 하루 넘어감
            if (startday == 6 || startday == 7) {
                startday = (startday % 7) + 1;
                continue;
            }
            // 출근 시간이 인정 시간보다 늦다면 false 리턴
            if (time[i] > maxTime) {
                return false;
            }

            startday = (startday % 7) + 1;
        }

        // 모두 출근 인정 시간 내에 들어왔다면 true 리턴
        return true;

    }
}