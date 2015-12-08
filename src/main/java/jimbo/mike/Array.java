package jimbo.mike;

/*
 * Array.java - variations on a theme
 *
 */

public class Array
{
	String s1 = "people say im the life of the party because i tell a joke or two";
	String s2 = "we the people of the united states of america";

	public char firstNonRepeatedChar( String in )
	{
		int counts[];
		counts = new int[128];
		int i;

		for( i=0; i < 128; i++ )
		{
			counts[i] = 0;
		}

		int length = in.length();
		char c;

		for( i = 0; i < length; i++ )
		{
			c = in.charAt(i);
			counts[ (int) c]++;
		}

                for( i = 0; i < length; i++ )
                {
			c = in.charAt(i);
                        if( counts[(int)c] == 1 )
			{
				return c;
			}
                }
		return ' ';
	}
	public static void main( String[] args )
	{
		System.out.println( "Hello Array!" );
		Array theArray = new Array();
		char c = theArray.firstNonRepeatedChar( theArray.s1 );
		System.out.println( c );
		c = theArray.firstNonRepeatedChar( theArray.s2 );
		System.out.println( c );
	}
}
