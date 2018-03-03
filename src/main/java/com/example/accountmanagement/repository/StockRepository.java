package com.example.accountmanagement.repository;

import org.springframework.data.repository.CrudRepository;
import com.example.accountmanagement.model.Stock;

public interface StockRepository extends CrudRepository<Stock, String>{
}