package project6_hashing;

/**
 * A basic hash table. It uses the Bernstein hashing algorithm and
 * separate chaining for collision resolution.
 * @author danieltripp
 */
public class HashTable {
    
    protected static final int DEFAULT_TABLE_SIZE = 50; //next prime after 50
    
    protected MyLinkedList<MyLinkedList.Node>[] theLists;
    public int currentSize;
    
    /** Function: HashTable
     * Author: Daniel Tripp
     * Description: A no argument constructor function which creates a hash table
     * of the default size.
     * Inputs: Integer, size
     * Outputs: None
     */
    public HashTable() {
        this( nextPrime( DEFAULT_TABLE_SIZE ) );
    }
    
    /** Function: HashTable
     * Author: Daniel Tripp
     * Description: A single argument constructor function which creates a hash table
     * of the specified size.
     * Inputs: Integer, size
     * Outputs: None
     */
    public HashTable( int tableSize ) {
        theLists = new MyLinkedList[ tableSize ];
        for( int i = 0; i < theLists.length; i++ ) {
            theLists[ i ] = new MyLinkedList<>();
        }
    }
    
    /** Function: insert
     * Author: Daniel Tripp
     * Description: This method searches the hash table for data.
     * First, it hashes the string to determine which cell of the has table to
     * visit. Then it does linear search of the linked list in the cell. It 
     * uses the contains method from the linked list class. If the data is not
     * found, it is inserted.
     * Inputs: String, data to search and insert to hash table.
     * Outputs: None
     */
    //public void hash( String data ) {
    public void insert( String data ) {
        MyLinkedList<MyLinkedList.Node> whatList = theLists[ bernsteinHash( data ) ];
        if( !whatList.contains( data ) ) {
            whatList.oAddToBeginning( data );
            
            if (++currentSize > theLists.length) {
                ;//rehash();
            }
        }
    }
    

    /** Function: remove
     * Author: Daniel Tripp
     * Description: This method searches the hash table for data to delete.
     * First, it hashes the string to determine which cell of the has table to
     * visit. Then it does linear search of the linked list in the cell. It 
     * uses the contains method from the linked list class. If the data is found,
     * It is deleted.
     * Inputs: String, data to search and delete from hash table.
     * Outputs: None
     */
    public void remove( String data ) {
        MyLinkedList<MyLinkedList.Node> whatList = theLists[ bernsteinHash( data ) ];
        if( whatList.contains( data ) ) {
            whatList.deleteNode( data );
            currentSize--;
        }
    }
    
    /** Function: contains
     * Author: Daniel Tripp
     * Description: This method searches the hash table for a String of data
     * First, it hashes the string to determine which cell of the has table to
     * visit. Then it does linear search of the linked list in the cell. It 
     * uses the contains method from the linked list class.
     * Inputs: String data to search for
     * Outputs: boolean indicating whether or not the data was found.
     */
    public boolean contains( String data ) {
        MyLinkedList<MyLinkedList.Node> whatList = theLists[ bernsteinHash( data ) ];
        return whatList.contains( data );
    }

    
    /** Function: rehash
     * Author: Daniel Tripp
     * Description: This method resizes the table when the load factor gets too
     * high. It creates a new table that is approximately double the size of the
     * previous table. Then, the old data is hashed and copied to the new table
     * Inputs: None
     * Outputs: New, larger hash table
     */
    public void rehash() {
        MyLinkedList<MyLinkedList.Node>[] oldLists = theLists;
        
        theLists = new MyLinkedList[ nextPrime( 2 * theLists.length ) ];
        for( int i = 0; i < theLists.length; i++ ) {
            theLists[ i ] = new MyLinkedList<>();
        }
        
        currentSize = 0;
        for( int j = 0; j < oldLists.length; j++ ) {
            MyLinkedList.Node p = oldLists[j].getHead();
            while(p.Next.Next != null) {
                insert( (String) p.Next.Data );
                p = p.Next;
            }
        }
    }
    
    /** Function: bernsteinHash
     * Author: Dr. Glenn Stevenson
     * Description: This method hashes a string to an integer value for 
     * placement into the has table
     * Inputs: String value
     * Outputs: int, hashed value
     */
    public int bernsteinHash(String value)
    {
        long hashVal = 5381;

        for(char c : value.toCharArray())
        {
            hashVal *= 33;
            hashVal += (int) c;
        }

        hashVal %= theLists.length;
        if ( hashVal < 0 ) {
            hashVal += theLists.length;
        }
        return (int) hashVal;
    }
    
    /** Function: search
     * Author: Daniel Tripp
     * Description: This method searches the hash table for a String of data
     * First, it hashes the string to determine which cell of the has table to
     * visit. Then it does linear search of the linked list in the cell. It 
     * uses the contains method from the linked list class.
     * Inputs: String data to search for
     * Outputs: Integer indicating whether or not the data was found.
     */
    public int search(String data) {
        MyLinkedList<MyLinkedList.Node> whatList = theLists[ bernsteinHash( data ) ];
        if( whatList.contains( data ) ) {
            return 1;
        }
        return 0;
    }
    
    /** Function: printTable
     * Author: Daniel Tripp
     * Description: This method formats and prints the hash table.
     * Inputs: None
     * Outputs: Prints the structure and contents of the hash table.
     */
    public void printTable() {
        for( int j = 0; j < theLists.length; j++ ) {
            System.out.print("List " + (j + 1) + ": ");
            MyLinkedList.Node p = theLists[j].getHead();
            while(p.Next.Next != null) {
                System.out.print("( " + p.Next.Data + " ) ");
                p = p.Next;
            }
            System.out.println();
        }
    }
    
    /** Function: nextPrime
     * Author: Unknown
     * Description: This helper method finds the next largest prime number of an
     * input. I obtained this code through an Internet search.
     * Inputs: Integer find next prime of.
     * Outputs: integer, next largest prime number.
     */
    public static int nextPrime( int n ) {
        n++;
        for( int i = 2; i < n; i++ ) {
            if(( n % i ) == 0 ) {
                n++;
                i = 2;
            } else {
                continue;
            }
        }        
        return n;
    }

    /** Function: isPrime
     * Author: Unknown
     * Description: This helper method checks if a number is prime and returns
     * a boolean. I obtained this code through an Internet search.
     * Inputs: Integer to check if prime.
     * Outputs: Boolean indicating whether the number input is prime.
     */
    public static boolean isPrime( int n ) {
        boolean prime = true;
        for( int i = 2; i < n; i++ ) {
            if(( n % i ) == 0 ) {
                prime = false;
            }
        }
        return prime;
    }
}