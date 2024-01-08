package org.mars.springjdbc.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Product {// model object
  
	private int prodId;
	private String ProdName;
	private String ProdDesc;
	private String prodCategory;
	private int price;
	private int quantity;
}
