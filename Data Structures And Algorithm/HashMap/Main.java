import java.util.* ;

public class Main
{
    public static void main(String[] args) 
    {
        // Khoi tao: HashMap giong nhu Dictionary trong Python. Quan ly dua tren nguyen tac key-value
        HashMap<Integer, String> hashMap = new HashMap<>();

        // Them phan tu vao HashMap
        hashMap.put(1, "A");
        hashMap.put(2, "B");
        hashMap.put(null, "C");

        // Lay gia tri cua value dua vao key
        System.out.println(hashMap.get(1)) ; 
        System.out.println(hashMap.get(null)) ;

        // Cap nhat lai gia tri cua value
        hashMap.put(null, "D");
        System.out.println(hashMap.get(null)) ;
        
        // Xoa phan tu trong HashMap
        hashMap.remove(null);
        // hashMap.clear(); // xoa het phan tu

        // Lap cac phan tu co trong HashMap
        for(Integer i : hashMap.keySet())
            System.out.println("Key " + i + " has value " + hashMap.get(i)) ;
    }
}