package com.grechi.tdddemo.repository;

import com.grechi.tdddemo.models.SaleNote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface SaleNoteRepository extends JpaRepository<SaleNote, Long> {

    @Query(nativeQuery = true,
    value = "SELECT * FROM SaleNote ORDER BY NUMBER DESC")
    Optional<SaleNote> getLastSaleNote();
}
