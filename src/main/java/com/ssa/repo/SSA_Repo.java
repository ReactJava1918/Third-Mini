package com.ssa.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ssa.model.SSA_Enrolement;


public interface SSA_Repo extends JpaRepository<SSA_Enrolement,String> {
	 

}
