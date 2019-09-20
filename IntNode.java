
public class IntNode {
	
	// instance variables
	private int num; //keeps integer value
	private IntNode link; // link pointing to another IntNode instance or null
	
	// no argument constructor
	public IntNode() {
		
		num = 0;
		link = null;
		
	} // end of no argument constructor
	
	// constructor
	public IntNode(int _num, IntNode _link) {
		
		num = _num;
		link = _link;
		
	} // end of constructor
	
	// get and set methods for both instance variables
	public int getNum() {
		
		return num;
		
	} // end of getNum
	
	public void setNum(int num) {
		
		this.num = num;
		
	} // end of setNum
	
	public IntNode getLink() {
		
		return link;
		
	} // end of getLink
	
	public void setLink(IntNode link) {
		
		this.link = link;
		
	} // end of setLink
	
	// toString function
	public String toString() {
		
		// this makes the format of the link print out nice and pretty
		
		// set cursor to link
		IntNode cursor = this.getLink();
		String a = String.format("%s", this.getNum());
		
		// run through the link, as long as the cursor is not null, it will continue to run through and format the link correctly
		while (cursor != null) {
			
			// create a string to put the format in to make the return statement simple
			a = a + "->" + cursor.getNum();
			cursor = cursor.getLink();
			
		}
		
		// return string
		return a;
		
	} // end of toString
	
	// method that adds node after current node
	public void addNodeAfterThis(int newnum) {
		
		link = new IntNode(newnum, link);
		
	} // end of addNodeAfterThis
	
	// method that removes node that the node links to
	public void removeNodeAfterThis() {
		
		link = getLink().getLink();
		
	} // end of removeNodeAfterThis
	
	// method to get number of nodes in the list starting from a given node head
	public static int listLength(IntNode head) {
		
		// set cursor to head and count to 0
		IntNode cursor = head;
		int count = 0;
		
		// run through the link
		while(cursor != null) {
			
			count++;
			cursor = cursor.link;
		
		} // end of while
		
		return count;
		
	} // end of listLength
	
	
	// method to search whether a linked list starting with head contains a given value num
	
	/*
	 * @precondition 
	 * 
	 * head is not equal to null
	 * 
	 */
	
	public static boolean search(IntNode head, int e) {
		
		// set cursor to head
		IntNode cursor = head;
		
		// fulfill requirements of precondition
		
		if (head == null) {
			
			throw new IllegalArgumentException("head cannot be null.");
			
		}
		
		else {
	
		// run through link
		while(cursor!= null) {
			
			if (cursor.getNum() == e) {
				
				// number in is in link
				return true;
				
			} // end of if
			
			cursor = cursor.getLink();
			
		} // end of while
		
		// number is not in link
		return false;
		
		} // end of else

	} // end of search

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

} // end of IntNode
