package com.example.accountmanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.accountmanagement.model.SaleSection;
import com.example.accountmanagement.repository.SaleRepository;

@Service
public class SaleService {

	@Autowired
	private SaleRepository saleRepository;

	public List<SaleSection> getSales() {
		return (List<SaleSection>) saleRepository.findAll();
	}

	public void addSales(SaleSection salesSection) {
		saleRepository.save(salesSection);
	}
}
