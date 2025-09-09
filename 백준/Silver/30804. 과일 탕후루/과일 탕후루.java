import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] fruit = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            fruit[i] = Integer.parseInt(st.nextToken());
        }

        // key: 과일 종류, value: 해당 과일의 개수
        Map<Integer, Integer> map = new HashMap<>();
        int left = 0;
        int answer = 0;

        // right 포인터 역할을 하는 for 루프
        for (int right = 0; right < N; right++) {
            // 1. 창문 확장: right 포인터의 과일을 창문에 포함시킨다.
            map.put(fruit[right], map.getOrDefault(fruit[right], 0) + 1);

            // 2. 조건 검사 및 창문 축소
            // 창문 안의 과일 종류가 2가지를 초과하면, 조건을 만족할 때까지 left 포인터를 이동
            while (map.size() > 2) {
                // left 포인터의 과일 개수를 하나 줄인다.
                map.put(fruit[left], map.get(fruit[left]) - 1);

                // 만약 해당 과일의 개수가 0이 되면, map에서 제거한다.
                if (map.get(fruit[left]) == 0) {
                    map.remove(fruit[left]);
                }
                // left 포인터를 오른쪽으로 한 칸 이동시킨다.
                left++;
            }

            // 3. 답 갱신: 현재 유효한 창문의 길이(right - left + 1)로 최댓값을 갱신한다.
            answer = Math.max(answer, right - left + 1);
        }

        System.out.println(answer);
        br.close();
    }
}