package algorithm.baekjoon.브루트포스;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 수학은비대면강의입니다 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] array = new int[6];

        for (int i = 0; i < array.length; i++){
            array[i] = Integer.parseInt(String.valueOf(br.read()));
        }












        int result1 = 0;
        int result2 = 0;

        int x = 0;
        int y = 0;

        for (int i = 0; i < 999; i++){
            for (int j = 0; j < 999; j++){

                if (i*j == (array[2]*j) - ((array[1]*j) * (array[1]*j)) / array[0]){
                    result1 = i*j;
                }

                if (i*j == (array[5]*j) - ((array[4]*j) * (array[4]*j)) / array[3]){
                    result2 = i*j;
                }

                if (result1 == result2){
                    x = i;
                    y = j;
                    break;
                }

            }
        }

        System.out.println(x);
        System.out.println(y);
    }
}
