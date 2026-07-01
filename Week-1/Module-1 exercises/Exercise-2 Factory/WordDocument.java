

public class WordDocument implements Document {
    @Override
    public void open() {
        System.out.println("Word file is now open for editing.");
    }

    @Override
    public void save() {
        System.out.println("Word file saved to disk as .docx format.");
    }

    @Override
    public void close() {
        System.out.println("Word file has been closed.");
    }
}
