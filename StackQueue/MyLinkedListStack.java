public class MyLinkedListStack implements StackQueue{
    private class Node{
        private Node next;
        private int value;
        public Node(int value){
            this.value = value;
        }
    }
    private Node head;
    public MyLinkedListStack(){
        head = null;
    }

    @Override
    public boolean push(int value) {
        if(!isFull()){
            Node newNode = new Node(value);
            newNode.next = head;
            head = newNode;
            return true;
        }
        return false;
    }

    @Override
    public int pop() {
        if(head == null){
            return -1;
        }
        int value = head.value;
        head = head.next;
        return 0;
    }

    @Override
    public boolean isFull() {
        return false;
    }

    @Override
    public boolean isEmpty() {
        return head == null;
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
