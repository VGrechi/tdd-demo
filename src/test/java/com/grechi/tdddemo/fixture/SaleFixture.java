package com.grechi.tdddemo.fixture;

import com.grechi.tdddemo.dto.SaleRequestDTO;

import java.math.BigDecimal;

public class SaleFixture {

    public static SaleRequestDTO getSaleRequestDTO() {
        return SaleRequestDTO.builder()
                .customerId(1L)
                .grossValue(BigDecimal.valueOf(200))
                .netValue(BigDecimal.valueOf(180))
                .discountValue(BigDecimal.valueOf(20))
                .desiredSaleNoteNumber(1L)
                .build();
    }

}
