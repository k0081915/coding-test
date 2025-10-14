import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.*;

public class Main {

	// Node 클래스
	static class Node {
		char data; // 알파벳
		Node left, right; // 좌우 자식

		public Node(char data) {
			this.data = data;
		}
	}

	// 전위 순회
	static void preOrder(Node node) {
		System.out.print(node.data);
		if(node.left != null) preOrder(node.left);
		if(node.right != null) preOrder(node.right);
	}

	// 중위 순회
	static void inOrder(Node node) {
		if(node.left != null) inOrder(node.left);
		System.out.print(node.data);
		if(node.right != null) inOrder(node.right);
	}

	// 후위 순회
	static void postOrder(Node node) {
		if(node.left != null) postOrder(node.left);
		if(node.right != null) postOrder(node.right);
		System.out.print(node.data);
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());
		// N개의 노드를 만든다
		// A부터 순서대로
		Node[] nodes = new Node[N];
		for (int i = 0; i < N; i++) {
			nodes[i] = new Node((char) ('A' + i));
		}

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			char data = st.nextToken().charAt(0);
			char left = st.nextToken().charAt(0);
			char right = st.nextToken().charAt(0);

			Node cur = nodes[data - 'A']; // 현재 노드
			if (left != '.') { // left가 . 이 아니면
				cur.left = nodes[left - 'A']; // 현재 노드의 left에 연결
			}
			if (right != '.') { // right가 . 이 아니면
				cur.right = nodes[right - 'A']; // 현재 노드의 right에 연결
			}
		}

		// A부터 시작
		preOrder(nodes[0]);
		System.out.println();

		inOrder(nodes[0]);
		System.out.println();

		postOrder(nodes[0]);
		System.out.println();

		br.close();
	}


}
