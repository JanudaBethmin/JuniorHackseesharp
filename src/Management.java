
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

    public class Management {
        private Map<Integer, Book> books;
        private List<Integer> availableBooks;
        private List<Integer> lendingBooks;

        public Management(){
            this.books= new HashMap<>();
            this.availableBooks=new ArrayList<>();
            this.lendingBooks=new ArrayList<>();
        }

        public Map<Integer, Book> getBooks() {
            return books;
        }

        public List<Integer> getAvailableBooks() {
            return availableBooks;
        }

        public List<Integer> getLendingBooks() {
            return lendingBooks;
        }

        public void addBook(Book book) {
            books.put(book.getISBN(), book);
            availableBooks.add(book.getISBN());
        }

        public void updateBook(Book book) {
            books.put(book.getISBN(), book);
        }

        public void removeBook(Book book) {
            books.remove(book);
            availableBooks.remove(book);
        }

        public void lendingBook(Book book) {
            availableBooks.remove(book);
            lendingBooks.add(book.getISBN());
        }
        public void returnBook(Book book) {
            availableBooks.add(book.getISBN());
            lendingBooks.remove(book);
        }

        public Book getBookIsbn(int isbn) {
            return books.get(isbn);
        }

        public void viewAvailableBook() {
            System.out.println(availableBooks);
        }



    }

