

public class ExcelDocument implements Document {
    @Override
    public void open() {
        System.out.println("Spreadsheet is now open with grid view active.");
    }

    @Override
    public void save() {
        System.out.println("Spreadsheet data saved in .xlsx format.");
    }

    @Override
    public void close() {
        System.out.println("Spreadsheet editor has been closed.");
    }
}
