package iuh.fit.factorymethod.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import iuh.fit.factorymethod.service.DocumentService;

@RestController
public class DocumentController {
    private final DocumentService documentService;

    @Autowired
    public DocumentController(DocumentService documentService) {
        this.documentService = documentService;
    }

    @PostMapping("/generate")
    public ResponseEntity<String> generateDocument(
            @RequestParam String type,
            @RequestParam String title,
            @RequestParam String content) {
        return ResponseEntity.ok(documentService.generateDocument(type, title, content));
    }
}
