package algorithm.심화1;

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