package org.imcs.MyMavenProjectTest.HibernateDemo.pojo;

import lombok.Data;

@Data
public class Item {
	
	protected int lineNumber;
	protected double buyprice;
	protected double MSRP;
	protected String Description;
	protected int quantityInStock;

}
