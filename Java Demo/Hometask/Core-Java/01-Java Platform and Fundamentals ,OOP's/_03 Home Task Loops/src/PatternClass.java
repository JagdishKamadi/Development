class PatternClass
{
    // pattern using for loop
    public static void usingForLoop(int number,int x)
    {
        int increment=0;           // to increment display value by x

        for(int i=0;i<number;i++)  // condition for external layer
        {
            for(int j=0;j<=i;j++)  // condition for internal layer
            {
                System.out.print(increment+"\t");  // to print the value
                increment+=x;	  				   // increment display value by x
            }
            System.out.println();  // printing new line
        }
    }

    public static void usingWhileLoop(int number,int x)
    {
        int i=0,j=0;
        int increment=0;    // to increment value by x

        while(i<number)     // condition for external layer
        {
            j=0;
            while(j<=i)    // condition for internal layer
            {
                System.out.print(increment+"\t");	// to print the value
                increment+=x; 						// increment display value by x
                j++;
            }
            i++;
            System.out.println();  // printing new line
        }
    }

    public static void usingDoWhileLoop(int number,int x)
    {
        int i=0,j=0;
        int increment=0;  // to increment value by x

        do
        {
            j=0;
            do
            {
                System.out.print(increment+"\t");  // to print the value
                increment+=x;					   // increment display value by x
                j++;
            }while(j<=i);  			// condition for internal layer
            i++;

            System.out.println();    	// printing new line
        }while(i<number);  				// condition for external layer
    }


    //	This function for printing - after pattern
    public static void space(int val)
    {
        System.out.println();
        for(int i=0;i<(val*4);i++)  // calculate boundary to print -
            System.out.print("-");

        System.out.println();

    }
}