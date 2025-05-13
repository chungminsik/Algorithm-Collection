package algorithm.baekjoon.조건문;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int score = sc.nextInt();

        if (score <= 100 && score >= 90){
            System.out.println("A");
        }
        if (score <= 89 && score >= 80){
            System.out.println("B");
        }
        if (score <= 79 && score >= 70){
            System.out.println("C");
        }
        if (score <= 69 && score >= 60){
            System.out.println("D");
        }
        else if (score < 60){
            System.out.println("F");
        }
    }
}
