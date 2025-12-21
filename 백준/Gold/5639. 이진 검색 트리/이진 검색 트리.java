import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

	static class Node {
		int data;
		Node left, right;

		Node(int data) {
			this.data = data;
			this.left = null;
			this.right = null;
		}
	}

	static Node root;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
//		StringBuilder sb = new StringBuilder();

		for (int i = 0; ; i++) {
			String str = br.readLine();
			if(str == null) break;
			int data = Integer.parseInt(str);

			if (i == 0) {
				root = new Node(data);
				continue;
			}

			Node node = new Node(data);
			searchNode(root, node);

		}

		postOrder(root);
		System.out.println(sb);


		br.close();
	}

	static void searchNode(Node node, Node child) {
		if (node.data > child.data) {
			if (node.left == null) {
				node.left = child;
			} else {
				searchNode(node.left, child);
			}
		} else {
			if (node.right == null) {
				node.right = child;
			} else {
				searchNode(node.right, child);
			}
		}
	}

	static void postOrder(Node node) {
		if(node == null) return;
		postOrder(node.left);
		postOrder(node.right);
		sb.append(node.data).append("\n");
	}
}
