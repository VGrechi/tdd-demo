package com.grechi.tdddemo.repository;

import com.grechi.tdddemo.models.SaleNote;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SaleNoteRepository extends JpaRepository<SaleNote, Long> {
}
