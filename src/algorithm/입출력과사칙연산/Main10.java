package algorithm.입출력과사칙연산;

import java.util.Scanner;

public class Main10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int number1 = sc.nextInt();
        int number2 = sc.nextInt();

        String number1ToString = Integer.toString(number2);

        for (int i = 0; i < number1ToString.length(); i++) {
            printResult(number1, Character.getNumericValue(number1ToString.charAt(i)));
        }
        printResult(number1, number2);
    }

    static void printResult(int number1, int number2) {
        System.out.println(number1 * number2);
    }
}

