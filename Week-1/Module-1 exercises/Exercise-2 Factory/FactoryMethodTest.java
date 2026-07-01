







public class FactoryMethodTest {
    public static void main(String[] args) {
        DocumentFactory[] factories = {
            new WordDocumentFactory(),
            new PdfDocumentFactory(),
            new ExcelDocumentFactory()
        };

        for (DocumentFactory factory : factories) {
            System.out.println("--- " + factory.getClass().getSimpleName() + " ---");
            Document doc = factory.createDocument();
            doc.open();
            doc.save();
            doc.close();
            System.out.println();
        }
    }
}
