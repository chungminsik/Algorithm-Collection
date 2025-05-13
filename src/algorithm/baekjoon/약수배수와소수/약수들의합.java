package algorithm.baekjoon.약수배수와소수;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 약수들의합 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> inputList = new ArrayList<>();

        //입력처리
        boolean loop = true;
        while (loop){
            int inputData = sc.nextInt();

            if (inputData == -1){
                loop = false;
                sc.close();
            } else{
                inputList.add(inputData);
            }
        }

        //출력처리
        for (int input : inputList){
            List<Integer> factorList = new ArrayList<>();
            int factorTotal = 0;

            //계산결과가 약수이면서 i 가 input이 아니면
            for (int i = 1; i <= input; i++){
                if (input % i == 0 && input != i){
                    factorList.add(i);
                    factorTotal += i;
                }
            }

            if (!(factorList.size() <= 2) && factorTotal == input){
                StringBuilder sb = new StringBuilder(input + " = " + factorList.get(0));

                for (int j = 1; j < factorList.size(); j++){
                    sb.append(" + " + factorList.get(j));
                }

                System.out.println(sb);

            } else{
                System.out.println(input + " is NOT perfect.");
            }
        }
    }
}
