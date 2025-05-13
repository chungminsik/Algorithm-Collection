package algorithm.baekjoon.스택큐덱;

import java.io.*;
import java.util.*;

public class 스택2 {

    private static final Stack<Integer> stack = new Stack<>();
    private static final List<Integer> printList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

        int input = Integer.parseInt(br.readLine());

        for (int i = 0; i < input; i++) {
            String[] tokens = br.readLine().split(" ");
            int command = Integer.parseInt(tokens[0]);

            if (command == 1) {
                int param = Integer.parseInt(tokens[1]);
                order(command, param);
            } else if (command >= 2 && command <= 5) {
                printList.add(order(command));
            } else {
                // 入力が不正な場合（競技では普通無視する）
            }
        }

        // 出力をまとめて
        for (Integer value : printList) {
            out.println(value);
        }

        out.flush(); // 明示的に出力
    }

    private static int order(int number) {
        int returnValue = 0;

        if (number == 2) {
            try {
                returnValue = stack.pop();
            } catch (EmptyStackException e) {
                returnValue = -1;
            }
        } else if (number == 3) {
            returnValue = stack.size();
        } else if (number == 4) {
            returnValue = stack.isEmpty() ? 1 : 0;
        } else if (number == 5) {
            try {
                returnValue = stack.peek();
            } catch (EmptyStackException e) {
                returnValue = -1;
            }
        }

        return returnValue;
    }

    private static void order(int number, int param) {
        if (number == 1) {
            stack.add(param);
        }
    }
}
