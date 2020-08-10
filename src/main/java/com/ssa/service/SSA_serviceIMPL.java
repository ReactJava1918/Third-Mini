package com.ssa.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssa.model.SSA_Enrolement;
import com.ssa.repo.SSA_Repo;

@Service
public class SSA_serviceIMPL implements SSA_service {
	
	@Autowired
	private SSA_Repo ssrepo;
	
	
	@Override
	public String save(SSA_Enrolement details) {
		 
		SSA_Enrolement resp=ssrepo.save(details);
		
		if(resp.getSsa_id()!=null)
		{
			return resp.getSsa_id();
		}
		 
		else
		{
			return null;
		}
	}


	@Override
	public boolean findById(String id) {
		Optional<SSA_Enrolement> findById = ssrepo.findById(id);

		boolean b = findById.isPresent();

		return b;
	}
	
	

}
