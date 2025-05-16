package algorithm;

public class SearchAlgorithm {

    public static void main(String[] args) {

        int[] array = {1, 5, 3, 3, 7, 2, 9, 6, 4, 8};
        int index = search(array, 3);

        System.out.println(index);
    }

    public static void sort(int[] array){
        int sortedTail = 0;

        while (sortedTail != array.length){
            int small = sortedTail;

            for (int i = sortedTail; i < array.length; i++){
                if (array[small] > array[i]){
                    small = i;
                }
            }

            int temp = array[small];
            array[small] = array[sortedTail];
            array[sortedTail] = temp;

            sortedTail++;
        }
    }

    public static int search(int[] array, int element){
        int[] copyArray = array.clone();
        sort(copyArray);

        //範囲外の要素はすぐ　-1をreturn
        if (copyArray[0] > element || copyArray[copyArray.length-1] < element){
            return -1;
        } else{
            int isHave = search(copyArray, element, 0, array.length);
            int resultIndex = 0;

            for (int i = 0; i < array.length; i++){
                if (copyArray[isHave] == array[i]){
                    resultIndex = i;
                    break;
                }
            }

            return resultIndex;
        }
    }

    private static int search(int[] array, int element, int startIndex, int endIndex){

        int middle = startIndex + (endIndex - startIndex) / 2;
        int returnIndex;

        if (array[middle] == element){
            returnIndex = middle;
            return returnIndex;

        } else if(array[middle] > element){
            //左
            endIndex = middle - 1;
            returnIndex = search(array, element, startIndex, endIndex);

        } else{
            //右
            startIndex = middle + 1;
            returnIndex = search(array, element, startIndex, endIndex);

        }

        return returnIndex;
    }
}
