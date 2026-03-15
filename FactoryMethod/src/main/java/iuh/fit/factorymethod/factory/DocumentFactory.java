package iuh.fit.factorymethod.factory;

import iuh.fit.factorymethod.document.DocumentGenerator;

public abstract class DocumentFactory {
    public abstract DocumentGenerator createGenerator();
    public abstract String supports();
}
