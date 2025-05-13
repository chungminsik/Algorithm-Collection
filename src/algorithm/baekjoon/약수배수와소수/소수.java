package algorithm.baekjoon.약수배수와소수;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 소수 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //소수 담는 List
        List<Integer> decimalArray = new ArrayList<>();

        int total = 0;
        int lower;

        int m = sc.nextInt();
        int n = sc.nextInt();
        sc.close();

        for(int i = m; i <= n; i++){
            if (i == 1){
                continue;
            }

            int count = 0;
            for (int j = 1; j <= i; j++) {
                if (i % j == 0){
                    count++;
                }
            }

            if (!(count > 2)){
                decimalArray.add(i);
                total += i;
            }
        }

        if (decimalArray.size() < 0){
            System.out.println(-1);
        } else{
            lower = decimalArray.get(0);
            System.out.println(total);
            System.out.println(lower);
        }

    }
}
