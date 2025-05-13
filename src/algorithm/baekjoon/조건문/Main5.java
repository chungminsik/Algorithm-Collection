package algorithm.baekjoon.조건문;

import java.util.Scanner;

public class Main5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int hour = sc.nextInt();
        int minute = sc.nextInt();
        sc.close();

        int[] result = back45(hour, minute);
        System.out.println(result[0]);
        System.out.println(result[1]);
    }

    static int[] back45(int hour, int minute) {
        minute -= 45;
        if (minute < 0) {
            minute += 60;
            hour--;
        }
        if (hour < 0) {
            hour = 23;
        }
        return new int[]{hour, minute};
    }
}

