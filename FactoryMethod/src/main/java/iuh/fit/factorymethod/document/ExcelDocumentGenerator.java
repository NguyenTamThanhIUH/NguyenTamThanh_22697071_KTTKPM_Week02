package iuh.fit.factorymethod.document;

public class ExcelDocumentGenerator implements DocumentGenerator {
    @Override
    public String generate(String title, String content) {
        return "Excel Document: Title='" + title + "', Content='" + content + "' (Formatted as .xlsx with cells and formulas)";
    }

    @Override
    public String getType() {
        return "EXCEL";
    }
}
