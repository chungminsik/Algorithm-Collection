package algorithm.브루트포스;

import java.util.Scanner;

public class 블랙잭 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int inputAmount = sc.nextInt();
        int m = sc.nextInt();
        int[] array = new int[inputAmount];
        int highest = 0;

        for (int i = 0; i < inputAmount; i++){
            array[i] = sc.nextInt();
        }
        sc.close();


        for (int i = 0; i < array.length; i++){
            for (int j = i+1; j < array.length; j++){
                for (int k = j+1; k < array.length; k++){
                    int amount = array[i] + array[j] + array[k];

                    if (m >= amount){
                        if (highest < amount){
                            highest = amount;
                        }
                    }
                }
            }
        }

        System.out.println(highest);
    }
}
