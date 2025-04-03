package algorithm.백트래킹;

import java.util.Scanner;

public class N과M_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        back(0,1, n, m, new int[m]);
    }

    private static void back(int depth, int start, int n, int m, int[] result){

        if (depth == m){
            for (int num : result){
                System.out.print(num + " ");
            }
            System.out.println();
            return;
        }

        for (int i = start; i <= n; i++){ // 1에서 숫자 경우의수 까지 반복
            result[depth] = i; // 1단계에서 1,2,3,4에서 1 고르기

            //단계 +1, 시작+1(현재 고른 숫자는 고르면 안됨)
            back(depth+1, i+1, n, m, result);
        }
    }
}
