package org.imcs.MyMavenProjectTest.HibernateDemo.pojo;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "customer")
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "customer_id")
	private int personId;
	@Column(name = "cust_name")
	private String firstName;

	@Column(name = "cust_phone")
	private int phone;

	@OneToOne(mappedBy = "customer", cascade = CascadeType.ALL)
	private Address address;
	
	@OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
	private List<Order> order;
	
	public Customer() {
		
	}

	public Customer(String firstName, int phone) {
		this.firstName = firstName;
		this.phone = phone;
	}

}
