public class BookRepository {
    public void saveToDatabase(Book book) {
        System.out.println("Saving book: " + book.getBookSummary());
    }
}
