
public class AlternateNodeSwap {
	private Node head;
	private Node tail;

	public AlternateNodeSwap(){
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
	
	public void swapNode(Node node1, Node node2){
		Node swapNode = node1;
		node1.next = node2.next;
		node2.next = swapNode;
	}
	
	public static void main(String args[]){
		AlternateNodeSwap test = new AlternateNodeSwap();
		for(int i=1;i<=500;i++){
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
		while(current != null){	
				
				if(current.next == null){
					break;
				}
			    
				if(current.equals(test.head)){
			    	test.head = current.next;
			    }
			    
			    if(prev != null){
					prev.next = current.next;
				}
			    test.swapNode(current,current.next);
			    prev = current;
			    current = current.next;
		}
		
		current = test.head;
		
		System.out.print("Modified: ");
		while(current != null){
			System.out.print(String.valueOf(current.value) + " ");
			current = current.next;
		}
	}
}
