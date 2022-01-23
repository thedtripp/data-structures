package project8_graphs;
public class Graph extends HashTable {
    
    private int size;
    //MyLinkedList[] graphArray; //Extended from hash table so don't need this.
    
    /** Function: Graph
     * Author: Daniel Tripp
     * Description: A single argument constructor function which creates a Graph
     * of the specified size.
     * Inputs: Integer, size
     * Outputs: None
     */
    public Graph(int tableSize) {
        this.theLists = new MyLinkedList[tableSize];
        for( int i = 0; i < theLists.length; i++ ) {
            theLists[ i ] = new MyLinkedList();
        }
    }

    
    /** Function: printGraph
     * Author: Daniel Tripp
     * Description: This method formats and prints the Graph and adjacency list.
     * Only prints cells that have data in them.
     * Inputs: None
     * Outputs: Adjacency list of Graph.
     */
    public void printGraph() {
        int i = 0;
        int k = 0;
        for( int j = 0; j < theLists.length; j++ ) {
            if (theLists[j].getSize() >= 1) {
                System.out.print("List " + (i + 1) + ": ");
                i++;
                MyLinkedList.Node p = theLists[j].getHead();
                k = 0;
                    while(p.Next.Next != null) {
                        // First item in list
                        if (k == 0) {
                            System.out.print("[ " + p.Next.Data + " ]\t-> ");
                            p = p.Next;
                            k++;
                        }
                        // All other items in list
                        else {
                            System.out.print("( " + p.Next.Data + " ) ");
                            p = p.Next;
                            k++;
                        }
                    }
                System.out.println();
            }
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
    @Override
    public void insert( String data ) {
        MyLinkedList<MyLinkedList.Node> whatList = theLists[ bernsteinHash( data ) ];
        if( !whatList.contains( data ) ) {
            whatList.oAddToEnd( data );
        }
    }
    
    
    /** Function: addEgde
     * Author: Daniel Tripp
     * Description: This method searches the Graph for both Nodes. If both Nodes
     * are found, they are added to each other's adjacency lists.
     * Inputs: String, data 2 nodes to be connected.
     * Outputs: None
     */
    public void addEgde( String src, String dest) {
        //Check that both values are in the table.
        if (theLists[ bernsteinHash( src ) ].getHead().Next.Data != null && theLists[ bernsteinHash( dest ) ].getHead().Next.Data != null) {
            
            if (theLists[ bernsteinHash( src ) ].getHead().Next.toString().equals(src) ) {
                if (!theLists[ bernsteinHash( src ) ].contains(dest)) {
                    theLists[ bernsteinHash( src )].oAddToEnd(dest);
                }
            }
            else
                System.out.println("\"" + src + "\" is NOT the first item in the chain.");
            
            if (theLists[ bernsteinHash( dest ) ].getHead().Next.toString().equals(dest) ) {
                if (!theLists[ bernsteinHash( dest ) ].contains(src)) {
                    theLists[ bernsteinHash( dest )].oAddToEnd(src);
                }
            }
            else
                System.out.println("\"" + dest + "\" is NOT the first item in the chain.");
        }
        else
            System.out.println("Error: Cannot add edge. Search term \"" + src + "\" or \"" + dest + "" + "\" not in Hash Table.");
    }
    
    /** Function: isVisited
     * Author: Daniel Tripp
     * Description: This method searches the hash table for a String of data.
     * If the node is in the hash table, it checks if node has been visited.
     * Inputs: String data to search for and check
     * Outputs: Boolean indicating whether or not the Node has been visited.
     */
    public boolean isVisited( String data ) {
        //Check if String exists in graph.
        if (theLists[ bernsteinHash( data ) ].getHead().Next.Data == null)
            System.out.println("Error: Data not found in Graph.");
        return (theLists[ bernsteinHash( data )].getHead().Next.Visited);
    }
    
    /** Function: depthFirstSearch
     * Author: Daniel Tripp
     * Description: Depth First Search of the graph, outputs each visited node
     * to the console.
     * This function is based on the pseudocode from Figure 9.61 in the textbook.
     * void dfs( Vertex v ) {
     *      v.visited = true;
     *      for each Vertex w adjacent to v
     *          if ( !w.visited )
     *              dfs( w );
     * }
     * Inputs: String.
     * Outputs: None.
     */
    public void depthFirstSearch( String data ) {
        //Check if data is in graph
        if (theLists[ bernsteinHash( data ) ].getHead().Next.Data == null) {
            System.out.println("Error: Data not found in Graph.");
            return;
        }
        // Print node if not yet visited.
        if (theLists[ bernsteinHash( data )].getHead().Next.Visited == false) {
            System.out.println(data);
        }
        // Find the node of interest and mark visited.
        theLists[ bernsteinHash( data )].getHead().Next.Visited = true;
        // Set a pointer to the first node adjacent to the node of interest
        MyLinkedList.Node p = theLists[ bernsteinHash( data ) ].getHead().Next;
        while(p.Next.Next != null) {
            if (!this.isVisited(p.Next.toString())) {
                depthFirstSearch( p.Next.toString());
            }
            p = p.Next;
        }            
    }
}
