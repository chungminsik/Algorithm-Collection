package algorithm.baekjoon.정렬;

import java.util.Arrays;
import java.util.Scanner;

public class 수정렬하기 {

    public static void main(String[] args) {

        int[] array;
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        array = new int[n];
        for (int i = 0; i < n; i++){
            array[i] = sc.nextInt();
        }

        Arrays.sort(array);

        for (int number : array){
            System.out.println(number);
        }

    }
}

class 내가만든삽입정렬알고리즘으로수정렬하기{
    public static void main(String[] args) {

        int[] array;
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        array = new int[n];

        for (int i = 0; i < n; i++){
            array[i] = sc.nextInt();
        }

        int[] sortedArray = insertSort(array);

        for (int num : sortedArray){
            System.out.println(num);
        }

    }

    public static int[] insertSort(int[] array){
        int[] sortedArray = array;

        for (int i = 1; i < array.length; i++){
            for (int j = i; j > 0; j--){
                if (array[j-1] > array[j]){
                    int change = array[j-1];
                    array[j-1] = array[j];
                    array[j] = change;
                }
            }

        }

        return sortedArray;
    }
}

class 내가만든선택정렬알고리즘으로수정렬하기{
    public static void main(String[] args) {

        int[] array;
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        array = new int[n];

        for (int i = 0; i < n; i++){
            array[i] = sc.nextInt();
        }

        int[] sortedArray = selectionSort(array);

        for (int num : sortedArray){
            System.out.println(num);
        }

    }

    public static int[] selectionSort(int[] array){
        int[] sortedArray = array;
        int currentIndex = 0;

        while (array.length != currentIndex){
            int smallIndex = currentIndex;

            for (int i = currentIndex; i < array.length; i++){
                if (array[i] < array[smallIndex]){
                    smallIndex = i;
                }
            }

            int smallNum = array[smallIndex];
            array[smallIndex] = array[currentIndex];
            array[currentIndex] = smallNum;

            currentIndex++;
        }

        return sortedArray;
    }
}