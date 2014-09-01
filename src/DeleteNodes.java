public class DeleteNodes {
	private Node head;
	private Node tail;

	public DeleteNodes(){
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
	
	public static void main(String args[]){
		DeleteNodes list = new DeleteNodes();
		
		for(int i=1;i<=500;i++){
			list.addNode(i);
		}
		
		//Skip n nodes
		int n = 1;
		
		//Delete m nodes
		int m = 2;
		
		Node current = null;
		current = list.head;
		System.out.print("Original List 1: ");
		while(current != null){
			System.out.print(String.valueOf(current.value) + " ");
			current = current.next;
		}
		
		current = list.head;
		Node prev = null;
		while(current != null){
			for(int i=0;i<n;i++){
				if(current == null){
					break;
				}
				prev = current;
				current = current.next;
			}
			
			for(int i=0;i<m;i++){
				if(current == null){
					break;
				}
				prev.next = current.next;
				current = prev.next;
			}
		}
		
		System.out.println("");
		
		current = list.head;
		System.out.print("Modified List 1: ");
		while(current != null){
			System.out.print(String.valueOf(current.value) + " ");
			current = current.next;
		}
	}

}
