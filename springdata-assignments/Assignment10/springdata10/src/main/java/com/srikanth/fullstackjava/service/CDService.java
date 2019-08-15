package com.srikanth.fullstackjava.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.core.types.dsl.NumberExpression;
import com.querydsl.core.types.dsl.StringExpression;
import com.srikanth.fullstackjava.model.CD;
import com.srikanth.fullstackjava.model.QCD;
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

	@Transactional(rollbackFor = Exception.class)
	public CD saveCD(CD cd){
		CD savedCD = repository.save(cd);
		return savedCD;
	}

	@Transactional(readOnly = true)
	public List<CD> getAllCDs() {
		return repository.findAll();
	}

	@Transactional(readOnly = true)
	public List<CD> getCDsByPublisher(String publisher) {
		List<CD> cdList = new ArrayList<CD>();
		QCD qcd = QCD.cD;
		StringExpression se = qcd.cdPublisher;
		BooleanExpression be = se.equalsIgnoreCase(publisher);
		Iterable<CD> cds = repository.findAll(be);
		cds.forEach(cdList::add);
		return cdList;
	}
}
