package algorithm.제출용;


/**
 * 所要時間：
 * 参考リンク：
 * youtube : https://www.youtube.com/watch?v=MolDbkwapzU&list=PLDV-cCQnUlIaAKZbfdkMU01MrMkeTvVgP&index=1
 * 　https://www.youtube.com/watch?v=Ar40zcPoKEI&list=PLDV-cCQnUlIaAKZbfdkMU01MrMkeTvVgP&index=2
 * 　https://www.youtube.com/watch?v=gVijWUHWzAU&list=PLDV-cCQnUlIaAKZbfdkMU01MrMkeTvVgP&index=3
 * 　https://www.youtube.com/watch?v=lhy9mtUqZGc&list=PLDV-cCQnUlIaAKZbfdkMU01MrMkeTvVgP&index=4
 * 　https://www.youtube.com/watch?v=Enz2csssTCs
 *
 * 練習問題：https://www.acmicpc.net/problem/15649
 * 　https://www.acmicpc.net/problem/15650
 * 　https://www.acmicpc.net/problem/15651
 */
public class Q1 {

    // 結果を保存する変数
    private static long totalSum = 0;

    public static void main(String[] args) {

        //順列を格納する配列
        int[] permArray = new int[9];
        // 数字の重複を防ぐために使用済みかどうかを記録する配列
        boolean[] used = new boolean[9];

        //計算開始
        executeCompute(permArray, used, 0);

        //計算終了後に結果を表示
        System.out.println(totalSum);
    }

    //ピラミッドの最下段の順列を作成し、計算後に結果を累積
    private static void executeCompute(int[] permArray, boolean[] used, int depth){

        //完成した順列に対して計算を実行し結果を累積
        if (depth == 9){
            totalSum += getTopNumber(permArray);
            return;
        }

        //未使用の数字を選択し、再帰的に順列を生成
        for (int i = 0; i < 9; i++){
            if (!used[i]){
                permArray[depth] = i;
                used[i] = true;

                executeCompute(permArray, used, depth+1);

                used[i] = false; //他の組み合わせでも使用できるように戻す
            }
        }
    }

    //ピラミッドの最下段の順列を元に、頂点の数値を再帰的に計算
    private static int getTopNumber(int[] permArray) {

        //頂点に到達したら再帰を終了
        if (permArray.length == 1) {
            return permArray[0];
        }

        //次の段階（上の段）の数値を保存する新しい配列を生成
        int[] newArray = new int[permArray.length - 1];

        //隣り合う数字を足し、次の段階の数値を計算（mod10）
        for (int i = 0; i < permArray.length - 1; i++) {
            newArray[i] = (permArray[i] + permArray[i+1]) % 10;
        }

        return getTopNumber(newArray); //配列の長さが1になるまで再帰処理を繰り返す
    }
}