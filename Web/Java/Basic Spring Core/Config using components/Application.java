package lab6_4;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@ComponentScan  // quet de tim tat ca cac @Component (dung cai nay thi luu y dat code trong package)
@Configuration
public class Application {
	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(Application.class); // file nay la file cau hinh luon (do co @Configuration)
		TextEditor textEditor = (TextEditor) context.getBean("textEditor");
		
		textEditor.input("Hello World");
		
		textEditor.save("output.txt");		
	}
}
