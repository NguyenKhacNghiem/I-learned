import java.util.* ;

public class Main
{
    public static void main(String[] args) 
    {
        HashMap<Character, Integer> hashMap = new HashMap<>();
        Scanner sc = new Scanner(System.in) ;
        
        System.out.print("Enter s: ") ;
        String s = sc.nextLine();

        for(int i=0;i<s.length();i++)
        {
            boolean exists = false;

            for(Character c : hashMap.keySet())
                if(s.charAt(i) == c)
                    exists = true;

            if(!exists)
                hashMap.put(s.charAt(i), 1);
            else
                hashMap.put(s.charAt(i), hashMap.get(s.charAt(i)) + 1);
        }

        for(Character c : hashMap.keySet())
            System.out.println(c + ": " + hashMap.get(c)) ;
    }
}