package iuh.fit.factorymethod.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import iuh.fit.factorymethod.factory.DocumentFactory;

@Service
public class DocumentService {
    private final List<DocumentFactory> factories;

    @Autowired
    public DocumentService(List<DocumentFactory> factories) {
        this.factories = factories;
    }

    public String generateDocument(String type, String title, String content) {
        for (DocumentFactory factory : factories) {
            if (factory.supports().equals(type)) {
                return factory.createGenerator().generate(title, content);
            }
        }
        throw new IllegalArgumentException("Unsupported document type: " + type);
    }
}
