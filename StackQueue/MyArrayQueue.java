public class MyArrayQueue implements StackQueue{
    private int[] array;
    private int SIZE;
    private int head,tail;

    public MyArrayQueue(int SIZE) {
        this.SIZE= SIZE;
        this.array= new int[SIZE];
        this.head=-1;
        this.tail=-1;
    }
    public int count() {
        if(isEmpty()) {
            return 0;
        }
        return tail-head+1;
    }
    @Override
    public boolean push(int value) {
        if(!isFull()){
            if(isEmpty()){
                this.head++;
            }
            array[++tail]=value;
 
            return true;
        }
        return false;
    }

    @Override
    public int pop() {
        if(!isEmpty()){
            int value = array[head];
            head++;
            if(head>tail){
                head=tail=-1;
            }
            return value;
        }
        return -1;
    }

    @Override
    public boolean isFull() {
        return this.tail==SIZE-1;
    }   

    @Override
    public boolean isEmpty() {
        return this.head<0 && this.tail<0;
    }

    @Override
    public void print() {
        if(!isEmpty()){
            for(int i=head;i<=tail;i++){
                System.out.print(array[i]+" ");
            }
            return;
        }
        System.out.println("Queue is empty!");        
    }
    
}
