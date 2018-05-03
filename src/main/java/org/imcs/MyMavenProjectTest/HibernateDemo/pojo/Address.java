package org.imcs.MyMavenProjectTest.HibernateDemo.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import lombok.Data;

@Data
@Entity
@Table(name = "Address")
public class Address {

	@Id
	@Column(name = "customer_id")
	@GenericGenerator(name = "gen", strategy = "foreign", parameters = 
	@Parameter(name = "property", value = "customer"))
	private long id;

	@Column(name = "city")
	private String city;
	@Column(name = "state")
	private String state;
	@Column(name = "aptNo")
	private String aptNo;
	@Column(name = "country")
	private String country;

	@OneToOne
	@PrimaryKeyJoinColumn
	private Customer customer;

	public Address(String city, String state, String aptNo, String country) {
		this.city = city;
		this.state = state;
		this.aptNo = aptNo;
	}

}
