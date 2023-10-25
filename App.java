package com.hibernate.PMS.ProdMmtSys;

import java.util.Scanner;


import com.PMS.ProdMmtSys.modal.Product;
import com.hibernate.PMS.ProdMmtSys.dao.Product_dao;

public class App 
{
	static int i,n,choice,price, quantity;
	static String name,brand,category;
	static char y;
	static Scanner sc=new Scanner(System.in);
	
    public static void main( String[] args )
    {
    	do {
    		System.out.println("*********Product Management System*********");

    		System.out.print("\n1) Add Data in rows.... \n2) Delete data.... \n3) Update data.... \n4) Get data by ID....");
    		System.out.print("\n___________________________________________________________________________");
    		System.out.print("\nSelect your option:- ");
			choice =sc.nextInt();
    		
    	switch(choice) 
    	{
   
    		case 1: 
    			row_insert();
    			break;
    			
    		case 2: 
    			prod_delete();
    			break;
    			
    		case 3: 
    			prod_update();
    			break;
    			
    		case 4: 
    			 prod_getById();
    			 break;
    		
    	default: 
    		System.out.println("Enter a valid option!!!");
    		break;
    	
    	}
    	System.out.print("\n\nDo you want to do another operation ? y/n: ");
		choice=sc.next().charAt(0);
		System.out.println("___________________________________________________________________________\n");
		
    	}while(choice=='y');
    	System.out.println(
				"\n\n____________________________________ The Process ended!!!!_______________________________________\n");
    }
    
    
    public static void row_insert()
    {
    	System.out.print("\nEnter the no of row's you want to add: ");
    	n=sc.nextInt();
    
    	for(i=1;i<=n;i++)
    	{
    		System.out.println("___________________________________________________________________________");
    		System.out.print("Enter Product Name: ");
    		name=sc.next();
    		
    		System.out.print("Enter Product Brand Name: ");
    		brand=sc.next();
    		
    		System.out.print("Enter Product Category: ");
    		category=sc.next();
    		
    		System.out.print("Enter Product Price: ");
    		price=sc.nextInt();
    		
    		System.out.print("Enter Product Quantity: ");
    		quantity=sc.nextInt();
    		
    		Product_dao prodao =new Product_dao();
    		Product prod =new Product();
    		prodao.save_Product(prod);
    		
    		System.out.println("___________________________________________________________________________");
    	}	
    	System.out.println("rows added succesfully...................");
    }
    
    public static void prod_delete()
    {
    	Product_dao prodao=new Product_dao();
    	System.out.println("Enter product ID which you want to delete:- ");
		n = sc.nextInt();
    	prodao.Delete_Product(n);
    	
    }
    
    public static void prod_update()
    {
    	Product_dao prodao=new Product_dao();
    	prodao.Update_Product();
    	
    }
    
    public static void prod_getById()
    {
    	Product_dao prodao=new Product_dao();
    	System.out.print("\nEnter ID you want:- ");
		n = sc.nextInt();
		prodao.get_DataByID(n);
    }
   
}