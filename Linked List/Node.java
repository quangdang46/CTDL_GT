public class Node {
  private SV data;
  private Node next;

  public Node(SV data) {
    this.data = data;
  }

  public boolean compare(Node t) {
    return this.data.getName().equals(t.data.getName());
  }

  public static void printNode(Node head) {
    if (head == null)
      return;
    Node temp = head;
    while (temp != null) {
      System.out.println(temp.data);
      temp = temp.next;
    }
  }

  public static Node addHeadSv(Node head, SV value) {
    Node newNode = new Node(value);
    if (head == null) {
      return newNode;
    }
    newNode.next = head;
    return newNode;
  }

  public static Node addTailSv(Node head, SV value) {
    Node newNode = new Node(value);
    if (head == null) {
      return newNode;
    }
    Node temp = head;
    while (temp.next != null) {
      temp = temp.next;
    }
    temp.next = newNode;
    return head;
  }

  public static Node addSv(Node head, SV prev, SV curr) {
    Node newNode = new Node(curr);
    Node newPrev = new Node(prev);
    if (head == null) {
      return newNode;
    }

    Node temp = head;
    while (temp != null && !temp.compare(newPrev)) {
      temp = temp.next;
    }
    if (temp != null) {
      newNode.next = temp.next;
      temp.next = newNode;
    }
    return head;

  }

  public static Node deleteHeadSv(Node head) {
    if (head == null) {
      throw new IllegalArgumentException("List is empty");
    }
    Node temp = head;
    head = temp.next;
    temp.next = null;
    return head;
  }

  public static Node deleteTailSv(Node head) {
    if (head == null) {
      throw new IllegalArgumentException("List is empty");
    }
    Node temp = head;
    Node prev = null;
    while (temp.next != null) {
      prev = temp;
      temp = temp.next;
    }
    if (prev == null) {
      head = null;
    } else {
      prev.next = null;
    }
    return head;
  }

  public static Node deleteSv(Node head, SV value) {
    if (head == null) {
      throw new IllegalArgumentException("List is empty");
    }
    Node valueNode = new Node(value);

    Node temp = head;
    Node prev = null;

    while (temp != null && !temp.compare(valueNode)) {
      prev = temp;
      temp = temp.next;
    }
    if (prev != null) {
      prev.next = temp.next;
      temp.next = null;

    } else {
      head = deleteHeadSv(temp);
    }
    return head;
  }

  public static void main(String[] args) {
    Node n1 = new Node(new SV("A", "2000"));
    Node n2 = new Node(new SV("B", "2001"));
    Node n3 = new Node(new SV("C", "2002"));
    Node n4 = new Node(new SV("D", "2003"));
    n1.next = n2;
    n2.next = n3;
    n3.next = n4;
    n4.next = null;
    Node newNode = deleteSv(n2, new SV("B", "2001"));
    printNode(newNode);

  }
}