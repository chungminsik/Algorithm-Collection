package algorithm.baekjoon.심화1;

import java.util.Scanner;

public class 그룹단어체커 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int input = sc.nextInt();
        String[] inputString = new String[input];

        for (int i = 0; i < input; i++){
            inputString[i] = sc.next();
        }

        int count = 0;

        for (String s : inputString){

            String[] uniqueArray = new String[s.length()];
            String[] stringArray = s.split("");

            for (int i = 0; i < s.length(); i++){
                if (!isUnique(uniqueArray, stringArray[i])){
                    if (isSame(stringArray[i], stringArray[i+1])){
                        continue;
                    }

                    count++;
                }

                break;
            }
        }

        System.out.println(count);
    }

    private static boolean isUnique(String[] uniqueArray, String s){
        for (String uniqueString : uniqueArray){
            if (uniqueString == null){
                return true;
            }

            if (!uniqueString.equals(s)){
                return false;
            }
        }

        return true;
    }

    private static boolean isSame(String now, String next){

        return now.equals(next);
    }
}

class 그룹단어체크2{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();
        int count = 0; // 그룹 단어의 수

        for (int i = 0; i < input; i++) {
            String word = sc.next();
            if (isGroupWord(word)) {
                count++;
            }
        }

        System.out.println(count);
    }

    private static boolean isGroupWord(String word) {
        boolean[] seen = new boolean[26]; // 알파벳 개수만큼
        char prev = 0;

        for (int i = 0; i < word.length(); i++) {
            char now = word.charAt(i);

            if (now != prev) {
                // 이미 등장한 문자면 그룹 단어가 아님
                if (seen[now - 'a']) {
                    return false;
                }
                seen[now - 'a'] = true; // 처음 등장한 문자 저장
            }

            prev = now;
        }

        return true;
    }
}
