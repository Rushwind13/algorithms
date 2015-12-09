package jimbo.mike;

/*
 *
 *
 */

public class Recur
{
	public int factorial( int n )
	{
		if( n == 0 || n == 1 ) return 1;
		return n * factorial( n-1 );
	}

	public int[] allTheFactorials( int n )
	{
		int results[] = new int[ n == 0 ? 1 : n ];
		doAllTheFactorials( n, results, n-1 );
		return results;
	}

	public int doAllTheFactorials( int n, int results[], int level )
	{
		if( n > 1 ) // Recur
		{
			results[level] = n * doAllTheFactorials( n-1, results, level-1 );
			return results[level];
		}
		else // Base
		{
			results[level] = 1;
			return 1;	
		}
	}
	public static void main( String[] args )
	{
		Recur theRecursion = new Recur();
		System.out.println( "Hello Recursion!" );

		int num = 10;
		System.out.println( theRecursion.factorial(num) );

		int results[] = theRecursion.allTheFactorials(num);
		for( int i=0; i < num; i++ )
		{
			System.out.println( results[i] );
		}
	}
}
