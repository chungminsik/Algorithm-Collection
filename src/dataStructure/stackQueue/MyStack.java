package dataStructure.stackQueue;

public class MyStack {
    public static void main(String[] args) {

        /*
        MyStackArray<Integer> stack = new MyStackArray<>();

        stack.push(3);
        stack.push(5);
        stack.push(7);

        System.out.println(stack.pop());
        System.out.println(stack.pop());

        stack.push(9);
        stack.push(11);

        stack.pop();
        stack.pop();
        stack.pop();

        stack.printStack();
         */

        MyMonotonicStack mono = new MyMonotonicStack();

    }
}



class MyStackArray<T>{

    private T[] array;
    private int arraySize = 10;
    private final int MAXSIZE = 100000;

    private int top = 0;
    private int size = 0;

    MyStackArray(){
        //Javaでジェネリック型の配列は直接作れない。
        array = (T[]) new Object[arraySize];
    }


    public void push(T t){
        if (array.length == top){
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
        if (top < 0){
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
        if (arraySize * 2 > MAXSIZE){
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


class MyStackArrayList<T>{

}

class MyStackLinkedList<T>{

}

class MyMonotonicStack{

    int[] monotonicArray;
    int arraySize = 5;

    int head = 0;

    public MyMonotonicStack(int arraySize){
        this.arraySize = arraySize;
        this.monotonicArray = new int[arraySize];
    }

    public MyMonotonicStack(){
        this.monotonicArray = new int[arraySize];
    }

    public void increasing(int param){
        if (head == 0 || param > peak()){
            push(param);
            return;
        }

        while (head > 0 && param <= peak()){
            pop();
        }

        push(param);
    }

    public void decreasing(int param){
        if (head == 0 || param < peak()){
            push(param);
            return;
        }

        while (head > 0 && param >= peak()){
            pop();
        }

        push(param);
    }

    private void push(int param){
        if (head == arraySize){
            throw new IllegalArgumentException("stack is full");
        }

        monotonicArray[head++] = param;
    }

    private int pop(){
        if (head == 0){
            throw new IllegalArgumentException("stack is empty");
        }

        return monotonicArray[--head];
    }

    public int peak(){
        if (head == 0){
            throw new IllegalArgumentException("stack is empty");
        }

        return monotonicArray[head-1];
    }

    public void printStack(){
        if (head == 0){
            System.out.println("empty");
            return;
        }

        for (int i =0; i < head; i++){
            System.out.print(monotonicArray[i] + " ");
        }
    }

    public int nextGreatestElement(){
        if (head == 1){
            throw new IllegalArgumentException("none");
        } else if(head == 0){
            throw new IllegalArgumentException("empty");
        }

        return monotonicArray[head-2];
    }
}
