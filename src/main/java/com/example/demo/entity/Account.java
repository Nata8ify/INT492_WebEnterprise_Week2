package com.example.demo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.validator.constraints.NotEmpty;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Data
public class Account {
	@NotEmpty
	private String name;
	
	@Id
	@GeneratedValue
	private int id;
	
	

	@Override
	public String toString() {
		return "Account [name=" + name + ", id=" + id + "]";
	}
	
	
}
