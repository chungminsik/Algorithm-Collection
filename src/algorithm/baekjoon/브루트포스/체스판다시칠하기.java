package algorithm.baekjoon.브루트포스;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


/*
문제 분석이 잘 안되었었다. 왜 인지 모르겠지만 반복문을 통해 정답을 찾아나가는 것이다 라는 것에 집중한 나머지
정답으로 제시된 체스판 규격이 있다는 것을 간과했다.(b로 시작되는 체스판인가  w로 시작되는 체스판인가)

B로 시작하는 체스판일 때 수정 갯수 W로 시작할 때 수정 갯수를 구하고
이 두가지 경우의 수정 갯수 중 가장 작은 것을 구하는 문제였다

- 자른 종이의 위치와 원하는 체스판이 어떤 색깔로 시작하는지에 따라서 수정하는 곳의 갯수가 달라진다.
- 종이를 자르면 시작하는 종이의 경우를 같이 비교해 볼 수 있다.
- 종이를 자르고 검은색으로 시작할 때 하얀색으로 시작할 때를 비교해서 둘 중 작은 값을 우선 저장한다
- 이후 종이를 다르게 자르고 이전 작업을 반복한다
 */
public class 체스판다시칠하기 {
    public static void main(String[] args) throws IOException {

        //입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        /*
         String말고 char로 보관하면 나중에 문자 비교할 때 더 간편하다
         */
        String[] xy = br.readLine().split(" ");
        int x = Integer.parseInt(xy[0]);
        int y = Integer.parseInt(xy[1]);
        String[][] array = new String[x][y];

        for (int i = 0; i < x; i++){
            array[i] = br.readLine().split("");
        }

        int result = Integer.MAX_VALUE;

        //체스판 크기로 입력값을 한번씩 모두 자르기
        for (int i = 0; i < x-8; i++){
            for (int j = 0; j < y-8; j++){
                //필요한 수정 부분 탐색 및 출력값 저장
                int editArea = searchEditArea(cutBoard(array, i, j));

                //저장된 출력값과 현재 값을 비교 만약 자신의 값이 더 작으면 교체
                if (editArea < result){
                    result = editArea;
                }
            }
        }

        //출력
        System.out.println(result);
    }

/*
cutBoard searchEditArea의 for반복문의 범위가 같기 때문에 한꺼번에 할 수 있다
returnArray[i][j] = board[x+i][y+j];
String cell = board[i][j];

char actual = b[startX + i][startY + j];
위의 두개의 메소드로 나누어져있는 문장과 아래 한문장은 같은 문장이다

 */


    public static String[][] cutBoard(String[][] board, int x, int y){
        String[][] returnArray = new String[8][8];

        for(int i = x; i < 8; i++){
            for(int j = y; j < 8; j++){
                returnArray[i][j] = board[x+i][y+j];
            }
        }
        return returnArray;
    }

    public static int searchEditArea(String[][] board){
        int repaintCount1 = 0; // (0,0)이 W인 체스판 기준
        int repaintCount2 = 0; // (0,0)이 B인 체스판 기준

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                String cell = board[i][j];
                // (i+j)%2==0 위치에는 시작색, 홀수 위치에는 반대색
                String expected1 = ((i + j) % 2 == 0) ? "W" : "B";
                String expected2 = ((i + j) % 2 == 0) ? "B" : "W";

                if (!cell.equals(expected1)) repaintCount1++;
                if (!cell.equals(expected2)) repaintCount2++;
            }
        }
        return Math.min(repaintCount1, repaintCount2);
    }
}

class 체스판다시칠하기2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] dims = br.readLine().split(" ");
        int N = Integer.parseInt(dims[0]);
        int M = Integer.parseInt(dims[1]);

        // 1) 문자열 한 줄을 그대로 읽어서 char 배열로 보관
        char[][] board = new char[N][M];
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                board[i][j] = line.charAt(j);
            }
        }

        // 2) 초기값은 아주 큰 값으로
        int result = Integer.MAX_VALUE;

        // 3) 시작 좌표는 0 <= i <= N-8, 0 <= j <= M-8
        for (int i = 0; i <= N - 8; i++) {
            for (int j = 0; j <= M - 8; j++) {
                // (i,j)에서 8×8 부분판 다시칠할 최소값 계산
                int repaint = countRepaint(board, i, j);
                result = Math.min(result, repaint);
            }
        }

        System.out.println(result);
    }

    /**
     * (startX, startY) 위치에서 8×8 부분판을 잘라,
     * '첫 칸 W', '첫 칸 B' 두 가지 패턴에 대해 다시 칠해야 할 수를 세고
     * 그 중 더 작은 값을 반환
     */
    private static int countRepaint(char[][] b, int startX, int startY) {
        int repaintW = 0;  // (0,0)이 'W'일 때
        int repaintB = 0;  // (0,0)이 'B'일 때

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                char actual = b[startX + i][startY + j];

                // (i+j)%2==0 위치엔 시작색, else 반대색
                char expectW = ((i + j) % 2 == 0) ? 'W' : 'B';
                char expectB = ((i + j) % 2 == 0) ? 'B' : 'W';

                if (actual != expectW) repaintW++;
                if (actual != expectB) repaintB++;
            }
        }
        return Math.min(repaintW, repaintB);
    }
}
