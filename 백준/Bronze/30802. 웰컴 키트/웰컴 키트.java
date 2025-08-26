import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        int S = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        int XL = Integer.parseInt(st.nextToken());
        int XXL = Integer.parseInt(st.nextToken());
        int XXXL = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        double TT = Math.ceil((double) S / T) + Math.ceil((double) M / T) + Math.ceil((double) L / T)
                + Math.ceil((double) XL / T) + Math.ceil((double) XXL / T) + Math.ceil((double) XXXL / T);
        int PP = N / P;
        int PPP = N % P;

        System.out.println((int) TT);
        System.out.println(PP + " " + PPP);
    }
}