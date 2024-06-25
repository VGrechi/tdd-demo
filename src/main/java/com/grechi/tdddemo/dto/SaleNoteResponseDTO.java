package com.grechi.tdddemo.dto;

import com.grechi.tdddemo.models.DocumentStatus;
import com.grechi.tdddemo.models.SaleNote;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SaleNoteResponseDTO {

    private Long number;
    private String fileId;
    private String folder;
    private DocumentStatus status;

    public SaleNoteResponseDTO(SaleNote saleNote){
        this.number = saleNote.getNumber();
        this.fileId = saleNote.getFileId();
        this.folder = saleNote.getFolder();
        this.status = saleNote.getStatus();
    }
}
