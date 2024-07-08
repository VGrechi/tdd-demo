package com.grechi.tdddemo.service;

import com.grechi.tdddemo.models.SaleNote;
import com.grechi.tdddemo.repository.SaleNoteRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class SaleNoteServiceTest {

    @InjectMocks SaleNoteService saleNoteService;
    @Mock FileService fileService;
    @Mock UploadService uploadService;
    @Mock SaleNoteRepository saleNoteRepository;

    @Test
    void shouldCreateSaleNote() {
        // Given
        when(fileService.generatePDF(any())).thenReturn(new byte[0]);
        SaleNote mockSaleNote = getSaleNote();
        when(saleNoteRepository.getLastSaleNote()).thenReturn(Optional.of(mockSaleNote));

        // When
        SaleNote response = saleNoteService.createSaleNote(1L);

        // Then
        assertNotNull(response);
        assertEquals(mockSaleNote.getNumber() + 1L, response.getNumber());
    }

    @Test
    void shouldCreateFirstSaleNote() {
        // Given
        when(fileService.generatePDF(any())).thenReturn(new byte[0]);
        when(saleNoteRepository.getLastSaleNote()).thenReturn(Optional.empty());

        // When
        SaleNote response = saleNoteService.createSaleNote(1L);

        // Then
        assertNotNull(response);
        assertEquals(1L, response.getNumber());
    }

    private SaleNote getSaleNote() {
        return SaleNote.builder()
                .id(1L)
                .number(1L)
                .build();
    }
}
