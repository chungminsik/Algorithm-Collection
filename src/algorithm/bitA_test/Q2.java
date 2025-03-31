package algorithm.bitA_test;


/**
 * 所要時間：2時間
 * 参考リンク：
 * dfs(14個の空欄がすべてつながっているか探索)
 * https://www.youtube.com/watch?v=By77aC9Oe3Q&ab_channel=%EC%9A%B0%EC%95%84%ED%95%9C%ED%85%8C%ED%81%AC
 * https://www.youtube.com/watch?v=gl5RhtU2mF8&t=12s&ab_channel=%EC%BD%94%EB%93%9C%EC%97%86%EB%8A%94%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%B0%8D
 * https://velog.io/@bbirong/3-1.-DFSBFS-%EA%B0%9C%EB%85%90-%EC%8B%A4%EC%A0%84-%EB%AC%B8%EC%A0%9C
 * https://adjh54.tistory.com/328
 */
public class Q2 {

    static int result = 0;

    public static void main(String[] args) {

        boolean[][] boardArray = new boolean[4][4];

        generateBoard(boardArray, 0, 0);

        System.out.println(result);

    }

    //全ての障害物配置パターンを生成する（バックトラッキング）
    private static void generateBoard(boolean[][] boardArray, int index, int count){

        //障害物が2個配置された場合、探索開始
        if (count == 2){
            result += startSearch(boardArray);
            return;
        }

        //インデックスが範囲外の場合、終了
        if (index >= 16) {
            return;
        }

        int row = index / 4;
        int column = index % 4;

        //現在のマスに障害物を配置しない場合
        generateBoard(boardArray, index + 1, count);

        //現在のマスに障害物を配置する場合
        boardArray[row][column] = true;
        generateBoard(boardArray, index + 1, count + 1);
        boardArray[row][column] = false;
    }

    //障害物が配置された盤面で探索を開始する
    private static int startSearch(boolean[][] boardArray){

        int total = 14;

        //盤面の各マスを起点として探索
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (!boardArray[i][j]) { //開始地点が空マスの場合
                    boolean[][] visited = new boolean[4][4];

                    //DFSを実行し、結果を取得
                    if (dfs(i, j, 1, total, boardArray, visited)) { //結果がtrueなら、14マス全てが連結されている
                        return 1;
                    }
                }
            }
        }

        return 0;
    }

    //深さ優先探索（DFS）によって空マスが連結しているかを確認
    private static boolean dfs(int row, int col, int totalEmpty, int total, boolean[][] board, boolean[][] visited) {

        //現在位置を訪問済みに設定
        visited[row][col] = true;

        //訪問したマスが全ての空マス数と一致すれば、連結確認完了
        if (totalEmpty == total) {
            return true;
        }

        //上下左右への移動を定義
        int[] dRow = {-1, 1, 0, 0};
        int[] dCol = {0, 0, -1, 1};

        for (int i = 0; i < 4; i++) { //上下左右への探索
            int newRow = row + dRow[i];
            int newCol = col + dCol[i];

            //盤面の範囲内で、障害物がなく、未訪問の場合
            if (newRow >= 0 && newRow < 4 && newCol >= 0 && newCol < 4 && !board[newRow][newCol] && !visited[newRow][newCol]) {

                //次のマスを探索
                if (dfs(newRow, newCol, totalEmpty + 1, total, board, visited)) { //DFSの結果がtrueの場合、そのままtrueを返す
                    return true;
                }
            }
        }

        //この経路での探索が失敗した場合、訪問済みを解除して戻る
        visited[row][col] = false;
        return false;
    }
}
