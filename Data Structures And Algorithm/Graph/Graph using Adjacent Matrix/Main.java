public class Main
{
    public static void main(String[] args) 
    {
        AdjMatrix adjMatrix = new AdjMatrix(5) ;
        adjMatrix.addEdge(0, 1);
        adjMatrix.addEdge(1, 2);
        adjMatrix.addEdge(2, 3);
        adjMatrix.addEdge(1, 4);
        adjMatrix.addEdge(3, 4);
        adjMatrix.print();

        System.out.println("Traversal by using BFS") ;
        adjMatrix.BFS(0) ;

        System.out.println("\nTraversal by using DFS") ;
        adjMatrix.DFS(0) ;

        System.out.println("\nTraversal by using DFS_Stack") ;
        adjMatrix.DFS_Stack(0) ;

        System.out.println("\n" + adjMatrix.isReachable(0, 3)) ;

        // find the path between vertex 1 and vertex 4
        System.out.println("\n"+adjMatrix.findThePathBetweenTwoVertices(0, 3)) ;
    }
}