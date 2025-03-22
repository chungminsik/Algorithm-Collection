package algorithm.시간복잡도;

import java.util.Scanner;

public class 알고리즘수업_알고리즘의수행시간4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long input = sc.nextInt();

        System.out.println(input * (input - 1) / 2);
        System.out.println(2);
    }
}
