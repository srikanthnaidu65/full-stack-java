package com.srikanth.fullstackjava.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.srikanth.fullstackjava.model.CD;
import com.srikanth.fullstackjava.repository.CDRepository;

@Service
public class CDService {

	@Autowired
	private CDRepository repository;

	public CDRepository getRepository() {
		return repository;
	}

	public void setRepository(CDRepository repository) {
		this.repository = repository;
	}

	public Optional<CD> getCDById(Long cdId) {
		return repository.findById(cdId);
	}

	public List<CD> getAllCDs() {
		return repository.findAll();
	}

	public List<CD> getCDByTitle(String cdTitle) {
		return repository.findByCdTitle(cdTitle);
	}

	public List<CD> getCDByPublisher(String cdPublisher) {
		return repository.findByCdPublisher(cdPublisher);
	}

	public CD insertCD(Long cdId, String cdTitle, Double cdPrice, String cdPublisher) {
		CD cd = new CD(cdId, cdTitle, cdPrice, cdPublisher);
		return repository.save(cd);
	}

	public int updateCD(Long cdId, String cdTitle, Double cdPrice, String cdPublisher) {
		return repository.updateCD(cdId, cdTitle, cdPrice, cdPublisher);
	}

	public void deleteCD(Long cdId) {
		repository.deleteById(cdId);
	}



}
