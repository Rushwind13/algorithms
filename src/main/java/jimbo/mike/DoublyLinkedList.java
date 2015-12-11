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
		tail = head;
	}

	// For this exercise, insert at the tail by default
	public Node insert( String _data )
	{
		Node toInsert = new Node( _data );
		return insert( toInsert );
	}

	public Node insert( Node toInsert )
	{
		this.tail.next = toInsert;
		toInsert.prev = this.tail;
		this.tail = toInsert;
		return toInsert;
	}

	// Difference between "append" and "insert(at tail)" is that
	//  append appends a list, so it sets the tail pointer to *its* tail, not its head.
	public void append( Node listToAppend )
	{
		this.tail.next = listToAppend;
		listToAppend.prev = this.tail;

		//this.tail = listToAppend.tail;
		while( listToAppend.next != null )
		{
			listToAppend = listToAppend.next;
		}
		this.tail = listToAppend;
	}

	public Node find( Node head, String _data )
	{
		Node curr = head;
		while( curr != null )
		{
			if( curr.data == _data )
			{
				return curr;
			}
			curr = curr.next;
		}
		return null;
	}

	public void insertChild( Node toChild )
	{
		this.head.child = toChild;
	}

	public void flatten( )
	{
		Node curr = this.head;
		while( curr != null )
		{
			if( curr.child != null )
			{
				this.append(curr.child);
			}
			curr = curr.next;
		}

	}

	public String iterate_print( Node start )
	{
		StringBuilder printString = new StringBuilder();
		Node curr = start;
		while( curr != null )
		{
			printString.append(curr.data + " ");
			curr = curr.next;
		}
		return printString.toString();
	}
	
	public String toString()
	{
		return iterate_print( head );
	}

	public static void main( String [] args )
	{
		System.out.println( "Hello DoublyLinkedList!" );
		// fourth-level nodes
		DoublyLinkedList node7 = new DoublyLinkedList( "7" );
		DoublyLinkedList list21 = new DoublyLinkedList( "21" );
		list21.insert( "3" );

		// third-level nodes
		DoublyLinkedList node8 = new DoublyLinkedList( "8" );
		DoublyLinkedList list9 = new DoublyLinkedList( "9" );
		list9.insertChild( node7.head );
		DoublyLinkedList list12 = new DoublyLinkedList( "12" );
		list12.insertChild( list21.head );
		list12.insert( "5" );

		// second-level nodes
		DoublyLinkedList list6 = new DoublyLinkedList( "6" );
		DoublyLinkedList list25 = new DoublyLinkedList( "25" );
		list25.insertChild( node8.head );
		DoublyLinkedList list6a = new DoublyLinkedList( "6" );
		list6a.insertChild( list9.head );

		list6.insert( list25.head );
		list6.insert( list6a.head );
		
		DoublyLinkedList list2 = new DoublyLinkedList( "2" );
		list2.insertChild( list12.head );
		list2.insert( "7" );

		// top-level nodes
		DoublyLinkedList dub = new DoublyLinkedList( "5" );
		dub.insertChild( list6.head );
		dub.insert( "33" );
		dub.insert( "17" );

		DoublyLinkedList list2a = new DoublyLinkedList( "2" );
		list2a.insertChild( list2.head );
		dub.insert( list2a.head );
		dub.insert( "1" );

		System.out.println( dub );
		dub.flatten();
		System.out.println( dub );
	}

	class Node
	{
		Node next;
		Node prev;

		// Just for this particular problem
		Node child;

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
