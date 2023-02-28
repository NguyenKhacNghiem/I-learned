import java.util.* ;
import java.io.* ;

public class AdjacentMatrix 
{
    private City[][] twoDimensionArray = new City[10][10] ;
    private int[][] codes = new int[10][10] ;

    public void addEdge(int r, int c, City city) 
    {
        twoDimensionArray[r][c] = city ;
    }

    // a) doc file Code.txt va bieu dien do thi
    public void readFile(ArrayList<City> cities)
    {
        try
        {
            Scanner reader = new Scanner(new File("Code.txt")) ;
            int r = 0 ;

            while(reader.hasNextLine())
            {
                String row = reader.nextLine() ;
                String[] columns = row.split(" ") ;
                int c = 0 ;

                for(String i:columns)
                {
                    System.out.print(i + " ") ;   
      
                    if(!i.equals("0"))
                    {
                        addEdge(r, c, cities.get(c)); 
                        codes[r][c] = Integer.parseInt(i) ;
                    }
                    
                    c++ ;
                }

                System.out.println() ;
                r++ ;
            }
            reader.close();
        }
        catch(Exception e)
        {
            System.out.println("Error") ;
        }
    }

    public void printGraph() 
    {
        for(int r=0;r<10;r++) 
        {
            System.out.println("Neighboring cities of city " + (r+1) + " is: ") ;
            
            for(int c=0;c<10;c++)
                if(twoDimensionArray[r][c] != null)
                    System.out.println(twoDimensionArray[r][c]) ;
        }
    }

    // b) Tra ve danh sach cay khung nho nhat cua do thi tren
    // Su dung thuat toan Prim
    public void primMST()
    {
        int[] mst = new int[10];
        int[] minimumWeightEdges = new int[10];
        boolean[] mstVertices = new boolean[10];
 
        for(int i=0;i<10;i++) 
        {
            minimumWeightEdges[i] = Integer.MAX_VALUE;  // ban dau gan cac canh la so lon nhat 
            mstVertices[i] = false;                     // de luc sau tim so nho nhat
        }
 
        minimumWeightEdges[0] = 0;   
        mst[0] = -1;  // node root cua MST
 
        for(int i=0;i<9;i++) 
        {
            // i = 1
            int minIndex = minWeightEdge(minimumWeightEdges, mstVertices);
            //System.out.println("Min index = " + minIndex) ;
            mstVertices[minIndex] = true;
 
            for(int k = 0; k < 10; k++)
                if(codes[minIndex][k] != 0 && !mstVertices[k] && codes[minIndex][k] < minimumWeightEdges[k]) 
                {  
                    mst[k] = minIndex; 
                    minimumWeightEdges[k] = codes[minIndex][k];
                }
        }
 
        printMST(mst);
    }

    private int minWeightEdge(int minimumWeightEdges[], boolean mstVertices[])
    {
        int min = Integer.MAX_VALUE, minIndex = -1;
 
        for(int i=0;i<10;i++)
            if (!mstVertices[i] && minimumWeightEdges[i] < min) 
            {
                min = minimumWeightEdges[i];  
                minIndex = i;  
            }
 
        return minIndex;
    }

    private void printMST(int mst[])
    {
        System.out.println("Edges\tWeight");

        for (int i=1;i<10;i++)
            System.out.println((mst[i] + 1) + " - " + (i+1) + "\t" + codes[i][mst[i]]);
    }
}