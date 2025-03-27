package algorithm.bitA;

/**
 * 1. 순열을 만든다 2. 계산을 한다 3. 계산한 꼭대기를 모두 더한다
 *
 * 계산은 쉬워보여서 하나의 순열을 계산하는 로직을 만듦
 * 많은 순열을 계산해야 하기 때문에 메소드화
 *
 * 순열을 만드는 방법을 모색(중복되지 않는 숫자, 중복되지 않은 조합의 9자리 숫자배열을 전부 만들기)
 * 초반에는 for문을 중첩해서 사용하는 것인가 했지만 말이 되지 않는 로직이였기 때문에 관두었다
 * 구글검색을 통해서 백트래킹 알고리즘을 통해서 구현할 수 있다는 것을 앎
 * 숫자가 많이 크지 않아서 하나씩 연산이 많아도 커버할 수 있었기 때문에 전부 하나씩 찾아보는 백트래킹을 사용
 * 순열 조합을 리턴하지 않고 바로 계산 메소드에 집어넣어서 결과물을 갱신
 *
 */

public class Q1 {

    public static void main(String[] args){

        int totalResult = 0;
        //int[] array = new int[9];
        int[] array = {1,2,3,4,9,8,7,6,5};

        //순열을 만든다


        //계산한다 + 더한다
        boolean loop = true;
        while(loop){
            if (array.length == 1){
                totalResult = array[0];
                loop = false;
                break;
            }

            int[] newArray = new int[array.length-1];

            for (int i = 0; i < array.length-1; i++){
                newArray[i] = (array[i] + array[i+1]) % 10;
                array = newArray;
            }
        }

        System.out.println(totalResult);


    }


}

class Hello{
    private static long totalSum = 0; // 모든 순열에 대한 꼭대기 값의 누적 합

    public static void main(String[] args) {

        int[] permArray = new int[9];
        boolean[] usedNum = new boolean[9];

        generatePerm(permArray, usedNum, 0);
        System.out.println(totalSum);
    }


    /*
    1, 2, 3, 4, 5, 6, 7, 8, 9 까지 만들고 뒤에서부터 바꿔가면서 경우의 수를 전부 확인
     */
    private static void generatePerm(int[] perm, boolean[] usedNum, int depth){
        if (depth == 9){
            totalSum += getTopNumber(perm);
            return;
        }

        for (int i = 0; i < 9; i++){
            if (!usedNum[i]){
                perm[depth] = i;
                usedNum[i] = true;
                generatePerm(perm, usedNum, depth+1);

                //만약 depth가 9가 되면 숫자를 더하고 여기로 리턴됨
                usedNum[i] = false;
            }
        }
    }

    // 주어진 순열을 기반으로 피라미드 꼭대기 값을 계산하는 메서드
    private static int getTopNumber(int[] perm) {
        // 기저 조건: 배열 길이가 1이면, 그 값이 피라미드의 꼭대기 값
        if (perm.length == 1) {
            return perm[0];
        }

        // 새로운 배열 생성: 길이는 현재 배열 길이 - 1
        int[] newArray = new int[perm.length - 1];

        // 인접한 두 숫자를 더한 후 10으로 나눈 나머지를 계산하여 새로운 배열에 저장
        for (int i = 0; i < perm.length - 1; i++) {
            newArray[i] = (perm[i] + perm[i+1]) % 10;
        }

        // 재귀적으로 다음 단계 계산
        return getTopNumber(newArray);
    }
}


