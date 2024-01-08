package org.mars.springjdbc.dao;

import java.util.List;

import javax.sql.DataSource;

import org.mars.springjdbc.model.Product;
import org.mars.springjdbc.model.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component   //regonized as bean
public class ProductDAOImpl implements ProductDAO{
	
	JdbcTemplate jdbcTemp;
	private final String SQL_CREATE_PRODUCT ="insert into product values(?,?,?,?,?,?)";
	private final String SQL_DELETE_PRODUCT="delete from product where product_Id=?";
	private final String SQL_UPDATE_PRODUCT=" update product set product_name=?,product_description=?,product_category=?,price=? ,quantity=? where product_id=?";
	private final String SQL_RETRIEVE_PRODUCT="select * from product";
	private final String  SQL_RETRIEVE_PRODUCTWITHID="  where product_Id=?";
	private final String SQL_ONLY_ID=SQL_RETRIEVE_PRODUCT+SQL_RETRIEVE_PRODUCTWITHID;
	 private final int[]  intValue = {4};
	@Autowired
	public ProductDAOImpl( DataSource ds) {
		jdbcTemp = new JdbcTemplate(ds);
		
	}
	
	public Product getProductById(int PRODUCT_ID) {
		// TODO Auto-generated method stub
		 return jdbcTemp.query( SQL_ONLY_ID, new Object[] {PRODUCT_ID }, intValue, new ProductMapper()).get(0);
	}
	public List<Product> getAllProducts() {
		return jdbcTemp.query(SQL_RETRIEVE_PRODUCT,  new ProductMapper());
	}
		public boolean deleteProduct(Product pro) {
		return jdbcTemp.update(SQL_DELETE_PRODUCT,pro.getProdId())>0;
	}

	public boolean updateProduct(Product pro) {
		return jdbcTemp.update(SQL_UPDATE_PRODUCT,pro.getProdName(),pro.getProdDesc(),pro.getProdCategory(),pro.getPrice(),pro.getQuantity(),pro.getProdId())>0;
	}

	public boolean createProduct(Product pro) {
		return jdbcTemp.update(SQL_CREATE_PRODUCT,pro.getProdId(),pro.getProdName(),pro.getProdDesc(),pro.getProdCategory(),pro.getPrice(),pro.getQuantity())>0;
	}
	
	

}
