package algorithm.제출용;


/**
 * 所要時間：
 * 参考リンク：
 */
public class Q2 {

    static int result = 0;

    public static void main(String[] args) {

        boolean[][] boardArray = new boolean[4][4];

        generateBoard(boardArray, 0, 0);

        System.out.println(result);

    }

    private static void generateBoard(boolean[][] boardArray, int index, int depth){

        if (depth == 2){
            result += startSearch(boardArray);
            return;
        }

        if (index >= 16) {
            return;
        }

        int row = index / 4;
        int column = index % 4;

        generateBoard(boardArray, index + 1, depth);

        boardArray[row][column] = true;

        generateBoard(boardArray, index +1, depth +1);

        boardArray[row][column] = false;
    }

    private static int startSearch(boolean[][] boardArray){

        int totalEmpty = 14;

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (!boardArray[i][j]) { // 시작점이 빈 칸이면
                    boolean[][] visited = new boolean[4][4]; // 각 시작점마다 새로운 방문 배열
                    if (dfs(i, j, 1, totalEmpty, boardArray, visited)) {
                        return 1;
                    }
                }
            }
        }

        return 0;
    }

    private static boolean dfs(int row, int col, int count, int total, boolean[][] board, boolean[][] visited) {

        visited[row][col] = true;

        if (count == total) {
            return true;
        }

        int[] dRow = {-1, 1, 0, 0};
        int[] dCol = {0, 0, -1, 1};

        for (int i = 0; i < 4; i++) {
            int newRow = row + dRow[i];
            int newCol = col + dCol[i];

            if (newRow >= 0 && newRow < 4 && newCol >= 0 && newCol < 4 && !board[newRow][newCol] && !visited[newRow][newCol]) {
                if (dfs(newRow, newCol, count + 1, total, board, visited)) {
                    return true;
                }
            }
        }

        visited[row][col] = false;
        return false;
    }

}
