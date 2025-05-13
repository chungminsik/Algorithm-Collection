package algorithm.baekjoon.기하_직사각형과삼각형;

import java.util.Scanner;

public class 수학은체육과목입니다 {
    public static void main(String[] args) {

        long input = new Scanner(System.in).nextInt();

        long squareLine = 1;
        squareLine += (3 * input) + (input - 1);

        System.out.println(squareLine);
    }
}
