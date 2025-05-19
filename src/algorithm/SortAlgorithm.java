package algorithm;

public class SortAlgorithm {

    public static int[] unSortedArray = {8, 3, 1, 7, 0, 10, 2};
    public static final int[] correctArray = {0, 1, 2, 3, 7, 8, 10};

    public static void main(String[] args) {

        printSortResult(selectionSort(cloneArray()));

        printSortResult(insertSort(cloneArray()));

        printSortResult(mergeSort(cloneArray(), 0, unSortedArray.length-1));

        printSortResult(quickSort(cloneArray(), 0, unSortedArray.length-1));




    }

    public static int[] cloneArray(){
        return unSortedArray.clone();
    }

    public static void printSortResult(int[] array){
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

        return array;
    }

    public static int[] insertSort(int[] array){

        for (int i = 1; i < array.length; i++){
            for (int j = i; j > 0; j--){
                if (array[j-1] > array[j]){
                    int change = array[j-1];
                    array[j-1] = array[j];
                    array[j] = change;
                }
            }
        }

        return array;
    }

    //順番に分割の命令（分割範囲を指定してメソッドに入れる）
    //そのあとマージを行う
    public static int[] mergeSort(int[] array, int left, int right){

        //要素が一つになってない場合
        if (left < right){
            int mid = (left + right) / 2;

            //arrayを分割するスタックを作る
            mergeSort(array, left, mid); //左の方にずっと分割していく
            mergeSort(array, mid+1, right);//右の方にずっと分割していく

            //mergeする
            int[] merged = merge(array, left, mid, right);

            for (int i = 0; i< merged.length; i++){
                array[left+i] = merged[i];
            }
        }

        return array;
    }

    //分割、定列
    public static int[] merge(int[] array, int left, int mid, int right){
        int[] temp = new int[right - left + 1];

        int i = left; //array1の先頭
        int j = mid + 1;//array2の先頭
        int k = 0;//tempの先頭

        //array1とarray2どちらかが比較が終わるまで終わるまで比較して統合
        while(i <= mid && j <= right){
            if (array[i] <= array[j]){
                temp[k++] = array[i++];
            } else{
                temp[k++] = array[j++];
            }
        }

        //残りの要素を入れる
        while (i <= mid){
            temp[k++] = array[i++];
        }
        while (j <= right){
            temp[k++] = array[j++];
        }

        return temp;
    }

    //ソートするarrayの範囲
    //pivot
    //対象のarray
    public static int[] quickSort(int[] array, int low, int high){

        if (low < high){ //配列の要素が2個以上
            //pivot選択
            int pivotIndex = quick(array, low, high);

            //pivotにより分割
            quickSort(array, low, pivotIndex-1);
            quickSort(array, pivotIndex+1, high);
        }

        return array;
    }

    public static int quick(int[] array, int low, int high){
        int pivot = array[high];
        int start = low - 1;

        //만약 pivot보다 작으면 스타트 지점에서 하나 큰 인덱스에 값을 이동
        for (int j = low; j < high; j++){
            if (array[j] <= pivot){
                start++;
                int temp = array[start];
                array[start] = array[j];
                array[j] = temp;
            }
        }

        //다음 pivot 선택
        int temp = array[start + 1];
        array[start + 1] = array[high];
        array[high] = temp;

        return start+1;
    }


    public static int[] newInsertionSort(int[] array){

        for (int i = 0; i < array.length; i++){
            for (int j = 0; j < i+1; j++){
                if (array[i] < array[j]){
                    int temp = array[j];
                    array[j] = array[i];
                    array[i] = temp;
                }
            }
        }

        return array;
    }
}





