package iuh.fit.factorymethod.document;

public class PDFDocumentGenerator implements DocumentGenerator {
    @Override
    public String generate(String title, String content) {
        return "PDF Document: Title='" + title + "', Content='" + content + "' (Formatted as PDF with proper font and layout)";
    }

    @Override
    public String getType() {
        return "PDF";
    }
}
