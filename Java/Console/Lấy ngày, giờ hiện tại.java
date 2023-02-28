/* Tham khao them cac API moi tai (xem o cuoi page): https://nguyenvanhieu.vn/ngay-gio-trong-java/ */
import java.time.* ;

public class TimeTest 
{
	public static void main(String[] args) 
	{
		// NGAY TRONG JAVA PHAI THEO FORMAT: YYYY-MM-DD
		// lay ngay hien tai 
		System.out.println("--- TEST DATE ---") ;
		LocalDate dateToDay = LocalDate.now();
        System.out.println("Today is: " + dateToDay);
        
        // cai ngay san
        LocalDate newYear = LocalDate.of(2022, 1, 1);
        System.out.println("New year is: " + newYear);
        
        LocalDate birthDay = LocalDate.of(2022, Month.AUGUST, 7);
        System.out.println("Birth day is: " + birthDay);
    
		// GIO TRONG JAVA PHAI THEO FORMAT: HH:MM:SS
        // lay gio hien tai
		System.out.println("--- TEST TIME ---") ;
        LocalTime timeNow = LocalTime.now();
        System.out.println("It's: " + timeNow);
        
        // cai gio san
        LocalTime setTime1 = LocalTime.of(10, 49);
        System.out.println("Set time 1: " + setTime1);
        
        LocalTime setTime2 = LocalTime.of(10, 49, 50);
        System.out.println("Set time 2: " + setTime2);
        
        // NGAY VA GIO TRONG JAVA PHAI THEO FORMAT: YYYY-MM-DDTHH:MM:SS
        // lay ngay va gio hien tai
		System.out.println("--- TEST DATE AND TIME ---") ;
        LocalDateTime dateAndTimeNow = LocalDateTime.now();
        System.out.println("It's: " + dateAndTimeNow);
        
        // cai ngay san
        LocalDateTime happyNewYear = LocalDateTime.of(LocalDate.of(2021, 12, 31), LocalTime.of(11, 59));
        System.out.println("Happy new year: " + happyNewYear);
	}

}
