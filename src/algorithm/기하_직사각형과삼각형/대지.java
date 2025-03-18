package algorithm.기하_직사각형과삼각형;

import java.util.Scanner;

public class 대지 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count = sc.nextInt();

        int xNum = sc.nextInt();
        int yNum = sc.nextInt();

        int xBig = xNum, xSmall = xNum;
        int yBig = yNum, ySmall = yNum;

        for (int i = 1; i < count; i++){
            xNum = sc.nextInt();
            yNum = sc.nextInt();

            if (xNum > xBig){
                xBig = xNum;
            }
            if (xNum < xSmall){
                xSmall = xNum;
            }
            if (yNum > yBig){
                yBig = yNum;
            }
            if (yNum < ySmall){
                ySmall = yNum;
            }
        }

        int result = (xBig-xSmall) * (yBig-ySmall);
        System.out.println(result);
    }
}
