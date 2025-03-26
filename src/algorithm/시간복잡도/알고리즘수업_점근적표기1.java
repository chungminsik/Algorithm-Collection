package algorithm.시간복잡도;

import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer;

public class 알고리즘수업_점근적표기1 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int a0 = sc.nextInt();
        int a1 = sc.nextInt();
        int c = sc.nextInt();;
        int n0 = sc.nextInt();
        sc.close();

        System.out.println(isBigO(a1, a0, c, n0) ? 1 : 0);
    }

    static boolean isBigO(int a1, int a0, int c, int n0) {
        for (int n = n0; n <= 1000; n++) {
            if (a1 * n + a0 > c * n) {
                return false;
            }
        }
        return true;
    }
}

//https://velog.io/@gayeong39/%EB%B0%B1%EC%A4%80-24313-%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98-%EC%88%98%EC%97%85-%EC%A0%90%EA%B7%BC%EC%A0%81-%ED%91%9C%EA%B8%B01
//내가 푼것 아님
class 알고리즘수업_점근식표기법1_1{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a1 = Integer.parseInt(st.nextToken());
        int a0 = Integer.parseInt(st.nextToken());

        int c = Integer.parseInt(br.readLine());
        int n0 = Integer.parseInt(br.readLine());
        br.close();

        if (a1*n0 + a0 <= c*n0 && c >= a1) { //참인 경우를 if문으로 만들어 작성한 것을 볼 수 있다.
            bw.write("1");
        } else {
            bw.write("0");
        }

        bw.flush();
        bw.close();

    }
}
