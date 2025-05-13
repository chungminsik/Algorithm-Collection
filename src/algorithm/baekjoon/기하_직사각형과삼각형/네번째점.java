package algorithm.baekjoon.기하_직사각형과삼각형;

import java.util.*;

public class 네번째점 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int[] x = new int[3];
        int[] y = new int[3];

        for (int i = 0; i < 3; i++){
            x[i] = sc.nextInt();
            y[i] = sc.nextInt();
        }

        int result_x = findUniqueNumber(x);
        int result_y = findUniqueNumber(y);

        System.out.println(result_x + " " + result_y);

    }

    public static int findUniqueNumber(int[] arr) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();

        // 숫자의 빈도수 계산
        for (int num : arr) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        // 빈도수가 1인 숫자 찾기
        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }

        return -1; // 예외 처리 (모든 숫자가 짝이 맞을 경우)
    }
}
