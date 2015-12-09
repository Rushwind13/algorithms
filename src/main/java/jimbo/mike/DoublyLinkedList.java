package jimbo.mike;

/*
 * Doubly-linked lists, FTW
 *
 */

class DoublyLinkedList
{
	Node head;
	Node tail;

	public DoublyLinkedList( String _data )
	{
		head = new Node( _data );
	}

	public String toString()
	{
		return head.toString();
	}
	public static void main( String [] args )
	{
		System.out.println( "Hello DoublyLinkedList!" );
		DoublyLinkedList dub = new DoublyLinkedList( "5" );

		System.out.println( dub );
	}

	class Node
	{
		Node next;
		Node prev;
		String data;

		public Node( String _data )
		{
			data = _data;
		}
		public String toString()
		{
			return data;
		}
	}
}
