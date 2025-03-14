package algorithm.약수배수와소수;

import java.util.Scanner;

public class 소수찾기 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        final int n = sc.nextInt();
        int result = 0;

        for (int i = 0; i < n; i++){
            int input = sc.nextInt();
            int count = 0;

            if (input == 1){
                continue;
            }

            for (int j = 1; j <= input; j++){
                if (input % j == 0){
                    count++;
                }
            }

            if (!(count > 2)){
                result++;
            }
        }
        sc.close();

        System.out.println(result);
    }
}
