package com.example.accountmanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.accountmanagement.model.CashSection;
import com.example.accountmanagement.repository.CashDetailRepository;

@Service
public class CashDetailService {
	
	@Autowired
	CashDetailRepository cashDetailRepository;

	public void addcash(CashSection cashSection) {
		cashDetailRepository.save(cashSection);
	}

	public List<CashSection> getAllStock() {
		return (List<CashSection>) cashDetailRepository.findAll();
		
	}

}
