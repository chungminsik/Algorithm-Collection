package algorithm.백트래킹;

import java.util.Scanner;

public class N과M_3 {

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        back(0, n, m, new int[m]);

        System.out.println(sb);
    }

    private static void back(int depth, int n, int m, int[] array){

        if (depth == m){
            for (int num : array){
                sb.append(num).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 0; i < n; i++){
            array[depth] = i+1;
            back(depth+1, n, m, array);
        }
    }
}
