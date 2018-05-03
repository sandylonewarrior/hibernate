package org.imcs.MyMavenProjectTest.HibernateDemo.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "Product")
public class Product{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "product_Code")
	private int productCode;
	@Column(name = "product_Name")
	private String productName;
	@Column(name = "product_Vendor")
	private String productVendor;
	@Column(name = "Description")
	private String Description;
	@Column(name = "priceEach")
	private int priceEach;
	@ManyToOne
	@JoinColumn(name = "order_Number")
	private Order order;
	
	
	public Product(String productName, String productVendor, String Description, int priceEach) {
		this.productName = productName;
		this.productVendor = productVendor;
		this.Description = Description;
		this.priceEach = priceEach;
	}
	
	
	
	

}
