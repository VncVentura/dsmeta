package com.devsuperior.dsmeta.services;

import java.time.Instant;

import java.time.LocalDate;
import java.time.ZoneId;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import com.devsuperior.dsmeta.entities.Sales;
import com.devsuperior.dsmeta.repositories.SaleRepository;

@Service
public class SalesService {

	@Autowired
	private SaleRepository repository;
	
	@GetMapping
	public Page<Sales> findSales(String minDate, String maxDate, Pageable pageable) {

		LocalDate today = LocalDate.ofInstant(Instant.now(), ZoneId.systemDefault());

		LocalDate min = minDate.equals("") ? today.minusYears(365): LocalDate.parse(minDate);
		LocalDate max = maxDate.equals("") ? today : LocalDate.parse(maxDate);

		return repository.findSales(min, max, pageable);
	}
}
