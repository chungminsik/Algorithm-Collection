package algorithm.baekjoon.정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class 단어정렬 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        Set<String> set = new HashSet<>();

        for (int i = 0; i < n; i++){
            set.add(br.readLine());
        }

        String[] array =  set.toArray(new String[set.size()]);

        Arrays.sort(array);

        Arrays.sort(array, (a, b) -> {
            if (a.length() < b.length()){
                return -1;
            } else if (a.length() == b.length()){
                return 0;
            } else{
                return 1;
            }
        });

        Arrays.sort(array, (a, b) -> {
            if (a.length() == b.length()){

                char[] charArray1 = a.toCharArray();
                char[] charArray2 = b.toCharArray();

                for (int i = 0; i < charArray1.length; i++){
                    if (charArray1[i] != charArray2[i]){
                        return charArray1[i] - charArray2[i];
                    }
                }

                return 0;

            }else {
                return 1;
            }
        });

        StringBuilder sb = new StringBuilder();
        for(Object str : array){
            sb.append((String) str).append('\n');
        }

        System.out.println(sb);
    }
}

