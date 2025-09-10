import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N, M;
    static ArrayList<int[]> house = new ArrayList<>();
    static ArrayList<int[]> chicken = new ArrayList<>();
    static int[] arr;
    static int min = Integer.MAX_VALUE;


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int input = Integer.parseInt(st.nextToken());
                // 1이면 house 리스트에 좌표값 저장
                if (input == 1) {
                    house.add(new int[]{i, j});
                }
                // 2면 chicken 리스트에 좌표값 저장
                else if (input == 2) {
                    chicken.add(new int[]{i, j});
                }
            }
        }

        combi(0, 0);

        System.out.println(min);

        br.close();
    }

    private static void combi(int idx, int start) {
        // idx가 설정한 치킨집 개수(M)과 같아지면
        if(idx == M) {
            int sum = 0;
            for (int i = 0; i < house.size(); i++) {
                // 각 집과 치킨집 사이 최소 거리
                int distance = Integer.MAX_VALUE;
                for (int j = 0; j < arr.length; j++) {
                    // |집 x좌표 - 치킨집 x좌표| + |집 y좌표 - 치킨집 y좌표|
                    distance = Math.min(distance,
                                Math.abs(house.get(i)[0] - chicken.get(arr[j])[0])
                                    + Math.abs(house.get(i)[1] - chicken.get(arr[j])[1]));
                }
                // 모든 집과 치킨집 사이의 거리를 더한다
                sum += distance;
            }
            // 거리의 최솟값을 갱신
            min = Math.min(min, sum);

            return;
        }

        for (int i = start; i < chicken.size(); i++) {
            arr[idx] = i;   // 치킨집의 인덱스를 저장
            combi(idx + 1, i + 1);  // 다음 idx, start 재귀 호출
        }
    }


}