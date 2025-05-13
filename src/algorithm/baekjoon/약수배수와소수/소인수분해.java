package algorithm.baekjoon.약수배수와소수;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 소인수분해 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();

        //num의 범위의 소수를 구한다.
        List<Integer> decimalList = new ArrayList<>();

        for(int i = 1; i <= num; i++){
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
                decimalList.add(i);
            }
        }

        //num을 범위의 소수 중 나머지가 0인 소수 중 가장 작은 인수로 나눈다.
        for (int decimal : decimalList){

            boolean loop = true;
            while (loop){
                if (num % decimal == 0){
                    System.out.println(decimal);
                    num = num / decimal;
                } else{
                    loop = false;
                }
            }
        }

    }
}

class 소인수분해2{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        sc.close();

        // 2로 나누기
        while(num % 2 == 0) {
            System.out.println(2);
            num /= 2;
        }

        // 홀수에 대해 3부터 sqrt(num)까지 검사
        for (int i = 3; i * i <= num; i += 2) {
            while(num % i == 0) {
                System.out.println(i);
                num /= i;
            }
        }

        // 남은 수가 소수인 경우
        if (num > 1) {
            System.out.println(num);
        }
    }
}
