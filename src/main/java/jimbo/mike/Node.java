package jimbo.mike;

/**
 * One element of a LinkedList
 *
 */
public class Node 
{
	public Node next;
	public Object data;

	public Node( Object _data )
	{
		this.data = _data;
	}

	@Override
	public String toString()
	{
		return data.toString();
	}
    public static void main( String[] args )
    {
	Node node = new Node( "This is a test" );
	
        System.out.println( "Hello Node!" );
        System.out.println( node );
    }
}
