package jimbo.mike;

/**
 * InsertionSort - first you insert it, then it's sorted
 *
 */
public class InsertionSort 
{
	public LinkedList ll;

	public InsertionSort()
	{
		ll = new LinkedList();
	}

	public String toString()
	{
		return ll.toString();
	}

	public void sort()
	{
		// there is a raw and a sorted
		// for item in raw
		// 	decide where it goes
		//	put it in sorted
	}
    public static void main( String[] args )
    {
	InsertionSort sort = new InsertionSort();
	sort.ll.insert("F");
	sort.ll.insert("C");
	sort.ll.insert("G");
	sort.ll.insert("D");
	sort.ll.insert("A");
	sort.ll.insert("E");
	sort.ll.insert("B");

        System.out.println( "Hello InsertionSort!" );
        System.out.println( sort );
    }
}
