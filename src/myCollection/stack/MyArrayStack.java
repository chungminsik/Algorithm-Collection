package myCollection.stack;

public class MyArrayStack<T> {

    private T[] array;
    private int arraySize = 10;
    private final int MAXSIZE = 100000;

    private int top = 0;
    private int size = 0;

    public MyArrayStack(){
        //Javaでジェネリック型の配列は直接作れない。
        array = (T[]) new Object[arraySize];
    }


    public void push(T t){
        if (array.length == top+1){
            expandArray();
        }

        array[top++] = t;
    }

    public T pop(){
        if (this.isEmpty()){
            return null;
        }
        if (top == 0){
            return null;
        }

        return array[--top];
    }

    public boolean isEmpty(){
        if (top == 0){
            return true;
        } else{
            return false;
        }
    }

    public void printStack(){
        if (top == 0){
            System.out.println("empty");
            return;
        }

        for (int i =0; i < top; i++){
            System.out.print(array[i] + " ");
        }
    }

    private void expandArray(){
        if (arraySize * 2 <= MAXSIZE){
            arraySize = arraySize * 2;
        } else{
            System.out.println("error: stack is full.");
            return;
        }

        T[] newArray = (T[]) new Object[arraySize];

        for (int i = 0; i < array.length; i++){
            newArray[i] = array[i];
        }

        array = newArray;
    }
}
