
public class MergeList {
	private Node head;
	private Node tail;

	public MergeList(){
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
		MergeList list1 = new MergeList();
		for(int i=1;i<=20;i++){
			list1.addNode(i);
		}
		
		Node currentList1 = null;
		currentList1 = list1.head;
		System.out.print("Original List 1: ");
		while(currentList1 != null){
			System.out.print(String.valueOf(currentList1.value) + " ");
			currentList1 = currentList1.next;
		}
		
		MergeList list2 = new MergeList();
		for(int i=51;i<=75;i++){
			list2.addNode(i);
		}
		
		System.out.println("");
		
		Node currentList2 = null;
		currentList2 = list2.head;
		System.out.print("Original List 2: ");
		while(currentList2 != null){
			System.out.print(String.valueOf(currentList2.value) + " ");
			currentList2 = currentList2.next;
		}
		
		currentList1 = list1.head;
		
		while(currentList1 != null){
			if(list2.head == null){
				break;
			}
			Node next = currentList1.next;
			Node insertNode = list2.head;
			list2.head = list2.head.next;
			currentList1.next = insertNode;
			insertNode.next = next;
			currentList1 = next;
		}
		
		System.out.println("");
		currentList1 = list1.head;
		System.out.print("Modified List 1: ");
		while(currentList1 != null){
			System.out.print(String.valueOf(currentList1.value) + " ");
			currentList1 = currentList1.next;
		}
		
		System.out.println("");
		currentList2 = list2.head;
		System.out.print("Modified List 2: ");
		while(currentList2 != null){
			System.out.print(String.valueOf(currentList2.value) + " ");
			currentList2 = currentList2.next;
		}
	}
}
