package com.example.accountmanagement.repository;


import org.springframework.data.repository.CrudRepository;

import com.example.accountmanagement.model.CashSection;

public interface CashDetailRepository extends CrudRepository<CashSection,Integer>{

}