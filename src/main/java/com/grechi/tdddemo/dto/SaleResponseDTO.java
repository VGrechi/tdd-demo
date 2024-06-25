package com.grechi.tdddemo.dto;

import com.grechi.tdddemo.models.Sale;
import com.grechi.tdddemo.models.SaleNote;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SaleResponseDTO {

    private Long id;
    private Long customerId;
    private BigDecimal grossValue;
    private BigDecimal netValue;
    private BigDecimal discountValue;
    private Date createdAt;
    private SaleNoteResponseDTO saleNote;

    public SaleResponseDTO(Sale sale, SaleNote saleNote){
        this.id = sale.getId();
        this.customerId = sale.getCustomerId();
        this.grossValue = sale.getGrossValue();
        this.netValue = sale.getNetValue();
        this.discountValue = sale.getDiscountValue();
        this.createdAt = sale.getCreatedAt();
        this.saleNote = new SaleNoteResponseDTO(saleNote);
    }
}
