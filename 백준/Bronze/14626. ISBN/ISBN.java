import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        String ISBN = br.readLine();

        int wild = 0, total = 0;
        for (int i = 0; i < ISBN.length(); i++) {
            char ch = ISBN.charAt(i);
            if (ch != '*') {
                total += (i % 2 == 0) ? ch - '0' : (ch - '0') * 3;
            } else {
                wild = i;
            }
        }

        int num = 0;
        while (true) {
            if (wild % 2 == 0) {
                if ((total + num) % 10 == 0) {
                    System.out.println(num);
                    break;
                }
            } else {
                if ((total + num * 3) % 10 == 0) {
                    System.out.println(num);
                    break;
                }
            } 
            num++;
        }

    }
}