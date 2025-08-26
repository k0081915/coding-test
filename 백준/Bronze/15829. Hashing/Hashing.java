import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int M = 1234567891;
        int L = Integer.parseInt(br.readLine());
        String str = br.readLine();

        long total = 0;
        for (int i = 0; i < L; i++) {
            total += (long) ((str.charAt(i) - 'a' + 1) * Math.pow(31, i));
        }

        System.out.println(total % M);
    }
}