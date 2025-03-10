package algorithm.이차원배열;

import algorithm.Question;

import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
        Question q1 = new 세로읽기1();
        q1.start();
    }
}

class 세로읽기1 implements Question{

    @Override
    public void start() {
        String[][] input = getInput();

        String result = "";

        for (int i = 0; i < 15; i++){
            for (int j = 0; j < 5; j++) {
                if (!input[j][i].equals(" ")){
                    result = result+ input[j][i];
                }
            }
        }

        System.out.println(result);
    }

    private static String[][] getInput(){
        Scanner sc = new Scanner(System.in);
        String[][] returnArray = new String[5][15];

        for (int i = 0; i < 5; i++){
            String input = sc.nextLine();
            String[] inputArray = input.split("");

            String[] stringArray = new String[15];

            // 15개의 배열에 대해 값을 채워줌
            for (int j = 0; j < 15; j++){
                if(j < inputArray.length){
                    stringArray[j] = inputArray[j];
                } else {
                    stringArray[j] = " ";  // 값이 없으면 공백 저장
                }
            }

            returnArray[i] = stringArray;
        }

        return returnArray;
    }
}

class 세로읽기2 implements Question{

    @Override
    public void start() {
        Scanner sc = new Scanner(System.in);
        String[] lines = new String[5];
        int maxLen = 0;

        // 5줄의 입력을 받고, 최대 길이도 계산
        for (int i = 0; i < 5; i++) {
            lines[i] = sc.nextLine();
            maxLen = Math.max(maxLen, lines[i].length());
        }
        sc.close();

        StringBuilder result = new StringBuilder();

        // 세로 읽기: 최대 길이까지 반복
        for (int col = 0; col < maxLen; col++) {
            for (int row = 0; row < 5; row++) {
                if (col < lines[row].length()) {
                    result.append(lines[row].charAt(col));
                }
            }
        }

        System.out.println(result);
    }
}