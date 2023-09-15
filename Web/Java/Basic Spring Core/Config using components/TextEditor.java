package lab6_4;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component // Khai bao class nay la 1 Component (giong nhu 1 Bean)
public class TextEditor {
	private String text;
	
	@Autowired // Tiem phu thuoc DI
	@Qualifier("plainTextWriter")  // Do interface nay dc 2 class implements nen can chi ro se dung class nao
	private TextWriter writer; // (hieu trong bai nay la se ghi vao file plain hay pdf)
	
	public void save(String fileName) {
		writer.write(fileName, text);
	}
	
	public void input(String text) {
		this.text = text;
	}
}
