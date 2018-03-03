package com.example.accountmanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.accountmanagement.model.PartyDetails;
import com.example.accountmanagement.repository.PartyDetailRepository;

@Service
public class PartyDetailService {

	@Autowired
	PartyDetailRepository partyDetailRepository;

	public void addparty(PartyDetails partydetail) {
		partyDetailRepository.save(partydetail);
		
	}

	public List<PartyDetails> getparty() {
		return (List<PartyDetails>) partyDetailRepository.findAll();
	}
}
