public class Main {
    public static void main(String[] args) {
        // MyArrayStack stack = new MyArrayStack(3);
        // stack.push(1);
        // stack.push(2);
        // stack.push(3);
        // System.out.println(stack.push(4));
        // stack.print();
        // System.out.println(stack.pop());
        // stack.print();
        // System.out.println(stack.pop());
        // stack.print();
        // System.out.println(stack.pop());
        // stack.print();
        MyLinkedListQueue queue = new MyLinkedListQueue();
        queue.push(1);
        queue.push(2);
        queue.push(3);
        queue.push(4);
        queue.print();
        System.out.println();
        System.out.println(queue.pop());
        queue.print();

    }
}
