import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        // cnt : 연속된 3개중 숫자가 나왔을 때 구해야할 숫자에 도달하기 위해 더해야할 수
        int cnt = 0, num = 0;
        for (int i = 0; i < 3; i++) {
            String str = br.readLine();
            // 입력받은 문자열이 숫자라면
            if (str.charAt(0) >= '0' && str.charAt(0) <= '9') {
                // 숫자로 바꿔주고
                num = Integer.parseInt(str);
                // cnt를 구해줌
                cnt = 3 - i;
            }
        }
        // num에 cnt를 더함
        num += cnt;

        // 문제에 나온 조건대로 출력
        if (num % 3 == 0 && num % 5 == 0) {
            System.out.println("FizzBuzz");
        } else if (num % 3 == 0) {
            System.out.println("Fizz");
        } else if (num % 5 == 0) {
            System.out.println("Buzz");
        } else {
            System.out.println(num);
        }
    }
}