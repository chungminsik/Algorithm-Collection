package algorithm.bitA_Algorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Backtracking {

    static List<int[]> list = new ArrayList<>();
    static int count = 0;

    public static void main(String[] args) {

        int[] array = new int[3];
        backTracking(0, array);

        for (int[] arrays : list) {
            for (int integer : arrays) {
                System.out.print(integer);
            }
            System.out.println(" ");
        }

        System.out.println(count);
    }

    private static void backTracking(int index, int[] letter){

        if (index == 3){
            list.add(letter.clone());
            count++;
            return;
        }

        for (int i = 0; i < 4; i++){
            letter[index] = i;
            backTracking(index+1, letter);
            System.out.println(index);
        }
    }
}


class back{

    static List<int[]> list1 = new ArrayList<>();

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); //경우의수
        int m = sc.nextInt(); // 선택 수

        int[] board = new int[m];
        boolean[] check = new boolean[n];

        backTracking(0, n, m, board, check);
    }

    //모든 조합을 고를 때는 for로 충분
    //순열을 고를 때는 check가 필요
    private static void backTracking(int index, int n, int m, int[] board, boolean[] check){

        //탈출구
        if (index == m){
            for (int num : board) {
                System.out.print(num + " ");
            }
            System.out.println();
            return;
        }

        //메인로직
        for (int i = 0; i < n; i++){
            if (!check[i]){
                check[i] = true;

                board[index] = i+1;

                backTracking(index+1, n, m, board, check);

                check[i] = false;
            }
        }
    }
}