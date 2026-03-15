package iuh.fit.factorymethod.document;

public class WordDocumentGenerator implements DocumentGenerator {
    @Override
    public String generate(String title, String content) {
        return "Word Document: Title='" + title + "', Content='" + content + "' (Formatted as .docx with editable styles)";
    }

    @Override
    public String getType() {
        return "WORD";
    }
}
