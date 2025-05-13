package myCollection.queue;

import myCollection.stack.MyArrayStack;

public class MyStackQueue<T> {

    private final MyArrayStack<T> trueStack = new MyArrayStack<>();
    private final MyArrayStack<T> falseStack = new MyArrayStack<>();

    private boolean vacant = false; //出口の印

    /*
    newStackの要素をsubStackにいれる。
    新しい値を入れる
    subStackの要素をまたmainStackにいれる

    indexなしにpopできる。(mainStackのpopした値がからず古いデータになる)
     */
    public void push(T param){

        if (trueStack.isEmpty() && falseStack.isEmpty()){
            trueStack.push(param);
            changeExitDoor();
            return;
        }

        if (vacant){
            while (!(trueStack.isEmpty())){
                falseStack.push(trueStack.pop());
            }

            changeExitDoor();
            trueStack.push(param);
        } else{
            while (!(falseStack.isEmpty())){
                trueStack.push(falseStack.pop());
            }

            changeExitDoor();
            falseStack.push(param);
        }
    }

    public T pop(){
        if (vacant){
            return trueStack.pop();
        }

        return falseStack.pop();
    }

    private void changeExitDoor(){
        if (vacant == true){
            vacant = false;
        } else{
            vacant = true;
        }
    }
}
