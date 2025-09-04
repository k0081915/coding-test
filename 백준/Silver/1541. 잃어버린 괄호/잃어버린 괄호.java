import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        String str = br.readLine();
        // -를 기준으로 니눠준다
        String[] ss = str.split("-");

        // 처음 나오는 배열은 숫자만 있거나 + 가 같이 있기 때문에
        // 초기값으로 설정
        int result = plusAll(ss[0]);

        for (int i = 1; i < ss.length; i++) {
            // -를 기준으로 나누었기 때문에 초기값에서 빼주면 된다
            result -= plusAll(ss[i]);
        }

        System.out.println(result);
    }

    static int plusAll(String ss) {
        // +를 기준으로 나눠줌
        String[] plus = ss.split("\\+");

        // 숫자 합을 구해줌
        int sum = 0;
        for (String s : plus) {
            sum += Integer.parseInt(s);
        }

        return sum;
    }
}