import java.util.*;
import java.io.*;

class Main {
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        
        int[] arr = new int[N];
        
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());   
        }
        
        // left 0 인덱스에서 시작
        int left = 0;
        // 최소 길이를 배열 최대 길이+1로 설정
        int minLength = Integer.MAX_VALUE;
        // 초기 sum 세팅
        int sum = 0;
        
        // right를 증가시킴
        for(int right = 0; right < N; right++) {
            sum += arr[right]; // 합 증가
            
            // sum >= S 인 동안 실행
            while(sum >= S) {
                // 최소 길이 갱신
                minLength = Math.min(minLength, right - left + 1);
                // sum에서 빼주고 left++
                sum -= arr[left++];
            }
        }
        
        // 최소 길이가 초기값과 같으면 0 출력
        System.out.print(minLength == Integer.MAX_VALUE ? 0 : minLength);
    }
}