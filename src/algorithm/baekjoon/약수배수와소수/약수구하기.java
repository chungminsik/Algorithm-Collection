package algorithm.baekjoon.약수배수와소수;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 약수구하기 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int number = sc.nextInt();
        int n = sc.nextInt();

        List<Integer> factorList = new ArrayList<>();

        for (int i = 1; i <= number; i++){
            if (number % i == 0){
                factorList.add(i);
            }
        }

        if (factorList.size() < n){
            System.out.println(0);
        } else{
            System.out.println(factorList.get(n-1));
        }
    }
}

class 약수구하기2{
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        int n = sc.nextInt();

        int result = 0;
        int count = 0;

        for (int i = 1; i <= number; i++){
            if (number % i == 0){
                count++;

                if (count == n){
                    result = i;
                    break;
                }
            }
        }

        System.out.println(result);
    }
}
