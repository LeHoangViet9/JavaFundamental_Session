package QuanLySachTrongThuVien.model;

public class Book {
    private int id;
    private String title;
    private String author;
    private int published_year;
    private double price;

    public Book() {
    }
    public Book(String title, String author, int published_year, double price) {
        this.title = title;
        this.author = author;
        this.published_year = published_year;
        this.price = price;
    }

    public Book(int id, String title, String author, int published_year, double price) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.published_year = published_year;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPublished_year() {
        return published_year;
    }

    public void setPublished_year(int published_year) {
        this.published_year = published_year;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", published_year=" + published_year +
                ", price=" + price +
                '}';
    }
}
