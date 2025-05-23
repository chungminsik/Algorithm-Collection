package algorithm.baekjoon.브루트포스;

import java.util.Scanner;

public class 분해합 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int inputNumber = sc.nextInt();

        for (int i = 1; i < inputNumber; i++) {
            int sum = i;
            int temp = i;

            while (temp > 0) {
                sum += temp % 10;
                temp /= 10;
            }

            if (sum == inputNumber) {
                System.out.println(i); // i가 생성자
                return;
            }
        }

        System.out.println(0); // 생성자가 없으면 0 출력
    }
}

class 분해햅햅{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int inputNumber = sc.nextInt();
        int tryNumber = inputNumber / 10;

        while (true){
            tryNumber ++;

            int x = tryNumber;
            int y = 0;

            while (x > 0) {
                int digit = x % 10;
                y += digit;
                x /= 10;
            }

            int resultNumber = tryNumber + y;

            if (resultNumber == inputNumber){
                System.out.println(tryNumber);
                break;
            }
        }

        System.out.println(0);
    }
}