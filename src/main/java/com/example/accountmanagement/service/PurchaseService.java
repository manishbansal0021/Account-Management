package com.example.accountmanagement.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.accountmanagement.model.PurchaseSection;
import com.example.accountmanagement.repository.PurchaseRepository;


@Service
public class PurchaseService {

	@Autowired
	private PurchaseRepository purchaseRepository;

	public List<PurchaseSection> getPurchase() {
		
		return (List<PurchaseSection>) purchaseRepository.findAll();
	}

	public void addPurchase(PurchaseSection purchaseSection) {
	
		purchaseRepository.save(purchaseSection);
	}
	public PurchaseSection findTile(PurchaseSection purchaseSection) {
		return purchaseRepository.findOne(purchaseSection.getId());
			
	}
	
}
