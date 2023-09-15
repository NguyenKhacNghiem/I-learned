import java.net.URL;
import java.io.File;
import org.apache.commons.io.FileUtils;
import org.apache.commons.validator.routines.UrlValidator;

public class Main 
{
    public static void main(String[] args)
    {
        // Check the url whether it is valid
        String[] arr = new String[] {"http", "https"};
        UrlValidator validator = new UrlValidator(arr, UrlValidator.ALLOW_ALL_SCHEMES);

        if(args.length == 0) 
            System.out.println("Please specify an URL to a file") ;
        else if(validator.isValid(args[0]) == false) // ham isValid() duoc xay dung san trong thu vien
            System.out.println("This is not a valid URL") ;
        // Download file from a valid url
        else
        {
            try {
                FileUtils.copyURLToFile(new URL(args[0]), new File("downloadedFile.html"));
                System.out.println("File downloaded successfully!");
            }catch(Exception e) {
                System.out.println("Error downloading file: " + e.getMessage());
            }
        }
    }
}
