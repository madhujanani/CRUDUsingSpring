package org.mars.springjdbc.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class ProductMapper implements RowMapper<Product> {



	public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		Product pro = new Product();
		pro.setProdId(rs.getInt("PRODUCT_ID"));
		pro.setProdName(rs.getString("PRODUCT_NAME"));
		pro.setProdDesc(rs.getString("PRODUCT_DESCRIPTION"));
		pro.setProdCategory(rs.getString("PRODUCT_CATEGORY"));		
		pro.setPrice(rs.getInt("Price"));
		pro.setQuantity(rs.getInt("Quantity"));		
		return pro;
	}

}
