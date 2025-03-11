package algorithm.이차원배열;

import algorithm.Question;

import java.util.Scanner;

public class Main4 {
    public static void main(String[] args) {
        Question q = new 색종이1();
        q.start();
    }
}

class 색종이1 implements Question{

    @Override
    public void start() {

        boolean[][] paper = new boolean[100][100];
        int inputCount;
        int[][] paperLocation;

        //입력
        Scanner sc = new Scanner(System.in);

        inputCount = sc.nextInt();
        paperLocation = new int[inputCount][2];

        for (int i = 0; i < inputCount; i++){
            paperLocation[i][0] = sc.nextInt();
            paperLocation[i][1] = sc.nextInt();
        }
        sc.close();

        //색종이 붙이기
        for (int i = 0; i < inputCount; i++){
            int a = paperLocation[i][0];
            int b = paperLocation[i][1];

            for (int j = 0; j < 10; j++){
                for (int k = 0; k < 10; k++){
                    paper[a+j][b+k] = true;
                }
            }
        }

        // 붙은 면적 새기
        int resultCount = 0;

        for (boolean[] array : paper){
            for (boolean check : array){
                if (check){
                    resultCount++;
                }
            }
        }

        //출력
        System.out.println(resultCount);
    }
}

