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

	public int binarySearch( int[] array, int lower, int upper, int target )
	{
		int range = (upper-lower);

		if( range == 0 && target != array[lower] )
		{
			System.out.println( "not in array" );
			return -1;
		}

		if( range < 0 )
		{
			System.out.println( "no esta aqui" );
			return -1;
		}

		int half = lower + (upper-lower)/2;
		System.out.println( "lower " + lower + " upper " + upper + " half " + half + " range " + range );
		if( target > array[half] )
		{
			System.out.println( "Target " + target + " >  array[half] " + array[half] + " ( half = " + half + " )" );
			// recur case
			return binarySearch( array, half+1, upper, target );
		}
		else if( target < array[half] )
		{
			// recur case
			System.out.println( "Target " + target + " <  array[half] " + array[half] + " ( half = " + half + " )" );
			return binarySearch( array, lower, half-1, target );
		}	
		else
		{
			// base case
			System.out.println( "Target " + target + " =  array[half] " + array[half] + " ( half = " + half + " )" );
			return half;
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

		int array[] = { 0,1,2,3,4,5,6,8,9,10,11,12,13,14,15,16,17,18,19,20 };

		System.out.println( theRecursion.binarySearch( array, 0, array.length, 7 ) );
		System.out.println( theRecursion.binarySearch( array, 0, array.length, 17 ) );
	}
}
