package com.example.accountmanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.accountmanagement.model.PurchaseSection;
import com.example.accountmanagement.model.SaleSection;
import com.example.accountmanagement.model.Stock;
import com.example.accountmanagement.repository.StockRepository;

@Service
public class StockService {

	@Autowired
	private StockRepository stockRepository;
	
	public List<Stock> getAllStock() {
		return (List<Stock>) stockRepository.findAll();
	}

	public void saveTile(Stock stk) {
		stockRepository.save(stk);
	}

	public boolean findtile(Stock stk) {
		if(stockRepository.exists(stk.getTilename()))
			return true;
		else 
			return false;
	}

	public Stock find(PurchaseSection purchaseSection) {
		return stockRepository.findOne(purchaseSection.getTilename());
	}

	public boolean decreaseStock(SaleSection salesSection) {
		Stock stk=stockRepository.findOne(salesSection.getTilename());
		if(stk!=null) {
			int stock=stk.getAvailablestock()-salesSection.getQuantity();
			if(stock>=0) {
				stk.setAvailablestock(stock);
				return true;
			}
		}
		return false;
	}
}
