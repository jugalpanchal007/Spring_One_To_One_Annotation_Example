package com.example.demo.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;




@Entity
@Table(name = "employees1")
public class Employee {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
	 
  private Long id;

  private String name;

 //@OneToOne(fetch = FetchType.LAZY)
  @OneToOne(cascade = CascadeType.ALL)
 // @OneToMany(cascade = CascadeType.ALL)
  	@JsonManagedReference
  	@JoinColumn(name = "address_id", referencedColumnName = "id")
  
  //private List<Address> address =new ArrayList<>();
  private Address address;

public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}




public Address getAddress() {
	return address;
}

public void setAddress(Address address) {
	this.address = address;
}

  
  // Getters and setters
}


