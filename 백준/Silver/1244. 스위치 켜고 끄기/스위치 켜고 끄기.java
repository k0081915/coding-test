import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[] sch;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        sch = new int[N + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            sch[i] = Integer.parseInt(st.nextToken());
        }

        int M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());

            task(s, num);

        }

        for (int i = 1; i <= N; i++) {
            sb.append(sch[i] + " ");
            if (i % 20 == 0) {
                sb.append("\n");
            }
        }

        System.out.println(sb);
    }

    static void task(int s, int num) {
        if (s == 1) {
            for (int i = num; i <= N; i++) {
                if (i % num == 0) {
                    if (sch[i] == 1) {
                        sch[i] = 0;
                    } else {
                        sch[i] = 1;
                    }
                }
            }
        } else {
            int i = num - 1;
            int j = num + 1;
            if (sch[num] == 1) {
                sch[num] = 0;
            } else {
                sch[num] = 1;
            }
            while (true) {
                if (i <= 0 || j > N) {
                    break;
                }
                if (sch[i] == sch[j]) {
                    if (sch[i] == 1) {
                        sch[i] = 0;
                    } else {
                        sch[i] = 1;
                    }
                    if (sch[j] == 1) {
                        sch[j] = 0;
                    } else {
                        sch[j] = 1;
                    }
                } else {
                    break;
                }

                i--;
                j++;
            }
        }
    }
}
