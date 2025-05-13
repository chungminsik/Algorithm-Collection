package myCollection.list;

public class MyArrayList<T> {
    private T[] array;
    private int index;

    private int size = -1;

    public MyArrayList(){
        this.index = 10;
        this.array = (T[]) new Object[index];
    }

    public MyArrayList(int index){
        this.index = index;
        this.array = (T[]) new Object[index];
    }

    public MyArrayList(T[] array){
        this.index = array.length + 10;
        this.array = array;
        this.size = array.length-1;
    }

    public int add(T param){
        if (size >= array.length-1){
            expandArraySize();
        }

        array[++size] = param;

        return size;
    }

    public T get(int index){
        if (inputIndexValidate(index)){
            throw new IllegalArgumentException("index exception");
        }

        return array[index];
    }

    public T update(int index, T param){
        if (inputIndexValidate(index)){
            throw new IllegalArgumentException("index exception");
        }

        T returnValue = array[index];
        array[index] = param;

        return returnValue;
    }

    public T delete(int index){
        if (inputIndexValidate(index)){
            throw new IllegalArgumentException("index exception");
        }

        T returnValue = array[index];

        for (int i = index; i < size+1; i++){
            update(i, array[i+1]);
        }
        array[size--] = null;

        return returnValue;
    }

    public int getSize(){
        return size;
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();

        for (T t : array){
            sb.append(t);
            sb.append(" ");
        }

        return sb.toString();
    }

    private void expandArraySize(){
        index = index * 2;

        T[] newArray = (T[]) new Object[index];

        for (int i = 0; i < array.length; i++){
            newArray[i] = array[i];
        }

        this.array = newArray;
    }

    public boolean inputIndexValidate(int inputIndex){
        return (inputIndex > size || inputIndex < 0) ? true : false;
    }
}
