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

	public void insert( String _data )
	{
		Node node = new Node( _data );
		node.next = head;
		head = node;
	}

	public void insert( Node after )
	{
             Node curr = this.head;
	     if( this.head == null )
             {
                this.head = after;
		return;
	     }


	     if( this.head.next == null && this.head.compareTo(after) > 0)
	     {
	        after.next = head;
		head = after; 
		return;
 	     }

	     while( curr.next != null && curr.compareTo(after) < 0 ){
		curr = curr.next;
	     }			
	     after.next = curr.next;
	     curr.next = after;
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
	theList.insert( "4" );

        System.out.println( theList );

	LinkedList n2 = new LinkedList();
	n2.insert("2");
        theList.insert(n2.head);

	LinkedList n0 = new LinkedList();
	n0.insert("0");
        theList.insert(n0.head);

	LinkedList n5 = new LinkedList();
	n5.insert("5");
        theList.insert(n5.head);
        //theList.insert(new LinkedList.Node( "0" ));
        //theList.insert(new LinkedList.Node( "3" ));
        //theList.insert(new LinkedList.Node( "5" ));
	
        System.out.println( "Hello from LinkedList!" );
        System.out.println( theList );
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
