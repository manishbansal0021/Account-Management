package com.example.accountmanagement.repository;


import org.springframework.data.repository.CrudRepository;

import com.example.accountmanagement.model.Accounts;


public interface AccountHolderRepository extends CrudRepository<Accounts,String>{
	//List<Accounts> findByName(String aname);
}