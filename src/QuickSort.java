public class QuickSort {
	private Node head;
	private Node tail;

	public QuickSort(){
		head = null;
		tail = null;
	}
	private class Node{
		int value;
		Node next = null;
	}
	
	public void addNode(int item){
		Node node = new Node();
		node.value = item;
		node.next = null;
		if(head == null){
			head = node;
			tail = node;
		}
		else{
			tail.next = node;
			tail = node;
		}
	}
	
	public Node findTail(Node current){
		while(current.next != null){
			current = current.next;
		}
		return current;
	}
	
	
	
	public Node QuickSortRecursive(Node head,Node tail){
		if(head == tail){
			return head;
		}
		
		Node newHead = null;
		Node newTail = null;
		
		Node pivot = tail;
		Node current = head;
		Node prev = null;
		while(current != pivot){
			if(current.value > pivot.value){
				if(prev == null){
					Node tailNode = current;
					tail.next = tailNode;
					current = tailNode.next;
					tailNode.next = null;
					tail = tail.next;
				}
				else{
					Node tailNode = current;
					prev.next = tailNode.next;
					current = tailNode.next;
					tail.next = tailNode;
					tailNode.next = null;
					tail = tail.next;
				}
			}
			else{
				if(newHead == null){
					newHead = current;
				}
				prev = current;
				current = current.next;
			}
		}
		
		newTail = tail;
		System.out.println("Returned Partition: " + String.valueOf(pivot.value));
		System.out.println("New Head: " + String.valueOf(newHead.value));
		System.out.println("New Tail: " + String.valueOf(newTail.value));
		
		if(newHead != pivot){
			Node temp = newHead;
			while(temp.next != pivot){
				temp=temp.next;
			}
			temp.next = null;
			
			newHead = QuickSortRecursive(newHead, temp);
			
			temp = findTail(newHead);
			temp.next =pivot;
		}
		
		pivot.next = QuickSortRecursive(pivot.next, newTail);
		
		return newHead;
	}
	
	public static void main(String args[]){
	    QuickSort list = new QuickSort();
	    list.addNode(2);
	    list.addNode(6);
	    list.addNode(9);
	    list.addNode(7);
	    list.addNode(5);
	    Node head = list.QuickSortRecursive(list.head, list.tail);
	    System.out.println("");
	    while(head !=null){
	    	System.out.print(String.valueOf(head.value) + " ");
	    	head = head.next;
	    }
	    
	    
	}

}
