package iuh.fit.factorymethod.factory;

import org.springframework.stereotype.Component;
import iuh.fit.factorymethod.document.DocumentGenerator;
import iuh.fit.factorymethod.document.PDFDocumentGenerator;

@Component
public class PDFDocumentFactory extends DocumentFactory {
    @Override
    public DocumentGenerator createGenerator() {
        return new PDFDocumentGenerator();
    }

    @Override
    public String supports() {
        return "PDF";
    }
}
