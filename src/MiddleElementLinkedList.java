public class MiddleElementLinkedList {
	private Node head;
	private Node middle;
	private int size;

	public MiddleElementLinkedList() {
		head = null;
		middle = null;
		size = 0;
	}

	private class Node {
		int value;
		Node next = null;
		Node prev = null;
	}

	public void addNode(int item) {
		Node node = new Node();
		node.value = item;
		node.next = null;
		node.prev = null;
		if (head == null) {
			head = node;
			middle = node;
			size++;
		} else {
			head.prev = node;
			node.next = head;
			head = node;

			if (size % 2 == 1) {
				middle = middle.prev;
			}

			size++;
		}
	}

	public void deleteMiddle() {

		middle.prev.next = middle.next;
		middle.next.prev = middle.prev;

		if (size % 2 == 1) {
			middle = middle.prev;
		} else {
			middle = middle.next;
		}

		size--;

	}

	
	public static void main(String args[]) {

		MiddleElementLinkedList list = new MiddleElementLinkedList();

		for (int i = 1; i <= 10; i++) {
			list.addNode(i);
		}

		Node current = null;
		current = list.head;
		System.out.print("Original List 1: ");
		while (current != null) {
			System.out.print(String.valueOf(current.value) + " ");
			current = current.next;
		}

		list.deleteMiddle();
		list.deleteMiddle();
		list.deleteMiddle();
		list.deleteMiddle();
		list.deleteMiddle();
		list.deleteMiddle();

		System.out.println("");

		current = list.head;
		System.out.print("Modified List 1: ");
		while (current != null) {
			System.out.print(String.valueOf(current.value) + " ");
			current = current.next;
		}
	}
}
