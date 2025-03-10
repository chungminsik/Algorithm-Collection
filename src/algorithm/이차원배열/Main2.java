package algorithm.이차원배열;

import algorithm.Question;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Question r1 = new 최댓값1();
        r1.start();
    }
}

class 최댓값1 implements Question{
    public void start(){
        List<Integer> list = new ArrayList<>();
        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < 81; i++){
            int input = sc.nextInt();
            list.add(input);
        }

        int result = list.get(0);
        int index = 0;

        for (int i = 1; i < 81; i++){
            if (result < list.get(i)){
                result = list.get(i);
                index = i;
            }
        }

        int[] location = findLocation(index);

        System.out.println(result);
        System.out.println(location[0] + " " + location[1]);
    }

    private static int[] findLocation(int index){
        int x = 1;
        int y = 1;

        x = x + (index / 9);
        y = y + (index % 9);

        int [] result = {x, y};

        return  result;
    }

}

class 최댓값2 implements Question{
    public void start(){
        List<Integer> list = inputArray();

        int max = Collections.max(list);
        int index = list.indexOf(max);

        int[] location = findLocation(index);

        System.out.println(max);
        System.out.println(location[0] + " " + location[1]);
    }

    private static List<Integer> inputArray(){
        List<Integer> result = new ArrayList<>();
        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < 81; i++){
            int input = sc.nextInt();
            result.add(input);
        }

        sc.close();
        return result;
    }

    private static int[] findLocation(int index){
        int x = 1;
        int y = 1;

        x = x + (index / 9);
        y = y + (index % 9);

        int [] result = {x, y};

        return  result;
    }
}

class 최댓값3 implements Question{
    public void start(){
        List<Integer> list = inputArray();

        int max = findMax(list);
        int index = list.indexOf(max);

        int[] location = findLocation(index);

        System.out.println(max);
        System.out.println(location[0] + " " + location[1]);
    }

    private static List<Integer> inputArray(){
        List<Integer> result = new ArrayList<>();
        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < 81; i++){
            int input = sc.nextInt();
            result.add(input);
        }

        sc.close();
        return result;
    }

    private static int findMax(List<Integer> list){
        int result = list.get(0);

        for (int i = 1; i < 81; i++){
            if (result < list.get(i)){
                result = list.get(i);
            }
        }

        return result;
    }

    private static int[] findLocation(int index){
        int x = 1;
        int y = 1;

        x = x + (index / 9);
        y = y + (index % 9);

        int [] result = {x, y};

        return  result;
    }
}

class 최댓값4 implements Question{

    public void start(){
        int[] maxAndIndex = findMaxAndIndex();
        int[] location = findLocation(maxAndIndex[1]);

        System.out.println(maxAndIndex[0]);
        System.out.println(location[0] + " " + location[1]);
    }

    private static int[] findMaxAndIndex(){
        List<Integer> list = new ArrayList<>();
        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < 81; i++){
            int input = sc.nextInt();
            list.add(input);
        }

        sc.close();
        int max = Collections.max(list);
        int index = list.indexOf(max);

        int[] result = {max, index};

        return result;
    }

    private static int[] findLocation(int index){
        int x = 1;
        int y = 1;

        x = x + (index / 9);
        y = y + (index % 9);

        int [] result = {x, y};

        return  result;
    }
}