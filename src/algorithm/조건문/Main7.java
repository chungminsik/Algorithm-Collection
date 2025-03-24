package algorithm.조건문;

import java.util.Scanner;

public class Main7 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        //입력
        int first = sc.nextInt();
        int second = sc.nextInt();
        int third = sc.nextInt();
        sc.close();

        //출력
        System.out.println(calculate(first, second, third));
    }
    //계산
    static int calculate(int first, int second, int third) {
        if(first == second && second == third && first == third) {
            int bonus = first*1000;
            return 10000+bonus;
        }
        else if(first == second || second == third || first == third) {
            int a = first+second;
            int b = second+third;
            int c = first+third;
            if (a != b && a != c) {
                int aa = a/2;
                return 1000+aa*100;
            } else if (b != a && b != c) {
                int bb = b/2;
                return 1000+bb*100;
            } else if (c != a && c != b) {
                int cc = c/2;
                return 1000+cc*100;
            } else {
                return 0;
            }
        }
        else if(first != second && second != third && first != third) {
            int max = Math.max(first, Math.max(second, third));
            return max*100;
        }
        else {
            return 0;
        }
    }
}
