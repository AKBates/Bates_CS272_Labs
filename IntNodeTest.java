
public class IntNodeTest extends IntNode {

	public static void main(String[] args) {
		
		IntNode head1 = new IntNode(4, null);
		
		head1.addNodeAfterThis(5);
		head1.addNodeAfterThis(7);
		head1.addNodeAfterThis(8);
		
		System.out.print("The list: ");
		System.out.println(head1.toString());
		
		System.out.println();
		
		System.out.print("The length of the list is: ");
		System.out.println(listLength(head1));
		
		System.out.println();
		
		System.out.print("The number 8 is in the list: ");
		System.out.println(search(head1, 8));
		System.out.print("The number 6 is in the list: ");
		System.out.println(search(head1, 6));
		
		head1.removeNodeAfterThis();
		
		System.out.println();
		
		System.out.print("The length of the list after removing a node: ");
		System.out.println(listLength(head1));
		
		System.out.println();
		
		System.out.print("The new list: ");
		System.out.println(head1.toString());
		
	}
	
}
