package com.grechi.tdddemo.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SaleNote {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "SALE_ID")
    private Long saleId;

    @Column(name = "NUMBER")
    private Long number;

    @Column(name = "FILE_ID")
    private String fileId;

    @Column(name = "FOLDER")
    private String folder;

    @Column(name = "STATUS")
    private DocumentStatus status;

}
