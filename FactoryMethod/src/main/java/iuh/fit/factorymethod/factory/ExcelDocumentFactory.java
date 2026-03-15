package iuh.fit.factorymethod.factory;

import org.springframework.stereotype.Component;
import iuh.fit.factorymethod.document.DocumentGenerator;
import iuh.fit.factorymethod.document.ExcelDocumentGenerator;

@Component
public class ExcelDocumentFactory extends DocumentFactory {
    @Override
    public DocumentGenerator createGenerator() {
        return new ExcelDocumentGenerator();
    }

    @Override
    public String supports() {
        return "EXCEL";
    }
}
