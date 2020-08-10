package com.ssa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ssa.exception_handling.NOSSA_IDFOUND;
import com.ssa.model.SSA_Enrolement;
import com.ssa.service.SSA_service;



@RestController
public class SSA_RegistartionController {
	
	@Autowired
	private SSA_service ssa_service;
	
	@PostMapping(value = "/register")
	public ResponseEntity<SSA_Enrolement> registerContacts(@RequestBody SSA_Enrolement ssa) 
	{
	 
		String ssa_id = ssa_service.save(ssa);
		ssa.setSsa_id(ssa_id);

		ResponseEntity r1 = new ResponseEntity(ssa, HttpStatus.CREATED);

		return r1;
}

	
	@GetMapping(value = "/check_ssaid/{ssaid}")
	public ResponseEntity<SSA_Enrolement> checking_ssaid(@PathVariable("ssaid") String id) 
	{
	 
		boolean b=ssa_service.findById(id);
		
		if (b)
		{
			String str="Given ssa_id "+id+"  is avaliable ";
			
			ResponseEntity r1 = new ResponseEntity(str, HttpStatus.OK);
			
			return r1;
		}
		
		else
		{
			 throw new NOSSA_IDFOUND();
			
		}
}
	
}