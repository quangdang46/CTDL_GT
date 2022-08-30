public class Node {
	private Sv value;
	private Node next;
	private Node prev;

	public Node(Sv value) {
		this.value = value;
	}

	public static void printNode(Node head) {
		Node temp = head;
		while (temp != null) {
			System.out.println(temp.value);
			temp = temp.next;
		}
	}

	//

	public boolean compare(Node v) {
		if (this.value.getName().equals(v.next.value.getName())) {
			return true;
		}
		return false;
	}

	// Chen Node vao dau
	public static Node addHead(Node head, Sv value) {
		Node newNode = new Node(value);
		// 1 Node
		if (head == null) {
			newNode.prev = null;
			newNode.next = null;
			head = newNode;
			return head;
		}
		// 2 Node
		newNode.prev = null;
		newNode.next = head;

		head.prev = newNode;
		head = newNode;
		return head;
	}

	public static Node addTail(Node head, Sv value) {
		Node newNode = new Node(value);
		if (head == null) {
			newNode.prev = null;
			newNode.next = null;
			head = newNode;
			return head;
		}
		Node temp = head;
		while (temp.next != null) {
			temp = temp.next;
		}

		newNode.prev = temp;
		newNode.next = null;

		temp.next = newNode;

		return head;
	}

	// Them vao truoc Node
	public static Node addNode(Node head, Node prev, Sv value) {
		Node newNode = new Node(value);

		if (head == null) {
			return null;
		}

		Node nextNode = prev.next;

		newNode.next = nextNode;
		newNode.prev = prev;
		if (nextNode != null) {
			nextNode.prev = newNode;
		}
		prev.next = newNode;

		return head;

	}

	// add vao phia sau
	public static Node addNode2(Node head, Node prev, Sv value) {
		Node newNode = new Node(value);
		if (head == null) {
			return null;
		}
		if (head.next == null) {
			return addHead(head, value);
		}
		if (head.next != null && head.next.equals(prev)) {
			return addNode(head, head, value);
		}

		Node temp = head;
		Node curr = null;
		while (temp.next != null && !temp.next.equals(prev)) {
			curr = temp.next;
			temp = temp.next;
		}
		if (curr == null) {
			return null;
		}
		newNode.next = prev;
		newNode.prev = curr;
		prev.prev = newNode;

		curr.next = newNode;

		return head;

	}

	// Xoa Node dau
	public static Node deleteHead(Node head) {
		if (head == null) {
			return null;
		}
		Node nextNode = head.next;
		nextNode.prev = null;

		return nextNode;
	}
	// Xoa cuoi

	public static Node deleteTail(Node head) {
		if (head == null) {
			return null;
		}
		Node temp = head;
		Node curr = null;
		while (temp.next != null) {
			curr = temp;
			temp = temp.next;
		}
		curr.next = null;
		return head;
	}

	// xoa truoc

	public static Node deleteNode(Node head, Node prev) {

		if (head == null) {
			return null;
		}
		Node nextNode = prev.next;
		if (nextNode == null) {
			return head;
		}
		if (nextNode.next == null) {
			return deleteTail(head);
		}
		prev.next = nextNode.next;
		nextNode.next.prev = prev;

		return head;
	}

	public static Node deleteNode2(Node head, Node prev) {
		if (head == null) {
			return null;
		}
		if (prev == null) {
			return head;
		}
		// Node temp = head;
		// Node curr = null;
		// while (temp.next.next != null && !temp.next.next.equals(prev)) {
		// 	curr = temp;
		// 	temp = temp.next;
		// }
		// if (curr == null) {
		// 	return null;
		// }
		// curr.next = prev.next;
		// prev.next.prev = curr;

		return head;
	}

	public static void main(String[] args) {
		Node n1 = new Node(new Sv("A", "1"));
		Node n2 = new Node(new Sv("B", "2"));
		Node n3 = new Node(new Sv("C", "3"));

		n1.next = n2;
		n1.prev = null;
		n2.prev = n1;

		n2.next = n3;

		n3.next = null;
		n3.prev = n2;

		Node newNode = deleteNode2(n1, n3);

		printNode(newNode);
	}
}
