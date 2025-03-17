package algorithm.기하_직사각형과삼각형;

import java.util.Arrays;
import java.util.Scanner;

public class 직사각형에서탈출 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int x = sc.nextInt();
        int y = sc.nextInt();
        int w = sc.nextInt();
        int h = sc.nextInt();

        int x1 = w-x;
        int y1 = h-y;

        int[] result = {x, y, x1, y1};

        System.out.println(Arrays.stream(result).min().getAsInt());

    }
}
