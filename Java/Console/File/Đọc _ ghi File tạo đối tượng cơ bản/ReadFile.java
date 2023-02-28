import java.util.* ;
import java.io.* ;  // Thu vien de xu ly File

public class ReadFile
{
    static void DisplayInformationsOnScreen(ArrayList<Person> person) // in thong tin len man hinh
    {
        for(Person i:person)
            System.out.println(i) ;
    }

    static void Read(ArrayList<Person> person)  // doc file SU DUNG Scanner
    {
        // tra ve void hay ArrayList deu duoc
        // neu cai ArrayList ma dat trong try-catch thi ra khoi try-catch no se mat
        try
        {
            File reader = new File("profiles_input.txt") ;  // hoac truyen String path vo
            Scanner sc = new Scanner(reader) ; 

            while(sc.hasNextLine())    // kt xem dong tiep theo co ton tai ko ->ham cho phep doc den cuoi file
            {
                String line = sc.nextLine() ;  // doc cai dong dau tien trong file
                System.out.println(line) ;    // xuat ra man hinh line vua doc duoc

                String[] informations = line.split(", ") ;

                String name = informations[0] ; 
                String sex = informations[1] ;
                int age = Integer.parseInt(informations[2]) ;   // chuyen String "123" thanh int 123
                double score = Double.parseDouble(informations[3]) ;
                boolean isLove = Boolean.parseBoolean(informations[4]) ; 

                person.add(new Person(name,sex,age,score,isLove)) ; 
            }

            sc.close() ;
        }catch(Exception e){
            System.out.println("Error when read file !!") ; 
            // if you don't want to print, you can use ";"
        }
    }

    static void Write(ArrayList<Person> person)  // ghi File KO SU DUNG Scanner
    {
        try
        {
            FileWriter writer = new FileWriter("profiles_output.txt") ;  // hoac truyen String path vo
            
            for(Person i:person)
                writer.write(i.toString()+"\n") ; 
            
            writer.close() ;

        }catch(Exception e){
            System.out.println("Error when write file !!") ; 
            // if you don't want to print, you can use ";"
        }
    }

    public static void main(String[] args)
    {
        ArrayList<Person> person = new ArrayList<>() ;

        Read(person);

        DisplayInformationsOnScreen(person) ;
        
        Write(person) ; 
    }
}
