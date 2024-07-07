package com.grechi.tdddemo.service;

import com.grechi.tdddemo.models.SaleNote;
import com.grechi.tdddemo.repository.SaleNoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

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

        Long nextNumber = getNextNumber();
        saleNote.setNumber(nextNumber);

        byte[] pdf = fileService.generatePDF(saleNote);

        uploadService.uploadFile(saleNote, pdf);

        saleNoteRepository.save(saleNote);

        return saleNote;
    }

    private Long getNextNumber() {
        long nextNumber = 1L;
        Optional<SaleNote> opLastSaleNote = saleNoteRepository.getLastSaleNote();

        if(opLastSaleNote.isPresent()){
            nextNumber = opLastSaleNote.get().getNumber() + 1L;
        }

        return nextNumber;
    }
}
