import java.util.* ;
import java.io.* ;

public class Main
{
    static AdjList getAdjacentList()
    {
        try
        {
            File file = new File("AL.txt") ;
            Scanner sc = new Scanner(file) ;
            int vertex = Integer.parseInt(sc.nextLine()) ;
            AdjList graph = new AdjList(vertex) ;

            int row = 0 ;
            while(sc.hasNextLine())
            {
                String line = sc.nextLine() ;
                String[] items = line.split(" ") ;

                for(int i=items.length-1;i>=0;i--)
                    graph.list[row].addFirst(Integer.parseInt(items[i])) ;
                
                row++ ;
            }

            sc.close();
            return graph ;
        }
        catch(Exception e)
        {
            System.out.println("Failed while reading file") ;
            return null ;
        }
    }

    static void getDegreeOfVertices(AdjList graph)
    {
        for(int i=0;i<graph.n;i++)  // n is number of vertices
            System.out.println("The degree of vertex "+(i+1)+" is: " + ((graph.list[i].size())-1)) ;
    }

    static int getTotalOfEdges(AdjList graph)
    {
        int edges = 0 ;

        for(int i=0;i<graph.n;i++)  // n is number of vertices
            edges += graph.list[i].size() - 1 ;
        
        return edges ;
    }

    static int[][] transferToAdjMatrix(AdjList graph)
    {
        int[][] adjMatrix = new int[graph.n][graph.n] ;  // n is the number of vertices

        for(int i=0;i<graph.n;i++)
            for(int j=0;j<graph.n;j++)
                adjMatrix[i][j] = 0 ;
        
        for(int i=0;i<graph.list.length;i++)
            for(int j=0;j<graph.list[i].size();j++)
                adjMatrix[i][graph.list[i].get(j)-1] = 1 ;
        
        for(int i=0;i<graph.n;i++)
        {
            for(int j=0;j<graph.n;j++)
                System.out.print(adjMatrix[i][j]+" ") ;

            System.out.println() ;
        }

        return adjMatrix ;
    }

    public static void main(String[] args) 
    {
        AdjList graph = getAdjacentList() ;
        
        getDegreeOfVertices(graph);
        
        System.out.println("Number of edges: "+getTotalOfEdges(graph)) ;

        System.out.println("ADJACENT MATRIX") ;
        int[][] adjMatrix = transferToAdjMatrix(graph) ;
    }
}