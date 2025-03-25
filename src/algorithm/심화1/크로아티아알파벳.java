package algorithm.심화1;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class 크로아티아알파벳 {
    public static void main(String[] args) {
        char[] inputArray = new Scanner(System.in).next().toCharArray();

        //크로아티아를 만나면 사이즈를 줄여감
        int size = inputArray.length;
        for (int i = 0; i < inputArray.length-1; i++){
            if (inputArray[i] == 'c' && inputArray[i+1] == '=' || inputArray[i+1] == '-'){
                size -= 1;
            } else if (inputArray[i] == 'd' && inputArray[i+1] == 'z' || inputArray[i+1] == '-'){
                size -= 1;
            } else if (inputArray[i] == 'l' && inputArray[i+1] == 'j'){
                size -= 1;
            } else if (inputArray[i] == 'n' && inputArray[i+1] == 'j') {
                size -= 1;
            } else if (inputArray[i] == 's' && inputArray[i+1] == '=') {
                size -= 1;
            } else if (inputArray[i] == 'z' && inputArray[i+1] == '=') {
                size -= 1;
            }
        }
        System.out.println(size);
    }
}

class 크로아티아알파벳_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        input = input.replace("dz=", "!");
        input = input.replace("c=", "@");
        input = input.replace("c-", "#");
        input = input.replace("d-", "$");
        input = input.replace("lj", "%");
        input = input.replace("nj", "^");
        input = input.replace("s=", "&");
        input = input.replace("z=", "*");
        System.out.println(input.length());
    }
}

class 크로아티아알파벳_옛날에푼것 {
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