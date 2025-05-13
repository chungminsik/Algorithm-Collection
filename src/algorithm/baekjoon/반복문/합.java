package algorithm.baekjoon.반복문;

import java.util.Scanner;

public class 합 {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);

        int number = sc.nextInt();
        int sum = 0;
        for (int i = 1; i <= number; i++){
            sum = sum+i;
        }
        System.out.println(sum);
    }
}
