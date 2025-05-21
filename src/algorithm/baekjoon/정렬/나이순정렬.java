package algorithm.baekjoon.정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 나이순정렬 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        String[][] user = new String[n][2];

        for (int i = 0; i < n; i++){
            String userInfo = br.readLine();
            String[] userInfoArray = userInfo.split(" ");

            user[i] = new String[] {userInfoArray[0], userInfo};
        }

        Arrays.sort(user, (a, b) -> {
            int intAgeA = Integer.parseInt(a[0]);
            int intAgeB = Integer.parseInt(b[0]);

            if (intAgeA < intAgeB){
                return -1;
            } else if (intAgeA == intAgeB){
                return 0;
            } else{
                return 1;
            }
        });

        StringBuilder sb = new StringBuilder();
        for (String[] userInfo : user){
            sb.append(userInfo[1]).append("\n");
        }
        System.out.println(sb);
    }
}
