import java.util.* ; 
import java.io.* ;

// DAY LA SRC MAU DE THAM KHAO, FILE KO CHAY DUOC
public class ReadFile 
{	
	static <E> ArrayList<E> docFile(String path, ArrayList<E> thuoc, int check) // Kien thuc Generic
	{
		try
		{
			File reader = new File(path) ; 
			Scanner sc = new Scanner(reader) ; 
		
			while(sc.hasNextLine())
			{
				String line_t = sc.nextLine() ;
				String line_sl = sc.nextLine() ;
				String line_dg = sc.nextLine() ;
				String line = sc.nextLine() ;
				
				if(check==1)   // nho ep ve kieu du lieu E cua Generic
					thuoc.add((E)new ThuocHo(line_t,Integer.parseInt(line_sl),Double.parseDouble(line_dg),line)) ; 
				if(check==2)  
					thuoc.add((E)new ThuocSot(line_t,Integer.parseInt(line_sl),Double.parseDouble(line_dg),line)) ;
			}
			sc.close();
			return thuoc ; 
		}catch(Exception e){;}
	
		return thuoc ; 
	}
	
	static <E> void ghiFile(String path,ArrayList<E> thuoc)
	{
		try
		{
			FileWriter writer = new FileWriter(path) ; 
			for(E i:thuoc)
				writer.write(i.toString()+"\n") ;
			
			writer.close(); 
		}catch (Exception e){;}
	}
	
	public static void main(String[] args) 
	{	
		ArrayList<ThuocHo> thuocHo = new ArrayList<>() ;
		ArrayList<ThuocSot> thuocSot = new ArrayList<>() ;	
		
		thuocHo = docFile("inputThuocHo.txt", thuocHo, check) ; 
		thuocSot = docFile("inputThuocSot.txt", thuocSot, check) ; 
		
		ghiFile("outputThuocHo.txt", thuocHo) ; 		
		ghiFile("outputThuocSot.txt", thuocSot) ; 
	}
}
					
					
						
					
					
		
				
				
					
					
						
					
					
				
