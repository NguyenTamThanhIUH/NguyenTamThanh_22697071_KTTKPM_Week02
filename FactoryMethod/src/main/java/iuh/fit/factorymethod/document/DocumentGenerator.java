package iuh.fit.factorymethod.document;

public interface DocumentGenerator {
    String generate(String title, String content);
    String getType();
}
