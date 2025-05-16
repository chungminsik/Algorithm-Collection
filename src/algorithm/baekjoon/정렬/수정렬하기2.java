package algorithm.baekjoon.정렬;

import java.util.Arrays;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class 수정렬하기2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 1. 첫 줄: 정수 개수
        int count = Integer.parseInt(br.readLine());
        int[] array = new int[count];

        // 2. 다음 count개 줄: 각 정수 읽기
        for (int i = 0; i < count; i++) {
            array[i] = Integer.parseInt(br.readLine());
        }

        // 3. 정렬
        Arrays.sort(array);

        // 4. StringBuilder에 모아서 한 번에 출력
        StringBuilder sb = new StringBuilder();
        for (int num : array) {
            sb.append(num).append('\n');
        }

        System.out.print(sb);
        // BufferedReader는 닫지 않아도 JVM 종료 시 자동으로 정리됩니다.
    }
}
