package com.example.accountmanagement.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.accountmanagement.model.AccountName;


public interface AccountRepository extends CrudRepository<AccountName,Integer>{
	List<AccountName> findByName(String aname);
}