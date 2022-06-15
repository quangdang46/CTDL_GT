public class main {
    public static class Node {
        Node next;
        int value;
        public Node(int value) {
            this.value = value;
        }
    }

    public static void PrintNode(Node nodeHead) {
        if(nodeHead == null){
            return;
        }else{
            Node tmp = nodeHead;
            while(tmp!=null){
                System.out.print(tmp.value);
                tmp = tmp.next;
                if(tmp != null){
                    System.out.print("->");
                }
            }
        }

    }

    public static Node ChenVaoCuoi(Node nodeHead,int value) {
        Node newNode= new Node(value);
        Node tmp = nodeHead;
        while(tmp != null){
            if(tmp.next == null){
                tmp.next = newNode;
                return nodeHead;
            }
            tmp = tmp.next;
        }
        return nodeHead;
    }
    public static void main(String[] args) {
        Node n1= new Node(1);
        Node n2= new Node(2);
        Node n3= new Node(3);
        Node n4= new Node(4);
        Node n5= new Node(5);
        n1.next=n2;
        n2.next=n3;
        n3.next=n4;
        n4.next=n5;
        n1=ChenVaoCuoi(n1,6);
        PrintNode(n1);
    }

}