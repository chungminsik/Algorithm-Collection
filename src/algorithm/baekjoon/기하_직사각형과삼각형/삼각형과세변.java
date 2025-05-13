package algorithm.baekjoon.기하_직사각형과삼각형;

import java.util.*;

public class 삼각형과세변 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        boolean loop = true;
        while (loop){
            List<Integer> inputList = new ArrayList<>();

            int count = 0;
            for (int i = 0; i < 3; i++){
                int input = sc.nextInt();
                count += input;
                inputList.add(input);
            }

            if (count == 0){
                break;
            }

            inputList.sort(Collections.reverseOrder());

            //삼각형인지 아닌지
            if (inputList.get(0) >= inputList.get(1)+inputList.get(2)){
                System.out.println("Invalid");

            } else if (inputList.get(0).equals(inputList.get(1)) && inputList.get(1).equals(inputList.get(2))) {
                System.out.println("Equilateral");

            } else if(inputList.get(0).equals(inputList.get(1)) || inputList.get(1).equals(inputList.get(2)) || inputList.get(0).equals(inputList.get(2))){
                System.out.println("Isosceles");

            } else {
                System.out.println("Scalene");

            }
        }
        sc.close();

    }
}

