import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {


	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		String str = br.readLine();
		String bomb = br.readLine();

		for (int i = 0; i < str.length(); i++) {
			// sb에 문자 하나씩 집어넣음
			sb.append(str.charAt(i));
			
			// sb의 길이가 폭탄 길이 이상이면 검사
			if (sb.length() >= bomb.length()) {
				boolean flag = true;

				for (int j = 0; j < bomb.length(); j++) {
					// sb 뒤부터 확인
					if (sb.charAt(sb.length() - bomb.length() + j) != bomb.charAt(j)) {
						// 문자가 다르면 false
						flag = false;
						break;
					}
				}

				// 문자가 같으면
				if (flag) {
					// 해당 문자열을 지움
					sb.delete(sb.length() - bomb.length(), sb.length());
				}
			}

		}

		// 남아있는 문자가 없으면 FRULA 출력
		if (sb.length() == 0) {
			System.out.println("FRULA");
		} else {
			System.out.println(sb);
		}

		br.close();
	}
}
