
import java.util.Scanner;
import java.util.List;


public class Main {
    public static Scanner sc = new Scanner(System.in);
    public static Management management = new Management();
    public static void main(String[] args) {

        System.out.println("\nWelcome to the library management system UoK!\n" +
                "Please choose an option:\n" +
                "1. Add a new book\n" +
                "2. Update an existing book\n" +
                "3. Remove an existing book\n" +
                "4. Lend a book\n" +
                "5. Return a book\n" +
                "6. List all available books\n" +
                "7. Exit");

        int choiceMenu;
        do {
            choiceMenu = sc.nextInt();
            switch (choiceMenu) {
                case 1:
                    addANewBook();
                    break;
                case 2:
                    updateAnExistingBook();
                    break;
                case 3:
                    removeAnExistingBook();
                    break;
                case 4:
                    lendABook();
                    break;
                case 5:
                    returnABook();
                    break;
                case 6:
                    listAllAvailableBooks();
                    break;
                case 7:
                    System.out.println("Happy to serve you!!!");
                    break;
                default:
                    System.out.println("Invalid Selection");

            }
        } while(choiceMenu!=7);
    }

    public static void addANewBook() {

        Book book = new Book();
        System.out.println("\nAdd a new book\n" +
                "Enter the ISBN:");
        book.setISBN(sc.nextInt());
        System.out.println("Enter the Title:" );
        book.setTitle(sc.nextLine());
        book.setTitle(sc.nextLine());
        System.out.println("Enter the Category:");
        book.setCategory(sc.nextLine());
        System.out.println("Enter the Author:");
        book.setAuthor(sc.nextLine());

        management.addBook(book);

        System.out.println("Successfully added a book.");
        main(null);

    }

    public static void updateAnExistingBook() {
        System.out.println("\nUpdate an existing bOOK\n" +
                "Enter the ISBN that need to update:\n");
        int isbn=sc.nextInt();
        //Book aBook = Management.getBooks().get(isbn);
        Book book = management.getBookIsbn(isbn);
        System.out.println("Update the book:\n" +
                "Enter the new Title (A Song of Ice and Fire):\n");
        book.setTitle(sc.nextLine());
        book.setTitle(sc.nextLine());
        System.out.println("Enter the new Category (Fantasy):\n");
        book.setCategory(sc.nextLine());
        System.out.println("Enter the new Author (George R. R. Martin):\n");
        book.setAuthor(sc.nextLine());

        management.addBook(book);

        System.out.println("Successfully updated a book.");
        main(null);
    }

    public static void removeAnExistingBook() {
        System.out.println("\nRemove an existing book\n" +
                "Enter the ISBN:\n");
        int isbn=sc.nextInt();
        Book book = management.getBookIsbn(isbn);

        String choice;
        do{
            System.out.println("Are you sure you want to remove this book? (Y/N)\n");
            String c= sc.next();
            choice = c.toUpperCase();

            switch (choice){
                case "Y":;break;
                case "N":;main(null);break;
                default:
                    System.out.println("Invalid choice");break;
            }
        }while (choice.compareTo("Y") != 0 && choice.compareTo("N") != 0);

        management.removeBook(book);

        System.out.println("Successfully removed a book.");
        main(null);

    }

    public static void lendABook() {
        System.out.println("\nLending a book\n" +
                "Enter the ISBN:\n");
        int isbn = sc.nextInt();
        Book book = management.getBookIsbn(isbn);

        management.lendingBook(book);

        System.out.println("Successfully lended a book.");
        main(null);
    }

    public static void returnABook() {
        System.out.println("\nReturn a book\n" +
                "Enter the ISBN:\n");
        int isbn=sc.nextInt();
        Book book = management.getBookIsbn(isbn);

        management.returnBook(book);

        System.out.println("Successfully returned a book.");
        main(null);
    }

    public static void listAllAvailableBooks() {
        System.out.println("\nList all available books\n");
        // Loop for printing all the books
        List <Integer> list = management.getAvailableBooks();
        for(int i=0;i<list.size();i++){
            int isbn= list.get(i);
            Book book = management.getBookIsbn(isbn);
            System.out.println(book);
        }
    }








}