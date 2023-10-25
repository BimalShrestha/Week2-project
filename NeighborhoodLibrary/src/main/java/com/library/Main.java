package com.library;
import java.util.Scanner;

/*
Everything is functional and I think you did a good job Bimal.
A couple small things like naming of variables and using switch vs if/else
not because of functionality but because of readability. 
 */
public class Main {
    public static void main(String[] args){
        Book [] books = new Book[20];
        books[0] = new Book(1,"978-1-60309-502-0","Animal Stories",false,"");
        books[1] = new Book(2,"978-1-60309-517-4","Harry potter",false,"");
        books[2] = new Book(3,"971-1-60309-535-8","Cant Hurt Me",false,"");
        books[3] = new Book(4,"971-1-60309-435-9","Atomic Habit",false,"");
        books[4] = new Book(5,"535-1-60325-235-8","The Alchemist",false,"");
        books[5] = new Book(6,"465-1-60896-435-2","Extreme ownership",false,"");
        books[6] = new Book(7,"971-1-60309-535-8","Born a crime",false,"");
        books[7] = new Book(8,"898-1-46532-464-1","I cant make this up",false,"");
        books[8] = new Book(9,"465-1-16546-468-8","Rich Dad Poor Dad",false,"");
        books[9] = new Book(10,"971-1-60309-535-8","Sapiens",false,"");
        books[10] = new Book(11,"465-5-46483-565-2","Game of Thrones",false,"");
        books[11] = new Book(12,"958-2-46566-145-9","The Fun Family",false,"");
        books[12] = new Book(13,"965-4-60309-522-2","Funny Things",false,"");
        books[13] = new Book(14,"914-6-65809-513-3","One Piece",false,"");
        books[14] = new Book(15,"935-7-14509-465-4","Death Note",false,"");
        books[15] = new Book(16,"451-5-61569-466-4","Demon Slayer",false,"");
        books[16] = new Book(17,"935-4-63609-156-5","Your lie in April",false,"");
        books[17] = new Book(18,"451-3-62509-456-8","American Sniper",false,"");
        books[18] = new Book(19,"936-2-56309-654-9","Goosebumps",false,"");
        books[19] = new Book(20,"925-7-60345-147-7","Twilight",false,"");

        Scanner scanner = new Scanner(System.in);

        //You broke things down into methods. Nice.
     while(true) {
         System.out.println("Chose the available option 1,2,3,4: ");
         System.out.println("1> Show Available Books");
         System.out.println("2> Show Checked Out Books");
         System.out.println("3> Check in Books");
         System.out.println("4> exit ");
         int userInput = scanner.nextInt();
         switch (userInput) {
             case 1:
                 showAvailableBooks(books);
                 break;
             case 2:
                 showCheckedOutBooks(books);
                 break;
             case 3:
                 checkInABook(books);
                 break;
             case 4:
                 return;
             default:
                 System.out.println("Enter the correct input");
                 break;
         }
     }
    }
    public static void showAvailableBooks(Book[] books){
        Scanner scanner = new Scanner(System.in);
        boolean isThere = false;
        for(Book element: books){
            if(element!=null && element.IsCheckedOut()==false){
                System.out.println(element);
                isThere =true;
            }
        }
        //I like this check because what if all books are checked out, we don't want to display just a blank screen
        if(!isThere){
            System.out.println("All books are checked out.");
        }
        boolean isValid = false;
        while (!isValid) {
            System.out.println("Select a book to checkout by entering id or type 0 to exit");
            //I might name this variable userSelection for clarity
            int select = scanner.nextInt();
            scanner.nextLine();
            //I think a switch case would make this logic more readable. It's hard for me to see
            //what the choices are
            if (select == 0) {
                System.out.println("You're heading back to main menu: ");
                isValid = true;
            }
            else {
                boolean user = false;
                //It might be nice if the user picks an id that is out of range
                //to say we don't have a book, instead of just saying "enter the correct input"
                //The user might not understand what you mean.
                for (Book element : books) {

                    if (element != null && element.getId() == select) {
                        System.out.println("What is your name: ");
                        String name = scanner.nextLine();
                        element.setIsCheckedOut(true);
                        element.setCheckedOut(name);
                        System.out.println(element + " is checkout by " + element.checkOut(name));
                        isValid = true;
                        user = true;
                        break;
                    }

                    }
                if (!user){
                    System.out.println("Enter the correct input");
                }
            }


        }
    }





    public static void showCheckedOutBooks(Book [] books){
        Scanner scanner = new Scanner(System.in);
        boolean isThere = false;
        for(Book element: books) {
            if (element!=null && element.IsCheckedOut() == true) {
                System.out.println(element +"is checked out by " +element.getCheckedOutTo());
                isThere = true;
            }
        }
        if(!isThere){
            System.out.println("There are no books checked out.");
        }
        boolean isValid = false;

        while(!isValid) {
            System.out.println("Enter C to check in a book or X to go back to the home screen: ");
            String userInput = scanner.nextLine();


            if (userInput.equalsIgnoreCase("c")) {
                checkInABook(books);
                isValid = true;
            } else if (userInput.equalsIgnoreCase("x")) {
                System.out.println("Your going back to the home screen");
                isValid=true;
            }
            else
                System.out.println("Chose between C or X");
        }

        }

    public static void checkInABook(Book [] books){
        Scanner scanner = new Scanner(System.in);
        boolean isValid = false;
        while(!isValid) {
            System.out.println("Enter the id of the book to check in or press 0 to go to home Screen ");
            int id = scanner.nextInt();
            if (id == 0) {
                System.out.println("you are heading back to main menu");
                isValid = true;
            }
            else {
                boolean isThere = false;
                for (Book element : books) {
                    if (element != null && element.getId() == id && element.IsCheckedOut() == true) {
                        element.setIsCheckedOut(false);
                        element.setCheckedOut(element.checkIn());
                        System.out.println("Your book " + element + " has been checked in");
                        isThere = true;
                        isValid = true;
                        break;
                    }
                }
                if(!isThere){
                    System.out.println("There is no book for that id to check in press 0 to exit or enter correct id ");
                }
            }

        }

    }


}
