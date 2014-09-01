public class SwapKNode {
	private Node head;

	public SwapKNode(){
		head = null;
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
		}
		else{
			node.next = head;
			head = node;
		}
	}
	
	public static void main(String args[]){		
		SwapKNode list = new SwapKNode();
		
		for(int i=1;i<=10;i++){
			list.addNode(i);
		}
		
		Node current = null;
		current = list.head;
		System.out.print("Original List 1: ");
		while(current != null){
			System.out.print(String.valueOf(current.value) + " ");
			current = current.next;
		}
		
		Node tempKNode = list.head;
		Node tempKPrev = null;
		Node temp = null;
		Node prev = null;
		
		Node kNode = null;
		Node kPrev = null;
		int k = 2;
		int index = 0;
		temp = list.head;
		while(temp != null){
			index++;
			if(index == k){
				kNode = temp;
				kPrev = prev;
			}
			if(index > k){
				tempKPrev = tempKNode;
				tempKNode = tempKNode.next;
			}
			prev = temp;
			temp = temp.next;
		}
		
		kPrev.next = tempKNode;
		tempKPrev.next = kNode;
		Node swapNode = kNode.next;
		kNode.next = tempKNode.next;
		tempKNode.next = swapNode;
		
		System.out.println("");
		
		current = list.head;
		System.out.print("Modified List 1: ");
		while(current != null){
			System.out.print(String.valueOf(current.value) + " ");
			current = current.next;
		}
	}
}
