package com.ssa.service;

import com.ssa.model.SSA_Enrolement;


public interface SSA_service {
	
	public String save(SSA_Enrolement details);
	public boolean findById(String id);
}
