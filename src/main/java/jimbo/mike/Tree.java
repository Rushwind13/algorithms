package jimbo.mike;

/*
 *
 *
 */

class Tree
{
	Leaf root;

	public Tree( String _data )
	{
		this.root = new Leaf( _data );
	}

	public void insert( String _data )
	{
		Leaf toInsert = new Leaf( _data );
		insert( toInsert );
	}

	public void insert( Leaf toInsert )
	{
		Leaf curr = root;

		while( curr != null )
		{
			if( curr.compareTo( toInsert ) >= 0 )
			{
				if( curr.left == null )
				{
					curr.left = toInsert;
					return;
				}
				curr = curr.left;
			}
			else
			{
				if( curr.right == null )
				{
					curr.right = toInsert;
					return;
				}
				curr = curr.right;
			}
		}
	}
	public Leaf find( String toFind )
	{
		Leaf query = new Leaf( toFind );
		return this.find( query );
	}
	public Leaf find( Leaf toFind )
	{
		Leaf curr = root;

		while( curr != null )
		{
			int pos = curr.compareTo( toFind );
			if( pos > 0 )
			{
				curr = curr.left;
			}
			else if( pos < 0 )
			{
				curr = curr.right;
			}
			else
			{
				return curr;
			}
		}
		return null;
	}

	public Leaf commonAncestor( String one, String two )
	{
		Leaf curr = root;
		// Ensure one < two
		if( one.compareTo( two ) > 0 )
		{
			//System.out.println( "Swapping " + one + " and " + two );
			String temp = one;
			one = two;
			two = temp;
		}

		while( curr != null )
		{
			// if curr > both, go right
			if( curr.data.compareTo( two ) > 0 )
			{
				//System.out.println( "Comparing " + two + " to " + curr.data + ": " + curr.data.compareTo( two ) );
				curr = curr.left;
			}
			// if curr < both, go left
			else if( curr.data.compareTo( one ) < 0 )
			{
				//System.out.println( "Comparing " + one + " to " + curr.data + ": " + curr.data.compareTo( one ) );
				curr = curr.right;
			}
			// otherwise, you're between, and thus are pointing to the correct node
			else
			{
				return curr;
			}
		}
		return null;
	}
	public String preOrderIterative()
	{
		StringBuffer out = new StringBuffer();
		Leaf curr = root;
		Tree.Stack.Node node;
		Stack theStack = new Stack();
		theStack.push( root );
		while( theStack.head != null )
		{
			node = theStack.pop();
			curr = node.data;
			out.append( curr.data + " " );
			if( curr.right != null ) theStack.push( curr.right );
			if( curr.left != null ) theStack.push( curr.left );
		}

		return out.toString();
	}
	public String inOrder( Leaf curr )
	{
		StringBuffer out = new StringBuffer();
		if( curr == null ) return out.toString();
		out.append( inOrder( curr.left ) );
		out.append( curr.data + " " );
		out.append( inOrder( curr.right ) );

		return out.toString();
	}
	public String preOrder( Leaf curr )
	{
		StringBuffer out = new StringBuffer();
		if( curr == null ) return out.toString();
		out.append( curr.data + " " );
		out.append( preOrder( curr.left ) );
		out.append( preOrder( curr.right ) );

		return out.toString();
	}
	public String postOrder( Leaf curr )
	{
		StringBuffer out = new StringBuffer();
		if( curr == null ) return out.toString();
		out.append( postOrder( curr.left ) );
		out.append( postOrder( curr.right ) );
		out.append( curr.data + " " );

		return out.toString();
	}

	@Override
	public String toString()
	{
		return this.inOrder( root );
	}
	public static void main( String[] args )
	{
		Tree theTree = new Tree( "5" );
		System.out.println( "Hello Tree!" );
		System.out.println( theTree );
		
		theTree.insert( "9" );
		System.out.println( theTree );
		
		theTree.insert( "2" );
		System.out.println( theTree );
		
		theTree.insert( "7" );
		System.out.println( theTree );
		
		theTree.insert( "1" );
		System.out.println( theTree );
		
		System.out.println( theTree.preOrder( theTree.root ) );
		System.out.println( theTree.postOrder( theTree.root ) );
		System.out.println( theTree.preOrderIterative() );

		System.out.println( theTree.find("7") );
		System.out.println( theTree.find("6") );

		Tree otherTree = new Tree( "20" );
		otherTree.insert("08");
		otherTree.insert("22");
		otherTree.insert("12");
		otherTree.insert("04");
		otherTree.insert("10");
		otherTree.insert("14");

		System.out.println( otherTree );
		System.out.println( otherTree.preOrderIterative() );
		System.out.println( otherTree.commonAncestor( "14", "04" ) );
		System.out.println( otherTree.commonAncestor( "10", "22" ) );
		System.out.println( otherTree.commonAncestor( "08", "04" ) );
	}

	class Leaf implements Comparable<Leaf>
	{
		Leaf left;
		Leaf right;
		String data;

		public Leaf( String _data )
		{
			this.data = _data;
		}
		@Override
		public String toString()
		{
			return this.data;
		}

		@Override
		public int compareTo( Leaf that )
		{
			return this.data.compareTo( that.data );
		}
	}

	class Stack
	{
		Node head;
		public Stack() {}
		public void push( Tree.Leaf _data )
		{
			Node toPush = new Node( _data );
			toPush.next = head;
			head = toPush;	
		}

		public Node pop()
		{
			Node toPop = head;
			head = toPop.next;

			return toPop;
		}

		class Node
		{
			public Node next;
			public Tree.Leaf data;

			public Node( Tree.Leaf _data )
			{
				this.data = _data;
			}
		}
	}
}
