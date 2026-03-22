import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        while(true) {
            String line = br.readLine();
            
            // 입력이 끝나면 종료
            if(line == null) {
                break;
            }
            
            StringTokenizer st = new StringTokenizer(line);
            int n = Integer.parseInt(st.nextToken());
            
            // n이 0이면 전체 입력 종료
            if(n == 0) {
                break;
            }
            
            long[] heights = new long[n];
            int idx = 0;
            
            // 한 중에 히스토그램 높이가 다 안들어올 수도 있으므로
            // n개를 모두 읽을 때까지 계속 토큰을 채움
            while(idx < n) {
                if(!st.hasMoreTokens()) {
                    st = new StringTokenizer(br.readLine());
                }
                heights[idx++] = Long.parseLong(st.nextToken());
            }
            
            // 스택에는 인덱스를 저장
            Stack<Integer> stack = new Stack<>();
            long maxArea = 0;
            
            // 왼쪽부터 막대를 하나씩 확인
            for(int i = 0; i < n; i++) {
                
                // 현재 막대가 스택 top 막대보다 낮아지는 순간
                // top 막대를 높이로 하는 최대 직사각형 넓이를 계산할 수 있다
                while(!stack.isEmpty() && heights[stack.peek()] > heights[i]) {
                    long height = heights[stack.pop()];
                    
                    // 스택이 비어있으면
                    // 현재 막대 i 이전까지 전부 확장 가능 -> 너비 = i
                    // 비어있지 않으면
                    // stack.peek() 다음부터 i-1까지 확장 가능
                    int width = stack.isEmpty() ? i : i - stack.peek() - 1;
                    
                    maxArea = Math.max(maxArea, height * width);
                }
                
                // 현재 막대 인덱스를 스택에 넣는다
                stack.push(i);
            }
            
            // 끝까지 다 봤는데도 스택에 남아있는 막대들 처리
            // 이 막대들은 오른쪽 끝(n-1)까지 확장 가능하다
            while(!stack.isEmpty()) {
                long height = heights[stack.pop()];
                
                // 스택이 비었으면 처음부터 끝까지 확장 가능 -> 너비 = n
                // 비어있지 않으면 stack.peek()+1 부터 n-1까지 확장 가능
                int width = stack.isEmpty() ? n : n - stack.peek() - 1;
                
                maxArea = Math.max(maxArea, height * width);
            }
            
            sb.append(maxArea).append('\n');
        }
        
        System.out.println(sb);
    }
}