package algorithm;

public class SortAlgorithm {
    public static void main(String[] args) {

        int[] unSortedArray = {3, 5, 1, 4, 2};

        //printSortResult(selectionSort(unSortedArray));
        //printSortResult(insertSort(unSortedArray));
        //printSortResult(mergeSort(unSortedArray, 0, unSortedArray.length-1));
        printSortResult(helloMergeSort(unSortedArray, 0, unSortedArray.length-1));
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

    //順番に分割の命令（分割範囲を指定してメソッドに入れる）
    //そのあとマージを行う
    public static int[] mergeSort(int[] array, int left, int right){

        //要素が一つになってない場合
        if (left < right){
            int mid = (left + right) / 2;

            //arrayを分割するスタックを作る
            mergeSort(array, left, mid); //array1
            mergeSort(array, mid+1, right);//array2

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






    public static int[] helloMergeSort(int[] array, int start, int end){

        if (start < end){
            int middle = (start + end) / 2;

            helloMergeSort(array, start, middle);
            helloMergeSort(array, middle + 1, end);

            int[] merged = helloMerge(array, start, middle, end);

            for (int i = 0; i < merged.length; i++){
                array[start+i] = merged[i];
            }
        }

        return array;
    }

    public static int[] helloMerge(int[] array, int start, int middle, int end){
        int[] temp = new int[end - start + 1];

        int firstArrayHead = start;
        int secondArrayHead = middle + 1;
        int tempHead = 0;

        while(firstArrayHead <= middle && secondArrayHead <= end){
            if (array[firstArrayHead] <= array[secondArrayHead]){
                temp[tempHead++] = array[firstArrayHead++];
            } else {
                temp[tempHead++] = array[secondArrayHead++];
            }
        }

        while (firstArrayHead <= middle){
            temp[tempHead++] = array[firstArrayHead++];
        }
        while (secondArrayHead <= end){
            temp[tempHead++] = array[secondArrayHead++];
        }

        return temp;
    }









    static int[] buff;
    static void mergeSort(int[] a, int n) {
        buff = new int[n];			// 作業用配列を生成

        __mergeSort(a, 0, n - 1);		// 配列全体をマージソート

        buff = null;				// 作業用配列を解放
    }
    //--- a[left]～a[right]を再帰的にマージソート ---//
    static void __mergeSort(int[] a, int left, int right) {
        if (left < right) {
            int i;
            int center = (left + right) / 2;
            int p = 0;
            int j = 0;
            int k = left;

            __mergeSort(a, left, center);        // 前半部をマージソート
            __mergeSort(a, center + 1, right);    // 後半部をマージソート

            for (i = left; i <= center; i++) {    //前半部分をbuffにコピー　①
                buff[p++] = a[i];
            }
            while (i <= right && j < p) {        //後半部分とbuffをマージ ②
                a[k++] = (buff[j] <= a[i]) ? buff[j++] : a[i++];
            }
            while (j < p) {                      //buffに残った要素をaにコピー ③
                a[k++] = buff[j++];
            }
        }
    }
}





