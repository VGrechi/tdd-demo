package com.grechi.tdddemo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SaleRequestDTO {

    private Long customerId;
    private BigDecimal grossValue;
    private BigDecimal netValue;
    private BigDecimal discountValue;
    private Long desiredSaleNoteNumber;
}
