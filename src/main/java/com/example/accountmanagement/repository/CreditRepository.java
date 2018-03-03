package com.example.accountmanagement.repository;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import com.example.accountmanagement.model.CreditDetail;

public interface CreditRepository extends CrudRepository<CreditDetail,Integer>{

	List<CreditDetail> findByPname(String pname);
}