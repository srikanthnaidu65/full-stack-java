package com.srikanth.fullstackjava.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

	@Transactional(readOnly = true, timeout = 50)
	public Optional<CD> getCDById(Long cdId) {
		return repository.findById(cdId);
	}

	@Transactional(readOnly = true)
	public List<CD> getAllCDs() {
		return repository.findAll();
	}

	@Transactional(readOnly = true, timeout = 50)
	public List<CD> getCDByTitle(String cdTitle) {
		return repository.findByCdTitle(cdTitle);
	}

	@Transactional(readOnly = true, timeout = 50)
	public List<CD> getCDByPublisher(String cdPublisher) {
		return repository.findByCdPublisher(cdPublisher);
	}

	@Transactional(rollbackFor = Exception.class)
	public CD insertCD(Long cdId, String cdTitle, Double cdPrice, String cdPublisher) {
		CD cd = new CD(cdId, cdTitle, cdPrice, cdPublisher);
		return repository.save(cd);
	}

	@Transactional(rollbackFor = Exception.class)
	public int updateCD(Long cdId, String cdTitle, Double cdPrice, String cdPublisher) {
		return repository.updateCD(cdId, cdTitle, cdPrice, cdPublisher);
	}

	@Modifying
	public void deleteCD(Long cdId) {
		repository.deleteById(cdId);
	}

	@Transactional
	public List<CD> findByPriceRange(Double startPrice, Double endPrice) {
		return repository.findByPriceRange(startPrice, endPrice);
	}

	@Transactional
	public List<CD> findByPriceRangeNamedParams(Double startPrice, Double endPrice) {
		return repository.findByPriceRangeNamedParams(startPrice, endPrice);
	}

	@Transactional
	public List<CD> findByTitleMatch(String title) {
		return repository.findByTitleMatch(title);
	}

	@Transactional
	public List<CD> findByTitleMatchNative(String title) {
		return repository.findByTitleMatchNative(title);
	}

	@Transactional
	public List<CD> findAllSorted() {
		return repository.findAllSorted();
	}

}
