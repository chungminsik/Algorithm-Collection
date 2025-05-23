package algorithm.baekjoon.정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
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

class 대표값22{
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] array = new int[5];
        array[0] = 0;
        int total = 0;

        for (int i = 0; i < 5; i++){
            int input = Integer.parseInt(br.readLine());
            total += input; //total 計算
            /*
            //定列
            if (array[0] == 0){
                array[i] = input;
            } else{
                for (int j = 0; j < i+1; j++){
                    if (array[j] < input){
                        int temp = input;
                        input = array[j];
                        array[j] = temp;
                    }
                }
            }

             */
        }
        br.close();
        Arrays.sort(array);

        StringBuilder sb = new StringBuilder();
        sb.append(total / 5).append("\n").append(array[2]);
        System.out.println(sb);
    }
}