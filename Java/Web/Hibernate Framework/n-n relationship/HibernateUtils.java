import org.hibernate.*;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtils 
{	
	private static final SessionFactory FACTORY;
	
	static
	{
		Configuration conf = new Configuration();
		conf.configure("hibernate.cfg.xml");
		
		conf.addAnnotatedClass(Student.class);
		conf.addAnnotatedClass(Course.class);
		conf.addAnnotatedClass(StudentCourse.class);
		
		ServiceRegistry registry = new StandardServiceRegistryBuilder().applySettings(conf.getProperties()).build();
		FACTORY = conf.buildSessionFactory(registry);
	}

	public static SessionFactory getFactory() 
	{
		return FACTORY;
	}
}
