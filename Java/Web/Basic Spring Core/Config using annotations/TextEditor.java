import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class TextEditor {
	private String text;
	
	@Autowired
	@Qualifier("plainTextWriter")
	private TextWriter writer;
	
	public void save(String fileName) {
		writer.write(fileName, text);
	}
	
	public void input(String text) {
		this.text = text;
	}
}
