package algorithm.baekjoon.정렬;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class 커트라인 {

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        int person = sc.nextInt();
        int winnerIndex = sc.nextInt() - 1;
        Integer[] score = new Integer[person];

        for (int i = 0; i < person; i++) {
            score[i] = sc.nextInt();
        }

        Arrays.sort(score, Collections.reverseOrder());

        System.out.println(score[winnerIndex]);
    }
}
