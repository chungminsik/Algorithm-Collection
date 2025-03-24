package algorithm.반복문;

import java.util.Scanner;

public class 영수증 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int total = 0;
        int price = sc.nextInt();
        int product = sc.nextInt();
        for (int i = 1; i <= product; i++){

            int money = sc.nextInt();
            int count = sc.nextInt();

            total = total+calculate(money, count);
        }
        if (total == price){
            System.out.println("Yes");
        }
        else {
            System.out.println("No");
        }
    }
    static int calculate(int money, int count){
        return money*count;
    }
}
