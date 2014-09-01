
public class MultiLevel {

	Node head;
	Node tail;
	private class Node{
		int value;
		Node next;
		Node down;
	}
	
	public MultiLevel(){
		head = null;
		tail = null;
	}
	
	public void addTail(int i){
		Node node = new Node();
		node.value = i;
		node.next = null;
		node.down = null;
		if(head == null){
			head = node;
			tail = node;
		}
		else{
			tail.next = node;
			tail = node;
		}
	}
	
	public void addDown(int value, int parent){
		Node node = new Node();
		node.value = value;
		node.next = null;
		node.down = null;
		Node current = head;
		while(current != null){
			if(parent == current.value){
				break;
			}
			current = current.next;
		}
		
		while(current.down != null){
			current = current.down;
		}
		
		current.down = node;
	}
	
	public static void main(String args[]){
		MultiLevel list = new MultiLevel();
		list.addTail(1);
		list.addTail(2);
		list.addTail(3);
		list.addTail(4);
		list.addTail(5);
		list.addTail(6);
		list.addDown(1, 1);
		list.addDown(2, 2);
		list.addDown(3, 3);
		list.addDown(3, 3);
		list.addDown(3, 3);
		list.addDown(4, 4);
		list.addDown(5, 5);
		
		Node current = list.head;
		while(current.next != null){
			if(current.down != null){
				list.tail.next = current.down;
				list.tail = current.down;
			}
			current = current.next;
		}
		
		current = list.head;
		
		while(current != null){
			System.out.print(String.valueOf(current.value) + " ");
			current = current.next;
		}
		
	}
}
