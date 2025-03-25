package algorithm.시간복잡도;

import java.util.Scanner;

public class 알고리즘수업_점근적표기1 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int a0 = sc.nextInt();
        int a1 = sc.nextInt();
        int c = sc.nextInt();;
        int n0 = sc.nextInt();
        sc.close();

        System.out.println(isBigO(a1, a0, c, n0) ? 1 : 0);
    }

    static boolean isBigO(int a1, int a0, int c, int n0) {
        for (int n = n0; n <= 1000; n++) {
            if (a1 * n + a0 > c * n) {
                return false;
            }
        }
        return true;
    }
}
