package utils;
import org.hibernate.*;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import pojo.Student;

import java.util.Properties;

public class HibernateUtils {
	private static final SessionFactory FACTORY;

	static {
		Configuration conf = new Configuration();
		Properties props = new Properties();

		props.put(Environment.DRIVER, "com.mysql.jdbc.Driver"); 
		props.put(Environment.URL, "jdbc:mysql://localhost:3306/lab06");
		props.put(Environment.USER, "root"); 
		props.put(Environment.PASS, ""); 
		props.put(Environment.DIALECT, "org.hibernate.dialect.MySQL8Dialect");
		props.put(Environment.SHOW_SQL, "true");

		conf.setProperties(props);

		conf.addAnnotatedClass(Student.class);

		ServiceRegistry registry = new StandardServiceRegistryBuilder().applySettings(conf.getProperties()).build();
		FACTORY = conf.buildSessionFactory(registry);
	}

	public static SessionFactory getFactory() {
		return FACTORY;
	}
}
