import java.util.* ;

public class SapXepTrongArrayList
{
    static ArrayList<Integer> SapXepInt(ArrayList<Integer> a)
    {
        Collections.sort(a, new Comparator<Integer>()  // nho import java.uti.* ; 
        {
            public int compare(Integer a1, Integer a2)  // kieu du lieu cua ArrayList. 
            {                                           // Ngoai ra con co sap xep theo doi tuong, theo ten trong ho ten -> Tham khao trong BTL
                // sap xep theo thu tu giam dan. Muon tang dan thi doi -1 -> 1 va 1 -> -1
                if(a1 < a2) return 1 ;
                if(a1 > a2) return -1 ;
                return 0 ;    // truong hop bang nhau
            }
        });  // Luu y cai ngoac o cuoi
        
        return a ;
    }

    static ArrayList<String> SapXepString(ArrayList<String> s)
    {
        Collections.sort(s, new Comparator<String>()   // nho import java.uti.* ;
        {  
            public int compare(String s1, String s2)   // kieu du lieu cua ArrayList
            {
                // sap xep theo thu tu bang chu cai Alphabet
                return s1.compareTo(s2) ; 
            }
        });  // Luu y cai ngoac o cuoi
        
        return s ;
    }

    static void Display(ArrayList<Integer> a, ArrayList<String> s)
    {
        for(Integer i:a)
            System.out.println(i) ;
        
        for(String i:s)
            System.out.println(i) ;
    }

    public static void main(String[] args)
    {
        ArrayList<Integer> a = new ArrayList<>() ;  // ArrayList khong chua kieu du lieu nguyen thuy
        a.add(1) ;
        a.add(3) ;
        a.add(2) ;

        ArrayList<String> s = new ArrayList<>() ; 
        s.add("an") ; 
        s.add("cuong") ; 
        s.add("binh") ; 

        System.out.println("Truoc khi sap xep: ") ; 
        Display(a,s);

        a = SapXepInt(a) ;
        s = SapXepString(s) ;

        System.out.println("Sau khi sap xep: ") ; 
        Display(a,s);
    }
}