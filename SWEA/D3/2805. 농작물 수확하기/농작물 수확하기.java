import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= t; tc++) {
            int n = Integer.parseInt(br.readLine());
            int mid = n / 2;
            int answer = 0;

            for (int row = 0; row < n; row++) {
                String line = br.readLine();
                int distance = Math.abs(row - mid);
                int start = distance;
                int end = n - 1 - distance;

                for (int col = start; col <= end; col++) {
                    answer += line.charAt(col) - '0';
                }
            }

            sb.append('#').append(tc).append(' ').append(answer).append('\n');
        }

        System.out.print(sb);
    }
}