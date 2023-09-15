import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class appConfig {
	@Bean
	@Scope("singleton") // default if not specify
	public TextWriter plainTextWriter() {
		return new PlainTextWriter();
	}
	
	@Bean
	public TextWriter pdfTextWriter() {
		return new PdfTextWriter();
	}
	
	@Bean
	public TextEditor textEditor() {
		return new TextEditor();
	}
}
