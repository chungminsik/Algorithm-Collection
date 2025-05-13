package bitA_Algorithm;

/**
 * 1. 120가지의 장애물을 놓을 수 있는 경우의 수의 2차원 배열을 생성 (백트래킹)
 * 2. 시작점을 찾기
 * 3. 시작점부터 순차적으로 dfs를 통해서 14개의 노드가 연결되어 있는지 찾기
 * 4. 연결되어있는 노드가 하나라도 발견되면 1을 리턴(그 장애물 조합은 우리가 찾는 케이스이다)
 */
public class Q2 {

    static int result = 0;

    public static void main(String[] args) {

        boolean[][] board = new boolean[4][4];
        generateBoard(board, 0, 0);

        System.out.println(result);

    }

    //バックトラッキング
    //백트래킹을 이용해 모든 경우의 수의 보드를 만들기
    //count : 장애물을 놓았는지 세는 변수

    /**
     * @logic 백트래킹과 재귀를 이용해서 120가지의 장애물 정보를 담은 배열을 생성합니다. 배열을 생성함과 동시에 startSearch()를 이용해 14개의 노드가 모두 이어져 있는 경우의 수가 있는지 계산합니다.
     *
     * @param board 장애물 정보를 담을 [4][4] 형태의 빈 배열을 초기에 할당해줍니다. 이후 재귀를 돌면서
     * @param pos
     * @param count
     */
    private static void generateBoard(boolean[][] board, int pos, int count){

        //장애물 다 놓았으니 계산하러 가기
        if (count == 2){
            result += startSearch(board);
            return;
        }

        // 모든 칸을 다 확인했지만 장애물 개수가 2개가 아니라면 종료
        if (pos >= 16) {
            return;
        }

        int row = pos / 4;
        int column = pos % 4;

        generateBoard(board, pos + 1, count);

        board[row][column] = true;
        generateBoard(board, pos+1, count+1);
        board[row][column] = false;
    }

    //보드를 만들면 계산해서 한붓을 그릴 수 있는지 만들기
    //지나간 경로가 14 == return 1
    //지나간 경로가 14!= return 0
    private static int startSearch(boolean[][] board){

        int totalEmpty = 14;

        // 모든 빈 칸(장애물이 없는 칸)을 시작점으로 DFS 시도
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (!board[i][j]) { // 시작점이 빈 칸이면
                    boolean[][] visited = new boolean[4][4]; // 각 시작점마다 새로운 방문 배열
                    if (dfs(i, j, 1, totalEmpty, board, visited)) {
                        return 1;
                    }
                }
            }
        }

        return 0;
    }

    //dfsアルゴリズムリンク
    // DFS: (row, col)에서 시작해 현재까지 count개의 빈 칸을 방문했을 때,
    // 전체 total개의 빈 칸을 모두 방문할 수 있으면 true, 아니면 false
    private static boolean dfs(int row, int col, int count, int total, boolean[][] board, boolean[][] visited) {
        // 현재 칸 방문 처리
        visited[row][col] = true;

        // 모든 빈 칸을 방문했다면 경로 완성!
        if (count == total) {
            return true;
        }

        // 상, 하, 좌, 우 이동을 위한 방향 벡터
        int[] dRow = {-1, 1, 0, 0};
        int[] dCol = {0, 0, -1, 1};

        for (int i = 0; i < 4; i++) {
            int newRow = row + dRow[i];
            int newCol = col + dCol[i];

            // 보드 범위 안에 있고, 장애물이 없으며, 아직 방문하지 않은 칸인지 확인
            if (newRow >= 0 && newRow < 4 && newCol >= 0 && newCol < 4 && !board[newRow][newCol] && !visited[newRow][newCol]) {
                if (dfs(newRow, newCol, count + 1, total, board, visited)) {
                    return true;
                }
            }
        }

        // 백트래킹: 현재 칸 방문 상태를 원복하여 다른 경로 탐색에 영향 주지 않도록 함
        visited[row][col] = false;
        return false;
    }

}
