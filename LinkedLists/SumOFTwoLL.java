package LinkedListClassesAndCodes;

public class SumOFTwoLL {

	class Node {
		int data;
		Node next;
	}

	Node head, tail;
	int size;

	public void addFirst(int val) {
		Node nn = new Node();
		nn.data = val;
		if (this.size == 0) {
			head = nn;
			tail = nn;
		} else {
			nn.next = head;
			head = nn;
		}
		this.size++;

	}
}
