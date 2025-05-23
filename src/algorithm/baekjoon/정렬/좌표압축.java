package algorithm.baekjoon.정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class 좌표압축 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        Integer[] array = new Integer[n];
        Set<Integer> set = new HashSet<>();

        String[] inputString = br.readLine().split(" ");

        for (int i = 0; i < n; i++){
            int input = Integer.parseInt(inputString[i]);

            array[i] = input;
            set.add(input);
        }

        Integer[] setArray = set.toArray(new Integer[set.size()]);
        Arrays.sort(setArray);

        for (int i = 0; i < n; i++){
            int searchIndex = Arrays.binarySearch(setArray, array[i]);
            array[i] = searchIndex;
        }

        StringBuilder sb = new StringBuilder();
        for (int result : array){
            sb.append(result).append(" ");
        }
        System.out.println(sb);
    }
}


/*
重複問題が解決できていない
 */
class 좌표출력miyu{

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Integer[] array = new Integer[n];

        String[] inputString = br.readLine().split(" ");

        for (int i = 0; i < n; i++){
            int input = Integer.parseInt(inputString[i]);
            array[i] = input;
        }

        int[] returnArray = new int[n];

        for (int j = 0; j < n; j++){
            int count = 0;

            for (int i = 0; i < n; i++){

                if (array[j] > array[i]){
                    count++;
                }

            }

            returnArray[j] = count;
        }

        StringBuilder sb = new StringBuilder();
        for (int result : returnArray){
            sb.append(result).append(" ");
        }
        System.out.println(sb);

    }

}
