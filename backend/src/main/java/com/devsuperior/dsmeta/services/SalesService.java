package com.devsuperior.dsmeta.services;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.devsuperior.dsmeta.entities.Sales;
import com.devsuperior.dsmeta.repositories.SaleRepository;

@Service
public class SalesService {

	@Autowired
	private SaleRepository repository;

	public Page<Sales> findSales(String minDate, String maxDate,Pageable pageable) {
		LocalDate min = LocalDate.parse(minDate);
		LocalDate max = LocalDate.parse(maxDate);
		
		return repository.findSales(min,max,pageable);
	}
}
