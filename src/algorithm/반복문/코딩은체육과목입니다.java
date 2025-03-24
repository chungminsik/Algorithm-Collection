package algorithm.반복문;

import java.util.Scanner;

public class 코딩은체육과목입니다 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int howLong = sc.nextInt();
        for (int i = 0; i < howLong/4; i++){
            System.out.print("long");
            System.out.print(" ");
        }
        System.out.print("int");
    }
}
