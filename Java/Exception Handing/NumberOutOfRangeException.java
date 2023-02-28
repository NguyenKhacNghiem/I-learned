public class NumberOutOfRangeException extends ArithmeticException    // Do Exception nay khong co san trong Java                                                                       
{                                                                     // Nen nguoi dung phai tu dinh nghia                                                               
    public NumberOutOfRangeException(String message)                  // Tu tao 1 class exception phu hop voi loi 
    {                                                                 // Class nay phai ke thua 1 trong nhung unchecked exception
        super(message) ;                                              // (coi tren google) ma o day la ArithmeticException
    }                                                      
}    