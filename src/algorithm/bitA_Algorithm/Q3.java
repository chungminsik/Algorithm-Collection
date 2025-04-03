package algorithm.bitA_Algorithm;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 1. 입력값을 받고
 * 2. 시간을 비교할 수 있게끔 문자열을 알맞게 숫자로 바꾸어서 배열로 리턴
 * 3. 입력받은 배열을 오름차순으로 정렬
 * 4. 계산 후 출력
 */

public class Q3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int scheduleCount = sc.nextInt();

        String[] scheduleStrings = readSchedules(scheduleCount, sc);
        int[][] scheduleIntervals = new int[scheduleCount][2];

        for (int i = 0; i < scheduleStrings.length; i++){
            int[] interval = parseSchedule(scheduleStrings[i]);
            scheduleIntervals[i][0] = interval[0];
            scheduleIntervals[i][1] = interval[1];
        }

        //参考書リンク
        // 시작 시각 기준으로 오름차순 정렬
        Arrays.sort(scheduleIntervals, (a, b) -> Integer.compare(a[0], b[0]));

        //계산 후 출력
        System.out.println(computeResult(scheduleIntervals));
    }

    //결과 값 계산
    private static int computeResult(int[][] scheduleIntervals){

        //첫번째 값을 기준으로 비교해가며 연산 진행
        int result = 0;
        int currentStart = scheduleIntervals[0][0];
        int currentEnd = scheduleIntervals[0][1];

        for (int i = 1; i < scheduleIntervals.length; i++){
            int start = scheduleIntervals[i][0];
            int end = scheduleIntervals[i][1];

            if (start < currentEnd){
                currentEnd = Math.max(currentEnd, end);
            } else{
                result = Math.max(result, currentEnd - currentStart);
                currentStart = start;
                currentEnd = end;
            }
        }

        result = Math.max(result, currentEnd - currentStart);
        return result;
    }

    //Input 작업 + 결과 가져가기
    private static String[] readSchedules(int count, Scanner sc) {
        String[] schedules = new String[count];

        for (int i = 0; i < count; i++){
            schedules[i] = sc.next();
        }
        sc.close();

        return schedules;
    }

    //변환하기 형변환
    private static int[] parseSchedule(String schedule) {
        int[] interval = new int[2];
        String[] times = schedule.split("~");
        interval[0] = convertToMinutes(times[0]);
        interval[1] = convertToMinutes(times[1]);

        return interval;
    }

    //변환하기 단위
    private static int convertToMinutes(String time) {
        String[] parts = time.split(":");
        return (Integer.parseInt(parts[0]) * 60) + Integer.parseInt(parts[1]);
    }
}


