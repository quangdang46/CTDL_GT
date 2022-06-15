import java.util.*;
public class MyArrayStack implements StackQueue {
    private int[] array;
    private int SIZE;
    private int topIndex;
    public MyArrayStack(int SIZE) {
        this.SIZE= SIZE;
        this.array= new int[SIZE];
        this.topIndex=-1;
    }
    @Override
    public boolean isEmpty() {
        return topIndex < 0;
    }

    @Override
    public boolean isFull() {
        return this.topIndex==SIZE-1;
    }

    @Override
    public int pop() {
        if(!isEmpty()){
            return this.array[topIndex--];
        }
        return -1;
    }

    @Override
    public boolean push(int value) {
        if(!isFull()) {
            this.array[++topIndex]=value;
            return true;
        }
        return false;
    }
    @Override
    public void print() {
        if(!isEmpty()){
            for(int i=0;i<=topIndex;i++){
                System.out.print(this.array[i]+" ");
            }
            return;
        }
        System.out.println("Stack is empty!");

    }

    
}
