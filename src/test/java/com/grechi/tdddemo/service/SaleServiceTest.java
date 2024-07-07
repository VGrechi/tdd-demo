package com.grechi.tdddemo.service;

import com.grechi.tdddemo.dto.SaleRequestDTO;
import com.grechi.tdddemo.dto.SaleResponseDTO;
import com.grechi.tdddemo.fixture.SaleFixture;
import com.grechi.tdddemo.models.Sale;
import com.grechi.tdddemo.models.SaleNote;
import com.grechi.tdddemo.repository.SaleRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class SaleServiceTest {

    @InjectMocks SaleService saleService;
    @Mock CustomerService customerService;
    @Mock PriceService priceService;
    @Mock SaleNoteService saleNoteService;
    @Mock SaleRepository saleRepository;

    @Test
    void shouldCreateSale(){
        // Given
        Sale mockSale = Sale.builder().id(1L).build();
        when(saleRepository.save(any())).thenReturn(mockSale);

        SaleNote mockSaleNote = SaleNote.builder().build();
        when(saleNoteService.createSaleNote(anyLong())).thenReturn(mockSaleNote);

        // When
        SaleRequestDTO dto = SaleFixture.getSaleRequestDTO();
        SaleResponseDTO response = saleService.createSale(dto);

        // Then
        assertNotNull(response);
    }


}
