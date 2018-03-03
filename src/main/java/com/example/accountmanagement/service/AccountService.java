package com.example.accountmanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.accountmanagement.model.AccountName;
import com.example.accountmanagement.repository.AccountRepository;


@Service
public class AccountService {
	
	@Autowired
	AccountRepository accountRepository;

	public List<AccountName> getAccounts() {
		return (List<AccountName>) accountRepository.findAll();
	}

	public List<AccountName> accountdetail(String aname) {
		return accountRepository.findByName(aname);
	}

	public void addAccountDetail(AccountName accountName) {
		accountRepository.save(accountName);
		
	}

}
