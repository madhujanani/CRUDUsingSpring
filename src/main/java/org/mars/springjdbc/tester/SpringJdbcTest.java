package org.mars.springjdbc.tester;

import java.util.List;

import org.mars.springjdbc.config.AppConfig;
import org.mars.springjdbc.dao.ProductDAO;
import org.mars.springjdbc.model.Product;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringJdbcTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext cont = new AnnotationConfigApplicationContext(AppConfig.class);
		ProductDAO proDao = cont.getBean((ProductDAO.class));
		
		//INSERT RECORD
		//=============
		
//		Product pro  = new Product(12,"ALEXA","LISTENING TO YOU ","ELECTRONICS",564,3); 
//		proDao.createProduct(pro);
//		System.out.println("Product Added Sucessfully");
//		
		//DELETE RECORD
		//==============
//		Product pro  = new Product();
//		pro.setProdId(12);
//		proDao.deleteProduct(pro);
//		System.out.println("product deleted");
		
		//UPDATE RECORD
		//==============
		Product pro  = new Product();
		pro.setProdName("Fitness Tracker");
		pro.setProdDesc("STAY HEALTHY ANF FIT");
		pro.setProdCategory("ENERGY");
		pro.setPrice(876);
		pro.setQuantity(4);
		pro.setProdId(15);
		//update everything and null for not given value
		proDao.updateProduct(pro);
		System.out.println("product updated");
		
		//RETREIVE  ALL RECORD
	   //==============
//
//		   List<Product> allProducts = proDao.getAllProducts();
//	        System.out.println("All records  retreived sucessfully");
//	        for (Product product : allProducts) {
//	        	System.out.println(product);				
//			}
	        
			// RETREIVE ONE RECORD BY ID
		    //==============================
		try {
			  Product productById = proDao.getProductById(7);
			     System.out.println("product by id  :"+ productById); 
			
		} catch (Exception e) {
			System.out.println("No such record present");
		}
	              
	    }
	}


