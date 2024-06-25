package com.grechi.tdddemo.service;

import com.grechi.tdddemo.models.SaleNote;
import com.grechi.tdddemo.repository.SaleNoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SaleNoteService {

    private final FileService fileService;
    private final UploadService uploadService;
    private final SaleNoteRepository saleNoteRepository;

    @Autowired
    public SaleNoteService(FileService fileService, UploadService uploadService, SaleNoteRepository saleNoteRepository) {
        this.fileService = fileService;
        this.uploadService = uploadService;
        this.saleNoteRepository = saleNoteRepository;
    }

    public SaleNote createSaleNote(Long saleId){
        SaleNote saleNote = SaleNote.builder()
                .saleId(saleId)
                .build();

        byte[] pdf = fileService.generatePDF(saleNote);

        uploadService.uploadFile(saleNote, pdf);

        saleNoteRepository.save(saleNote);

        return saleNote;
    }
}
