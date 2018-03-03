package com.example.accountmanagement.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.accountmanagement.model.Accounts;
import com.example.accountmanagement.repository.AccountHolderRepository;


@Service
public class AccountHolderService {
	
	@Autowired
	AccountHolderRepository accountHolderRepository;

	public List<Accounts> getAccounts() {
		return (List<Accounts>) accountHolderRepository.findAll();
	}

	public void addAccount(Accounts accountholder) {
		
		accountHolderRepository.save(accountholder);
	}

	


}
