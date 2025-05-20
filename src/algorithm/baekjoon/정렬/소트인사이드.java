package algorithm.baekjoon.정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class 소트인사이드 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] n = br.readLine().split("");
        Arrays.sort(n, Collections.reverseOrder());

        StringBuilder sb = new StringBuilder();
        for (String str : n){
            sb.append(str);
        }
        System.out.println(sb);
    }
}
