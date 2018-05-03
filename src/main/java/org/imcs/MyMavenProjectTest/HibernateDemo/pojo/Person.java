package org.imcs.MyMavenProjectTest.HibernateDemo.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "person")
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
public class Person {
	
	

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "customer_id")
	private int personId;
	@Column(name = "cust_name")
	private String firstName;
	
	@Column(name = "cust_phone")
	protected int phone;

	
	public Person(int personId, String firstName, int phone) {
		
		this.personId = personId;
		this.firstName = firstName;
		this.phone = phone;
	}
	
	/*public Person() {
		super();
	}*/
}
