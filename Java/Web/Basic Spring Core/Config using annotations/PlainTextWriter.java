import java.io.FileWriter;
import java.io.IOException;

public class PlainTextWriter implements TextWriter {
	public void write(String fileName, String text){
		try {
			FileWriter fw = new FileWriter(fileName);
			
			fw.write("By PlainTextWriter: " + text);
			
			fw.close();
		} catch(IOException e) {
			System.out.println("Error when writing file.");
		}
	}
}
