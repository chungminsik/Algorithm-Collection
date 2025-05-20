package algorithm.baekjoon.정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 나이순정렬 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String[][] users = new String[n][2];

        for (int i = 0; i < n; i++){
            String[] user = br.readLine().split(" ");
            users[i] = user;
        }


//        Arrays.sort(users, (a, b) -> {
//
//        });

        StringBuilder sb = new StringBuilder();
        for (String[] user : users){
            sb.append(user[0]).append(" ").append(user[1]).append("\n");
        }
        System.out.println(sb);
    }
}
