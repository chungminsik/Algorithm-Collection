package algorithm.baekjoon.일반수학1;

import algorithm.baekjoon.Question;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Question q = new 진법변환2_1();
        q.start();
    }
}

class 진법변환2_1 implements Question {

    @Override
    public void start() {

        Scanner sc = new Scanner(System.in);

        int number = sc.nextInt();
        int radix = sc.nextInt();
        sc.close();

        String result = Integer.toString(number, radix);
        System.out.println(result.toUpperCase());
    }
}
