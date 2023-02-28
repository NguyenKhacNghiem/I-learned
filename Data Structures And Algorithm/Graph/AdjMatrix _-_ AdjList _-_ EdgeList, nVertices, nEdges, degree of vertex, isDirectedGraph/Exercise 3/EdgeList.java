import java.util.* ;

public class EdgeList
{
    private ArrayList<IntegerTriple> edges;

    public EdgeList()
    {
        edges = new ArrayList<>();
    }

    public ArrayList<IntegerTriple> getEdges()
    {
        return edges ;
    }

    public void setEdges(ArrayList<IntegerTriple> edges)
    {
        this.edges = edges ;
    }
}