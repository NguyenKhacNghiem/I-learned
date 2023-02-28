import java.io.* ;
import java.util.* ;

public class Main {
    // Ham xu ly du lieu dau vao
    static ArrayList<String> handleInput() throws FileNotFoundException {
        // Khai bao du lieu
        File file = new File("input.txt");
        Scanner sc = new Scanner(file) ;
        ArrayList<String> sentences = new ArrayList<>();

        // Tach van ban dau vao thanh cac cau. Dau hieu nhan biet ket thuc 1 cau la dau ".", "!", "?"
        String input = sc.nextLine();
        String[] temp = input.split("[.!?]");

        // Xu ly cac truong hop dac biet co su xuat hien cua "Mr. Name, Mrs. Name,..."
        for(int i=0;i<temp.length;i++) 
            if(temp[i].indexOf("Mr") != -1 || temp[i].indexOf("Dr") != -1 || temp[i].indexOf("Mrs") != -1 || temp[i].indexOf("Ms") != -1) {
                temp[i] += " " + temp[i+1];
                temp[i+1] = "";
            }
        
        // Tao mot mang chua cac cau hoan chinh sau khi xu ly
        for(String s:temp)
            if(!s.equals(""))
                sentences.add(s);
        
        sc.close();
        return sentences; // tra ve mot mang chua cac cau hoan chinh
    }

    // Ham xu ly du lieu dau ra
    static void handleOutput(ArrayList<String> sentences, String key) {
        Set<Integer> appear = new HashSet<>(); // dung Set de khong luu gia tri trung lap
        int count = 0;

        for(int i=0;i<sentences.size();i++) {
            // Tu 1 cau, ta tach thanh 1 mang cac tu
            String[] words = sentences.get(i).split(" ");

            // Lap tung tu, tu nao bang voi tu muon tra thi ghi lai vi tri va cap nhat so lan xuat hien cua no
            for(String w : words)
                if(w.equalsIgnoreCase(key)) {
                    count++;
                    appear.add(i+1);
                }    
        }

        if(count == 0)
            System.out.println("KHONG ton tai") ;
        else {
            System.out.print("Tu " + key + " xuat hien " + count + " lan trong cau ") ;

            // Chuyen Set thanh ArrayList
            ArrayList<Integer> rs = new ArrayList<>();
            rs.addAll(appear);

            for(int i=0;i<rs.size();i++)
                if(i == rs.size() - 1)
                    System.out.println(rs.get(i)) ; // neu la so cuoi cung thi ta khong can in ra dau "," de ngan cach
                else
                    System.out.print(rs.get(i) + ", ") ;
        }
    }

    public static void main(String[] args) throws FileNotFoundException{
        
        Scanner sc = new Scanner(System.in) ;
        ArrayList<String> sentences = handleInput(); // goi ham handleInput()

        // Lap lien tuc
        while(true) {
            System.out.print("Nhap vao tu ban muon tra: ") ;
            String key = sc.nextLine();

            // Truong hop nguoi dung nhap vao dau "#" thi chuong trinh dung
            if(key.equals("#"))
                break;

            handleOutput(sentences, key); // goi ham handleOutput()
        }   
    }
}