package algorithm.일반수학1;

import algorithm.Question;

import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Question q = new 진법변환1();
        q.start();

    }
}

class 진법변환1 implements Question{

    @Override
    public void start() {
        Scanner sc = new Scanner(System.in);

        String number = sc.next();
        int radix = sc.nextInt();
        sc.close();

        System.out.println(Integer.parseInt(number, radix));
    }
}
