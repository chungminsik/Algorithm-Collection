package algorithm.baekjoon.백트래킹;

import java.util.Scanner;

public class N과M_4 {

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        back(0, 0, n, m, new int[m]);
        System.out.println(sb);

    }

    public static void back(int depth, int start, int n, int m, int[] array){

        if (depth == m){
            for (int num : array){
                sb.append(num).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = start; i < n; i++){
            array[depth] = i+1;

            back(depth + 1,start , n, m, array);
            start += 1;

        }
    }
}
