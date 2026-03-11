public class Book extends LibraryItem {
    private int numberOfPages;
    private String isbn;
    private String genre;
    public Book(String title, String author, int year, int numberOfPages, String isbn, String genre) {
        super(title, author, year);
        this.numberOfPages = numberOfPages;
        this.isbn = isbn;
        this.genre = genre;
    }
    public Book(String title, String author, int year, int numberOfPages) {
        super(title, author, year);
        this.numberOfPages = numberOfPages;
        this.isbn = "N/A";
        this.genre = "Unknown";
    }
    @Override
    public String getItemType() {
        return "Book";
    }
    public int getNumberOfPages() { return numberOfPages; }
    public void setNumberOfPages(int numberOfPages) { this.numberOfPages = numberOfPages; }
    public String getIsbn() { return isbn; }
    public void setIsbn(String isbn) { this.isbn = isbn; }
    public String getGenre() { return genre; }
    public void setGenre(String genre) { this.genre = genre; }
    public String getSummaryInfo() {
        return String.format("Genre: %s | Pages: %d | ISBN: %s", genre, numberOfPages, isbn);
    }
    @Override
    public String toString() {
        return super.toString() + " | " + getSummaryInfo();
    }
}
