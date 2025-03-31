package algorithm.제출용;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 所要時間：1시간
 * 参考リンク：람다 사용법, sort 사용법
 */
public class Q3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int scheduleCount = sc.nextInt();

        // 入力として受け取ったスケジュール文字列
        String[] scheduleStrings = inputSchedule(scheduleCount, sc);

        // 入力されたスケジュールを開始時刻・終了時刻に分けて格納する配列
        int[][] scheduleIntervals = new int[scheduleCount][2];

        // 文字列のスケジュールをすべて分単位の整数に変換（開始時刻・終了時刻を分けて格納）
        for (int i = 0; i < scheduleStrings.length; i++){
            int[] interval = parseSchedule(scheduleStrings[i]);
            scheduleIntervals[i][0] = interval[0];
            scheduleIntervals[i][1] = interval[1];
        }

        // 結果を計算して出力
        System.out.println(computeResult(scheduleIntervals));
    }

    // 各スケジュールの時間を比較し、最も長い連続スケジュールを計算
    private static int computeResult(int[][] scheduleIntervals){

        // 開始時間を基準に昇順ソート
        Arrays.sort(scheduleIntervals, (a, b) -> Integer.compare(a[0], b[0]));

        int result = 0;

        // 最初の比較対象は一番早いスケジュールの開始・終了時間に設定（そのため事前に昇順でソート済み）
        int currentStart = scheduleIntervals[0][0];
        int currentEnd = scheduleIntervals[0][1];

        for (int i = 1; i < scheduleIntervals.length; i++){
            int start = scheduleIntervals[i][0];
            int end = scheduleIntervals[i][1];

            // 現在のスケジュール終了時間が次のスケジュール開始時間より遅い場合（＝重複している場合）
            if (start < currentEnd){
                currentEnd = Math.max(currentEnd, end);
            } else {
                // 重複していない場合、これまでの最長スケジュール時間を結果に保存し、新しい時間帯に切り替える
                result = Math.max(result, currentEnd - currentStart);

                currentStart = start;
                currentEnd = end;
            }
        }

        // 最後のスケジュール時間帯も結果と比較
        result = Math.max(result, currentEnd - currentStart);
        return result; // 最も長い連続時間を返す
    }

    // 文字列形式の時刻を分単位の整数に変換
    private static int convertToMinutes(String time) {
        String[] parts = time.split(":");
        return (Integer.parseInt(parts[0]) * 60) + Integer.parseInt(parts[1]);
    }

    // スケジュール文字列から開始時刻・終了時刻を抽出（分単位）
    private static int[] parseSchedule(String schedule) {
        int[] interval = new int[2];
        String[] times = schedule.split("~");
        interval[0] = convertToMinutes(times[0]);
        interval[1] = convertToMinutes(times[1]);

        return interval;
    }

    // スケジュールの入力を受け取る
    private static String[] inputSchedule(int count, Scanner sc) {
        String[] schedules = new String[count];

        for (int i = 0; i < count; i++){
            schedules[i] = sc.next();
        }
        sc.close();

        return schedules;
    }
}


