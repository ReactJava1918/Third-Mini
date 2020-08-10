package com.ssa.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

import lombok.Getter;
import lombok.Setter;


@Entity
@Setter
@Getter

public class SSA_Enrolement {
	@Id
	@GenericGenerator(name = "ssa_id", strategy = "com.ssa.custom_generator.SSA_Id_Custom_generator")
	@GeneratedValue(generator = "ssa_id")
	private String ssa_id;

	private String fname;

	private String lname;
	private String gender;
	private Date dob;
	private String statename;
	 
  
	
}