package algorithm.baekjoon.정렬;

import java.util.Scanner;

public class 대표값2 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int avg, middle;
        int max = 0;

        int[] array = new int[5];

        for (int i = 0; i < 5; i++){
            int inputArray = sc.nextInt();
            array[i] = inputArray;
            max += inputArray;
        }

        avg = max / 5;
        middle = middle(array);

        System.out.println(avg);
        System.out.println(middle);
    }

    public static int middle(int[] array) {
        for (int i = 1; i < array.length; i++) {
            for (int j = i; j > 0; j--) {
                if (array[j - 1] > array[j]) {
                    int temp = array[j];
                    array[j] = array[j - 1];
                    array[j - 1] = temp;
                }
            }
        }
        return array[2];
    }
}
