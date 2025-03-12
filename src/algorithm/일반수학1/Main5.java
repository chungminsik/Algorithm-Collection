package algorithm.일반수학1;

import algorithm.Question;

import java.util.Scanner;

public class Main5 {

    static int flag = 0;
    static int[] coordinate = {0, 0};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int loop = sc.nextInt();
        sc.close();

        for (int i = 0; i < loop-1; i++){
            //방향전환
            if (coordinate[flag] == 0){
                changeFlag();
                coordinate[flag] += 1;
                continue;
            }

            //지그재그
            if (flag == 0){
                left();
            } else if (flag == 1){
                right();
            }
        }

        String result = arrayToFractions(coordinate);
        System.out.println(result);
    }

    private static void changeFlag(){
        if (flag == 0){
            flag = 1;
        } else if (flag == 1){
            flag = 0;
        }
    }

    private static void left(){
        coordinate[0] -= 1;
        coordinate[1] += 1;
    }

    private static void right(){
        coordinate[0] += 1;
        coordinate[1] -= 1;
    }

    private static String arrayToFractions(int[] coordinate){
        int child = coordinate[0] + 1;
        int mother = coordinate[1] + 1;

        return child + "/" + mother;
    }
}
