package algorithm.기하_직사각형과삼각형;

import java.util.Arrays;
import java.util.Scanner;

public class 세막대 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] sticks = { sc.nextInt(), sc.nextInt(), sc.nextInt() };
        Arrays.sort(sticks); // sticks[0] ≤ sticks[1] ≤ sticks[2]

        int a = sticks[0], b = sticks[1], c = sticks[2];
        if(a + b > c) {
            System.out.println(a + b + c);
        } else {
            System.out.println(2 * (a + b) - 1);
        }
    }
}
