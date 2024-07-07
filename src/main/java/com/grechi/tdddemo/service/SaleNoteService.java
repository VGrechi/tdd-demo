package com.grechi.tdddemo.service;

import com.grechi.tdddemo.exception.InvalidNumberException;
import com.grechi.tdddemo.models.SaleNote;
import com.grechi.tdddemo.repository.SaleNoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.security.InvalidAlgorithmParameterException;
import java.util.Objects;
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

    public SaleNote createSaleNote(Long saleId, Long desiredNumber) {
        SaleNote saleNote = SaleNote.builder()
                .saleId(saleId)
                .build();

        Long nextNumber = getNextNumber(desiredNumber);
        saleNote.setNumber(nextNumber);

        byte[] pdf = fileService.generatePDF(saleNote);

        uploadService.uploadFile(saleNote, pdf);

        saleNoteRepository.save(saleNote);

        return saleNote;
    }

    private Long getNextNumber(Long desiredNumber) {
        long nextNumber = 1L;
        Optional<SaleNote> opLastSaleNote = saleNoteRepository.getLastSaleNote();

        if(opLastSaleNote.isPresent()){
            nextNumber = opLastSaleNote.get().getNumber() + 1L;
        }

        if(Objects.nonNull(desiredNumber)){
            if(desiredNumber < nextNumber){
                throw new InvalidNumberException("invalid.number.for.sale.note");
            }else {
                nextNumber = desiredNumber;
            }
        }

        return nextNumber;
    }
}
