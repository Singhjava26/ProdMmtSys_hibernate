package com.hibernate.PMS.ProdMmtSys.util;

import java.util.Properties;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;
import com.PMS.ProdMmtSys.modal.Product;
import com.mysql.cj.xdevapi.Statement;

public class Product_util 
{
	private static SessionFactory sessionfactory;
	
	public static SessionFactory getSessionFactory()
	{
		if(sessionfactory==null)
		{
			try 
			{
				Configuration configuration=new Configuration();
				Properties settings=new Properties();
				settings.put(Environment.DRIVER,"com.mysql.cj.jdbc.Driver");
				settings.put(Environment.URL, "jdbc:mysql://localhost:3952/online_product?useSSL=false");
				settings.put(Environment.USER,"root");
				settings.put(Environment.PASS, "root");
				settings.put(Environment.DIALECT,"org.hibernate.dialect.MySQL5Dialect");
				settings.put(Environment.SHOW_SQL, "true");
				settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
				settings.put(Environment.HBM2DDL_AUTO,"update");
				
				configuration.setProperties(settings);
				configuration.addAnnotatedClass(Product.class);
				
				ServiceRegistry serviceregistery=new StandardServiceRegistryBuilder().
						applySettings(configuration.getProperties()).build();
				
				sessionfactory=configuration.buildSessionFactory(serviceregistery);
			}
			catch(Exception e)
			{
				System.out.println(e.getMessage());
			}
		}
		
	
		return sessionfactory;
		
	}

}


