package dataStructure.List;

public class MyArrayList<T> implements MyList<T> {

    private T[] array;
    private int size;

    public MyArrayList(){
        array = (T[]) new Object[10];
        size = 0;
    }

    @Override
    public void add(T param) {
        if (size >= array.length) {
            T[] newArray = (T[]) new Object[array.length * 2];

            for (int i = 0; i < array.length; i++) {
                newArray[i] = array[i];
            }
            array = newArray;
        }
        array[size] = (T) param;
        size++;
    }

    @Override
    public T get(int index) {
        return array[index];
    }

    @Override
    public T update(int index, T param) {
        T returnValue = array[index];
        array[index] = (T) param;

        return returnValue;
    }

    @Override
    public T delete(int index) {
        T returnValue = array[index];

        for (int i = index; i < size - 1; i++) {
            array[i] = array[i + 1];
        }

        array[size - 1] = null;
        size--;

        return returnValue;
    }

    @Override
    public int size() {
        return size;
    }
}
