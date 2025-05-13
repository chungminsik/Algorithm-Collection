package algorithm;

public class SortAlgorithm {
    public static void main(String[] args) {

        int[] unSortedArray = {3, 5, 1, 4, 2};

        printSortResult(selectionSort(unSortedArray));
        printSortResult(insertSort(unSortedArray));
    }

    public static void printSortResult(int[] array){

        int[] correctArray = {1, 2, 3, 4, 5};
        boolean result = true;
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < array.length; i++){
            if (array[i] != correctArray[i]){
                result = false;
                break;
            }
        }

        for (int num : array){
            sb.append(" ");
            sb.append(num);
        }

        System.out.println(result + sb.toString());
    }

    public static int[] selectionSort(int[] array){
        int[] sortedArray = array;
        int currentIndex = 0;

        while (array.length != currentIndex){
            int smallIndex = currentIndex;

            for (int i = currentIndex; i < array.length; i++){
                if (array[i] < array[smallIndex]){
                    smallIndex = i;
                }
            }

            int smallNum = array[smallIndex];
            array[smallIndex] = array[currentIndex];
            array[currentIndex] = smallNum;

            currentIndex++;
        }

        return sortedArray;
    }

    public static int[] insertSort(int[] array){
        int[] sortedArray = array;

        for (int i = 1; i < array.length; i++){
            for (int j = i; j > 0; j--){
                if (array[j-1] > array[j]){
                    int change = array[j-1];
                    array[j-1] = array[j];
                    array[j] = change;
                }
            }

        }

        return sortedArray;
    }
}


