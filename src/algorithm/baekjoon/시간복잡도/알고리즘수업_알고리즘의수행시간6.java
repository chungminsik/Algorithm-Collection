package algorithm.baekjoon.시간복잡도;

import java.util.Scanner;

public class 알고리즘수업_알고리즘의수행시간6 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        long n = sc.nextInt();
        sc.close();

        System.out.println(((n) * (n-1) * (n-2)) / 6);
        System.out.println(3);
    }
}
