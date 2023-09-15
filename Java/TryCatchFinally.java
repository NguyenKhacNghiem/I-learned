// Khi catch, ta phai catch tu chi tiet -> tong quat

public class TryCatchFinally
{
	public static void main(String[] args)
	{
		int n;
		
		// try-catch nhung catch van dinh ngoai le -> chuong trinh dung
		try {
			n = 1 / 0;
			System.out.println("try");
		}
		catch(NullPointerException e1) { 
			n = 2 / 0;
			System.out.println("catch 1");
		}
		
		// catch 1 dinh ngoai le thi con catch 2
		try {
			n = 1 / 0;
			System.out.println("try");
		}
		catch(NullPointerException e1) {  // ngoai le chi tiet
			n = 2 / 0;
			System.out.println("catch 1");
		}
		catch(Exception e2) {  			 // ngoai le tong quat
			System.out.println("catch 2");
		}
		
		// finally: du vo try hay catch thi cuoi cung van phai di qua finally
		try {
			n = 1 / 0;
			System.out.println("try");
		}
		catch(NullPointerException e1) {  // ngoai le chi tiet
			n = 2 / 0;
			System.out.println("catch 1");
		}
		catch(Exception e2) {  // ngoai le tong quat
			System.out.println("catch 2");
		}
		finally {
			System.out.println("finally");
		}
	}
}