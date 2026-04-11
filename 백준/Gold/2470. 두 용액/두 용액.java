import java.util.*;
import java.io.*;

class Main {
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        Arrays.sort(arr);
        
        int left = 0;
        int right = N - 1;
        
        int x = arr[left];
        int y = arr[right];
        
        int min = 2100000000;
        while(left < right) {
            int sum = arr[left] + arr[right];
            
            if(Math.abs(sum) < min) {
                min = Math.abs(sum);
                x = arr[left];
                y = arr[right];
            }
            
            if(sum < 0) {
                left++;
            } else if(sum > 0) {
                right--;
            } else {
                break;
            }
        }
        
        System.out.println(x + " " + y);
    }
}