

public class PdfDocument implements Document {
    @Override
    public void open() {
        System.out.println("PDF file is now open in viewer mode.");
    }

    @Override
    public void save() {
        System.out.println("PDF file exported and saved successfully.");
    }

    @Override
    public void close() {
        System.out.println("PDF file viewer has been closed.");
    }
}
