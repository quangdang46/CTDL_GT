public class MyLinkedListQueue implements StackQueue{


    private class Node{
        private Node next;
        private int value;
        public Node(int value){
            this.value = value;
        }
    }
    private Node head, tail;
    public MyLinkedListQueue(){
        head = null;
        tail = null;
    }

    @Override
    public boolean push(int value) {
        if(!isFull()){
            Node newNode = new Node(value);
            if(isEmpty()){
                head = newNode;
                tail = newNode;
            }else{
                tail.next = newNode;
                tail = newNode;
                tail.next = null;
            }
            return true;
        }
        return false;
    }

    @Override
    public int pop() {
        if(!isEmpty()){
            int value = head.value;
            if(head == tail){
                head = null;
                tail = null;
            }else{
                head = head.next;
            }
            return value;
        }
        return -1;
    }

    @Override
    public boolean isFull() {
        return false;
    }

    @Override
    public boolean isEmpty() {
        return head == null && tail == null;
    }

    @Override
    public void print() {
        Node tmp=head;
        while(tmp!=null){
            System.out.print(tmp.value+" ");
            tmp=tmp.next;
        }
    }
    
}
