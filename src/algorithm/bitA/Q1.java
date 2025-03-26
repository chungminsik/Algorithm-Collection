package algorithm.bitA;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Q1 {
    static int totalSum = 0;

    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 1; i <= 9; i++) {
            numbers.add(i);
        }

        permute(numbers, 0);
        System.out.println("모든 꼭대기 숫자의 합: " + totalSum);
    }

    // 순열 생성 함수
    public static void permute(List<Integer> arr, int index) {
        if (index == arr.size()) {
            int top = buildPyramid(arr);
            totalSum += top;
            return;
        }

        for (int i = index; i < arr.size(); i++) {
            Collections.swap(arr, i, index);
            permute(arr, index + 1);
            Collections.swap(arr, i, index); // backtrack
        }
    }

    // 피라미드 계산 함수
    public static int buildPyramid(List<Integer> base) {
        List<Integer> current = new ArrayList<>(base);

        while (current.size() > 1) {
            List<Integer> next = new ArrayList<>();
            for (int i = 0; i < current.size() - 1; i++) {
                int sum = (current.get(i) + current.get(i + 1)) % 10;
                next.add(sum);
            }
            current = next;
        }

        return current.get(0); // 꼭대기 숫자
    }
}
