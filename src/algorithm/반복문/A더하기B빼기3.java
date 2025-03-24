package algorithm.반복문;

import java.util.Scanner;

public class A더하기B빼기3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int testcase = sc.nextInt();
        int[] results = new int[testcase];

        for (int i = 0; i < testcase; i++){
            int number1 = sc.nextInt();
            int number2 = sc.nextInt();

            results[i] = number1+number2;
        }

        for (int i : results){
            System.out.println(i);
        }
    }
}
