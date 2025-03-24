package algorithm.심화1;

/**
 * 아직 글을 모르는 영석이가 벽에 걸린 칠판에 자석이 붙어있는 글자들을 붙이는 장난감을 가지고 놀고 있다.
 * 이 장난감에 있는 글자들은 영어 대문자 'A'부터 Z, 영어 소문자 'a'부터 2', 숫자 0'부터 9'이다.
 * 영석이는 칠판에 글 자들을 수평으로 일렬로 붙여서 단어를 만든다. 다시 그 아래쪽에 글자들을 붙여서 또 다른 단어를 만든다.
 * 이런 식으 로 다섯 개의 단어를 만든다. 아래 그림 1은 영석이가 칠판에 붙여 만든 단어들의 예이다.
 *
 * A A B C D D
 * a f z z
 * 0 9 1 2 1
 * a 8 E W g 6
 * P 5 h 3 k x
 *
 * 한 줄의 단어는 글자들을 빈칸 없이 연속으로 나열해서 최대 15개의 글자들로 이루어진다.
 * 또한 만들어진 다섯 개의 단어들의 글자 개수는 서로 다를 수 있다.
 * 심심해진 영석이는 칠판에 만들어진 다섯 개의 단어를 세로로 읽으려 한다.
 * 세로로 읽을 때, 각 단어의 첫 번째 글자들 을 위에서 아래로 세로로 읽는다.
 * 다음에 두 번째 글자들을 세로로 읽는다. 이런 식으로 왼쪽에서 오른쪽으로 한 자리 씩 이동 하면서 동일한 자리의 글자들을 세로로 읽어 나간다.
 * 위의 그림 1의 다섯 번째 자리를 보면 두 번째 줄의 다섯 번째 자리의 글자는 없다.
 * 이런 경우처럼 세로로 읽을 때 해당 자리의 글자가 없으면, 읽지 않고 그 다음 글자를 계속 읽는다.
 * 그림 1의 다섯 번째 자리를 세로로 읽으면 D1gk로 읽는다.
 *
 * 그림 1에서 영석이가 세로로 읽은 순서대로 글자들을 공백 없이 출력하면 다음과 같다:
 * Aa0aPAf985Bz1EhCz2W3D1gkD6x
 *
 * 칠판에 붙여진 단어들이 주어질 때, 영석이가 세로로 읽은 순서대로 글자들을 출력하는 프로그램을 작성하시오.
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * 입력 : 총 다섯줄의 입력이 주어진다. 각 줄에는 최소 1개, 최대 15개의 글자들이 빈칸 없이 연속으로 주어진다.
 *      주어지는 글 자는 영어 대문자 'A'부터 2, 영어 소문자 'a'부터 2', 숫자 '0'부터 9' 중 하나이다. 각 줄의 시작과 마지막에 빈칸은 없다
 *
 * 출력 : 영석이가 세로로 읽은 순서대로 글자들을 출력한다. 이때, 글자들을 공백 없이 연속해서 출력한다.
 */

public class 그룹단어체커 {
    public static void main(String[] args){
        List<String> board = inputString();

        List<List<String>> boardList = makeBoardBlank(board, findLongestStringLength(board));

        printBoardColumn(boardList);
    }


    //String 입력받고 리스트 반환
    private static List<String> inputString(){
        Scanner sc = new Scanner(System.in);
        List<String> board = new ArrayList<>();

        for (int i = 0; i < 5; i++){
            String sentance = sc.next();
            board.add(sentance);
        }

        return board;
    }

    //리스트에서 가장 긴 String의 길이를 반환
    private static int findLongestStringLength(List<String> board){
        int longestLength = 0;

        for (String sentance : board){
            if (sentance.length() > longestLength){
                longestLength = sentance.length();
            }
        }

        return longestLength;
    }

    //String을 리스트 변환, 만약 가장 긴 String보다 짧으면 긴 숫자 만큼 빈 String 만들기
    private static List<List<String>> makeBoardBlank(List<String> sentance, int stringLength){
        List<List<String>> resultSentanceList = new ArrayList<>();

        int sentanceSize = sentance.size();

        for (String word : sentance){
            List<String> resultSentance = new ArrayList<>();

            resultSentance.add(word);

            for (int i = 0; i < stringLength-sentanceSize; i++){
                resultSentance.add("");
            }

            resultSentanceList.add(resultSentance);
        }

        return resultSentanceList;
    }

    //리스트를 세로로 훓어서 String으로 만들어서 변환
    private static void printBoardColumn(List<List<String>> board){
        String result = "";

        

    }




    //
    private static String findBoardString(List<List<String>> stringBoard, int index){
        int nullStatus = 0;
        String result = "";

        for (int j = 0; j < 5; j++){
            String board = stringBoard.get(j).get(index);

            if (board.equals(null)){
                nullStatus ++;
            }
            if (nullStatus == 5){
                break;
            }

            result += board;
        }

        return result;
    }

    private static List<List<String>> getStringBoard(){
        Scanner sc = new Scanner(System.in);
        List<List<String>> boards = new ArrayList<>();

        for (int i = 0; i < 5; i++){
            List<String> board = Arrays.stream(sc.next().split("")).toList();
            boards.add(board);
        }

        return boards;
    }
}
