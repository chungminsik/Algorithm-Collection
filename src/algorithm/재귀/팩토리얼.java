package algorithm.재귀;

import java.util.Scanner;

public class 팩토리얼 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        System.out.println(factorial(n, n));
    }

    public static long factorial(long n, long result){

        if (n <= 1){
            return n == 0 ? 1 : result;
        }

        result *= n-1;
        return factorial(n-1, result);
    }
}
