package com.grechi.tdddemo.repository;

import com.grechi.tdddemo.models.Sale;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SaleRepository extends JpaRepository<Sale, Long> {
}
