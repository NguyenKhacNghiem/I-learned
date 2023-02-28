import java.util.*;
import org.hibernate.Session;
import org.hibernate.query.Query;

public class Main 
{
	static void printList()
	{
		Session session = HibernateUtils.getFactory().openSession();
		Query query = session.createQuery("FROM Student");
		
		List<Student> students = query.getResultList();
		
		if(students.size() != 0)
			students.forEach(s -> System.out.println("Student[id="+s.getId()+", gender="+s.getGender()+", age="+s.getAge()+", gpa="+s.getGpa()+"]"));
		else
			System.out.println("Danh sach rong");
		
		session.close();
	}
	
	static void search()
	{
		Scanner sc = new Scanner(System.in);
		Session session = HibernateUtils.getFactory().openSession();
		
		System.out.print("Nhap mssv ban muon tim kiem: ");
		int id = sc.nextInt();
		
		Student student = session.get(Student.class, id);
		
		if(student != null)
			System.out.println("Student[id="+student.getId()+", gender="+student.getGender()+", age="+student.getAge()+", gpa="+student.getGpa()+"]");
		else
			System.out.println("Khong tim thay sinh vien");
		
		session.close();
	}
	
	static void add()
	{
		Session session = HibernateUtils.getFactory().openSession();
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Nhap gioi tinh: ");
		String gender = sc.nextLine();
		
		System.out.print("Nhap tuoi: ");
		int age = sc.nextInt();
		
		System.out.print("Nhap diem trung binh: ");
		double gpa = sc.nextDouble();
		
		Student student = new Student();
		student.setGender(gender);
		student.setAge(age);
		student.setGpa(gpa);
		
		session.save(student);
		session.close();
	}
	
	static void update()
	{
		Session session = HibernateUtils.getFactory().openSession();
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Nhap mssv cua sinh vien can cap nhat thong tin: ");
		int id = sc.nextInt();
		
		Student student = session.get(Student.class, id);
		
		if(student != null)
		{
			sc.nextLine();
			System.out.print("Nhap gioi tinh moi: ");
			String gender = sc.nextLine();
			
			System.out.print("Nhap tuoi moi: ");
			int age = sc.nextInt();
			
			System.out.print("Nhap diem trung binh moi: ");
			double gpa = sc.nextDouble();
			
			student.setGender(gender);
			student.setAge(age);
			student.setGpa(gpa);
			
			session.getTransaction().begin(); // Tranh chap ghi du lieu phai co giao tac (co 2 client cung thuc hien)
			session.save(student);
			session.getTransaction().commit(); // save lai
			
			System.out.println("Cap nhat thong tin sinh vien thanh cong");
		}
		else
			System.out.println("Khong tim thay sinh vien");
			
		session.close();
	}
	
	static void delete()
	{
		Session session = HibernateUtils.getFactory().openSession();
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Nhap mssv cua sinh vien ban muon xoa: ");
		int id = sc.nextInt();
		
		Student student = session.get(Student.class, id);
		
		if(student != null)
		{	
			session.getTransaction().begin(); // Tranh chap ghi du lieu phai co giao tac (co 2 client cung thuc hien)
			session.delete(student);
			session.getTransaction().commit(); // save lai
			
			System.out.println("Xoa sinh vien thanh cong");
		}
		else
			System.out.println("Khong tim thay sinh vien");
		
		session.close();
	}
	
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		int choice;
		
		do
		{
			System.out.println("1. Hien thi danh sach sinh vien");
			System.out.println("2. Hien thi danh sach sinh vien theo MSSV");
			System.out.println("3. Them sinh vien voi MSSV tu dong");
			System.out.println("4. Cap nhat thong tin SV");
			System.out.println("5. Xoa SV");
			System.out.println("6. Thoat");
			System.out.print("Chon: ");
			choice = sc.nextInt();
			
			switch(choice)
			{
				case 1:
					printList();
					break;
				case 2:
					search();
					break;
				case 3:
					add();
					break;
				case 4:
					update();
					break;
				case 5:
					delete();
					break;
				case 6:
					System.out.println("Thoat thanh cong");
					break;
				default:
					System.out.println("Lua chon khong hop le");
					break;
			}
		}while(choice != 6);
		

	}

}
