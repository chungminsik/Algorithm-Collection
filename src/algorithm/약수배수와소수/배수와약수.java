package algorithm.약수배수와소수;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 배수와약수 {
    public static void main(String[] args) {
        List<int[]> inputList = input();

        for (int i = 0; i < inputList.size(); i++){

            boolean isFactor = factor(inputList.get(i));
            boolean isMultiple = multiple(inputList.get(i));

            if (isFactor){
                System.out.println("factor");
            } else if (isMultiple){
                System.out.println("multiple");
            } else{
                System.out.println("neither");
            }
        }
    }

    private static List<int[]> input(){
        Scanner sc = new Scanner(System.in);
        List<int[]> resultList = new ArrayList<>();

        boolean loop = true;
        while(loop){
            int[] array = new int[2];

            int left = sc.nextInt();
            int right = sc.nextInt();

            if (left == 0 && right == 0){
                loop = false;
            } else {
                array[0] = left;
                array[1] = right;

                resultList.add(array);
            }
        }

        sc.close();
        return resultList;
    }

    private static boolean factor(int[] array){
        return array[1] % array[0] == 0 ? true : false;
    }

    private static boolean multiple(int[] array){
        return array[0] % array[1] == 0 ? true : false;
    }
}

//무한 루프 돎
class 배수와약수2{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        while(true){
            int left = sc.nextInt();
            int right = sc.nextInt();

            if (left == 0 && right == 0){
                break;

            } else {
                if (right % left == 0 ? true : false){
                    System.out.println("factor");
                } else if (left % right == 0 ? true : false){
                    System.out.println("multiple");
                } else{
                    System.out.println("neither");
                }
            }
        }

        sc.close();
    }
}
