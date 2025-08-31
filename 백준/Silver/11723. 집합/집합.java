import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;


public class Main {


    static Set<Integer> set;
    static StringBuilder sb;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        sb = new StringBuilder();

        set = new HashSet<>();

        int M = Integer.parseInt(br.readLine());

        int x = 0;
        while (M-- > 0) {
            // 연산을 입력받는다
            st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();
            // 다음 토큰이 들어올때만 x를 초기화해준다
            if (st.hasMoreTokens()) {
                x = Integer.parseInt(st.nextToken());
            }

            // 연산에 맞는 메서드를 호출
            switch(cmd) {
                case "add": add(x); break;
                case "remove": remove(x); break;
                case "check": check(x); break;
                case "toggle": toggle(x); break;
                case "all" : all(); break;
                case "empty": empty(); break;
            }
        }

        System.out.println(sb);
    }

    static void add(int x) {
        set.add(x);
    }

    static void remove(int x) {
        set.remove(x);
    }

    static void check(int x) {
        if (set.contains(x)) {
            sb.append(1 + "\n");
        } else {
            sb.append(0 + "\n");
        }
    }

    static void toggle(int x) {
        if (set.contains(x)) {
            set.remove(x);
        } else {
            set.add(x);
        }
    }

    static void all() {
        set.clear();
        for (int i = 1; i <= 20; i++) {
            set.add(i);
        }
    }

    static void empty() {
        set.clear();
    }
}
