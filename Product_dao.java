package com.hibernate.PMS.ProdMmtSys.dao;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.PMS.ProdMmtSys.modal.Product;
public class Product_dao extends Thread 
{
	
	private static final Session Product_util = null;
	Scanner sc =new Scanner(System.in);

	public void save_Product(Product product) 
	{
		Transaction transaction = null;
		try(Session session = Product_util.getSessionFactory().openSession())
		{
			transaction=session.beginTransaction();
			session.save(product);
			transaction.commit();
		}
		catch (Exception e) 
		{
			if(transaction!=null)
			{
				 transaction.rollback();
			}
		}
	}
	
	public void Delete_Product(long id) 
	{
		Transaction transaction = null;
		try(Session session = Product_util.getSessionFactory().openSession())
		{
			transaction=session.beginTransaction();
			Product product= session.get(Product.class, id);
			session.delete(product);
			transaction.commit();
			System.out.println("Product ID=" + id + "is successfully deleted!!...");
		}
		catch (Exception e) 
		{
			if(transaction!=null)
			{
				 transaction.rollback();
			}
		}
	}
	
	
	public void Update_Product() 
	{
		long n;
		Transaction transaction = null;
		try(Session session = Product_util.getSessionFactory().openSession())
		{
			transaction=session.beginTransaction();
			
			System.out.print("\nEnter Product ID to Update: ");
			n=sc.nextInt();
			
			// Retrieve the entity from the database
			Product product=session.get(Product.class, n);
			
			if(product!=null)
			{	
			int choice;
			System.out.println("___________________________________________________________________________");
			System.out.print("Enter How many rows you want to update: ");
			n=sc.nextLong();
		
			for(int i=1;i<=n;i++) 
			{	System.out.println("___________________________________________________________________________");
				System.out.println("\n1.Name\n2.Brand\n3.Category\n4.Price\n5.Quantity");
				System.out.print("\nEnter Column no: ");
				choice=sc.nextInt();
				
				switch( choice) 
				{
				 
				case 1: 
						System.out.print("\nEnter new Name: ");
						product.setP_name(sc.next());
						break;
						
				case 2:
						System.out.print("\nEnter new Brand Name: ");
						product.setP_brand(sc.next());
						break;
				
				case 3:
						System.out.print("\nEnter new Category: ");
						product.setP_category(sc.next());
						break;
				
				
				case 4:
						System.out.print("\nEnter new Price: : ");
						product.setP_price(sc.nextLong());
						break;
				
				
				case 5:
						System.out.print("\nEnter new Name: ");
						product.setP_quantity(sc.nextLong());
						break;
				
				default :
						System.out.print("Invalid input!!!!.... ");
						break;
				}
			}
			
			// Save the updated entity back to the database
			session.update(product);
			transaction.commit();
			System.out.print("\nData Updated successfully!!!!...");
			
			}
			else {
			System.out.println("Entered ID is Invalid!!!!.."+ n);
			}
		}
		
		catch (Exception e) 
		{
			if(transaction!=null)
			{
				 transaction.rollback();
			}
		}
	}
	
	
	public void get_DataByID(long id) 
	{	
		Transaction transaction = null;
		try (Session session = Product_util.getSessionFactory().openSession())
		{
			transaction = session.beginTransaction();
			Product product = session.get(Product.class, id);
			
			if(product !=null) 
			{
				System.out.print("___________________________________________________________________________");
				
				System.out.print("\n\nName:- "+product.getP_price()
				+"\nBrand:- "+product.getP_brand()+"\nCategory:- "+product.getP_category()
				+"\nPrice:-"+product.getP_price()+"\nQuantity-"+product.getP_quantity());	
				System.out.print("\n___________________________________________________________________________");
			}
			else 
			{
				System.out.println("\n Data not Found....");
				
			}
		
			transaction.commit();
		}
		catch (Exception e) 
		{
			System.out.println("\nError occurred while fetching data: " + e.getMessage());
			if (transaction != null)
			{
				transaction.rollback();
			}

		}
	
	}
}


