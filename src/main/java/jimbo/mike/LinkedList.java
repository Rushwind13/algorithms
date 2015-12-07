package jimbo.mike;

/**
 * Linked list implementation
 *
 */
public class LinkedList 
{
	public Node head;

	public LinkedList()
	{
	}

	// Stack operations: push and pop (only deal with head of list)
	public void push( String _data )
	{
		Node node = new Node( _data );
		node.next = this.head;
		this.head = node;
	}

	public Node pop()
	{
		Node node = this.head;
		this.head = node.next;
		return node;
	}

	// Normal LL inserts are "sorted".
	public void insert( String _data )
	{
		Node node = new Node( _data );
		this.insert( node );
	}

	public void insert( Node toInsert )
	{
		// special case: if list empty or head larger than incoming, incoming is new head
		if( this.head == null || this.head.compareTo(toInsert) > 0 )
		{
			// toInsert is the new head
			toInsert.next = head;
			head = toInsert;
			return;
		}

		// Not empty list, not left of list, so somewhere in middle.
		Node curr = head;
		while( curr.next != null && curr.next.compareTo(toInsert) < 0 )
		{
			curr = curr.next;	
		}
		// insert before curr_next
		toInsert.next = curr.next;
		curr.next = toInsert;
	}

	// find() returns the first Node in the LinkedList with data = the query term, or null if the data is not present.
	public Node find( String _data )
	{
		Node curr = this.head;
		while( curr != null && curr.data != _data )
		{
			curr = curr.next;
		}
		return curr;
	}

	public boolean delete( Node deleteMe )
	{
		Node curr = head;
		if( this.head == deleteMe )
		{
			this.head = curr.next;
			deleteMe = null;
			return true;
		}

		while( curr != null )
		{
			if( curr.next == deleteMe )
			{
				curr.next = deleteMe.next;
				deleteMe = null;
				return true;
			}
			curr = curr.next;
		}

		// not found
		return false;
	}

	public boolean deleteList()
	{
		// trust the Java magic.
		head = null;
		/*Node deleteMe = this.head;
		while( deleteMe.next != null )
		{
			Node next = deleteMe.next;
			deleteMe = null;
			deleteMe = next;
		}/**/
		return true;	
	}

	public String toString()
	{
		StringBuffer retval = new StringBuffer();
		Node curr = head;
		while( curr != null )
		{
			retval.append(curr.data);
			curr = curr.next;
		}
		return retval.toString();
	}

    public static void main( String[] args )
    {
	LinkedList theList = new LinkedList();
	theList.insert( "1" );
	theList.insert( "2" );
	theList.insert( "0" );
	theList.insert( "5" );
	theList.insert( "9" );
	theList.insert( "3" );

        System.out.println( "Hello from LinkedList!" );
        System.out.println( theList );

	Node toDelete = theList.find( "5" );
	theList.delete( toDelete );

	System.out.println( theList );

	theList.deleteList();
	System.out.println( theList );

	LinkedList theStack = new LinkedList();
	theStack.push( "D" );
	theStack.push( "A" );
	theStack.push( "E" );
	theStack.push( "B" );

	System.out.println( "Hello from Stack!" );
        System.out.println( theStack );

	Node got = theStack.pop();

	System.out.println( got );
	System.out.println( theStack );

	theStack.push( "F" );
	theStack.push( "C" );
	theStack.push( "G" );

	System.out.println( theStack );
    }
	
    public class Node implements Comparable<Node>
    {
            public Node next;
            public String data;
    
            public Node( String _data )
            {
                    this.data = _data;
            }
    
            @Override
            public String toString()
            {
                    return data.toString();
            }

	    @Override
	    public int compareTo( Node that ) 
            {
		return this.data.compareTo(that.data);	
	    }

        /*public static void main( String[] args )
        {
            Node node = new Node( "This is a test" );
    
            System.out.println( "Hello Node!" );
            System.out.println( node );
        }/**/
    }
}
