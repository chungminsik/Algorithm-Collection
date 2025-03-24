package algorithm.심화1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 예전에는 운영체제에서 크로아티아 알파벳을 입력할 수가 없었다. 따라서, 다음과 같이 크로아티아 알파벳을 변경해서 입력했다.
 *
 * 크로아티아 알파벳	변경
 * č	            c=
 * ć	            c-
 * dž	            dz=
 * đ	            d-
 * lj	            lj
 * nj	            nj
 * š	            s=
 * ž	            z=
 *
 * 예를 들어, ljes=njak은 크로아티아 알파벳 6개(lj, e, š, nj, a, k)로 이루어져 있다. 단어가 주어졌을 때,
 * 몇 개의 크로아티아 알파벳으로 이루어져 있는지 출력한다.
 *
 * dž는 무조건 하나의 알파벳으로 쓰이고, d와 ž가 분리된 것으로 보지 않는다. lj와 nj도 마찬가지이다. 위 목록에 없는 알파벳은 한 글자씩 센다.
 *
 *
 * # 입력
 * 첫째 줄에 최대 100글자의 단어가 주어진다. 알파벳 소문자와 '-', '='로만 이루어져 있다.
 * 단어는 크로아티아 알파벳으로 이루어져 있다. 문제 설명의 표에 나와있는 알파벳은 변경된 형태로 입력된다.
 *
 * # 출력
 * 입력으로 주어진 단어가 몇 개의 크로아티아 알파벳으로 이루어져 있는지 출력한다.
 */
public class Main6 {
    public static void main(String[] args) {
        String text = requestAlphabet();
        String[] textArray = text.split("");

        int count = 0;
        int textArrayId = textArray.length-1;

        for (int i = 0; i < textArrayId; i++){
            String croatiaAlphabet = textArray[i] + textArray[(textArray.length) - (textArrayId-i)];
            System.out.println(croatiaAlphabet);

            if (croatiaAlphabetValidate(croatiaAlphabet)){
                count++;
            }
        }

        /*
            알파벳 을 구분해서 true false 까지 만드는 것은 해결
            그러나 false 로 판별된 알파벳을 세어주는 것
            3자리 로 되어있는 dz=가 판독 되지 않는 문제점이 있음
         */

        printResult(count);
    }

    //알파벳과 크로아티아어 알파벳이 들어 있는 Map 생성
    private static Map<String, String> getCroatiaMap(){
        Map<String, String> map = new HashMap<>();
        map.put("c=", "č");
        map.put("c-", "ć");
        map.put("dz=", "dž");
        map.put("d-", "đ");
        map.put("lj", "lj");
        map.put("nj", "nj");
        map.put("s=", "š");
        map.put("z=", "ž");

        return map;
    }

    private static String requestAlphabet(){
        Scanner sc = new Scanner(System.in);
        String text = sc.next();

        return text;
    }

    private static boolean croatiaAlphabetValidate(String alphabet){
        Map<String, String> croatiaAlphabet = getCroatiaMap();
        String result = croatiaAlphabet.get(alphabet);
        if (result == null){
            return false;
        }

        return true;
    }

    private static void printResult(int count){
        System.out.println("result : " + count);
    }
}
