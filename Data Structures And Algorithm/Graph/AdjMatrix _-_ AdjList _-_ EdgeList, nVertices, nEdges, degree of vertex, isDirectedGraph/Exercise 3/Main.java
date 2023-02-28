import java.util.* ;
import java.io.* ;

public class Main
{
    static EdgeList getGraph()
    {
        try
        {
            File file = new File("EL.txt") ;
            Scanner sc = new Scanner(file) ;            
            EdgeList graph = new EdgeList() ;

            while(sc.hasNextLine())
            {
                String line = sc.nextLine() ;
                String[] items = line.split(" ") ;

                graph.getEdges().add(new IntegerTriple(Integer.parseInt(items[0]), 
                                         Integer.parseInt(items[1]), Integer.parseInt(items[2]))) ;
            }
            sc.close();
            return graph;
        }
        catch(Exception e)
        {
            System.out.println("Fail while reading file !") ;
            return null ;
        }
    }

    static int getNumberOfVertices(EdgeList graph)
    {
        int max = 0 ;

        for(IntegerTriple i:graph.getEdges())
        {
            if(i.getDest() > max)     max = i.getDest() ; 
            if(i.getSource() > max)   max = i.getSource() ; 
        }
        
        return max ;
    }

    static int getNumberOfEdges(EdgeList graph)
    {
        return graph.getEdges().size() ;
    }

    static void getDegreeOfVertices(EdgeList graph)
    {
        for(int i=1;i<=getNumberOfVertices(graph);i++)
        {
            int degree = 0 ;

            for(IntegerTriple j:graph.getEdges())
                if(j.getSource() == i)
                    degree++ ;
            
            System.out.println("The degree of vertex "+i+" is: "+degree) ;
        }
    }

    static int[][] transferToAdjMatrix(EdgeList graph)
    {
        int n = getNumberOfVertices(graph) ; // n is the number of vertices
        int[][] adjMatrix = new int[n+1][n+1] ;

        for(int i=0;i<n;i++)
            for(int j=0;j<n;j++)
                adjMatrix[i][j] = 0 ;
        
        for(IntegerTriple i:graph.getEdges())  
            adjMatrix[i.getSource()][i.getDest()] = i.getWeight() ;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
                System.out.print(adjMatrix[i][j]+" ") ;
            System.out.println() ;
        }
        
        return adjMatrix ;
    }

    public static void main(String[] args) 
    {
        EdgeList graph = getGraph() ;

        System.out.println("The number of vertices: "+getNumberOfVertices(graph)) ;

        System.out.println("The number of edges: "+getNumberOfEdges(graph)) ;

        getDegreeOfVertices(graph);

        System.out.println("ADJACENT MATRIX") ;
        int[][] adjMatrix = transferToAdjMatrix(graph) ;
    }
}