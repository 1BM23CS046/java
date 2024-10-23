import java.util.Scanner;

class Book {
    private String name;
    private String author;
    private double price;
    private int num_pages;

   
    public Book(String name, String author, double price, int num_pages) {
        this.name = name;
        this.author = author;
        this.price = price;
        this.num_pages = num_pages;
    }

    
    public String toString() {
        return "Book Name: " + name + "\nAuthor: " + author + "\nPrice: $" + price + "\nPages: " + num_pages;
    }
}

public class Main {
    public static void main(String[] args) {
        
        Book book1 = new Book("Java Basics", "John Doe", 29.99, 350);
        Book book2 = new Book("Advanced Java", "Jane Smith", 39.99, 500);

        System.out.println(book1);
        System.out.println();
        System.out.println(book2);
    }
}
