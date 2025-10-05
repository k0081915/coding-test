import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

	static int N, K;
	static int[] arr;
	static int[] tmp;

	static int cnt;
	static int answer = -1;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		arr = new int[N];
		tmp = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		mergeSort(0, N - 1);

		System.out.println(answer);

		br.close();
	}

	static void mergeSort(int p, int r) {
		if(cnt >= K) return;
		if (p < r) {
			int q = (p + r) / 2;
			mergeSort(p, q);
			mergeSort(q + 1, r);
			merge(p, q, r);
		}
	}

	static void merge(int p, int q, int r) {
		int i = p, j = q + 1, t = p;
		while (i <= q && j <= r) {
			if (arr[i] < arr[j]) {
				tmp[t++] = arr[i++];
			} else {
				tmp[t++] = arr[j++];
			}
		}
		while (i <= q) {
			tmp[t++] = arr[i++];
		}
		while (j <= r) {
			tmp[t++] = arr[j++];
		}

		i = p; t = p;
		while (i <= r) {
			cnt++;
			arr[i] = tmp[t];
			if (cnt == K) {
				answer = arr[i];
				return;
			}
			i++;
			t++;
		}
	}
}
