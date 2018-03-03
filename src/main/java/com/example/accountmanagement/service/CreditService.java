package com.example.accountmanagement.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.accountmanagement.model.CreditDetail;
import com.example.accountmanagement.repository.CreditRepository;

@Service
public class CreditService {

	@Autowired
	CreditRepository creditRepository;

	public void addSales(CreditDetail creditDetail) {
		creditRepository.save(creditDetail);
		
	}

	public List<CreditDetail> partydetail(String pname) {
		return creditRepository.findByPname(pname);
	}
	

}
