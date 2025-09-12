import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

	static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
	static int[][] graph2;
	static int[][] result;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());
		graph2 = new int[N][N];
		result = new int[N][N];

		for (int i = 0; i < N; i++) {
			graph.add(new ArrayList<>());
		}

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				graph2[i][j] = Integer.parseInt(st.nextToken());
//				if (Integer.parseInt(st.nextToken()) == 1) {
//					graph.get(i).add(j);
//					graph.get(j).add(i);
//					graph2[i][j] = graph2[j][i] = 1;
//				}
			}
		}


//		for (int i = 0; i < graph.size(); i++) {
//			System.out.println("index = " + i + " values = " + graph.get(i));
//			bfs(i);
//		}

//		for (int[] ints : result) {
//			for (int num : ints) {
//				sb.append(num + " ");
//			}
//			sb.append('\n');
//		}

		for (int k = 0; k < N; k++) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (graph2[i][k] == 1 && graph2[k][j] == 1) {
						graph2[i][j] = 1;
					}
				}
			}
		}

		for (int[] ints : graph2) {
			for (int num : ints) {
				sb.append(num + " ");
			}
			sb.append('\n');
		}

		System.out.println(sb);
		br.close();
	}

	static void bfs(int node) {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(node);

		while (!queue.isEmpty()) {
			int idx = queue.remove();
			ArrayList<Integer> list = graph.get(idx);
			for (Integer i : list) {
				result[node][i] = 1;
			}
		}
	}
}