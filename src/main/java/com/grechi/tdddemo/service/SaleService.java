package com.grechi.tdddemo.service;

import com.grechi.tdddemo.dto.SaleRequestDTO;
import com.grechi.tdddemo.dto.SaleResponseDTO;
import com.grechi.tdddemo.models.Sale;
import com.grechi.tdddemo.models.SaleNote;
import com.grechi.tdddemo.repository.SaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class SaleService {

    private final CustomerService customerService;
    private final PriceService priceService;
    private final SaleNoteService saleNoteService;
    private final SaleRepository saleRepository;

    @Autowired
    public SaleService(CustomerService customerService, PriceService priceService, SaleNoteService saleNoteService, SaleRepository saleRepository) {
        this.customerService = customerService;
        this.priceService = priceService;
        this.saleNoteService = saleNoteService;
        this.saleRepository = saleRepository;
    }

    public SaleResponseDTO createSale(SaleRequestDTO dto){
        customerService.validateCustomer(dto.getCustomerId());

        priceService.validateValues(dto);

        Sale sale = Sale.builder()
                .customerId(dto.getCustomerId())
                .grossValue(dto.getGrossValue())
                .netValue(dto.getNetValue())
                .discountValue(dto.getDiscountValue())
                .createdAt(new Date())
                .build();
        Sale savedSale = saleRepository.save(sale);

        SaleNote saleNote = saleNoteService.createSaleNote(savedSale.getId(), dto.getDesiredSaleNoteNumber());

        return new SaleResponseDTO(savedSale, saleNote);
    }
}
