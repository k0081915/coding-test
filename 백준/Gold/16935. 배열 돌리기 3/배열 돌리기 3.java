import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N, M, R;

    static int[][] arr;
    static int[] op;

    static int[][] newArr;
    static int[][] part1;
    static int[][] part2;
    static int[][] part3;
    static int[][] part4;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        op = new int[R];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < R; i++) {
            op[i] = Integer.parseInt(st.nextToken());
            switch (op[i]) {
                case 1: one(); break;
                case 2: two(); break;
                case 3: three(); break;
                case 4: four(); break;
                case 5: five(); break;
                case 6: six(); break;
            }
        }

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
        
    }

    static void one() {
        for (int i = 0; i < N / 2; i++) {
            for (int j = 0; j < M; j++) {
                int tmp = arr[i][j];
                arr[i][j] = arr[N - i - 1][j];
                arr[N - i - 1][j] = tmp;
            }
        }
    }

    static void two() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M / 2; j++) {
                int tmp = arr[i][j];
                arr[i][j] = arr[i][M - j - 1];
                arr[i][M - j - 1] = tmp;
            }
        }
    }

    static void three() {
        int tmp = N;
        N = M;
        M = tmp;
        newArr = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                newArr[i][j] = arr[M - j - 1][i];
            }
        }
        arr = new int[N][M];
        arr = newArr.clone();
    }

    static void four() {
        int tmp = N;
        N = M;
        M = tmp;
        newArr = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                newArr[i][j] = arr[j][N - i - 1];
            }
        }
        arr = new int[N][M];
        arr = newArr.clone();
    }

    static void five() {
        makeGroup();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (i < N / 2) {
                    if (j < M / 2) {
                        arr[i][j] = part4[i][j];
                    } else {
                        arr[i][j] = part1[i][j - M / 2];
                    }
                } else {
                    if (j < M / 2) {
                        arr[i][j] = part3[i - N / 2][j];
                    } else {
                        arr[i][j] = part2[i - N / 2][j - M / 2];
                    }
                }
            }
        }
    }

    static void six() {
        makeGroup();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (i < N / 2) {
                    if (j < M / 2) {
                        arr[i][j] = part2[i][j];
                    } else {
                        arr[i][j] = part3[i][j - M / 2];
                    }
                } else {
                    if (j < M / 2) {
                        arr[i][j] = part1[i - N / 2][j];
                    } else {
                        arr[i][j] = part4[i - N / 2][j - M / 2];
                    }
                }
            }
        }
    }

    private static void makeGroup() {
        part1 = new int[N / 2][M / 2];
        part2 = new int[N / 2][M / 2];
        part3 = new int[N / 2][M / 2];
        part4 = new int[N / 2][M / 2];

        for (int i = 0; i < N / 2; i++) {
            for (int j = 0; j < M / 2; j++) {
                part1[i][j] = arr[i][j];
            }
        }

        for (int i = 0; i < N / 2; i++) {
            for (int j = M / 2; j < M; j++) {
                part2[i][j - M / 2] = arr[i][j];
            }
        }

        for (int i = N / 2; i < N; i++) {
            for (int j = M / 2; j < M; j++) {
                part3[i - N / 2][j - M / 2] = arr[i][j];
            }
        }

        for (int i = N / 2; i < N; i++) {
            for (int j = 0; j < M / 2; j++) {
                part4[i - N / 2][j] = arr[i][j];
            }
        }
    }
}