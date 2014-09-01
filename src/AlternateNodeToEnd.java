
public class AlternateNodeToEnd {
	private Node head;
	private Node tail;

	public AlternateNodeToEnd(){
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
	
	public void addNodeToTail(Node node){
		
		node.next = null;
		if(tail == null){
			head = node;
			tail = node;
		}
		else{
			if(tail.next == null){
				tail.next = node;
			}
			else{
				node.next = tail.next;
				tail.next = node;
			}
		}
	}
	
	public static void main(String args[]){
		AlternateNodeToEnd test = new AlternateNodeToEnd();
		for(int i=1;i<=999;i++){
			test.addNode(i);
		}
		
		Node current = test.head;
		
		System.out.print("Original: ");
		while(current != null){
			System.out.print(String.valueOf(current.value) + " ");
			current = current.next;
		}
		
		System.out.println("");
	
		current = test.head;
		Node prev = null;
		do{
			if(current.value % 2 != 0){
				prev = current;
				current = current.next;
			}
			else{	
				prev.next = current.next;
				test.addNodeToTail(current);
				current = prev.next;
			}
		}while(!current.equals(test.tail));
		
		current = test.head;
		System.out.print("Modified: ");
		while(current != null){
			System.out.print(String.valueOf(current.value) + " ");
			current = current.next;
		}
	}
}
