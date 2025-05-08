package dataStructure.stackQueue;

import java.util.ArrayList;
import java.util.List;

public class MyStack {
    public static void main(String[] args) {

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
    }
}



class MyStackArray<T>{

    private T[] array;

    private int arraySize = 10;
    private final int MAXSIZE = 100000;
    private int top = 0;


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

    private List<T> stack;
    private int top;

    MyStackArrayList(){
        stack = new ArrayList<T>();
    }

    public void push(T t){
        stack.add(t);
        top++;
    }

    public T pop(){
        return null;
    }

}

class MyStackLinkedList<T>{


    public void push(T t){

    }

    public T pop(){
        return null;
    }
}