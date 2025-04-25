package algorithm;

public class Haha {

    private static int n = 8; // 보드 크기
    private static int[][] board = new int[n][n];

    public static void main(String[] args) {
        nQueen(0, board);
    }

    // 백트래킹 재귀 함수
    private static void nQueen(int row, int[][] board) {
        if (row == n) {
            printBoard(board);
            System.out.println();

            return;
        }

        for (int col = 0; col < n; col++) {
            if (board[row][col] == 0) {
                int[][] newBoard = copyBoard(board);

                newBoard[row][col] = 1;

                int[][] attacked = queenRoute(newBoard, row, col);

                nQueen(row + 1, attacked);
            }
        }
    }

    // 1. queenRoute 수정: 공격 칸은 -1, 퀸 자리는 그대로
    public static int[][] queenRoute(int[][] board, int x, int y) {
        int n = board.length;

        // 가로·세로
        for (int i = 0; i < n; i++) {
            if (board[x][i] == 0) {
                board[x][i] = -1;  // 공격 칸
            }
            if (board[i][y] == 0) {
                board[i][y] = -1;
            }
        }

        // 대각선 (\ 방향)과 (/ 방향)
        for (int i = -n; i < n; i++) {
            int dx = x + i;
            int dy1 = y + i;
            int dy2 = y - i;

            if (0 <= dx && dx < n) {
                if (0 <= dy1 && dy1 < n && board[dx][dy1] == 0) {
                    board[dx][dy1] = -1;
                }
                if (0 <= dy2 && dy2 < n && board[dx][dy2] == 0) {
                    board[dx][dy2] = -1;
                }
            }
        }

        return board;
    }

    // 2. printBoard 수정: 1만 출력하고, 나머지는 모두 0으로 보이게
    private static void printBoard(int[][] board) {
        for (int[] row : board) {
            for (int cell : row) {
                System.out.print((cell == 1 ? "1 " : "0 "));
            }
            System.out.println();
        }
    }

    // 보드 복사
    private static int[][] copyBoard(int[][] original) {
        int[][] copy = new int[original.length][original[0].length];

        for (int i = 0; i < original.length; i++) {
            System.arraycopy(original[i], 0, copy[i], 0, original[i].length);
        }

        return copy;
    }
}
