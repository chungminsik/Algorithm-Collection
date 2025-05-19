package algorithm.baekjoon.정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 좌표정렬하기2 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[][] xy = new int[n][2];

        for (int i = 0; i < n; i++){
            String[] input = br.readLine().split(" ");
            xy[i][0] = Integer.parseInt(input[0]);
            xy[i][1] = Integer.parseInt(input[1]);
        }

        Arrays.sort(xy, (a, b) -> {
            if (a[1] != b[1]){
                return a[1] - b[1];
            }else {
                return a[0] - b[0];
            }
        });

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++){
            String output = xy[i][0] + " " + xy[i][1];
            sb.append(output).append('\n');
        }
        System.out.println(sb);
    }

}
