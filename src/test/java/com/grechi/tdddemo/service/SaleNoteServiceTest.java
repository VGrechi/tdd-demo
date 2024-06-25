package com.grechi.tdddemo.service;

import com.grechi.tdddemo.models.SaleNote;
import com.grechi.tdddemo.repository.SaleNoteRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

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

        // When
        SaleNote response = saleNoteService.createSaleNote(1L);

        // Then
        assertNotNull(response);

    }
}
