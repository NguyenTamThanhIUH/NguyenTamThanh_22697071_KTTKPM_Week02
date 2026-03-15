package iuh.fit.factorymethod.factory;

import org.springframework.stereotype.Component;
import iuh.fit.factorymethod.document.DocumentGenerator;
import iuh.fit.factorymethod.document.WordDocumentGenerator;

@Component
public class WordDocumentFactory extends DocumentFactory {
    @Override
    public DocumentGenerator createGenerator() {
        return new WordDocumentGenerator();
    }

    @Override
    public String supports() {
        return "WORD";
    }
}
