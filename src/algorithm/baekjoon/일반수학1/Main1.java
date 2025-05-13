package algorithm.baekjoon.일반수학1;

import algorithm.baekjoon.Question;

import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Question q = new 진법변환1_2();
        q.start();

    }
}

class 진법변환1_1 implements Question{

    @Override
    public void start() {
        Scanner sc = new Scanner(System.in);

        String number = sc.next();
        int radix = sc.nextInt();
        sc.close();

        System.out.println(Integer.parseInt(number, radix));
    }
}

class 진법변환1_2 implements Question{

    @Override
    public void start() {
        Scanner sc = new Scanner(System.in);

        String number = sc.next();
        int radix = sc.nextInt();
        sc.close();

        System.out.println(convertRadix(number, radix));
    }

    private static int convertRadix(String number, int radix){
        int returnValue = 0;
        int numberLength = number.length();

        for (int i = 0; i < numberLength; i++){
            char digitChar = number.charAt(i);
            int digitValue;

            if (Character.isDigit(digitChar)){
                digitValue = digitChar - '0';
            } else{
                digitValue = Character.toUpperCase(digitChar) - 'A' + 10;
            }

            returnValue = returnValue * radix + digitValue;
        }

        return returnValue;
    }
}