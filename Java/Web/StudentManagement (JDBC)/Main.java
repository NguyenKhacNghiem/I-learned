import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class Main 
{
	static void insert(Connection connect) throws SQLException
	{
		Scanner sc = new Scanner(System.in);
		
		System.out.println("MSSV se duoc tao tu dong.");
		
		System.out.print("Nhap gioi tinh: ");
		String gender = sc.nextLine();
		
		System.out.print("Nhap tuoi: ");
		int age = sc.nextInt();
		
		System.out.print("Nhap gpa: ");
		double gpa = sc.nextDouble();
		
		String sql = "INSERT INTO Student (gender, age, gpa) VALUES (?, ?, ?)";
		PreparedStatement statement = connect.prepareStatement(sql)  ; // Create a statement to excute sql commands
		
		statement.setString(1, gender);
		statement.setInt(2, age);
		statement.setDouble(3, gpa);
		
		int numberOfResult = statement.executeUpdate(); // executeUpdate() used for insert, update, delete
		
		if(numberOfResult != 0)
			System.out.println("Them thanh cong.");
		else
			System.out.println("Them that bai.");		
	}
	
	static void printStudentList(Connection connect) throws SQLException
	{
		String sql = "SELECT * FROM Student";
		PreparedStatement statement = connect.prepareStatement(sql);
		
		ResultSet rs = statement.executeQuery();
		
		while(rs.next())
		{
			int id = rs.getInt(1);  // get by column index (start at 1)
			String gender = rs.getString(2);
			int age = rs.getInt("age"); // get by column label
			double gpa = rs.getDouble("gpa");
			
			System.out.println("Student[mssv=" + id + ", gender=" + gender + ", age=" + age + ", gpa=" + gpa + "]");
		}
	}
	
	static void search(Connection connect) throws SQLException
	{
		Scanner sc = new Scanner(System.in);
		boolean check = false;
		
		System.out.print("Nhap mssv cua sinh vien ban muon tim kiem: ");
		int key = sc.nextInt();
		
		String sql = "SELECT * FROM Student";
		PreparedStatement statement = connect.prepareStatement(sql);
		
		ResultSet rs = statement.executeQuery();
		
		while(rs.next())
		{
			int id = rs.getInt(1);  
			
			if(id == key)
			{
				String gender = rs.getString(2);
				int age = rs.getInt("age");
				double gpa = rs.getDouble("gpa");
				
				check = true;
				System.out.println("Student[mssv=" + id + ", gender=" + gender + ", age=" + age + ", gpa=" + gpa + "]");
			}
		}
		
		if(!check)
			System.out.println("Khong tim thay sinh vien.");
	}
	
	static void update(Connection connect) throws SQLException
	{
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Nhap mssv cua sinh vien ban muon cap nhat thong tin: ");
		int id = sc.nextInt();
				
		sc.nextLine();
		System.out.print("Nhap gioi tinh moi: ");
		String gender = sc.nextLine();
		
		System.out.print("Nhap tuoi moi: ");
		int age = sc.nextInt();
		
		System.out.print("Nhap gpa moi: ");
		double gpa = sc.nextDouble();
		
		String sql = "UPDATE Student SET gender = ?, age = ?, gpa = ? WHERE id = ?";
		PreparedStatement statement = connect.prepareStatement(sql)  ; 
		
		statement.setString(1, gender);
		statement.setInt(2, age);
		statement.setDouble(3, gpa);
		statement.setInt(4, id);
		
		int numberOfResult = statement.executeUpdate();
		
		if(numberOfResult != 0)
			System.out.println("Them thanh cong.");
		else
			System.out.println("Khong tim thay sinh vien.");		
	}
	
	static void delete(Connection connect) throws SQLException
	{
Scanner sc = new Scanner(System.in);
		
		System.out.print("Nhap mssv cua sinh vien ban muon xoa: ");
		int id = sc.nextInt();
		
		String sql = "DELETE FROM Student WHERE id = ?";
		PreparedStatement statement = connect.prepareStatement(sql)  ; 
		
		statement.setInt(1, id);
		
		int numberOfResult = statement.executeUpdate();
		
		if(numberOfResult != 0)
			System.out.println("Xoa thanh cong.");
		else
			System.out.println("Khong tim thay sinh vien.");		
	}
	
	public static void main(String[] args) throws SQLException 
	{
		Scanner sc = new Scanner(System.in);
		Connection connect = MySQLConnUtils.openConnection(); // Open connection
		int choice;
		
		do
		{
			System.out.println("***** QUAN LY SINH VIEN SU DUNG JDBC *****");
			System.out.println("1. Hien thi danh sach sinh vien");
			System.out.println("2. Tim kiem sinh vien");
			System.out.println("3. Them sinh vien");
			System.out.println("4. Cap nhat thong tin sinh vien");
			System.out.println("5. Xoa sinh vien");
			System.out.println("6. Thoat");
			System.out.println("Chon: ");
			choice = sc.nextInt();
			
			switch(choice)
			{
				case 1:
					printStudentList(connect);
					break;
				case 2:
					search(connect);
					break;
				case 3:
					insert(connect);
					break;
				case 4:
					update(connect);
					break;
				case 5:
					delete(connect);
					break;
				case 6:
					System.out.println("Thoat thanh cong.");
					break;
				default: 
					System.out.println("Yeu cau khong hop le.");
					break;
			}
			
		}while(choice != 6);
		
		/* Print info of connection for testing */
		// MySQLConnUtils.printConnectionInfo(connect);
		// System.out.println(connect);
		
		connect.close(); // Close connection
	}
}
