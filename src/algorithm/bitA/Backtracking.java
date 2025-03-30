package algorithm.bitA;

import java.util.ArrayList;
import java.util.List;

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
