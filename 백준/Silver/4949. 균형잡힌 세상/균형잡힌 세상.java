import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        Stack<Character> stack = new Stack<>();

        while (true) {
            String str = br.readLine();
            // 온점이면 종료
            if (str.equals(".")) {
                break;
            }

            for (int i = 0; i < str.length(); i++) {
                char ch = str.charAt(i);
                // ch가 ( [ 이면 스택에 푸시하고
                // ) ] 이면 스택이 비어있는지 확인하고
                // 스택의 가장 위가 ( [ 라면 pop 해준다
                // ) ] 일 때 스택이 비어있거나 알맞은 짝이 아니면 스택에 넣고 for문을 빠져나온다
                if (ch == '(') {
                    stack.push(ch);
                } else if (ch == ')') {
                    if (!stack.isEmpty() && stack.peek() == '(') {
                        stack.pop();
                    } else if (stack.isEmpty() || stack.peek() != '(') {
                        stack.push(ch);
                        break;
                    }
                } else if (ch == '[') {
                    stack.push(ch);
                } else if (ch == ']') {
                    if (!stack.isEmpty() && stack.peek() == '[') {
                        stack.pop();
                    } else if (stack.isEmpty() || stack.peek() != '[') {
                        stack.push(ch);
                        break;
                    }
                }
            }

            // 모든 과정이 끝나고 스택이 비어있으면 균형을 이루는 것
            if (stack.isEmpty()) {
                sb.append("yes").append('\n');
            } else {
                sb.append("no").append('\n');
            }
            // 한 문자열이 끝나면 스택을 클리어 해줌
            stack.clear();
        }

        System.out.println(sb);
    }
}