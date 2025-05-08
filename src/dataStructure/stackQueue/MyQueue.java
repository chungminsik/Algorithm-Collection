package dataStructure.stackQueue;

import dataStructure.List.MyArrayList;
import dataStructure.List.MyList;

public class MyQueue {

    public static void main(String[] args) {

        MyQueueArray<Integer> queue = new MyQueueArray<>();

        queue.enqueue(1);
        queue.enqueue(2);

        System.out.println(queue.peek());

        queue.printQueue();

    }
}

/*
Arrayで実装するQueueは
- 循環バッファで実装する。
 */

class MyQueueArray<T>{

    private final T[] array;
    private final int index;

    private int head = -1;
    private int tail = 0;
    private int size = 0;

    public MyQueueArray(){
        index = 10;
        array = (T[]) new Object[this.index];
    }

    public MyQueueArray(int index){
        this.index = index;
        array = (T[]) new Object[this.index];
    }

    public void enqueue(T t){
        int next = (tail + 1) % index;

        if (size == index){
            throw new IllegalArgumentException("Queue is full");
        }

        array[tail] = t;
        tail = next;
        size++;
    }

    public T dequeue(){
        int next = (head + 1) % index;

        if (size == 0){
            throw new IllegalArgumentException("Queue is empty");
        }

        T returnValue = array[next];
        head = next;
        size--;

        return returnValue;
    }

    public T peek(){
        return array[head+1];
    }

    public void printQueue() {
        for (int i = 0; i < size; i++){
            int present = ((head+1) % index) + i;
            System.out.println(array[present]);
        }
    }
}


class MyQueueArrayList<T>{

}

class MyQueueLinkedList{

}

class MyDeque{

}

class MyPriorityQueue{

}