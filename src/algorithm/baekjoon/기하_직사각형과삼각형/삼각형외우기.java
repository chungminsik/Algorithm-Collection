package algorithm.baekjoon.기하_직사각형과삼각형;

import java.util.Scanner;

public class 삼각형외우기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt(), b= sc.nextInt(), c = sc.nextInt();

        if ((a + b + c) != 180){
            System.out.println("error");
        } else if (a == 60 && b == 60 && c == 60){
            System.out.println("Equilateral");
        } else if(a == b || b == c || a == c){
            System.out.println("Isosceles");
        } else{
            System.out.println("Scalene");
        }
    }
}
